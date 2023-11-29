package io.studio.course.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.course.dal.dataobject.CourseCategoryDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Date:2023/11/23 15:29
 *
 * @Author:poboking
 */
@Mapper
public interface CourseCategoryMapper extends BaseMapper<CourseCategoryDO> {
    /**
     * 插入数据并将ID插入传参的ID字段中
     *
     * @param categoryDO CourseCategoryDO
     * @return int 插入条数
     */
    int insertAndGetId(@Param("categoryDO") CourseCategoryDO categoryDO);
}
