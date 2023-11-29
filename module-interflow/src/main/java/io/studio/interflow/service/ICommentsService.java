package io.studio.interflow.service;

import io.studio.interflow.controller.comment.vo.CommentsCreateReqVO;
import io.studio.interflow.controller.comment.vo.CommentsPageReqVO;
import io.studio.interflow.controller.comment.vo.CommentsUpdateReqVO;
import io.studio.interflow.dal.dataobject.CommentsDO;
import pojo.PageResult;

import java.util.List;

/**
 * Date:2023/11/24 21:54
 *
 * @Author:poboking
 */

public interface ICommentsService {

    /**
     * 创建评论
     *
     * @param createReqVO 创建信息
     * @return 评论ID
     */
    Long insertComment(CommentsCreateReqVO createReqVO);

    /**
     * 删除评论
     *
     * @param commentId 评论ID
     * @return delete boolean
     */
    Boolean deleteComment(Long commentId);

    /**
     * 更新评论
     *
     * @param updateReqVO 更新信息
     * @return update boolean
     */
    Boolean updateComment(CommentsUpdateReqVO updateReqVO);

    /**
     * 获取指定评论ID的评论详情
     * @param commentId 评论ID
     * @return update boolean
     */
    CommentsDO getComment(Long commentId);

    /**
     * 获取指定动态评论数
     *
     * @param postId 动态ID
     * @return commentNum
     */
    Long getCommentCount(Long postId);

    /**
     * 获取指定动态评论
     *
     * @return list
     */
    List<CommentsDO> getCommentList(Long postId);

    /**
     * 获取分页动态评论
     *
     * @param pageReqVO 分页查询信息
     * @return page
     */
    PageResult<CommentsDO> getCommentPage(CommentsPageReqVO pageReqVO);
}
