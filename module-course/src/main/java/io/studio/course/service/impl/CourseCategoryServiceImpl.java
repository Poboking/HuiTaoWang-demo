package io.studio.course.service.impl;

import io.studio.course.controller.category.vo.CourseCategoryCreateReqVO;
import io.studio.course.controller.category.vo.CourseCategoryUpdateReqVO;
import io.studio.course.convert.CourseCategoryConvert;
import io.studio.course.dal.dataobject.CourseCategoryDO;
import io.studio.course.dal.mysql.CourseCategoryMapper;
import io.studio.course.service.ICourseCategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Date:2023/11/23 16:34
 *
 * @Author:poboking
 */
@Service
public class CourseCategoryServiceImpl implements ICourseCategoryService {
    @Resource
    private  CourseCategoryMapper courseCategoryMapper;
    /**
     * 创建课程类别
     *
     * @param createReqVO 创建信息
     * @return 课程编号
     */
    @Override
    public Long createCourseCategory(CourseCategoryCreateReqVO createReqVO) {
        CourseCategoryDO categoryDO = CourseCategoryConvert.INSTANCE.convert(createReqVO);
        if (courseCategoryMapper.insertAndGetId(categoryDO) < 0) {
            return -1L;
        }
        return categoryDO.getCategoryId();
    }

    /**
     * 删除课程类别
     *
     * @param courseCategoryId 课程类别ID
     * @return boolean
     */
    @Override
    public boolean deleteCourseCategory(Long courseCategoryId) {
        return courseCategoryMapper.deleteById(courseCategoryId) > 0;
    }

    /**
     * 更新课程类别
     *
     * @param updateReqVO 更新信息
     * @return boolean
     */
    @Override
    public boolean updateCourseCategory(CourseCategoryUpdateReqVO updateReqVO) {
        CourseCategoryDO categoryDO = CourseCategoryConvert.INSTANCE.convert(updateReqVO);
        if (Objects.isNull(courseCategoryMapper.selectById(categoryDO.getCategoryId()))){
            return false;
        }
        return courseCategoryMapper.updateById(categoryDO) > 0;
    }

    /**
     * 获取课程类别
     *
     * @param categoryId 课程类别ID
     * @return 课程信息
     */
    @Override
    public CourseCategoryDO getCourseCategory(Long categoryId) {
        return courseCategoryMapper.selectById(categoryId);
    }

    /**
     * 获取课程类别列表
     *
     * @return list
     */
    @Override
    public List<CourseCategoryDO> getCourseCategoryList() {
        return courseCategoryMapper.selectList(null);
    }

    /**
     * 获取课程列表
     *
     * @param categoryIds 课程类别ID
     * @return list
     */
    @Override
    public List<CourseCategoryDO> getCourseCategoryList(Collection<Long> categoryIds) {
        return courseCategoryMapper.selectBatchIds(categoryIds);
    }
}
