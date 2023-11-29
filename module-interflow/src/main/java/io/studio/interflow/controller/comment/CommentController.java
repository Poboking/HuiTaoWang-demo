package io.studio.interflow.controller.comment;

import io.studio.interflow.controller.comment.vo.CommentsCreateReqVO;
import io.studio.interflow.controller.comment.vo.CommentsRespVO;
import io.studio.interflow.controller.comment.vo.CommentsUpdateReqVO;
import io.studio.interflow.convert.CommentsConvert;
import io.studio.interflow.dal.dataobject.CommentsDO;
import io.studio.interflow.service.impl.CommentsServiceImpl;
import io.studio.interflow.service.impl.InterflowPostServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pojo.CommonResult;

import javax.validation.Valid;

import java.util.List;
import java.util.Objects;

import static pojo.CommonResult.success;
import static pojo.CommonResult.error;

/**
 * Date:2023/11/25 10:55
 *
 * @Author:poboking
 */
@Tag(name = "交流圈管理 - 评论管理")
@RestController
@RequestMapping("/api/interflow/comment")
@Validated
@Slf4j
public class CommentController {
    @Resource
    private CommentsServiceImpl commentsService;
    @Resource
    private InterflowPostServiceImpl interflowPostService;

    @PostMapping("/create")
    @Operation(summary = "创建评论项")
    public CommonResult<Long> createComment(@Valid @RequestBody CommentsCreateReqVO createReqVO) {
        log.info("[{}]: being comment create of process", createReqVO);
        if (Boolean.FALSE.equals(interflowPostService.checkInterflowPostExist(createReqVO.getPostId()))){
            return error(400,"comment create failure on account of the post non-existent");
        }
        Long commentId = commentsService.insertComment(createReqVO);
        if (commentId < 0) {
            return error(500, "comment create failure");
        }
        if (Boolean.FALSE.equals(interflowPostService.updateCommentNumPlusOne(createReqVO.getPostId()))) {
            commentsService.deleteComment(commentId);
            return error(500, "comment create failure on account of commentNum plus one failure or the post non-existent");
        }
        return success(commentId);
    }

    @DeleteMapping("/delete/{commentId}")
    @Operation(summary = "删除评论项")
    public CommonResult<Object> deleteComment(@Valid @PathVariable("commentId") Long commentId) {
        log.info("[{}]: being comment delete of process", commentId);
        CommentsDO commentDO = commentsService.getComment(commentId);
        if (Objects.isNull(commentDO)) {
            return error(400, "comment delete failure on account of commentId nonexistent");
        }
        if (Boolean.FALSE.equals(commentsService.deleteComment(commentId))) {
            return error(500, "comment delete failure");
        }
        if (Boolean.FALSE.equals(interflowPostService.updateCommentMinusOne(commentDO.getPostId()))){
            commentsService.insertComment(CommentsConvert.INSTANCE.convert(commentDO));
            return error(500,"comment delete failure on account of commentNum minus one failure");
        }
            return success(true);
    }

    @PutMapping("/update")
    @Operation(summary = "更新评论项")
    public CommonResult<Object> updateComment(@Valid @RequestBody CommentsUpdateReqVO updateReqVO) {
        log.info("[{}]: being comment update of process", updateReqVO);
        if (Boolean.FALSE.equals(commentsService.updateComment(updateReqVO))) {
            return error(500, "comment update failure");
        }
        return success(true);
    }

    @GetMapping("/list/{postId}")
    @Operation(summary = "获取指定动态评论列表项")
    public CommonResult<List<CommentsRespVO>> getCommentList(@Valid @PathVariable("postId") Long postId) {
        log.info("[{}]: being comment list get of process", postId);
        if (Boolean.FALSE.equals(interflowPostService.checkInterflowPostExist(postId))){
            return error(400,"comment list get failure on account of the post non-existent");
        }
        List<CommentsDO> list = commentsService.getCommentList(postId);
        if (list.isEmpty()) {
            return error(500, "comment list get failure on account of internal error");
        }
        List<CommentsRespVO> respVOList = CommentsConvert.INSTANCE.convertList(list);
        respVOList.forEach(item ->item.setAuthorName("功能未实现"));
        respVOList.forEach(item ->item.setAuthorUrl("功能未实现"));
        return success(respVOList);
    }
}
