package io.studio.mall.convert.cart;

import io.studio.mall.controller.cart.vo.CartItemCreateReqVO;
import io.studio.mall.controller.cart.vo.CartItemRespVO;
import io.studio.mall.controller.cart.vo.CartItemUpdateReqVO;
import io.studio.mall.dal.dataobject.CartItemDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Date:2023/11/27 9:26
 *
 * @Author:poboking
 */
@Mapper
public interface CartItemConvert {
    CartItemConvert INSTANCE = Mappers.getMapper(CartItemConvert.class);
    CartItemDO convert(CartItemCreateReqVO bean);
    CartItemDO convert(CartItemUpdateReqVO bean);
    CartItemRespVO map(CartItemDO value);
    List<CartItemRespVO> convertList(List<CartItemDO> list);
}
