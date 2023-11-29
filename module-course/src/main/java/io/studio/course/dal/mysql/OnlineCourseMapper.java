package io.studio.course.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.course.dal.dataobject.OnlineCourseDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Date:2023/11/23 15:32
 *
 * @Author:poboking
 */
@Mapper
public interface OnlineCourseMapper extends BaseMapper<OnlineCourseDO> {
    /**
     * 插入数据并将ID插入传参的ID字段中
     *
     * @param coursesDO OnlineCourseDO
     * @return int 插入条数
     */
    int insertAndGetId(@Param("courseDO") OnlineCourseDO coursesDO);
}
