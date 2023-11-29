package io.studio.mall.service;

import io.studio.mall.dal.dataobject.CartDO;

/**
 * Date:2023/11/26 20:29
 *
 * @Author:poboking
 */
public interface ICartService {
    /**
     * 创建购物车
     *
     * @return cartID
     */
    Long insertCart(Long userId);

    /**
     * 删除购物车
     *
     * @param cartId 购物车ID
     * @return boolean delete
     */
    Boolean deleteCart(Long cartId);

    /**
     * 更新用户购物车
     *
     * @param cartId    用户ID
     * @param newUserId 购物车新ID
     * @return boolean update
     */
    Boolean updateCart(Long cartId, Long newUserId);

    /**
     * 检查购物车是否存在
     * @param userId ID
     * @return boolean checkOut
     */
    Boolean checkOutCartByUser(Long userId);

    /**
     * 获取指定用户的购物车ID
     *
     * @param userId 用户Id
     * @return long cartId
     */
    Long getCart(Long userId);
}
