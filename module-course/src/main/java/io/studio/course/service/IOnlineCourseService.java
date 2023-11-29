package io.studio.course.service;

import io.studio.course.controller.course.vo.OnlineCourseCreateReqVO;
import io.studio.course.controller.course.vo.OnlineCourseUpdateReqVO;
import io.studio.course.dal.dataobject.OnlineCourseDO;

import java.util.Collection;
import java.util.List;

/**
 * Date:2023/11/23 16:31
 *
 * @Author:poboking
 */
public interface IOnlineCourseService {
    /**
     * 创建在线课程
     *
     * @param createReqVO 创建信息
     * @return 课程ID
     */
    Long createOnlineCourse(OnlineCourseCreateReqVO createReqVO);

    /**
     * 删除在线课程
     *
     * @param courseId 课程ID
     * @return boolean
     */
    boolean deleteOnlineCourse(Long courseId);

    /**
     * 更新在线课程
     *
     * @param updateReqVO 更新信息
     * @return boolean
     */
    boolean updateOnlineCourse(OnlineCourseUpdateReqVO updateReqVO);

    /**
     * 获取指定在线课程
     *
     * @param courseId 课程ID
     * @return 课程信息
     */
    OnlineCourseDO getOnlineCourse(Long courseId);

    /**
     * 获取在线课程列表
     *
     * @return 课程信息列表
     */
    List<OnlineCourseDO> getOnlineCourseList();

    /**
     * 获取在线课程列表
     *
     * @param courseName 课程名称
     * @return 课程信息列表
     */
    List<OnlineCourseDO> getOnlineCourseList(String courseName);

    /**
     * 获取在线课程列表
     *
     * @param categoryId 课程类别ID
     * @return 课程信息列表
     */
    List<OnlineCourseDO> getOnlineCourseList(Long categoryId);

    /**
     * 获取在线课程列表
     *
     * @param courseIds 课程ID
     * @return 课程信息列表
     */
    List<OnlineCourseDO> getOnlineCourselist(Collection<Long> courseIds);
}
