package io.studio.mall.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.mall.dal.dataobject.ProductDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Date:2023/11/26 20:25
 *
 * @Author:poboking
 */
@Mapper
public interface ProductMapper extends BaseMapper<ProductDO> {
    int insertAndGetId(@Param("productDO") ProductDO productDO);
}
