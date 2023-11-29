package io.studio.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import io.studio.mall.controller.cart.vo.CartItemSubmitOrderReqVO;
import io.studio.mall.convert.cart.CartItemConvert;
import io.studio.mall.convert.order.OrderItemConvert;
import io.studio.mall.dal.dataobject.CartItemDO;
import io.studio.mall.dal.dataobject.OrderItemDO;
import io.studio.mall.dal.mysql.OrderItemMapper;
import io.studio.mall.service.IOrderItemService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Date:2023/11/27 14:24
 *
 * @Author:poboking
 */
@Service
public class OrderItemServiceImpl implements IOrderItemService {
    @Resource
    private OrderItemMapper orderItemMapper;
    /**
     * 创建订单项
     *
     * @param submitReqVO 订单项提交信息
     * @return 订单项ID
     */
    @Override
    public Long submitOrderItem(CartItemSubmitOrderReqVO submitReqVO) {
        OrderItemDO itemDO = OrderItemConvert.INSTANCE.convert(submitReqVO);
        if (orderItemMapper.insertAndGetId(itemDO) < 0) {
            return -1L;
        }
        return itemDO.getItemId();
    }

    /**
     * 创建订单项列表
     *
     * @param submitReqVOList 订单项列表提交信息
     * @return 订单项列表ID
     */
    @Override
    @Transactional
    public List<Long> submitOrderItem(List<CartItemSubmitOrderReqVO> submitReqVOList) {
        ArrayList<Long> list = new ArrayList<>();
        submitReqVOList.forEach(item -> list.add(submitOrderItem(item)));
        return list;
    }

    /**
     * 删除指定ID订单项
     *
     * @param orderItemId 订单项ID
     * @return boolean delete
     */
    @Override
    public Boolean deleteOrderItem(Long orderItemId) {
        return orderItemMapper.deleteById(orderItemId) > 0;
    }

    /**
     * 删除指定OrderId订单项
     *
     * @param orderId 订单ID
     * @return boolean delete
     */
    @Override
    public Boolean deleteOrderItemByOrderId(Long orderId) {
        return orderItemMapper.delete(new QueryWrapper<OrderItemDO>().eq("order_id",orderId)) > 0;
    }

    /**
     * 获取订单项列表
     *
     * @param orderId 订单ID
     * @return list
     */
    @Override
    public List<OrderItemDO> getOrderItemList(Long orderId) {
        return orderItemMapper.selectList(new QueryWrapper<OrderItemDO>().eq("order_id",orderId));
    }
}
