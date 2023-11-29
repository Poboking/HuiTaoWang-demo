package io.studio.mall.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.mall.dal.dataobject.AddressDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Date:2023/11/26 20:28
 *
 * @Author:poboking
 */
@Mapper
public interface AddressMapper extends BaseMapper<AddressDO> {
    int insertAndGetId(@Param("addressDO") AddressDO addressDO);
}
