package io.studio.tweet.convert.industryinfo;

import io.studio.tweet.controller.vo.industry.info.IndustryInfoCreateReqVO;
import io.studio.tweet.controller.vo.industry.info.IndustryInfoRespVO;
import io.studio.tweet.controller.vo.industry.info.IndustryInfoUpdateReqVO;
import io.studio.tweet.dal.dataobject.IndustryInfoDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Date:2023/11/20 19:59
 *
 * @Author:poboking
 */
@Mapper
public interface IndustryInfoConvert {
    IndustryInfoConvert INSTANCE = Mappers.getMapper(IndustryInfoConvert.class);
    IndustryInfoDO convert(IndustryInfoCreateReqVO bean);
    IndustryInfoDO convert(IndustryInfoUpdateReqVO bean);
    IndustryInfoRespVO map(IndustryInfoDO value);

    /**
     * Tips:
     *
     * @Mappings 是容器注解,用于包括多个@Mapping注解
     */
    @Mappings({
            @Mapping(source = "createAt",target = "sendTime")
//            @Mapping(source = "createAt",target = "sendTime")
    })
    List<IndustryInfoRespVO> convertList(List<IndustryInfoDO> list);
}
