package io.studio.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.studio.mall.controller.product.vo.ProductCreateReqVO;
import io.studio.mall.controller.product.vo.ProductUpdateReqVO;
import io.studio.mall.convert.product.ProductConvert;
import io.studio.mall.dal.dataobject.ProductDO;
import io.studio.mall.dal.mysql.ProductMapper;
import javax.annotation.Resource;

import io.studio.mall.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * Date:2023/11/27 10:52
 *
 * @Author:poboking
 */
@Service
public class ProductServiceImpl implements IProductService {
    @Resource
    private ProductMapper productMapper;
    /**
     * 新增商品
     *
     * @param createReqVO 创建信息
     * @return Long 主键ID
     */
    @Override
    @Transactional
    public Long insertProduct(ProductCreateReqVO createReqVO) {
        ProductDO productDO = ProductConvert.INSTANCE.convert(createReqVO);
        if (productMapper.insertAndGetId(productDO) < 0) {
            return -1L;
        }
        return productDO.getProductId();
    }

    /**
     * 删除商品
     *
     * @param productId 商品ID
     * @return boolean delete
     */
    @Override
    public Boolean deleteProduct(Long productId) {
        return productMapper.deleteById(productId) > 0;
    }

    /**
     * 更新商品
     *
     * @param updateReqVO 更新信息
     * @return boolean update
     */
    @Override
    public Boolean updateProduct(ProductUpdateReqVO updateReqVO) {
        return productMapper.updateById(ProductConvert.INSTANCE.convert(updateReqVO)) >0;
    }

    /**
     * 检查指定ID商品是否存在
     *
     * @param productId 商品ID
     * @return boolean checkout
     */
    @Override
    public Boolean checkOutProduct(Long productId) {
        return !Objects.isNull(getProduct(productId));
    }

    /**
     * 获取指定ID商品
     *
     * @param productId 商品ID
     * @return productDO
     */
    @Override
    public ProductDO getProduct(Long productId) {
        return productMapper.selectById(productId);
    }

    /**
     * 获取无参商品列表
     *
     * @return list
     */
    @Override
    public List<ProductDO> getProductList() {
        return productMapper.selectList(null);
    }

    /**
     * 获取指定IDs商品列表
     *
     * @param ids 主键列表
     * @return list
     */
    @Override
    public List<ProductDO> getProductList(List<Long> ids) {
        return productMapper.selectBatchIds(ids);
    }

    /**
     * 搜索keyword商品列表
     *
     * @param keyword 商品名称/关键词
     * @return list
     */
    @Override
    public List<ProductDO> getProductList(String keyword) {
        return productMapper.selectList(new QueryWrapper<ProductDO>().like("name",keyword)
                .or().like("subhead",keyword).or().like("description",keyword));
    }

    /**
     * 获取商品推荐列表
     *
     * @return list
     */
    @Override
    public List<ProductDO> getProductRecommendList() {
        return productMapper.selectList(new QueryWrapper<ProductDO>().eq("recommend",1));
    }
}
