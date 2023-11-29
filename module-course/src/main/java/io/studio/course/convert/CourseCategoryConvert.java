package io.studio.course.convert;

import io.studio.course.controller.category.vo.CourseCategoryCreateReqVO;
import io.studio.course.controller.category.vo.CourseCategoryRespVO;
import io.studio.course.controller.category.vo.CourseCategoryUpdateReqVO;
import io.studio.course.dal.dataobject.CourseCategoryDO;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Date:2023/11/23 17:16
 *
 * @Author:poboking
 */
@Mapper
public interface CourseCategoryConvert {
    CourseCategoryConvert INSTANCE = Mappers.getMapper(CourseCategoryConvert.class);

    CourseCategoryDO convert(CourseCategoryCreateReqVO bean);

    CourseCategoryDO convert(CourseCategoryUpdateReqVO bean);

    @Named("convert")
    CourseCategoryRespVO convert(CourseCategoryDO bean);

    CourseCategoryRespVO map(CourseCategoryDO value);

    List<CourseCategoryRespVO> convertList(List<CourseCategoryDO> list);

}
