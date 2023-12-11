package io.studio.auth.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.auth.dal.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Date:2023/12/4 17:41
 *
 * @Author:poboking
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
    int insertAndGetID(@Param("userDO") UserDO userDO);

    int updateIfNoNull(@Param("userDO") UserDO userDO);

    List<String> getAvatarUrlListByUserId(List<Long> ids);

    @Select("SELECT * FROM user WHERE phone_number = #{phoneNumber}")
    UserDO findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    @Select("SELECT * FROM user WHERE name = #{name}")
    UserDO findByName(@Param("name") String name);

    @Select("SELECT * FROM user WHERE phone_number = #{phoneNumber} AND user_id <> #{userId}")
    UserDO findByPhoneNumberExcludeUserId(@Param("phoneNumber") String phoneNumber, @Param("userId") Long userId);

    @Select("SELECT * FROM user WHERE name = #{name} AND user_id <> #{userId}")
    UserDO findByNameExcludeUserId(@Param("name") String name, @Param("userId") Long userId);
}
