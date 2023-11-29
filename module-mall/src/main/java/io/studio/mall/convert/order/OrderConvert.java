package io.studio.mall.convert.order;

import io.studio.mall.controller.order.vo.order.OrderCreateReqVO;
import io.studio.mall.controller.order.vo.order.OrderRespVO;
import io.studio.mall.controller.order.vo.order.OrderUpdateReqVO;
import io.studio.mall.dal.dataobject.OrderDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Date:2023/11/27 9:27
 *
 * @Author:poboking
 */
@Mapper
public interface OrderConvert {
    OrderConvert INSTANCE = Mappers.getMapper(OrderConvert.class);
    OrderDO convert(OrderCreateReqVO bean);
    OrderDO convert(OrderUpdateReqVO bean);
    OrderRespVO map(OrderDO value);
    List<OrderRespVO> convertList(List<OrderDO> list);
}
