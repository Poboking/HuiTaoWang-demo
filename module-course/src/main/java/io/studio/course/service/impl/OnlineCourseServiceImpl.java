package io.studio.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.studio.course.controller.course.vo.OnlineCourseCreateReqVO;
import io.studio.course.controller.course.vo.OnlineCourseUpdateReqVO;
import io.studio.course.convert.OnlineCourseConvert;
import io.studio.course.dal.dataobject.OnlineCourseDO;
import io.studio.course.dal.mysql.OnlineCourseMapper;
import io.studio.course.service.IOnlineCourseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Date:2023/11/23 16:32
 *
 * @Author:poboking
 */
@Service
public class OnlineCourseServiceImpl implements IOnlineCourseService {
    @Resource
    private OnlineCourseMapper onlineCourseMapper;
    /**
     * 创建在线课程
     *
     * @param createReqVO 创建信息
     * @return 课程ID
     */
    @Override
    public Long createOnlineCourse(OnlineCourseCreateReqVO createReqVO) {
        OnlineCourseDO courseDO = OnlineCourseConvert.INSTANCE.convert(createReqVO);
        if (onlineCourseMapper.insertAndGetId(courseDO) < 0) {
            return -1L;
        }
        return courseDO.getCourseId();
    }

    /**
     * 删除在线课程
     *
     * @param courseId 课程ID
     * @return boolean
     */
    @Override
    public boolean deleteOnlineCourse(Long courseId) {
        return onlineCourseMapper.deleteById(courseId) > 0;
    }

    /**
     * 更新在线课程
     *
     * @param updateReqVO 更新信息
     * @return boolean
     */
    @Override
    public boolean updateOnlineCourse(OnlineCourseUpdateReqVO updateReqVO) {
        OnlineCourseDO courseDO = OnlineCourseConvert.INSTANCE.convert(updateReqVO);
        if (Objects.isNull(onlineCourseMapper.selectById(courseDO.getCourseId()))){
            System.out.println(onlineCourseMapper.selectById(courseDO.getCourseId()));
            return false;
        }
        return onlineCourseMapper.updateById(courseDO) > 0;
    }

    /**
     * 获取指定在线课程
     *
     * @param courseId 课程ID
     * @return 课程信息
     */
    @Override
    public OnlineCourseDO getOnlineCourse(Long courseId) {
        return onlineCourseMapper.selectById(courseId);
    }

    /**
     * 获取在线课程列表
     *
     * @return 课程信息列表
     */
    @Override
    public List<OnlineCourseDO> getOnlineCourseList() {
        return onlineCourseMapper.selectList(null);
    }

    /**
     * 获取在线课程列表
     *
     * @param courseName 课程名称
     * @return 课程信息列表
     */
    @Override
    public List<OnlineCourseDO> getOnlineCourseList(String courseName) {
        QueryWrapper<OnlineCourseDO> wrapper = new QueryWrapper<>();
        return onlineCourseMapper.selectList(wrapper.like("course_name",courseName));
    }

    /**
     * 获取在线课程列表
     *
     * @param categoryId 课程类别ID
     * @return 课程信息列表
     */
    @Override
    public List<OnlineCourseDO> getOnlineCourseList(Long categoryId) {
        QueryWrapper<OnlineCourseDO> wrapper = new QueryWrapper<>();
        return onlineCourseMapper.selectList(wrapper.eq("category_id", categoryId));
    }

    /**
     * 获取在线课程列表
     *
     * @param courseIds 课程ID
     * @return 课程信息列表
     */
    @Override
    public List<OnlineCourseDO> getOnlineCourselist(Collection<Long> courseIds) {
        return onlineCourseMapper.selectBatchIds(courseIds);
    }
}
