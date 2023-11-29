package io.studio.interflow.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.studio.interflow.controller.like.vo.LikesCreateReqVO;
import io.studio.interflow.convert.LikesConvert;
import io.studio.interflow.dal.dataobject.LikesDO;
import io.studio.interflow.dal.mysql.LikesMapper;
import io.studio.interflow.service.ILikesService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Date:2023/11/24 23:16
 *
 * @Author:poboking
 */
@Service
public class LikesServiceImpl implements ILikesService {
    @Resource
    private LikesMapper likesMapper;
    /**
     * 新增点赞
     *
     * @param createReqVO 新增信息
     * @return likeID
     */
    @Override
    public Long insertLike(LikesCreateReqVO createReqVO) {
        LikesDO likesDO = LikesConvert.INSTANCE.convert(createReqVO);
        if (likesMapper.insertAndGetId(likesDO) < 0) {
            return -1L;
        }
        return likesDO.getLikeId();
    }

    /**
     * 取消点赞
     *
     * @param likeId 主键ID
     * @return delete boolean
     */
    @Override
    public Boolean deleteLike(Long likeId) {
        return likesMapper.deleteById(likeId) >= 0;
    }

    /**
     * 获取指定动态点赞数
     *
     * @param postId 动态ID
     * @return long 点赞数
     */
    @Override
    public Long getLikeNum(Long postId) {
        QueryWrapper<LikesDO> queryWrapper = new QueryWrapper<LikesDO>().eq("post_id", postId);
        return likesMapper.selectCount(queryWrapper);
    }

    /**
     * 获取点赞ID
     *
     * @param postId 动态ID
     * @param userId 用户ID
     * @return 点赞ID
     */
    @Override
    public Long getLikeId(Long postId, Long userId) {
        LikesDO likesDO = likesMapper.selectOne(new QueryWrapper<LikesDO>().eq("post_id", postId).
                eq("user_id", userId));
        if (Objects.isNull(likesDO)){
            return -1L;
        }
        return likesDO.getLikeId();
    }
}
