package io.studio.mall.service;

import io.studio.mall.controller.order.vo.order.OrderCreateReqVO;
import io.studio.mall.controller.order.vo.order.OrderUpdateReqVO;
import io.studio.mall.dal.dataobject.OrderDO;

import java.util.List;

/**
 * Date:2023/11/26 20:30
 *
 * @Author:poboking
 */
public interface IOrderService {
    /**
     * 新增订单
     *
     * @param createReqVO 创建信息
     * @return Long 主键ID
     */
    Long createOrder(OrderCreateReqVO createReqVO);

    /**
     * 删除订单
     *
     * @param orderId 主键ID
     * @return boolean delete
     */
    Boolean deleteOrder(Long orderId);

    /**
     * 更新订单
     *
     * @param updateReqVO 更新信息
     * @return boolean update
     */
    Boolean updateOrder(OrderUpdateReqVO updateReqVO);

    /**
     * 更新订单状态项
     *
     * @param updateReqVO 更新信息
     * @return boolean update
     */
    Boolean updateOrderStatus(OrderUpdateReqVO updateReqVO);

    /**
     * 检查订单是否存在
     *
     * @param orderId 订单主键
     * @return boolean checkOut
     */
    Boolean checkOutOrder(Long orderId);

    /**
     * 获取订单信息
     *
     * @param orderId 主键ID
     * @return orderDO
     */
    OrderDO getOrder(Long orderId);

    /**
     * 获取订单信息
     *
     * @param orderId 主键ID
     * @param userId  用户ID
     * @return orderDO
     */
    OrderDO getOrder(Long orderId, Long userId);

    /**
     * 获取用户订单列表
     *
     * @param userId 用户ID
     * @return list
     */
    List<OrderDO> getOrderList(Long userId);
}
