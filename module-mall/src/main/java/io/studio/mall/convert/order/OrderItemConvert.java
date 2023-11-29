package io.studio.mall.convert.order;

import io.studio.mall.controller.cart.vo.CartItemSubmitOrderReqVO;
import io.studio.mall.controller.order.vo.item.OrderItemRespVO;
import io.studio.mall.controller.order.vo.order.OrderRespVO;
import io.studio.mall.dal.dataobject.CartItemDO;
import io.studio.mall.dal.dataobject.OrderItemDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Date:2023/11/27 9:27
 *
 * @Author:poboking
 */
@Mapper
public interface OrderItemConvert {
    OrderItemConvert INSTANCE = Mappers.getMapper(OrderItemConvert.class);
    OrderItemDO convert(CartItemSubmitOrderReqVO bean);
    OrderRespVO map(OrderItemDO value);
    List<OrderItemRespVO> convertList(List<OrderItemDO> list);
}
