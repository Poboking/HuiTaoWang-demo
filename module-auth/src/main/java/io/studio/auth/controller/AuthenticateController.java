package io.studio.auth.controller;

import io.studio.auth.common.pojo.CommonResult;
import io.studio.auth.common.pojo.Token;
import io.studio.auth.controller.vo.biz.user.UserBaseVO;
import io.studio.auth.controller.vo.biz.user.UserLoginReqVO;
import io.studio.auth.controller.vo.biz.user.UserRegisterReqVO;
import io.studio.auth.controller.vo.security.AuthenticationRespVO;
import io.studio.auth.dal.dataobject.UserDO;
import io.studio.auth.service.security.AuthenticationService;
import io.studio.auth.utils.IpAddressUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import static io.studio.auth.common.pojo.CommonResult.error;
import static io.studio.auth.common.pojo.CommonResult.success;

/**
 * Date:2023/12/4 16:09
 *
 * @Author:poboking
 */
@Tag(name = "认证管理 - 权限控制")
@RestController
@RequestMapping("/api/auth/authenticate")
@RequiredArgsConstructor
@Validated
@Slf4j
public class AuthenticateController {
    @Resource
    private final AuthenticationService service;

    @GetMapping("/login")
    @Operation(summary = "登录页面")
    public String toLoginPage() {
        return "redirect:/api/auth/authenticate/login.html";
    }


    @PostMapping("/register")
    @Operation(summary = "用户注册项")
    public CommonResult<AuthenticationRespVO> register(@Valid @RequestBody UserRegisterReqVO registerReqVO
            , HttpServletResponse response
            , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                log.info("Field" + error.getField() + ":" + error.getDefaultMessage());
            }
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return error(400, "Failure to register an account of Bad Request");
        }
        Token token = service.register(registerReqVO);
        return getSuccessOrInternalError(response, token, registerReqVO.getPhoneNumber(), registerReqVO);
    }


    @PostMapping("/perform-login")
    @Operation(summary = "用户登录项")
    public CommonResult<AuthenticationRespVO> login(@Valid @RequestBody UserLoginReqVO loginReqVO
            , HttpServletResponse response
            , HttpServletRequest request
            , BindingResult bindingResult) {

        log.info("[ IP "+ IpAddressUtil.getClientIp(request) + "]: BEING LOGIN");

        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                log.info("Field" + error.getField() + ":" + error.getDefaultMessage());
            }
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return error(400, "Failure to login an account of Bad Request");
        }

        Token token = service.login(loginReqVO);
        return getSuccessOrInternalError(response, token, loginReqVO.getPhoneNumber(), loginReqVO);
    }

    @GetMapping("/logout")
    @Operation(summary = "用户注销项")
    public CommonResult<Object> logout(@RequestHeader("Authorization") String header) {
        service.logout(header.substring(7));
        return success(true);
    }

    @NotNull
    private CommonResult<AuthenticationRespVO> getSuccessOrInternalError(HttpServletResponse response, Token token, String phoneNumber, @RequestBody @Valid UserBaseVO ReqVO) {
        if (token.getToken().isBlank()) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return error(500, "Failure to authenticate an account of Failure to obtain token");
        }
        UserDO userDO = service.getUserId(phoneNumber);
        return success(AuthenticationRespVO.builder()
                .userId(userDO.getUserId())
                .userType(userDO.getUserType())
                .token(token)
                .build());
    }

    private static String getCurrentMethodName() {
        // 获取调用栈信息
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        /*
            第0个元素是当前方法，第1个元素是调用该方法的方法，以此类推
            所以要获取当前方法名称，需要获取第2个元素的方法名
         */
        if (stackTrace.length >= 3) {
            return stackTrace[2].getMethodName();
        } else {
            return "Unknown Method";
        }
    }
}
