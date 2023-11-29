package io.studio.course.controller.category;

import io.studio.course.controller.category.vo.CourseCategoryCreateReqVO;
import io.studio.course.controller.category.vo.CourseCategoryRespVO;
import io.studio.course.controller.category.vo.CourseCategoryUpdateReqVO;
import io.studio.course.convert.CourseCategoryConvert;
import io.studio.course.service.impl.CourseCategoryServiceImpl;
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
 * Date:2023/11/23 19:11
 *
 * @Author:poboking
 */
@Tag(name = "课程管理 - 课程类别管理")
@RestController
@RequestMapping("/api/course/category")
@Validated
@Slf4j
public class CourseCategoryController {
    @Resource
    private CourseCategoryServiceImpl courseCategoryService;

    @PostMapping("/create")
    @Operation(summary = "创建课程类别项")
    public CommonResult<Long> createCourseCategory(@Valid @RequestBody CourseCategoryCreateReqVO createReqVO){
        log.info("[{}]: being online course category create of process", createReqVO);
        Long categoryId = courseCategoryService.createCourseCategory(createReqVO);
        if (categoryId < 0){
            return error(500,"course category create failure");
        }
        return success(categoryId);

    }

    @DeleteMapping("/delete/{categoryId}")
    @Operation(summary = "删除课程类别项")
    public CommonResult<Object> deleteCourseCategory(@Valid @PathVariable("categoryId") Long categoryId){
        log.info("[{}]: being online course category delete of process", categoryId);
        if (!courseCategoryService.deleteCourseCategory(categoryId)){
            return error(500,"course category delete failure");
        }
        return success(true);
    }

    @PutMapping("/update")
    @Operation(description = "更新课程类别项")
    public CommonResult<Object> updateCourseCategory(@Valid @RequestBody CourseCategoryUpdateReqVO updateReqVO){
        log.info("[{}]: being online course category update of process", updateReqVO);
        if (!courseCategoryService.updateCourseCategory(updateReqVO)) {
            return error(500,"course category update failure");
        }
        return success(true);
    }

    @GetMapping("/get/{categoryId}")
    @Operation(summary = "获取课程类别项")
    public CommonResult<CourseCategoryRespVO> getCourseCategory(@Valid @PathVariable("categoryId") Long categoryId){
        log.info("[{}]: being online course category get by categoryId of process", categoryId);
        CourseCategoryRespVO categoryRespVO = CourseCategoryConvert.INSTANCE.convert(courseCategoryService.getCourseCategory(categoryId));
        if (Objects.isNull(categoryRespVO)){
            return error(500,"course category get by id failure");
        }
        return success(categoryRespVO);
    }

    @GetMapping("/get/list")
    @Operation(summary = "获取课程类别列表项")
    public CommonResult<List<CourseCategoryRespVO>> getCourseCategoryList(){
        log.info("[]: being online course category list get by no args  of process");
        List<CourseCategoryRespVO> respVOList = CourseCategoryConvert.INSTANCE.convertList(
                courseCategoryService.getCourseCategoryList()
        );
        if (respVOList.isEmpty()){
            return error(500,"course category list get failure");
        }
        return success(respVOList);
    }

    @PostMapping("/get/list")
    @Operation(summary = "获取指定课程类别列表项")
    public CommonResult<List<CourseCategoryRespVO>> getCourseCategoryList(@Valid @RequestBody List<Long> ids){
        List<CourseCategoryRespVO> respVOList = CourseCategoryConvert.INSTANCE.convertList(
                courseCategoryService.getCourseCategoryList(ids)
        );
        if (respVOList.isEmpty()){
            return error(500,"course category list get by ids failure");
        }
        return success(respVOList);
    }

}
