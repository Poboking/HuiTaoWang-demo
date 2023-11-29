package io.studio.interflow.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.interflow.dal.dataobject.CommentsDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Date:2023/11/24 20:40
 *
 * @Author:poboking
 */
@Mapper
public interface CommentsMapper extends BaseMapper<CommentsDO> {
    Long insertAndGetId(@Param("commentsDO") CommentsDO commentsDO);
}
