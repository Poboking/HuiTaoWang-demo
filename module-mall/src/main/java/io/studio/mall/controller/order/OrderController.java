package io.studio.mall.controller.order;

import io.studio.mall.controller.cart.vo.CartItemSubmitOrderReqVO;
import io.studio.mall.controller.order.vo.order.OrderCreateReqVO;
import io.studio.mall.controller.order.vo.order.OrderRespVO;
import io.studio.mall.controller.order.vo.order.OrderUpdateReqVO;
import io.studio.mall.convert.order.OrderConvert;
import io.studio.mall.convert.order.OrderItemConvert;
import io.studio.mall.dal.dataobject.OrderDO;
import io.studio.mall.service.impl.CartItemServiceImpl;
import io.studio.mall.service.impl.CartServiceImpl;
import io.studio.mall.service.impl.OrderItemServiceImpl;
import io.studio.mall.service.impl.OrderServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pojo.CommonResult;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static pojo.CommonResult.error;
import static pojo.CommonResult.success;

/**
 * Date:2023/11/26 20:35
 *
 * @Author:poboking
 */
@Tag(name = "电商管理 - 订单管理")
@RestController
@RequestMapping("/api/mall/order")
@Validated
@Slf4j
public class OrderController {
    @Resource
    private OrderItemServiceImpl orderItemService;
    @Resource
    private OrderServiceImpl orderService;
    @Resource
    private CartItemServiceImpl cartItemService;

    @Resource
    private CartServiceImpl cartService;

    @PostMapping("/create")
    @Operation(summary = "创建订单项")
    public CommonResult<Long> createOrder(@Valid @RequestBody OrderCreateReqVO createReqVO){
        log.info("[{}]: being order created of process", createReqVO);
        List<Long> productIds = new ArrayList<>();
        List<CartItemSubmitOrderReqVO> products = createReqVO.getProducts();

        if (products.isEmpty()){
            return error(400,"order create failure on account of product not null");
        }

        //检查User是否存在
        if (Boolean.FALSE.equals(cartService.checkOutCartByUser(createReqVO.getUserId()))){
            return error(400,"order create failure on account of the userId non-existent");
        }

        //删除对应购物车项
        createReqVO.getProducts().forEach(product ->productIds.add(product.getProductId()));
        cartItemService.deleteCartItemList(createReqVO.getUserId(),productIds);
//        if (Boolean.FALSE.equals(cartItemService.deleteCartItemList(createReqVO.getUserId(),productIds))) {
//            return error(500,"order create failure on account of cart items delete failure");
//        }

        //创建订单
        Long orderId = orderService.createOrder(createReqVO);
        if (orderId < 0){
            return error(500,"order create failure on account of OrderService error");
        }

        //添加订单商品项
        products.forEach(product -> product.setOrderId(orderId));
        List<Long> itemId = orderItemService.submitOrderItem(products);
        if (itemId.isEmpty()){
            return error(500,"order create failure on account of OrderItemService error");
        }
        return success(orderId);
    }

    @DeleteMapping("/delete/{orderId}")
    @Operation(summary = "删除订单项")
    public CommonResult<Object> deleteOrder(@Valid @PathVariable("orderId") Long orderId){
        log.info("[{}]: being order deleted of process", orderId);
        if (Boolean.FALSE.equals(orderService.checkOutOrder(orderId))){
            return error(400,"order delete failure on account of the orderId non-existent");
        }
        if (Boolean.FALSE.equals(orderItemService.deleteOrderItemByOrderId(orderId))){
            return error(500,"order delete failure on account of order item delete failure");
        }
        if (Boolean.FALSE.equals(orderService.deleteOrder(orderId))){
            return error(500,"order delete failure on account of OrderService error");
        }
        return success(true);
    }

    @PutMapping("/update")
    @Operation(summary = "更新订单状态")
    public CommonResult<Object> updateOrder(@NotNull @Valid @RequestBody OrderUpdateReqVO updateReqVO){
        log.info("[{}]: being order updated of process", updateReqVO);
        if (Boolean.FALSE.equals(orderService.checkOutOrder(updateReqVO.getOrderId()))){
            return error(400,"order update failure on account of the orderId non-existent");
        }
        if (Boolean.FALSE.equals(orderService.updateOrder(updateReqVO))){
            return error(500,"order update failure on account of OrderService error");
        }
        return success(true);
    }

    @GetMapping("/get/{userId}")
    @Operation(summary = "获取订单详情")
    public CommonResult<List<OrderRespVO>> getOrderDetail(@Valid @PathVariable Long userId){
        log.info("[]: being order list get of process");
        List<OrderDO> orderList = orderService.getOrderList(userId);
        if (orderList.isEmpty()){
            return error(400,String.format("The user@%d non-existent or user orders non-existent",userId));
        }
        List<OrderRespVO> orderRespVOList = OrderConvert.INSTANCE.convertList(orderList);
        orderRespVOList.forEach(order -> order.setProducts(OrderItemConvert.INSTANCE.convertList(orderItemService.getOrderItemList(order.getOrderId()))));
        return success(orderRespVOList);
    }
}
