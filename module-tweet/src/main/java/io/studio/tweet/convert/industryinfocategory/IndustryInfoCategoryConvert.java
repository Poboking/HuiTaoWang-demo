package io.studio.tweet.convert.industryinfocategory;

import io.studio.tweet.controller.vo.industry.category.IndustryInfoCategoryCreateReqVO;
import io.studio.tweet.controller.vo.industry.category.IndustryInfoCategoryRespVO;
import io.studio.tweet.controller.vo.industry.category.IndustryInfoCategoryUpdateReqVO;
import io.studio.tweet.dal.dataobject.IndustryInfoCategoryDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Date:2023/11/21 9:14
 *
 * @Author:poboking
 */
@Mapper
public interface IndustryInfoCategoryConvert {
    IndustryInfoCategoryConvert INSTANCE = Mappers.getMapper(IndustryInfoCategoryConvert.class);
    IndustryInfoCategoryDO convert(IndustryInfoCategoryCreateReqVO bean);
    IndustryInfoCategoryDO convert(IndustryInfoCategoryUpdateReqVO bean);
    IndustryInfoCategoryRespVO map(IndustryInfoCategoryDO value);
    List<IndustryInfoCategoryRespVO> convertList(List<IndustryInfoCategoryDO> list);

}
