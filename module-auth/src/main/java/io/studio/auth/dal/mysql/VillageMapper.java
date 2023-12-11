package io.studio.auth.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.auth.dal.dataobject.VillageDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Date:2023/12/4 17:42
 *
 * @Author:poboking
 */
@Mapper
public interface VillageMapper extends BaseMapper<VillageDO> {
    int insertAndGetId(@Param("villageDO")VillageDO villageDO);
}
