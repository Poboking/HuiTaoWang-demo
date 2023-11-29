package io.studio.interflow.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.studio.interflow.controller.comment.vo.CommentsCreateReqVO;
import io.studio.interflow.controller.comment.vo.CommentsPageReqVO;
import io.studio.interflow.controller.comment.vo.CommentsUpdateReqVO;
import io.studio.interflow.convert.CommentsConvert;
import io.studio.interflow.dal.dataobject.CommentsDO;
import io.studio.interflow.dal.mysql.CommentsMapper;
import io.studio.interflow.service.ICommentsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import pojo.PageResult;

import java.util.List;

/**
 * Date:2023/11/24 23:16
 *
 * @Author:poboking
 */
@Service
public class CommentsServiceImpl implements ICommentsService {
    @Resource
    private CommentsMapper commentsMapper;
    /**
     * 创建评论
     *
     * @param createReqVO 创建信息
     * @return 评论ID
     */
    @Override
    public Long insertComment(CommentsCreateReqVO createReqVO) {
        CommentsDO commentsDO = CommentsConvert.INSTANCE.convert(createReqVO);
        if (commentsMapper.insertAndGetId(commentsDO) < 0) {
            return -1L;
        }
        return commentsDO.getCommentId();
    }

    /**
     * 删除评论
     *
     * @param commentId 评论ID
     * @return delete boolean
     */
    @Override
    public Boolean deleteComment(Long commentId) {
        return commentsMapper.deleteById(commentId) > 0;
    }

    /**
     * 更新评论
     *
     * @param updateReqVO 更新信息
     * @return update boolean
     */
    @Override
    public Boolean updateComment(CommentsUpdateReqVO updateReqVO) {
        return commentsMapper.updateById(CommentsConvert.INSTANCE.convert(updateReqVO)) > 0;
    }

    /**
     * 获取指定评论ID的评论详情
     *
     * @param commentId 评论ID
     * @return update boolean
     */
    @Override
    public CommentsDO getComment(Long commentId) {
        QueryWrapper<CommentsDO> queryWrapper = new QueryWrapper<CommentsDO>().eq("comment_id", commentId);
        return commentsMapper.selectOne(queryWrapper);
    }

    /**
     * 获取指定动态评论数
     *
     * @param postId 动态ID
     * @return commentNum
     */
    @Override
    public Long getCommentCount(Long postId) {
        QueryWrapper<CommentsDO> queryWrapper = new QueryWrapper<CommentsDO>().eq("post_id", postId);
        return commentsMapper.selectCount(queryWrapper);
    }

    /**
     * 获取指定动态评论
     *
     * @return list
     */
    @Override
    public List<CommentsDO> getCommentList(Long postId) {
        QueryWrapper<CommentsDO> queryWrapper = new QueryWrapper<CommentsDO>().eq("post_id", postId);
        return commentsMapper.selectList(queryWrapper);
    }

    /**
     * 获取分页动态评论
     *
     * @param pageReqVO 分页查询信息
     * @return page
     */
    @Override
    public PageResult<CommentsDO> getCommentPage(CommentsPageReqVO pageReqVO) {
        return null;
    }
}
