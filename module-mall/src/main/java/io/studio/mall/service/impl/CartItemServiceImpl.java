package io.studio.mall.service.impl;

import ch.qos.logback.classic.spi.EventArgUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.studio.mall.controller.cart.vo.CartItemCreateReqVO;
import io.studio.mall.controller.cart.vo.CartItemUpdateReqVO;
import io.studio.mall.convert.cart.CartItemConvert;
import io.studio.mall.dal.dataobject.CartDO;
import io.studio.mall.dal.dataobject.CartItemDO;
import io.studio.mall.dal.mysql.CartItemMapper;
import io.studio.mall.dal.mysql.CartMapper;
import io.studio.mall.service.ICartItemService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Date:2023/11/27 14:23
 *
 * @Author:poboking
 */
@Service
public class CartItemServiceImpl implements ICartItemService {
    @Resource
    private CartItemMapper cartItemMapper;
    @Resource
    private CartMapper cartMapper;

    /**
     * 创建购物车商品项
     *
     * @param createReqVO 创建信息
     * @return 购物车商品项ID
     */
    @Override
    public Long insertCartItem(Long cartId, CartItemCreateReqVO createReqVO) {
        CartItemDO itemDO = CartItemConvert.INSTANCE.convert(createReqVO);
        itemDO.setCartId(cartId);
        if (cartItemMapper.insertAndGetId(itemDO) < 0) {
            return -1L;
        }
        return itemDO.getItemId();
    }

    /**
     * 删除购物车商品项
     *
     * @param cartId 购物车ID
     * @return boolean delete
     */
    @Override
    public Boolean deleteCartItem(Long cartId) {
        return cartItemMapper.deleteById(cartId) > 0;
    }

    /**
     * 删除指定ID购物车商品项列表
     *
     * @param cartIds ids
     * @return boolean delete
     */
    @Override
    public Boolean deleteCartItemList(List<Long> cartIds) {
        return cartItemMapper.deleteBatchIds(cartIds) > 0;
    }

    /**
     * 删除指定用户购物车项列表
     *
     * @param userId     用户ID
     * @param productIds 商品IDs
     * @return boolean delete
     */
    @Override
    public Boolean deleteCartItemList(Long userId, List<Long> productIds) {
        Long cartId = cartMapper.getCartIdByUserId(userId);
        if (Objects.isNull(cartId) || cartId < 0){
            return false;
        }
        return cartItemMapper.deleteByCartIdAndProductIds(cartId,productIds) > 0;
    }

    /**
     * 清空购物车
     *
     * @param userId 用户ID
     * @return boolean cleanCart
     */
    @Override
    public Boolean cleanCartItem(Long userId) {
        List<Long> list = new ArrayList<>();
        cartItemMapper.selectList(new QueryWrapper<CartItemDO>()
                .eq("cart_id",cartMapper.getCartIdByUserId(userId)))
                .forEach(item ->list.add(item.getCartId()));
        return deleteCartItemList(list);
    }

    /**
     * 更新购物车商品项
     *
     * @param updateReqVO 更新信息
     * @return boolean update
     */
    @Override
    public Boolean updateCartItem(CartItemUpdateReqVO updateReqVO) {
        Long cartId = cartMapper.getCartIdByUserId(updateReqVO.getUserId());
        CartItemDO itemDO = CartItemConvert.INSTANCE.convert(updateReqVO);
        itemDO.setCartId(cartId);
        return cartItemMapper.updateById(itemDO) > 0;
//        return cartItemMapper.update(itemDO,new UpdateWrapper<CartItemDO>()
//                .eq("item_id",itemDO.getItemId())
//                .set()
//        ) > 0;
    }

    /**
     * 更新购物车商品项数量
     * @param cartItemId 商品项ID
     * @param quantity 数量
     * @return boolean update
     */
    @Override
    public Boolean updateCartItemCount(Long cartItemId,Integer quantity) {
        //update的第一个参数用于确定更新哪张表, 第二个参数用于限定更新行的条件
        return cartItemMapper.update(new CartItemDO(),new UpdateWrapper<CartItemDO>().eq("item_id",cartItemId)
                .set("quantity",quantity)) > 0;
    }

    /**
     * 检查购物车项是否存在
     *
     * @param cartItemId 购物车项ID
     * @return boolean checkOut
     */
    @Override
    public Boolean checkOutCartItem(Long cartItemId) {
        return !Objects.isNull(getCartItemByCartItemId(cartItemId));
    }

    /**
     * 检查购物车项是否存在
     *
     * @param userId    用户ID
     * @param productId 商品ID
     * @return boolean checkOut
     */
    @Override
    public Boolean checkOutCartItemByUserAndProduct(Long userId, Long productId) {
        return Objects.isNull(cartItemMapper.selectOne(new QueryWrapper<CartItemDO>()
                .eq("cart_id",cartMapper.getCartIdByUserId(userId))
                .eq("product_id",productId)));
    }

    /**
     * 获取购物项
     *
     * @param cartItemId 购物车项ID
     * @return entity
     */
    @Override
    public CartItemDO getCartItemByCartItemId(Long cartItemId) {
        return cartItemMapper.selectOne(new QueryWrapper<CartItemDO>()
                .eq("item_id", cartItemId));
    }

    /**
     * 获取购物车商品项列表
     *
     * @param cartId 购物车ID
     * @return list
     */
    @Override
    public List<CartItemDO> getCartItemByCartId(Long cartId) {
        return cartItemMapper.selectList(new QueryWrapper<CartItemDO>().eq("cart_id",cartId));
    }

    /**
     * 获取购物车商品项列表
     *
     * @param userId 用户ID
     * @return list
     */
    @Override
    public List<CartItemDO> getCartItemByUserId(Long userId) {
        Long cartId = cartMapper.getCartIdByUserId(userId);
        if (Objects.isNull(cartId)){
            return null;
        }
        return cartItemMapper.selectList(new QueryWrapper<CartItemDO>().eq("cart_id",cartId));
    }
}
