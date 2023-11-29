package io.studio.interflow.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.interflow.dal.dataobject.InterflowPostDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Date:2023/11/24 20:38
 *
 * @Author:poboking
 */
@Mapper
public interface InterflowPostMapper extends BaseMapper<InterflowPostDO> {
    Long insertAndGetId(@Param("postDO") InterflowPostDO interflowPostDO);
}
