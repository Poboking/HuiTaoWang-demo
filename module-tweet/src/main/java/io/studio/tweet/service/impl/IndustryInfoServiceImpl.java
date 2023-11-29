package io.studio.tweet.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.studio.tweet.controller.vo.industry.category.IndustryInfoCategoryCreateReqVO;
import io.studio.tweet.controller.vo.industry.category.IndustryInfoCategoryUpdateReqVO;
import io.studio.tweet.controller.vo.industry.info.IndustryInfoCreateReqVO;
import io.studio.tweet.controller.vo.industry.info.IndustryInfoUpdateReqVO;
import io.studio.tweet.convert.industryinfo.IndustryInfoConvert;
import io.studio.tweet.convert.industryinfocategory.IndustryInfoCategoryConvert;
import io.studio.tweet.dal.dataobject.IndustryInfoCategoryDO;
import io.studio.tweet.dal.dataobject.IndustryInfoDO;
import io.studio.tweet.dal.mysql.IndustryInfoCategoryMapper;
import io.studio.tweet.dal.mysql.IndustryInfoMapper;
import io.studio.tweet.service.IIndustryInfoService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Date:2023/11/11 17:23
 *
 * @Author:poboking
 */
@Service
@Slf4j
public class IndustryInfoServiceImpl implements IIndustryInfoService {
    @Resource
    private IndustryInfoMapper industryInfoMapper;
    @Resource
    private IndustryInfoCategoryMapper industryInfoCategoryMapper;

    /**
     * 插入行业资讯推文
     *
     * @param createReqVO DO
     * @return infoId 主键ID
     */
    @Override
    public Long insertIndustryInfo(IndustryInfoCreateReqVO createReqVO) {
        //Convert to entity
        IndustryInfoDO infoDO = IndustryInfoConvert.INSTANCE.convert(createReqVO);
        if (industryInfoMapper.insertAndGetId(infoDO) > 0) {
            return infoDO.getInfoId();
        }
        return -1L;
    }

    /**
     * 删除行业资讯推文
     *
     * @param industryInfoId int
     * @return 结果
     */
    @Override
    public boolean deleteIndustryInfoById(Long industryInfoId) {
        return industryInfoMapper.deleteById(industryInfoId) > 0;
    }

    /**
     * 更新行业资讯推文
     *
     * @param updateReqVO VO
     * @return 结果
     */
    @Override
    public boolean updateIndustryInfo(IndustryInfoUpdateReqVO updateReqVO) {
        //Convert to entity
        IndustryInfoDO infoDO = IndustryInfoConvert.INSTANCE.convert(updateReqVO);
        /*
          查询是否存在该推文
         */
        if (!Objects.equals(industryInfoMapper.selectById(infoDO.getInfoId()), null)) {
            return industryInfoMapper.updateById(infoDO) > 0;
        }
        return false;
    }

    /**
     * 获取行业资讯推文列表
     *
     * @param current currentPage
     * @param size    pageSize
     * @return 结果
     */
    @Override
    public List<IndustryInfoDO> getIndustryInfoPage(int current, int size) {
        Page<IndustryInfoDO> page = new Page<>(current, size);
        page.setSearchCount(false);
        page.setOptimizeCountSql(false);

        IPage<IndustryInfoDO> result = industryInfoMapper.selectPage(page, null);
        return result.getRecords();
    }

    /**
     * 获取行业资讯推文列表
     *
     * @return 结果
     */
    public List<IndustryInfoDO> getIndustryInfoList() {
        return industryInfoMapper.selectList(null);
    }

    /**
     * 插入行业资讯推文类别
     *
     * @param createReqVO DO
     * @return categoryId 主键ID
     */
    @Override
    public Long insertIndustryInfoCategory(IndustryInfoCategoryCreateReqVO createReqVO) {
        //Convert to entity
        IndustryInfoCategoryDO categoryDO = IndustryInfoCategoryConvert.INSTANCE.convert(createReqVO);
        if (industryInfoCategoryMapper.insertAndGetId(categoryDO) > 0) {
            return categoryDO.getCategoryId();
        }
        return -1L;
    }

    /**
     * 删除行业资讯推文类别
     *
     * @param categoryId int
     * @return 结果
     */
    @Override
    public boolean deleteIndustryInfoCategoryById(Long categoryId) {
        return industryInfoCategoryMapper.deleteById(categoryId) > 0;
    }

    /**
     * 更新行业资讯推文类别
     *
     * @param updateReqVO DO
     * @return 结果
     */
    @Override
    public boolean updateIndustryInfoCategory(IndustryInfoCategoryUpdateReqVO updateReqVO) {
        //Convert to entity
        IndustryInfoCategoryDO categoryDO = IndustryInfoCategoryConvert.INSTANCE.convert(updateReqVO);
//        return industryInfoCategoryMapper.updateById(categoryDO) > 0;

        int delete = 0, insert;
        if (!Objects.isNull(industryInfoCategoryMapper.selectById(categoryDO.getCategoryId()))) {
            delete = industryInfoCategoryMapper.deleteById(categoryDO.getCategoryId());
        }
        insert = industryInfoCategoryMapper.insert(categoryDO);
        return delete > 0 & insert > 0;
    }


    /**
     * 获取行业资讯推文类别
     *
     * @param categoryId int
     * @return 结果
     */
    @Override
    public IndustryInfoCategoryDO getIndustryInfoCategoryById(Long categoryId) {
        return industryInfoCategoryMapper.selectById(categoryId);
    }

    /**
     * 获取行业资讯推文类别分页列表
     *
     * @param current currentPage
     * @param size    pageSize
     * @return 结果
     */
    @Override
    public List<IndustryInfoCategoryDO> getIndustryInfoCategoryPage(int current, int size) {
        Page<IndustryInfoCategoryDO> page = new Page<>(current, size);
        page.setSearchCount(false);
        page.setOptimizeCountSql(false);

        Page<IndustryInfoCategoryDO> result = industryInfoCategoryMapper.selectPage(page, null);
        return result.getRecords();
    }

    /**
     * 获取行业资讯推文类别列表
     *
     * @return 结果
     */
    public List<IndustryInfoCategoryDO> getIndustryCategoryList() {
        return industryInfoCategoryMapper.selectList(null);
    }
}
