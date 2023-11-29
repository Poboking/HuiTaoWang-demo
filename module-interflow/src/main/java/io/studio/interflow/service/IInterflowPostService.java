package io.studio.interflow.service;

import io.studio.interflow.controller.post.vo.InterflowPostCreateReqVO;
import io.studio.interflow.controller.post.vo.InterflowPostPageReqVO;
import io.studio.interflow.controller.post.vo.InterflowPostUpdateReqVO;
import io.studio.interflow.dal.dataobject.InterflowPostDO;
import pojo.PageResult;

import java.util.List;

/**
 * Date:2023/11/24 21:54
 *
 * @Author:poboking
 */

public interface IInterflowPostService {

    /**
     * 创建动态
     *
     * @param createReqVO 创建信息
     * @return postID
     */
    Long insertInterflowPost(InterflowPostCreateReqVO createReqVO);

    /**
     * 删除动态
     *
     * @param postId 动态ID
     * @return delete boolean
     */
    Boolean deleteInterflowPost(Long postId);

    /**
     * 更新动态
     *
     * @param updateReqVO 更新信息
     * @return update boolean
     */
    Boolean updateInterflowPost(InterflowPostUpdateReqVO updateReqVO);

    /**
     * 更新动态评论数减一
     *
     * @param postId 动态ID
     * @return update boolean
     */
    Boolean updateCommentMinusOne(Long postId);

    /**
     * 更新动态点赞数减一
     *
     * @param postId 动态ID
     * @return update boolean
     */
    Boolean updateLikeNumMinusOne(Long postId);

    /**
     * 更新动态评论数加一
     *
     * @param postId 动态ID
     * @return update boolean
     */
    Boolean updateCommentNumPlusOne(Long postId);

    /**
     * 更新动态点赞数加一
     *
     * @param postId 动态ID
     * @return update boolean
     */
    Boolean updateLikeNumPlusOne(Long postId);

    /**
     * 检查指定ID动态是否存在
     *
     * @param postId 动态ID
     * @return check boolean
     */
    Boolean checkInterflowPostExist(Long postId);

    /**
     * 获取动态列表
     *
     * @return list
     */
    List<InterflowPostDO> getInterflowPostList();

    /**
     * 获取动态分页结果
     *
     * @param pageReqVO 分页查询信息
     * @return 分页结果
     */
    PageResult<InterflowPostDO> getInterflowPostPage(InterflowPostPageReqVO pageReqVO);
}
