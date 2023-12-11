package io.studio.auth.config;

import io.studio.auth.dal.mysql.UserMapper;
import io.studio.auth.service.security.Impl.IUserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * Date:2023/12/4 19:56
 *
 * @Author:poboking
 */
@Configuration
@RequiredArgsConstructor
@ComponentScan("io.studio.auth.service.security")
public class ApplicationConfiguration {
    @Resource
    private final UserMapper userMapper;

    @Bean
    public AuthenticationProvider authenticationProvider(){
        //用于基于数据访问对象（DAO）进行用户身份验证
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }

    //spring security类内置的账户密码验证类, 用于处理身份验证请求
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


    @Bean
    //定义了用于从数据源加载用户详细信息的方法
    public UserDetailsService userDetailsService() {
        return phoneNumber -> Optional.ofNullable(userMapper.findByPhoneNumber(phoneNumber))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
