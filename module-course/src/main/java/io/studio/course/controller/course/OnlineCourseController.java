package io.studio.course.controller.course;

import io.studio.course.controller.course.vo.OnlineCourseCreateReqVO;
import io.studio.course.controller.course.vo.OnlineCourseRespVO;
import io.studio.course.controller.course.vo.OnlineCourseUpdateReqVO;
import io.studio.course.convert.OnlineCourseConvert;
import io.studio.course.service.impl.OnlineCourseServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pojo.CommonResult;

import javax.validation.Valid;

import java.util.List;
import java.util.Objects;

import static pojo.CommonResult.success;
import static pojo.CommonResult.error;

/**
 * Date:2023/11/23 16:36
 *
 * @Author:poboking
 */
@Tag(name = "课程管理 - 在线课程管理")
@RestController
@RequestMapping("/api/course")
@Validated
@Slf4j
public class OnlineCourseController {
    @Resource
    private OnlineCourseServiceImpl onlineCourseService;

    @PostMapping("/create")
    @Operation(summary = "创建在线课程项")
    public CommonResult<Long> createOnlineCourse(@Valid @RequestBody OnlineCourseCreateReqVO createReqVO) {
        log.info("[{}]: being online course create of process", createReqVO);
        Long courseId = onlineCourseService.createOnlineCourse(createReqVO);
        if (courseId < 0) {
            return error(500, "online course create failure");
        }
        return success(courseId);
    }

    @DeleteMapping("/delete/{courseId}")
    @Operation(summary = "删除在线课程项")
    public CommonResult<Object> deleteOnlineCourse(@Valid @PathVariable("courseId") Long courseId) {
        log.info("[{}]: being online course delete of process", courseId);
        if (!onlineCourseService.deleteOnlineCourse(courseId)) {
            return error(500, "online course delete failure");
        }
        return success(true);
    }

    @PutMapping("/update")
    @Operation(summary = "更新在线课程项")
    public CommonResult<Object> updateOnlineCourse(@Valid @RequestBody OnlineCourseUpdateReqVO updateReqVO) {
        log.info("[{}]: being online course update of process", updateReqVO);
        if (!onlineCourseService.updateOnlineCourse(updateReqVO)) {
            return error(500, "online course update failure");
        }
        return success(true);
    }

    @GetMapping("/get/{courseId}")
    @Operation(summary = "获取指定ID课程详情项")
    public CommonResult<OnlineCourseRespVO> getOnlineCourse(@Valid @PathVariable("courseId") Long courseId) {
        log.info("[{}]: being online course get by courseId of process", courseId);
        OnlineCourseRespVO respVO = OnlineCourseConvert.INSTANCE.convert(onlineCourseService.getOnlineCourse(courseId));
        if (Objects.isNull(respVO)) {
            return error(500, "online course get by courseId failure");
        }
        return success(respVO);
    }

    @GetMapping("/get/list")
    @Operation(summary = "获取课程详情列表项")
    public CommonResult<List<OnlineCourseRespVO>> getOnlineCourseList() {
        log.info("[]: being online course get no args of process");
        List<OnlineCourseRespVO> respVOList = OnlineCourseConvert.INSTANCE.convertList(onlineCourseService.getOnlineCourseList());
        if (respVOList.isEmpty()) {
            return error(500, "online course list get failure");
        }
        return success(respVOList);
    }

    @GetMapping("/get/list/search")
    @Operation(summary = "获取指定课程名称的课程详情列表项")
    public CommonResult<List<OnlineCourseRespVO>> getOnlineCourseList(@Valid @RequestParam("course_name") String courseName){
        log.info("[{}]: being online course list search by courseName of process", courseName);
        List<OnlineCourseRespVO> respVOList = OnlineCourseConvert.INSTANCE.convertList(onlineCourseService.getOnlineCourseList(courseName));
        //对于集合类, Objects.equals()方法并不适用.
        if (respVOList.isEmpty()){
            return error(500,"online course list get by courseName failure");
        }
        return success(respVOList);
    }

    @GetMapping("/get/list/category/{categoryId}")
    @Operation(summary = "获取指定类别课程详情列表项")
    public CommonResult<List<OnlineCourseRespVO>> getOnlineCourseList(@Valid @PathVariable("categoryId") Long categoryId) {
        log.info("[{}]: being online course list get by categoryId of process", categoryId);
        List<OnlineCourseRespVO> respVOList = OnlineCourseConvert.INSTANCE.convertList(onlineCourseService.getOnlineCourseList(categoryId));
        System.out.println(respVOList);
        if (respVOList.isEmpty()) {
            return error(500, "online course list get by categoryId failure");
        }
        return success(respVOList);
    }

    @PostMapping("/get/list/ids")
    @Operation(summary = "获取指定IDs课程详情列表项")
    public CommonResult<List<OnlineCourseRespVO>> getOnlineCourseList(@Valid @RequestBody List<Long> ids) {
        log.info("[{}]: being online course list by courseIds of process", ids);
        List<OnlineCourseRespVO> respVOList = OnlineCourseConvert.INSTANCE.convertList(onlineCourseService.getOnlineCourselist(ids));
        if (respVOList.isEmpty()) {
            return error(500, "online course list get by courseIds failure");
        }
        return success(respVOList);
    }
}
