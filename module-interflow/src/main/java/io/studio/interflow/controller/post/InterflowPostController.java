package io.studio.interflow.controller.post;

import io.studio.interflow.controller.post.vo.InterflowPostCreateReqVO;
import io.studio.interflow.controller.post.vo.InterflowPostRespVO;
import io.studio.interflow.controller.post.vo.InterflowPostUpdateReqVO;
import io.studio.interflow.convert.InterflowPostConvert;
import io.studio.interflow.dal.mysql.CommentsMapper;
import io.studio.interflow.dal.mysql.InterflowPostMapper;
import io.studio.interflow.service.impl.InterflowPostServiceImpl;
import io.studio.interflow.service.impl.LikesServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pojo.CommonResult;

import javax.validation.Valid;

import java.util.List;

import static pojo.CommonResult.success;
import static pojo.CommonResult.error;

/**
 * Date:2023/11/24 21:02
 *
 * @Author:poboking
 */
@Tag(name = "交流圈管理 - 动态管理")
@RestController
@RequestMapping("/api/interflow")
@Validated
@Slf4j
public class InterflowPostController {
    @Resource
    private InterflowPostServiceImpl interflowPostService;

    @Resource
    private LikesServiceImpl likesService;

    @PostMapping("/create")
    @Operation(summary = "创建动态项")
    public CommonResult<Long> createInterflowPost(@Valid @RequestBody InterflowPostCreateReqVO createReqVO) {
        log.info("[{}]: being interflow post create of process", createReqVO);
        Long postId = interflowPostService.insertInterflowPost(createReqVO);
        if (postId < 0) {
            return error(500, "interflow post create failure");
        }
        return success(postId);
    }

    @DeleteMapping("/delete/{postId}")
    @Operation(summary = "删除动态项")
    public CommonResult<Object> deleteInterflowPost(@Valid @PathVariable("postId") Long postId) {
        log.info("[{}]: being interflow post delete of process", postId);
        if (Boolean.FALSE.equals(interflowPostService.deleteInterflowPost(postId))) {
            return error(500, "interflow post delete failure");
        }
        return success(true);
    }

    @PutMapping("/update")
    @Operation(summary = "更新动态项")
    public CommonResult<Object> updateInterflowPost(@Valid @RequestBody InterflowPostUpdateReqVO updateReqVO){
        log.info("[{}]: being interflow post update of process",updateReqVO);
        if (Boolean.FALSE.equals(interflowPostService.updateInterflowPost(updateReqVO))) {
            return error(500,"interflow post update failure");
        }
        return success(true);
    }

    @GetMapping("/list")
    @Operation(summary = "获取动态列表项")
    public CommonResult<List<InterflowPostRespVO>> getInterflowPostList(){
        log.info("[]: being interflow post list get of process");
        List<InterflowPostRespVO> respVOList = InterflowPostConvert.INSTANCE.convertList(interflowPostService.getInterflowPostList());
        if (respVOList.isEmpty()) {
            return error(500,"interflow post list get failure");
        }
        // 这里的item.getUserId, 需要替换成具体的当前用户ID,即用户认证模块的getCurrentId()
        respVOList.forEach(item -> item.setIsLike(Boolean.TRUE.equals(
                likesService.getLikeId(item.getPostId(),item.getUserId())>0)));
        respVOList.forEach(item -> item.setAvatarUrl("功能未实现"));
        respVOList.forEach(item -> item.setAuthorName("功能未实现"));
        return success(respVOList);
    }
}
