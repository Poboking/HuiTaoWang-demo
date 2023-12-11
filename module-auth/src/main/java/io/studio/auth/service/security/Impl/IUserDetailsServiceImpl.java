package io.studio.auth.service.security.Impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.studio.auth.dal.dataobject.UserDO;
import io.studio.auth.dal.mysql.UserMapper;
import io.studio.auth.service.security.IUserDetailService;
import io.studio.auth.utils.StrUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * Date:2023/12/8 16:59
 *
 * @Author:poboking
 */
//@Service
@Slf4j
@RequiredArgsConstructor
public class IUserDetailsServiceImpl implements IUserDetailService {
    @Resource
    private final UserMapper mapper;

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //判断用户名是否为空
        if (StrUtil.isEmpty(username)) {
            throw new NullPointerException("用户名不能为空");
        }
        UserDO loginUser = mapper.findByPhoneNumber(username);
        log.info("获取到的用户：{}", loginUser);
        if (Objects.isNull(loginUser)) {
            throw new InternalAuthenticationServiceException("用户名错误");
        }
        return loginUser;
    }
}
