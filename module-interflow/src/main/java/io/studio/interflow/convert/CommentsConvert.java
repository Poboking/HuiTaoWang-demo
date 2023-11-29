package io.studio.interflow.convert;

import io.studio.interflow.controller.comment.vo.CommentsCreateReqVO;
import io.studio.interflow.controller.comment.vo.CommentsRespVO;
import io.studio.interflow.controller.comment.vo.CommentsUpdateReqVO;
import io.studio.interflow.dal.dataobject.CommentsDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Date:2023/11/24 23:19
 *
 * @Author:poboking
 */
@Mapper
public interface CommentsConvert {
    CommentsConvert INSTANCE = Mappers.getMapper(CommentsConvert.class);
    CommentsDO convert(CommentsCreateReqVO bean);
    CommentsCreateReqVO convert(CommentsDO bean);
    CommentsDO convert(CommentsUpdateReqVO bean);
    @Mappings({
            @Mapping(source = "createdAt",target = "sendTime")
    })
    CommentsRespVO map(CommentsDO value);
    List<CommentsRespVO> convertList(List<CommentsDO> list);
}
