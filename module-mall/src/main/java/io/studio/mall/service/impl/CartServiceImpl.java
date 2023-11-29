package io.studio.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.studio.mall.dal.dataobject.CartDO;
import io.studio.mall.dal.mysql.CartMapper;
import io.studio.mall.service.ICartService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Date:2023/11/27 14:23
 *
 * @Author:poboking
 */
@Service
public class CartServiceImpl implements ICartService {
    @Resource
    private CartMapper cartMapper;
    /**
     * 创建购物车
     *
     * @param userId 用户ID
     * @return cartID
     */
    @Override
    public Long insertCart(Long userId) {
        CartDO cartDO = new CartDO();
        cartDO.setUserId(userId);
        if (cartMapper.insertAndGetId(cartDO) < 0) {
            return -1L;
        }
        return cartDO.getCartId();
    }

    /**
     * 删除购物车
     *
     * @param cartId 购物车ID
     * @return boolean delete
     */
    @Override
    public Boolean deleteCart(Long cartId) {
        return cartMapper.deleteById(cartId) > 0;
    }

    /**
     * 更新用户购物车
     *
     * @param cartId    购物车新ID
     * @param newUserId 用户ID
     * @return boolean update
     */
    @Override
    public Boolean updateCart(Long cartId, Long newUserId) {
        if (Objects.isNull(cartMapper.selectById(cartId))){
            return false;
        }
        return cartMapper.updateById(new CartDO(cartId, newUserId)) > 0;
    }

    /**
     * 检查购物车是否存在
     *
     * @param userId ID
     * @return boolean checkOut
     */
    @Override
    public Boolean checkOutCartByUser(Long userId) {
        return !Objects.isNull(cartMapper.getCartIdByUserId(userId));
    }

    /**
     * 获取指定用户的购物车ID
     *
     * @param userId 用户Id
     * @return long cartId
     */
    @Override
    public Long getCart(Long userId) {
        CartDO cartDO = cartMapper.selectOne(new QueryWrapper<CartDO>()
                .eq("user_id", userId));
        if (Objects.isNull(cartDO)){
            return -1L;
        }
        return cartDO.getCartId();
    }
}
