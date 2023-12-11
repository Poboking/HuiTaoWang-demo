package io.studio.auth.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.auth.dal.dataobject.InvalidTokensDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Date:2023/12/6 9:37
 *
 * @Author:poboking
 */
@Mapper
public interface InvalidTokensMapper extends BaseMapper<InvalidTokensDO> {
    @Insert("INSERT INTO invalid_tokens (token) VALUES (#{token})")
    int insertToken(@Param("token")String token);

    @Select("SELECT * FROM invalid_tokens WHERE token = #{token}")
    InvalidTokensDO findByToken(@Param("token")String token);
}
