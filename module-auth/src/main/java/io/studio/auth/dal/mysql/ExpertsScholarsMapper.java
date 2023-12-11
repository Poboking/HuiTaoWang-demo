package io.studio.auth.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.auth.dal.dataobject.ExpertsScholarsDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Date:2023/12/4 17:43
 *
 * @Author:poboking
 */
@Mapper
public interface ExpertsScholarsMapper extends BaseMapper<ExpertsScholarsDO> {
    int insertAndGetId(@Param("expertsScholarsDO")ExpertsScholarsDO expertsScholarsDO);
}
