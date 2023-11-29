package io.studio.tweet.service;

import io.studio.tweet.controller.vo.industry.category.IndustryInfoCategoryCreateReqVO;
import io.studio.tweet.controller.vo.industry.category.IndustryInfoCategoryUpdateReqVO;
import io.studio.tweet.controller.vo.industry.info.IndustryInfoCreateReqVO;
import io.studio.tweet.controller.vo.industry.info.IndustryInfoUpdateReqVO;
import io.studio.tweet.dal.dataobject.IndustryInfoCategoryDO;
import io.studio.tweet.dal.dataobject.IndustryInfoDO;

import java.util.List;

/**
 * Date:2023/11/11 16:59
 *
 * @Author:poboking
 */
public interface IIndustryInfoService {
    /**
     * 插入行业资讯推文
     *
     * @param createReqVO VO
     * @return infoId 主键ID
     */
     Long insertIndustryInfo(IndustryInfoCreateReqVO createReqVO);

    /**
     * 删除行业资讯推文
     *
     * @param industryInfoId int
     * @return 结果
     */
     boolean deleteIndustryInfoById(Long industryInfoId);

    /**
     * 更新行业资讯推文
     *
     * @param updateReqVO VO
     * @return 结果
     */
     boolean updateIndustryInfo(IndustryInfoUpdateReqVO updateReqVO);

    /**
     * 获取行业资讯推文分页列表
     *
     * @param current currentPage
     * @param size    pageSize
     * @return 结果
     */
     List<IndustryInfoDO> getIndustryInfoPage(int current, int size);

    /**
     * 获取行业资讯推文列表
     *
     * @return 结果
     */
     List<IndustryInfoDO> getIndustryInfoList();

    /**
     * 插入行业资讯推文类别
     * @param createReqVO VO
     * @return categoryId 主键ID
     */
     Long insertIndustryInfoCategory(IndustryInfoCategoryCreateReqVO createReqVO);

    /**
     * 删除行业资讯推文类别
     * @param categoryId int
     * @return 结果
     */
     boolean deleteIndustryInfoCategoryById(Long categoryId);

    /**
     * 更新行业资讯推文类别
     * @param updateReqVO VO
     * @return 结果
     */
     boolean updateIndustryInfoCategory(IndustryInfoCategoryUpdateReqVO updateReqVO);

    /**
     * 获取行业资讯推文类别
     * @param categoryId int
     * @return 结果
     */
     IndustryInfoCategoryDO getIndustryInfoCategoryById(Long categoryId);

    /**
     * 获取行业资讯推文类别分页列表
     *
     * @param current currentPage
     * @param size pageSize
     * @return 结果
     */
     List<IndustryInfoCategoryDO> getIndustryInfoCategoryPage(int current, int size);

    /**
     * 获取行业资讯推文类别列表
     *
     * @return 结果
     */
     List<IndustryInfoCategoryDO> getIndustryCategoryList();

}
