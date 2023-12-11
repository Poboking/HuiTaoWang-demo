package io.studio.auth.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.auth.dal.dataobject.AdministratorDO;
import io.studio.auth.dal.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Date:2023/12/4 17:45
 *
 * @Author:poboking
 */
@Mapper
public interface AdministratorMapper extends BaseMapper<AdministratorDO> {
}
