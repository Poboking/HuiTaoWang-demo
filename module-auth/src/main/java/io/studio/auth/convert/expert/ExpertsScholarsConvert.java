package io.studio.auth.convert.expert;

import io.studio.auth.controller.vo.biz.expert.ExpertsScholarsRespVO;
import io.studio.auth.dal.dataobject.ExpertsScholarsDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Date:2023/12/7 17:55
 *
 * @Author:poboking
 */
@Mapper
public interface ExpertsScholarsConvert {
    ExpertsScholarsConvert INSTANCE = Mappers.getMapper(ExpertsScholarsConvert.class);
    ExpertsScholarsRespVO convert(ExpertsScholarsDO value);
    List<ExpertsScholarsRespVO> convertList(List<ExpertsScholarsDO> list);
}
