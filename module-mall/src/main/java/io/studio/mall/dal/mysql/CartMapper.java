package io.studio.mall.dal.mysql;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.mall.dal.dataobject.CartDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Objects;

/**
 * Date:2023/11/26 20:26
 *
 * @Author:poboking
 */
@Mapper
public interface CartMapper extends BaseMapper<CartDO> {
    @Insert("INSERT INTO cart(user_id) VALUES (#{userId})")
    int initializeCart(@Param("userId")Long userId);
    int insertAndGetId(@Param("cartDO") CartDO cartDO);

    default Long getCartIdByUserId(@Param("userId") Long userId) {
        QueryWrapper<CartDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        CartDO cartDO = selectOne(queryWrapper);
        if (Objects.isNull(cartDO)){
            return null;
        }
        return cartDO.getCartId();
    }
}
