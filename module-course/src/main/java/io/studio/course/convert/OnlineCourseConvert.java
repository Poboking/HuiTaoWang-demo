package io.studio.course.convert;

import io.studio.course.controller.course.vo.OnlineCourseCreateReqVO;
import io.studio.course.controller.course.vo.OnlineCourseRespVO;
import io.studio.course.controller.course.vo.OnlineCourseUpdateReqVO;
import io.studio.course.dal.dataobject.OnlineCourseDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Date:2023/11/23 17:16
 *
 * @Author:poboking
 */
@Mapper
public interface OnlineCourseConvert {
    OnlineCourseConvert INSTANCE = Mappers.getMapper(OnlineCourseConvert.class);

    OnlineCourseDO convert(OnlineCourseCreateReqVO bean);

    OnlineCourseDO convert(OnlineCourseUpdateReqVO bean);

    @Named("convert")
    OnlineCourseRespVO convert(OnlineCourseDO bean);

    OnlineCourseRespVO map(OnlineCourseDO value);

    List<OnlineCourseRespVO> convertList(List<OnlineCourseDO> list);
}
