package io.studio.mall.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.mall.dal.dataobject.OrderItemDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Date:2023/11/26 20:24
 *
 * @Author:poboking
 */
@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItemDO> {
    int insertAndGetId(@Param("orderItemDO")OrderItemDO orderItemDO);
}
