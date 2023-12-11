package io.studio.auth.service.security;

import io.studio.auth.dal.dataobject.UserDO;
import io.studio.auth.dal.mysql.UserMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Date:2023/12/8 16:55
 *
 * @Author:poboking
 */
public interface IUserDetailService extends UserDetailsService{
}
