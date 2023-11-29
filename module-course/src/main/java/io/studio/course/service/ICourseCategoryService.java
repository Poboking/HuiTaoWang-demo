package io.studio.course.service;

import io.studio.course.controller.category.vo.CourseCategoryCreateReqVO;
import io.studio.course.controller.category.vo.CourseCategoryUpdateReqVO;
import io.studio.course.dal.dataobject.CourseCategoryDO;

import java.util.Collection;
import java.util.List;

/**
 * Date:2023/11/23 16:32
 *
 * @Author:poboking
 */
public interface ICourseCategoryService {
    /**
     * 创建课程类别
     *
     * @param createReqVO 创建信息
     * @return 课程编号
     */
    Long createCourseCategory(CourseCategoryCreateReqVO createReqVO);

    /**
     * 删除课程类别
     *
     * @param courseCategoryId 课程类别ID
     * @return boolean
     */
    boolean deleteCourseCategory(Long courseCategoryId);

    /**
     * 更新课程类别
     *
     * @param updateReqVO 更新信息
     * @return boolean
     */
    boolean updateCourseCategory(CourseCategoryUpdateReqVO updateReqVO);

    /**
     * 获取课程类别
     *
     * @param categoryId 课程类别ID
     * @return 课程信息
     */

    CourseCategoryDO getCourseCategory(Long categoryId);

    /**
     * 获取课程类别列表
     *
     * @return list
     */
    List<CourseCategoryDO> getCourseCategoryList();

    /**
     * 获取课程列表
     *
     * @param categoryIds 课程类别ID
     * @return list
     */
    List<CourseCategoryDO> getCourseCategoryList(Collection<Long> categoryIds);
}
