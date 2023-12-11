package io.studio.auth.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.auth.dal.dataobject.PlantsDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Date:2023/12/4 17:42
 *
 * @Author:poboking
 */
@Mapper
public interface PlantsMapper extends BaseMapper<PlantsDO> {
    int insertAndGetId(@Param("plantsDO") PlantsDO plantsDO);
}
