package io.studio.mall.convert.product;

import io.studio.mall.controller.product.vo.ProductCreateReqVO;
import io.studio.mall.controller.product.vo.ProductRespVO;
import io.studio.mall.controller.product.vo.ProductUpdateReqVO;
import io.studio.mall.dal.dataobject.ProductDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Date:2023/11/27 9:24
 *
 * @Author:poboking
 */
@Mapper
public interface ProductConvert {
    ProductConvert INSTANCE = Mappers.getMapper(ProductConvert.class);
    ProductDO convert(ProductCreateReqVO bean);
    ProductDO convert(ProductUpdateReqVO bean);
    ProductRespVO map(ProductDO value);
    List<ProductRespVO> convertList(List<ProductDO> list);
}
