package io.studio.mall.service;

import io.studio.mall.controller.cart.vo.CartItemCreateReqVO;
import io.studio.mall.controller.cart.vo.CartItemRespVO;
import io.studio.mall.controller.cart.vo.CartItemUpdateReqVO;
import io.studio.mall.convert.cart.CartItemConvert;
import io.studio.mall.dal.dataobject.CartItemDO;

import java.util.List;

/**
 * Date:2023/11/26 20:30
 *
 * @Author:poboking
 */
public interface ICartItemService {
    /**
     * 创建购物车商品项
     *
     * @param createReqVO 创建信息
     * @return 购物车商品项ID
     */

    Long insertCartItem(Long cartId, CartItemCreateReqVO createReqVO);

    /**
     * 删除购物车商品项
     *
     * @param cartId 购物车ID
     * @return boolean delete
     */
    Boolean deleteCartItem(Long cartId);

    /**
     * 删除指定ID购物车商品项列表
     *
     * @param cartIds ids
     * @return boolean delete
     */
    Boolean deleteCartItemList(List<Long> cartIds);

    /**
     * 删除指定用户购物车项列表
     *
     * @param userId     用户ID
     * @param productIds 商品IDs
     * @return boolean delete
     */
    Boolean deleteCartItemList(Long userId, List<Long> productIds);

    /**
     * 清空购物车
     *
     * @param userId 用户ID
     * @return boolean cleanCart
     */
    Boolean cleanCartItem(Long userId);

    /**
     * 更新购物车商品项
     *
     * @param updateReqVO 更新信息
     * @return boolean update
     */
    Boolean updateCartItem(CartItemUpdateReqVO updateReqVO);

    /**
     * 更新购物车商品项
     *
     * @param cartItemId 商品项ID
     * @param quantity   数量
     * @return boolean update
     */
    Boolean updateCartItemCount(Long cartItemId, Integer quantity);

    /**
     * 检查购物车项是否存在
     *
     * @param cartItemId 购物车项ID
     * @return boolean checkOut
     */
    Boolean checkOutCartItem(Long cartItemId);

    /**
     * 检查购物车项是否存在
     * @param userId 用户ID
     * @param ProductId 商品ID
     * @return boolean checkOut
     */
    Boolean checkOutCartItemByUserAndProduct(Long userId, Long ProductId);

    /**
     * 获取购物项
     * @param cartItemId 购物车项ID
     * @return entity
     */
    CartItemDO getCartItemByCartItemId(Long cartItemId);

    /**
     * 获取购物车商品项列表
     *
     * @param cartId 购物车ID
     * @return list
     */
    List<CartItemDO> getCartItemByCartId(Long cartId);

    /**
     * 获取购物车商品项列表
     *
     * @param userId 用户ID
     * @return list
     */
    List<CartItemDO> getCartItemByUserId(Long userId);

}
