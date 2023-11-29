package io.studio.mall.service;

import io.studio.mall.controller.product.vo.ProductCreateReqVO;
import io.studio.mall.controller.product.vo.ProductRespVO;
import io.studio.mall.controller.product.vo.ProductUpdateReqVO;
import io.studio.mall.dal.dataobject.ProductDO;

import java.util.List;

/**
 * Date:2023/11/26 20:29
 *
 * @Author:poboking
 */
public interface IProductService {
    /**
     * 新增商品
     *
     * @param createReqVO 创建信息
     * @return Long 主键ID
     */
    Long insertProduct(ProductCreateReqVO createReqVO);

    /**
     * 删除商品
     *
     * @param productId 商品ID
     * @return boolean delete
     */
    Boolean deleteProduct(Long productId);

    /**
     * 更新商品
     *
     * @param updateReqVO 更新信息
     * @return boolean update
     */
    Boolean updateProduct(ProductUpdateReqVO updateReqVO);

    /**
     * 检查指定ID商品是否存在
     *
     * @param productId 商品ID
     * @return boolean checkout
     */
    Boolean checkOutProduct(Long productId);
    /**
     * 获取指定ID商品
     *
     * @param productId 商品ID
     * @return productDO
     */
    ProductDO getProduct(Long productId);

    /**
     * 获取无参商品列表
     *
     * @return list
     */
    List<ProductDO> getProductList();

    /**
     * 获取指定IDs商品列表
     *
     * @param ids 主键列表
     * @return list
     */
    List<ProductDO> getProductList(List<Long> ids);

    /**
     * 搜索keyword商品列表
     *
     * @param keyword 商品名称/关键词
     * @return list
     */
    List<ProductDO> getProductList(String keyword);

    /**
     * 获取商品推荐列表
     *
     * @return list
     */
    List<ProductDO> getProductRecommendList();
}
