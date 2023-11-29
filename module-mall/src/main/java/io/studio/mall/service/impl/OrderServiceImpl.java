package io.studio.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.studio.mall.controller.order.vo.order.OrderCreateReqVO;
import io.studio.mall.controller.order.vo.order.OrderUpdateReqVO;
import io.studio.mall.convert.order.OrderConvert;
import io.studio.mall.dal.dataobject.OrderDO;
import io.studio.mall.dal.mysql.OrderMapper;
import io.studio.mall.service.IOrderService;
import io.studio.mall.service.enums.OrderStatus;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * Date:2023/11/27 11:15
 *
 * @Author:poboking
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private OrderMapper orderMapper;

    /**
     * 新增订单
     *
     * @param createReqVO 创建信息
     * @return Long 主键ID
     */
    @Override
    @Transactional
    public Long createOrder(OrderCreateReqVO createReqVO) {
        OrderDO orderDO = OrderConvert.INSTANCE.convert(createReqVO);
        if (createReqVO.getProducts().isEmpty()) {
            return -1L;
        }
        if (orderMapper.insertAndGetId(orderDO) < 0) {
            return -1L;
        }
        return orderDO.getOrderId();
    }

    /**
     * 删除订单
     *
     * @param orderId 主键ID
     * @return boolean delete
     */
    @Override
    public Boolean deleteOrder(Long orderId) {
        return orderMapper.deleteById(orderId) > 0;
    }

    /**
     * 更新订单
     *
     * @param updateReqVO 更新信息
     * @return boolean update
     */
    @Override
    public Boolean updateOrder(OrderUpdateReqVO updateReqVO) {
        return orderMapper.updateById(OrderConvert.INSTANCE.convert(updateReqVO)) > 0;
    }

    /**
     * 更新订单状态项
     *
     * @param updateReqVO 更新信息
     * @return boolean update
     */
    @Override
    public Boolean updateOrderStatus(OrderUpdateReqVO updateReqVO) {
        if (updateReqVO.getStatus().isEmpty() || updateReqVO.getStatus().isBlank()) {
            return false;
        }
        return orderMapper.update(null,new UpdateWrapper<OrderDO>()
                .eq("order_id",updateReqVO.getOrderId())
                .eq("user_id",updateReqVO.getUserId())
                .set(OrderStatus.PENDING_PAYMENT.getDisplayName().equals(updateReqVO.getStatus()),"status",updateReqVO.getStatus())
                .set(OrderStatus.PROCESSING.getDisplayName().equals(updateReqVO.getStatus()),"status",updateReqVO.getStatus())
                .set(OrderStatus.CANCELED.getDisplayName().equals(updateReqVO.getStatus()),"status",updateReqVO.getStatus())
        ) > 0;
    }

    public Boolean validateOrderPayable(Long userId, Long orderId) {
        return false;
    }

    public Boolean updateOrderPaid(Long userId, Long orderId) {
        return false;
    }


    /**
     * 检查订单是否存在
     *
     * @param orderId 订单主键
     * @return boolean checkOut
     */
    @Override
    public Boolean checkOutOrder(Long orderId) {
        return !Objects.isNull(getOrder(orderId));
    }
    /**
     * 获取订单信息
     *
     * @param orderId 主键ID
     * @return orderDO
     */
    @Override
    public OrderDO getOrder(Long orderId) {
        return orderMapper.getOrderByOrderId(orderId);
    }

    /**
     * 获取订单信息
     *
     * @param orderId 主键ID
     * @param userId  用户ID
     * @return orderDO
     */
    @Override
    public OrderDO getOrder(Long orderId, Long userId) {
        return orderMapper.selectOne(new QueryWrapper<OrderDO>().eq("order_id", orderId).eq("user_id", userId));
    }

    /**
     * 获取用户订单列表
     *
     * @param userId 用户ID
     * @return list
     */
    @Override
    public List<OrderDO> getOrderList(Long userId) {
        return orderMapper.selectList(new QueryWrapper<OrderDO>().eq("user_id", userId));
    }
}
