package io.studio.interflow.convert;

import io.studio.interflow.controller.post.vo.InterflowPostCreateReqVO;
import io.studio.interflow.controller.post.vo.InterflowPostRespVO;
import io.studio.interflow.controller.post.vo.InterflowPostUpdateReqVO;
import io.studio.interflow.dal.dataobject.InterflowPostDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Date:2023/11/24 23:18
 *
 * @Author:poboking
 */
@Mapper
public interface InterflowPostConvert {
    InterflowPostConvert INSTANCE = Mappers.getMapper(InterflowPostConvert.class);
    InterflowPostDO convert(InterflowPostCreateReqVO bean);
    InterflowPostDO convert(InterflowPostUpdateReqVO bean);
    @Mappings({
            @Mapping(source = "upvotes",target = "likeNum"),
            @Mapping(source = "replies",target = "commentNum"),
            @Mapping(source = "createdAt",target = "sendTime")
    })
    InterflowPostRespVO map(InterflowPostDO value);
    List<InterflowPostRespVO> convertList(List<InterflowPostDO> list);
}
