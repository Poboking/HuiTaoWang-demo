package io.studio.mall.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.mall.dal.dataobject.CartItemDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Date:2023/11/26 20:27
 *
 * @Author:poboking
 */
@Mapper
public interface CartItemMapper extends BaseMapper<CartItemDO> {
    int insertAndGetId(@Param("cartItemDO")CartItemDO cartItemDO);
    //根据用户ID和产品ID列表删除购物车项
    int deleteByCartIdAndProductIds(@Param("cartId") Long cartId, @Param("productIds") List<Long> productIds);
}
