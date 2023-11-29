package io.studio.interflow.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.interflow.dal.dataobject.LikesDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.security.PrivilegedAction;

/**
 * Date:2023/11/24 20:39
 *
 * @Author:poboking
 */
@Mapper
public interface LikesMapper extends BaseMapper<LikesDO> {
    Long insertAndGetId (@Param("likesDO") LikesDO likesDO);
}
