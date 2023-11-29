package io.studio.tweet.controller;

import io.studio.tweet.controller.vo.industry.category.IndustryInfoCategoryCreateReqVO;
import io.studio.tweet.controller.vo.industry.category.IndustryInfoCategoryRespVO;
import io.studio.tweet.controller.vo.industry.category.IndustryInfoCategoryUpdateReqVO;
import io.studio.tweet.controller.vo.industry.info.IndustryInfoCreateReqVO;
import io.studio.tweet.controller.vo.industry.info.IndustryInfoRespVO;
import io.studio.tweet.controller.vo.industry.info.IndustryInfoUpdateReqVO;
import io.studio.tweet.controller.vo.scenery.SceneryCreateReqVO;
import io.studio.tweet.controller.vo.scenery.SceneryRespVO;
import io.studio.tweet.controller.vo.scenery.SceneryUpdateReqVO;
import io.studio.tweet.convert.industryinfo.IndustryInfoConvert;
import io.studio.tweet.convert.industryinfocategory.IndustryInfoCategoryConvert;
import io.studio.tweet.service.impl.IndustryInfoServiceImpl;
import io.studio.tweet.service.impl.SceneryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pojo.CommonResult;

import javax.validation.Valid;
import java.util.List;

import static pojo.CommonResult.error;
import static pojo.CommonResult.success;

/**
 * Date:2023/11/13 11:24
 *
 * @Author:poboking
 */
@Tag(name = "首页管理 - 推文管理")
@RestController
@RequestMapping("/api/homepage/tweet")
@Validated
@Slf4j
public class HomePageTweetController {


    @Resource
    private IndustryInfoServiceImpl industryInfoService;
    @Resource
    private SceneryServiceImpl sceneryService;

    @PostMapping("/industry_info/create")
    @Operation(summary = "创建资讯项")
    public CommonResult<Long> createIndustryInfo(@Valid @RequestBody IndustryInfoCreateReqVO createReqVO) {
        log.info("[{}]: being industry info created of process", createReqVO);
        Long infoId = industryInfoService.insertIndustryInfo(createReqVO);
        if (infoId < 0){
            return error(500,"industry info create failure");
        }
        return success(infoId);
    }

    @DeleteMapping("/industry_info/delete/{infoId}")
    @Operation(summary = "删除资讯项")
    public CommonResult<Object> deleteIndustryInfo(@Valid @PathVariable Long infoId) {
        log.info("[{}]: being industry info deleted of process", infoId);
        if (!industryInfoService.deleteIndustryInfoById(infoId)) {
            return error(500, "industry info delete failure");
        }
        return success(true);
    }

    @PutMapping("/industry_info/update")
    @Operation(summary = "更新资讯项")
    public CommonResult<Object> updateIndustryInfo(@Valid @RequestBody IndustryInfoUpdateReqVO updateReqVO) {
        log.info("[{}]: being industry info updated of process", updateReqVO);
        if (!industryInfoService.updateIndustryInfo(updateReqVO)) {
            return error(500, "industry info update failure.");
        }
        return success(true);
    }

    @GetMapping("/industry_info/get")
    @Operation(summary = "获取资讯项")
    public CommonResult<List<IndustryInfoRespVO>> getIndustryInfo() {
        log.info("[]: being get industry info of process");
        List<IndustryInfoRespVO> respVOList = IndustryInfoConvert.INSTANCE.convertList(
                industryInfoService.getIndustryInfoList());
        if (respVOList.isEmpty()){
            return error(500,"industry info list get failure");
        }
        return success(respVOList);
    }

    @PostMapping("/industry_info_category/create")
    @Operation(summary = " 新增资讯类别项")
    public CommonResult<Long> createInfoCategory(@Valid @RequestBody
                                                 IndustryInfoCategoryCreateReqVO createReqVO) {
        log.info("[{}]: being industry info category created of process", createReqVO);
        Long categoryId = industryInfoService.insertIndustryInfoCategory(createReqVO);
        if (categoryId < 0){
            return error(500,"industry info category create failure");
        }
        return success(categoryId);
    }

    @DeleteMapping("/industry_info_category/delete/{categoryId}")
    @Operation(summary = "删除资讯类别项")
    public CommonResult<Object> deleteIndustryInfoCategory(@Valid @PathVariable Long categoryId) {
        log.info("[{}]: being industry info category deleted of process", categoryId);
        if (!industryInfoService.deleteIndustryInfoCategoryById(categoryId)) {
            return error(500, "industry info delete fault");
        }
        return success(true);
    }

    @PutMapping("/industry_info_category/update")
    @Operation(summary = "更新资讯类别项")
    public CommonResult<Object> updateIndustryInfoCategory(@Valid @RequestBody IndustryInfoCategoryUpdateReqVO updateReqVO) {
        log.info("[{}]: being industry info category updated of process", updateReqVO);
        if (!industryInfoService.updateIndustryInfoCategory(updateReqVO)) {
            return error(500, "industry info update fault.");
        }
        return success(null);
    }

    @GetMapping("/industry_info_category/get")
    @Operation(summary = "获取资讯类别项")
    public CommonResult<List<IndustryInfoCategoryRespVO>> getIndustryInfoCategory() {
        log.info("[]: being get industry info category of process");
        List<IndustryInfoCategoryRespVO> respVOList = IndustryInfoCategoryConvert.INSTANCE.convertList(
                industryInfoService.getIndustryCategoryList());
        if (respVOList.isEmpty()){
            return error(500,"industry info category list get failure");
        }
        return success(respVOList);
    }

    @PostMapping("scenery/create")
    @Operation(summary = "新增桃园风光推文项")
    public CommonResult<Long> createScenery(@Valid @RequestBody SceneryCreateReqVO createReqVO) {
        log.info("[{}]: being scenery created of process", createReqVO);
        Long sceneryId = sceneryService.createScenery(createReqVO);
        if (sceneryId < 0) {
            return error(500,"scenery create failure");
        }
        return success(sceneryId);
    }

    @DeleteMapping("/scenery/delete/{sceneryId}")
    @Operation(summary = "删除桃园风光推文项")
    public CommonResult<Object> deleteScenery(@Valid @PathVariable Long sceneryId) {
        log.info("[{}]: being scenery deleted of process",sceneryId);
        if (!sceneryService.deleteSceneryById(sceneryId)) {
            return error(500, "scenery delete fault.");
        }
        return success(true);
    }

    @PutMapping("/scenery/update")
    @Operation(summary = "更新桃园风光推文项")
    public CommonResult<Object> updateScenery(@Valid @RequestBody SceneryUpdateReqVO updateReqVO) {
        log.info("[{}]: being scenery updated of process",updateReqVO);
        if (!sceneryService.updateScenery(updateReqVO)) {
            return error(500, "scenery update fault.");
        }
        return success(true);
    }

    @GetMapping("/scenery/get")
    @Operation(summary = "获取桃园风光推文项")
    public CommonResult<List<SceneryRespVO>> getScenery() {
        log.info("[]: being get scenery of process");
        List<SceneryRespVO> respVOList = sceneryService.getSceneryList();
        if (respVOList.isEmpty()){
            return error(500,"scenery list get failure");
        }
        return success(respVOList);
    }

}
