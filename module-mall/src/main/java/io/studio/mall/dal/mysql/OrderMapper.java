package io.studio.mall.dal.mysql;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.mall.dal.dataobject.OrderDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Date:2023/11/26 20:22
 *
 * @Author:poboking
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderDO> {
    int insertAndGetId(@Param("orderDO") OrderDO orderDO);

    default int updateByIdAndStatus(Long id, Integer status, OrderDO update) {
        return update(update, new LambdaUpdateWrapper<OrderDO>()
                .eq(OrderDO::getOrderId, id).eq(OrderDO::getStatus, status));
    }

    OrderDO getOrderByOrderId(@Param("orderId") Long orderId);
}
