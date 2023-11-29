package io.studio.mall.convert.address;

import io.studio.mall.controller.address.vo.AddressCreateReqVO;
import io.studio.mall.controller.address.vo.AddressRespVO;
import io.studio.mall.controller.address.vo.AddressUpdateReqVO;
import io.studio.mall.dal.dataobject.AddressDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Date:2023/11/27 9:27
 *
 * @Author:poboking
 */
@Mapper
public interface AddressConvert {
    AddressConvert INSTANCE = Mappers.getMapper(AddressConvert.class);
    AddressDO convert(AddressCreateReqVO bean);
    AddressDO convert(AddressUpdateReqVO bean);
    AddressRespVO map(AddressDO value);
    List<AddressRespVO> convertList(List<AddressDO> list);
}
