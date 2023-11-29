package io.studio.interflow.convert;

import io.studio.interflow.controller.like.vo.LikesCreateReqVO;
import io.studio.interflow.dal.dataobject.LikesDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Date:2023/11/24 23:18
 *
 * @Author:poboking
 */
@Mapper
public interface LikesConvert {
    LikesConvert INSTANCE = Mappers.getMapper(LikesConvert.class);

    LikesDO convert(LikesCreateReqVO bean);
}
