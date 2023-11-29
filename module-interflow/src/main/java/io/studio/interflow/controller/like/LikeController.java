package io.studio.interflow.controller.like;

import io.studio.interflow.controller.like.vo.LikesCreateReqVO;
import io.studio.interflow.service.impl.InterflowPostServiceImpl;
import io.studio.interflow.service.impl.LikesServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pojo.CommonResult;

import javax.validation.Valid;
import java.util.Objects;

import static pojo.CommonResult.error;
import static pojo.CommonResult.success;

/**
 * Date:2023/11/25 10:55
 *
 * @Author:poboking
 */
@Tag(name = "交流圈管理 - 点赞管理")
@RestController
@RequestMapping("/api/interflow/like")
@Validated
@Slf4j
public class LikeController {
    @Resource
    private LikesServiceImpl likesService;
    @Resource
    private InterflowPostServiceImpl interflowPostService;

    @PostMapping("/is")
    @Operation(summary = "点赞项")
    public CommonResult<Boolean> isLike(@Valid @RequestBody LikesCreateReqVO createReqVO) {
        log.info("[{}]: being like create or delete of process", createReqVO);
        if (Boolean.TRUE.equals(createReqVO.getIsLike())) {
            //点赞操作

            //判断点赞是否存在
            if (likesService.getLikeId(createReqVO.getPostId(), createReqVO.getUserId()) > 0) {
                return error(400, "like create failure on account of likeId already existed");
            }
            Long likeId = likesService.insertLike(createReqVO);
            if (likeId < 0) {
                return error(500, "like create failure on account of internal error");
            }
            if (Boolean.FALSE.equals(interflowPostService.updateLikeNumPlusOne(createReqVO.getPostId()))) {
                likesService.deleteLike(likeId);
                return error(500,"like create failure on account of likeNum plus one failure or the post non-existent");
            }
            //点赞成功
            return success(true);
        }
        //取消点赞操作

        //判断点赞是否不存在
        if (likesService.getLikeId(createReqVO.getPostId(), createReqVO.getUserId()) < 0) {
            return error(400, "like delete failure on account of likeId noe-existent");
        }
        if (Boolean.FALSE.equals(likesService.deleteLike(likesService.getLikeId(
                createReqVO.getPostId(), createReqVO.getUserId())))) {
            return error(500, "like delete failure on account of internal error");
        }
        if (Boolean.FALSE.equals(interflowPostService.updateLikeNumMinusOne(createReqVO.getPostId()))){
            likesService.insertLike(createReqVO);
            return error(500,"like create failure on account of likeNum minus one failure");
        }
        //取消点赞成功
        return success(true);
    }

    @GetMapping("/get/{postId}")
    @Operation(summary = "获取点赞数项")
    public CommonResult<Long> getLikeNum(@Valid @PathVariable("postId") Long postId) {
        if (Boolean.FALSE.equals(interflowPostService.checkInterflowPostExist(postId))) {
            return error(400, "likeNum get failure on account of postId non-existent");
        }
        return success(likesService.getLikeNum(postId));
    }
}
