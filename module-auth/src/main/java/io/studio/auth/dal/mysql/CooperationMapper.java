package io.studio.auth.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.auth.dal.dataobject.CooperationDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Date:2023/12/4 17:44
 *
 * @Author:poboking
 */
@Mapper
public interface CooperationMapper extends BaseMapper<CooperationDO> {
    int insertAndGetId(@Param("cooperationDO")CooperationDO cooperationDO);
}
