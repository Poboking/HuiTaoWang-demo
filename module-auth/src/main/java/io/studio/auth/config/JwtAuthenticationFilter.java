package io.studio.auth.config;

import io.studio.auth.service.security.JwtService;
import io.studio.auth.utils.IpAddressUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * Date:2023/12/4 20:00
 *
 * @Author:poboking
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Resource
    private final JwtService jwtService;
    @Resource
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authHead = request.getHeader("Authorization");
        final String jwt;

        /*
          若Authorization头信息为null 或 若token不以"Bearer  "为开头 或 该token处于失效列表中
          则将该请求传递到过滤链的下一端, 实际上是过滤掉, 或重定向为login界面
         */
        if (Objects.isNull(authHead) || Boolean.FALSE.equals(authHead.startsWith("Bearer ")) || jwtService.isTokenInvalid(authHead.substring(7))){
            log.info("[ IP "+ IpAddressUtil.getClientIp(request) + "]: is not token");
            filterChain.doFilter(request,response);
            return;
        }

        /*
            若经过上述if判断, 则默认该用户已经注册或或登录或登录过却没有注销, 开始获取token进行验证
         */
        jwt = authHead.substring(7);
        final String phoneNumber = jwtService.extractUserName(jwt);

        /*
            若username不为null 或 security上下文没有保存相应的Authentication, 则进行验证
         */
        if (!Objects.isNull(phoneNumber) && Objects.isNull(SecurityContextHolder.getContext().getAuthentication())){
            UserDetails userDetails = userDetailsService.loadUserByUsername(phoneNumber);

            /*
                判断token是否有效: 是否未过期, token中username是否等于数据库内username
                如果没有过期, 则保存在上下文中.
             */
            if (jwtService.isTokenValid(jwt,userDetails)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null
                        ,userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                //将登录信息保存在security上下文中.
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request,response);
    }

}
