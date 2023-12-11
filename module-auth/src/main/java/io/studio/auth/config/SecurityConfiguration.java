package io.studio.auth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * Date:2023/12/4 20:24
 *
 * @Author:poboking
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final String registerPath = "/api/auth/authenticate/register";
    private final String loginPath = "/api/auth/authenticate/login";
    private final String logoutPath = "/api/auth/authenticate/logout";

    @Resource
    private final AuthenticationProvider authenticationProvider;
    @Resource
    private JwtAuthenticationFilter jwtAuthFilter;

//    @Resource
//    private UserDetailsService userDetailsService;

    //解决 WebSecurityConfigurerAdapter 过时的方法之一, 就是提供提供一股FilterChain类的Bean.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers(registerPath).permitAll()
                    .antMatchers("/css/**").permitAll()
                    .antMatchers("/js/**").permitAll()
                    .antMatchers("/api/auth/authenticate/**").permitAll()
                    .anyRequest().authenticated()
                /*
                    登录设置
                 */
                .and()
                    .formLogin()//.disable()
                    .loginPage(loginPath)
//                    .loginProcessingUrl("/api/auth/authenticate/perform-login") //此配置不可与loginPage()一起使用, 否则会导致重复验证, 且无法登录
                    .defaultSuccessUrl("/api/auth/user/homepage", true)
                /*
                    登出设置
                 */
                .and()
                    .logout()
                    .logoutUrl(logoutPath)
                    .logoutSuccessUrl(loginPath)
                    .permitAll()
                .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
//                    .userDetailsService(userDetailsService) userDetailService 已经在authenticationProvider的bean中设置过了
                    .authenticationProvider(authenticationProvider)
                    .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
