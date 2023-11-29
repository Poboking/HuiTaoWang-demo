package io.studio.mall.service;

import io.studio.mall.controller.cart.vo.CartItemSubmitOrderReqVO;
import io.studio.mall.dal.dataobject.OrderItemDO;

import java.util.List;

/**
 * Date:2023/11/26 20:30
 *
 * @Author:poboking
 */
public interface IOrderItemService {
    /**
     * 创建订单项
     *
     * @param submitReqVO 订单项提交信息
     * @return 订单项ID
     */
    Long submitOrderItem(CartItemSubmitOrderReqVO submitReqVO);

    /**
     * 创建订单项列表
     *
     * @param submitReqVOList 订单项列表提交信息
     * @return 订单项列表ID
     */
    List<Long> submitOrderItem(List<CartItemSubmitOrderReqVO> submitReqVOList);

    /**
     * 删除指定ID订单项
     *
     * @param orderItemId 订单项ID
     * @return boolean delete
     */
    Boolean deleteOrderItem(Long orderItemId);

    /**
     * 删除指定OrderId订单项
     * @param orderId 订单ID
     * @return boolean delete
     */
    Boolean deleteOrderItemByOrderId(Long orderId);

    /**
     * 获取订单项列表
     *
     * @param orderId 订单ID
     * @return list
     */
    List<OrderItemDO> getOrderItemList(Long orderId);
}
