package io.studio.mall.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.mall.dal.dataobject.CouponDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Date:2023/11/26 20:27
 *
 * @Author:poboking
 */
@Mapper
public interface CouponMapper extends BaseMapper<CouponDO> {
}
