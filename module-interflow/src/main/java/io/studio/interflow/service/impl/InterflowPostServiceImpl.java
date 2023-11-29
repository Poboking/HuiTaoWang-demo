package io.studio.interflow.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.studio.interflow.controller.post.vo.InterflowPostCreateReqVO;
import io.studio.interflow.controller.post.vo.InterflowPostPageReqVO;
import io.studio.interflow.controller.post.vo.InterflowPostUpdateReqVO;
import io.studio.interflow.convert.InterflowPostConvert;
import io.studio.interflow.dal.dataobject.InterflowPostDO;
import io.studio.interflow.dal.mysql.InterflowPostMapper;
import io.studio.interflow.service.IInterflowPostService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import pojo.PageResult;

import java.util.List;
import java.util.Objects;

/**
 * Date:2023/11/24 22:18
 *
 * @Author:poboking
 */
@Service
public class InterflowPostServiceImpl implements IInterflowPostService {
    @Resource
    private InterflowPostMapper interflowPostMapper;
    /**
     * 创建动态
     *
     * @param createReqVO 创建信息
     * @return postID
     */
    @Override
    public Long insertInterflowPost(InterflowPostCreateReqVO createReqVO) {
        InterflowPostDO postDO = InterflowPostConvert.INSTANCE.convert(createReqVO);
        if (interflowPostMapper.insertAndGetId(postDO) < 0){
            return -1L;
        }
        return postDO.getPostId();
    }

    /**
     * 删除动态
     *
     * @param postId 动态ID
     * @return delete boolean
     */
    @Override
    public Boolean deleteInterflowPost(Long postId) {
        return interflowPostMapper.deleteById(postId) > 0;
    }

    /**
     * 更新动态
     *
     * @param updateReqVO 更新信息
     * @return update boolean
     */
    @Override
    public Boolean updateInterflowPost(InterflowPostUpdateReqVO updateReqVO) {
        return interflowPostMapper.updateById(InterflowPostConvert.INSTANCE.convert(updateReqVO)) > 0;
    }

    /**
     * 更新动态评论数减一
     *
     * @param postId 动态ID
     * @return update boolean
     */
    @Override
    public Boolean updateCommentMinusOne(Long postId) {
        UpdateWrapper<InterflowPostDO> updateWrapper = new UpdateWrapper<InterflowPostDO>().
                setSql("replies = replies - 1").eq("post_id", postId);
        return interflowPostMapper.update(null,updateWrapper) > 0;
    }

    /**
     * 更新动态点赞数减一
     *
     * @param postId 动态ID
     * @return update boolean
     */
    @Override
    public Boolean updateLikeNumMinusOne(Long postId) {
        UpdateWrapper<InterflowPostDO> updateWrapper = new UpdateWrapper<InterflowPostDO>().
                setSql("upvotes = upvotes - 1").eq("post_id", postId);
        return interflowPostMapper.update(null,updateWrapper) > 0;
    }

    /**
     * 更新动态评论数
     *
     * @param postId 动态ID
     * @return update boolean
     */
    @Override
    public Boolean updateCommentNumPlusOne(Long postId) {
        UpdateWrapper<InterflowPostDO> updateWrapper = new UpdateWrapper<InterflowPostDO>().
                setSql("replies = replies + 1").eq("post_id", postId);
        return interflowPostMapper.update(null,updateWrapper) > 0;
    }

    /**
     * 更新动态点赞数
     *
     * @param postId 动态ID
     * @return update boolean
     */
    @Override
    public Boolean updateLikeNumPlusOne(Long postId) {
        UpdateWrapper<InterflowPostDO> updateWrapper = new UpdateWrapper<InterflowPostDO>().
                setSql("upvotes = upvotes + 1").eq("post_id", postId);
        return interflowPostMapper.update(null,updateWrapper) > 0;
    }

    /**
     * 检查指定ID动态是否存在
     *
     * @param postId 动态ID
     * @return check boolean
     */
    @Override
    public Boolean checkInterflowPostExist(Long postId) {
        return !Objects.isNull(interflowPostMapper.selectById(postId));
    }

    /**
     * 获取动态列表
     *
     * @return list
     */
    @Override
    public List<InterflowPostDO> getInterflowPostList() {
        return interflowPostMapper.selectList(null);
    }

    /**
     * 获取动态分页结果
     *
     * @param pageReqVO 分页查询信息
     * @return 分页结果
     */
    @Override
    public PageResult<InterflowPostDO> getInterflowPostPage(InterflowPostPageReqVO pageReqVO) {
        return null;
    }
}
