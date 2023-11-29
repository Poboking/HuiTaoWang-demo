package io.studio.interflow.service;

import io.studio.interflow.controller.like.vo.LikesCreateReqVO;

/**
 * Date:2023/11/24 21:54
 *
 * @Author:poboking
 */

public interface ILikesService {

    /**
     * 新增点赞
     * @param createReqVO 新增信息
     * @return likeID
     */
    Long insertLike(LikesCreateReqVO createReqVO);

    /**
     * 取消点赞
     * @param likeId 主键ID
     * @return delete boolean
     */
    Boolean deleteLike(Long likeId);

    /**
     * 获取指定动态点赞数
     *
     * @param postId 动态ID
     * @return likeNum 点赞数
     */
    Long getLikeNum(Long postId);

    /**
     * 获取点赞ID
     * @param postId 动态ID
     * @param userId 用户ID
     * @return 点赞ID
     */
    Long getLikeId(Long postId, Long userId);
}
