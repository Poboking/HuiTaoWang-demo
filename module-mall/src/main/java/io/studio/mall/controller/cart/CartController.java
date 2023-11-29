package io.studio.mall.controller.cart;

import io.studio.mall.controller.cart.vo.CartItemCreateReqVO;
import io.studio.mall.controller.cart.vo.CartItemRespVO;
import io.studio.mall.controller.cart.vo.CartItemUpdateReqVO;
import io.studio.mall.convert.cart.CartItemConvert;
import io.studio.mall.dal.dataobject.CartItemDO;
import io.studio.mall.service.impl.CartItemServiceImpl;
import io.studio.mall.service.impl.CartServiceImpl;
import io.studio.mall.service.impl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pojo.CommonResult;

import javax.validation.Valid;

import java.util.List;
import java.util.Objects;

import static pojo.CommonResult.success;
import static pojo.CommonResult.error;

/**
 * Date:2023/11/26 20:35
 *
 * @Author:poboking
 */
@Tag(name = "电商管理 - 购物车项管理")
@RestController
@RequestMapping("/api/mall/cart")
@Validated
@Slf4j
public class CartController {
    @Resource
    private CartItemServiceImpl cartItemService;
    @Resource
    private CartServiceImpl cartService;
    @Resource
    private ProductServiceImpl productService;

    @PostMapping("/add")
    @Operation(summary = "添加商品到购物车")
    public CommonResult<Long> addCartItem(@Valid @RequestBody CartItemCreateReqVO createReqVO) {
        log.info("[{}]: being cart item created of process", createReqVO);
        //检验购物车是否存在
        if (Objects.isNull(createReqVO.getUserId()) || !cartService.checkOutCartByUser(createReqVO.getUserId())) {
            return error(400, "add product to cart failure on account of the userId non-existent");
        }
        //校验商品是否存在
        if (Objects.isNull(productService.getProduct(createReqVO.getProductId()))){
            return error(400, "add product to cart failure on account of the productId non-existent");
        }
        //检验商品是否在购物车中
        if (Boolean.FALSE.equals(cartItemService.checkOutCartItemByUserAndProduct(createReqVO.getUserId(),createReqVO.getProductId()))){
            return error(400,"Add failure:The item is already in the shopping cart");
        }
        //新增购物车项
        Long itemId = cartItemService.insertCartItem(createReqVO.getUserId(), createReqVO);
        if (itemId < 0) {
            return error(500, "add product to cart failure on account of internal error");
        }
        return success(itemId);
    }

    @DeleteMapping("/delete/{itemId}")
    @Operation(summary = "删除购物车项")
    public CommonResult<Object> deleteCartItem(@Valid @PathVariable("itemId") Long itemId) {
        log.info("[{}]: being cart item deleted of process", itemId);
        if (Boolean.FALSE.equals(cartItemService.checkOutCartItem(itemId))) {
            return error(400, "cart item delete failure on account of the cartItemId non-existent");
        }
        if (Boolean.FALSE.equals(cartItemService.deleteCartItem(itemId))) {
            return error(500, "cart item delete failure on account of internal error");
        }
        return success(true);
    }

    @PutMapping("/update")
    @Operation(summary = "更新购物车项")
    public CommonResult<Object> updateCartItem(@Valid @RequestBody CartItemUpdateReqVO updateReqVO) {
        log.info("[{}]: being cart item updated of process", updateReqVO);
        if (Boolean.FALSE.equals(productService.checkOutProduct(updateReqVO.getProductId()))) {
            return error(400, "cart item update failure on account of the product non-existent");
        }
        if (Boolean.FALSE.equals(cartItemService.updateCartItem(updateReqVO))) {
            return error(500, "cart item update failure on account of internal error");
        }
        return success(true);
    }

    @GetMapping("/clean/{userId}")
    @Operation(summary = "清空购物车")
    public CommonResult<Object> cleanCart(@Valid @PathVariable("userId") Long userId) {
        log.info("[{}]: being cart item clean of process", userId);
        if (Boolean.FALSE.equals(cartService.checkOutCartByUser(userId))){
            return error(400,"cart clean failure on account of the userId non-existent");
        }
        if (Boolean.FALSE.equals(cartItemService.cleanCartItem(userId))) {
            return error(500, "cart clean failure on account of internal error");
        }
        return success(true);
    }

    @GetMapping("/get/{userId}")
    @Operation(summary = "获取购物车详情")
    public CommonResult<List<CartItemRespVO>> getCartDetail(@Valid @PathVariable("userId") Long userId) {
        log.info("[{}]: being cart item list get of process", userId);
        if (Boolean.FALSE.equals(cartService.checkOutCartByUser(userId))){
            return error(400,"cart item clean failure on account of the userId non-existent");
        }
        List<CartItemDO> cartDetail = cartItemService.getCartItemByUserId(userId);
        if (cartDetail.isEmpty()){
            return error(500,"cart item clean failure on account of internal error");
        }
        List<CartItemRespVO> cartItemRespVOS = CartItemConvert.INSTANCE.convertList(cartDetail);
        cartItemRespVOS.forEach(resp -> resp.setUserId(userId));
        return success(cartItemRespVOS);
    }

}
