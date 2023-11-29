package io.studio.tweet.convert.scenery;

import io.studio.tweet.controller.vo.scenery.SceneryCreateReqVO;
import io.studio.tweet.controller.vo.scenery.SceneryRespVO;
import io.studio.tweet.controller.vo.scenery.SceneryUpdateReqVO;
import io.studio.tweet.dal.dataobject.SceneryDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Date:2023/11/21 0:07
 *
 * @Author:poboking
 */
@Mapper
public interface SceneryConvert {
    SceneryConvert INSTANT = Mappers.getMapper(SceneryConvert.class);
    SceneryDO convert(SceneryCreateReqVO bean);
    SceneryDO convert(SceneryUpdateReqVO updateReqVO);
    SceneryRespVO map(SceneryDO value);
    List<SceneryRespVO> convertList(List<SceneryDO> list);
}
