package io.studio.mall.controller.product;

import io.studio.mall.controller.product.vo.ProductCreateReqVO;
import io.studio.mall.controller.product.vo.ProductRespVO;
import io.studio.mall.controller.product.vo.ProductUpdateReqVO;
import io.studio.mall.convert.product.ProductConvert;
import io.studio.mall.dal.dataobject.ProductDO;
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

import static pojo.CommonResult.success;
import static pojo.CommonResult.error;

/**
 * Date:2023/11/26 20:35
 *
 * @Author:poboking
 */
@Tag(name = "电商管理 - 商品管理")
@RestController
@RequestMapping("/api/mall/product")
@Validated
@Slf4j
public class ProductController {
    @Resource
    private ProductServiceImpl productService;

    @PostMapping("/create")
    @Operation(summary = " 创建商品项")
    public CommonResult<Long> createProduct(@Valid @RequestBody ProductCreateReqVO createReqVO) {
        log.info("[{}]: being product created of process", createReqVO);
        Long id = productService.insertProduct(createReqVO);
        if (id < 0) {
            return error(500, "product create failure on account of internal error");
        }
        return success(id);
    }

    @DeleteMapping("/delete/{productId}")
    @Operation(summary = "删除商品项")
    public CommonResult<Object> deleteProduct(@Valid @PathVariable("productId")Long productId){
        log.info("[{}]: being product deleted of process", productId);
        if (Boolean.FALSE.equals(productService.checkOutProduct(productId))){
            return error(400,"product delete failure on account of the productId non-existent");
        }
        if (Boolean.FALSE.equals(productService.deleteProduct(productId))){
            return error(500,"product delete failure on account of internal error");
        }
        return success(true);
    }

    @PutMapping("/update")
    @Operation(summary = "更新商品项")
    public CommonResult<Object> updateProduct(@Valid @RequestBody ProductUpdateReqVO updateReqVO){
        log.info("[{}]: being product updated of process", updateReqVO);
        if (Boolean.FALSE.equals(productService.checkOutProduct(updateReqVO.getProductId()))){
            return error(400,"product update failure on account of the productId non-existent");
        }
        if (Boolean.FALSE.equals(productService.updateProduct(updateReqVO))) {
            return error(500,"product update failure on account of internal error");
        }
        return success(true);
    }

    @GetMapping("/list")
    @Operation(summary = "获取商品列表")
    public CommonResult<List<ProductRespVO>> getProductList(){
        log.info("[]: being product list get of process");
        List<ProductDO> productList = productService.getProductList();
        if (productList.isEmpty()) {
            return error(500,"product list get failure on account of internal error");
        }
        return success(ProductConvert.INSTANCE.convertList(productList));
    }

    @GetMapping("/list/recommend")
    @Operation(summary = "获取商品推荐列表")
    public CommonResult<List<ProductRespVO>> getProductRecommendList(){
        log.info("[]: being product recommend list get of process");
        List<ProductDO> productRecommendList = productService.getProductRecommendList();
        if (productRecommendList.isEmpty()){
            return error(500,"product recommend list get failure on account of internal error");
        }
        return success(ProductConvert.INSTANCE.convertList(productRecommendList));
    }
}
