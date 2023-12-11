package io.studio.auth.service.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.jdi.InternalException;
import io.studio.auth.common.exception.UserLogoutException;
import io.studio.auth.common.exception.UserRegistrationException;
import io.studio.auth.common.pojo.Token;
import io.studio.auth.controller.vo.biz.user.UserLoginReqVO;
import io.studio.auth.controller.vo.biz.user.UserRegisterReqVO;
import io.studio.auth.dal.dataobject.AdministratorDO;
import io.studio.auth.dal.dataobject.ExpertsScholarsDO;
import io.studio.auth.dal.dataobject.PeachFarmerDO;
import io.studio.auth.dal.dataobject.UserDO;
import io.studio.auth.dal.enums.UserType;
import io.studio.auth.dal.mysql.*;
import io.studio.auth.utils.SnowflakeUtil;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;


/**
 * Date:2023/12/4 19:43
 *
 * @Author:poboking
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @Resource
    private final UserMapper userMapper;
    @Resource
    private final PeachFarmerMapper farmerMapper;
    @Resource
    private final ExpertsScholarsMapper expertsScholarsMapper;
    @Resource
    private final AdministratorMapper administratorMapper;
    @Resource
    private final CartMapper cartMapper;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private JwtService jwtService;
    @Resource
    private AuthenticationManager authenticationManager;
    private final SnowflakeUtil utils = new SnowflakeUtil(1,1);
    private final String DEFAULT_AVATAR_URL = "https://ydlunacommon-cdn.nosdn.127.net/e5d302ac10bb57dbb7bace5281d5eb6a.png";

    /**
     * 注册用户
     *
     * @param request UserRegisterReqVO
     * @return token
     */
    public Token register(@NotNull UserRegisterReqVO request) {
        /*
            判断电话号码是否存在
         */
        if (isPhoneNumExistent(request.getPhoneNumber())) {
            throw new IllegalArgumentException("failure to register an account of the phoneNum existent");
        }

        var user = UserDO.builder()
                .userId(utils.nextId())
                .phoneNumber(request.getPhoneNumber())
                .name(request.getName())
                /*
                    passwordEncoder.encode()对传入参数进行加密、编码
                 */
//                .password(passwordEncoder.encode(request.getPassword()))
                .userType(Optional.of(UserType.valueOf(request.getUserType())).orElse(UserType.NORMAL))
                .phoneNumber(request.getPhoneNumber())
                .avatar(DEFAULT_AVATAR_URL)
                .build();

        if (userMapper.insert(user) < 0) {
            throw new InternalException("failure to insert user data an account of user mapper service error");
        }
        switch (user.getUserType()) {
            case NORMAL -> {
                /*
                    初始化用户购物车
                 */
                if (cartMapper.initializeCart(user.getUserId()) < 0){
                    userMapper.deleteById(user.getUserId());
                    throw new InternalException("failure to insert user data an account of cart mapper service error");
                }
                break;
            }
            case FARMER -> {
                var farmer = PeachFarmerDO.builder()
                        .userId(user.getUserId())
                        .villageId(request.getVillageId())
                        .cooperationId(request.getCooperationId())
                        .plantId(request.getPlantId())
                        .cropArea(request.getCropArea())
                        .cropCount(request.getCropCount())
                        .build();
                if (farmerMapper.insert(farmer) < 0) {
                    userMapper.deleteById(user.getUserId());
                    throw new InternalException("failure to insert user data an account of farmer mapper service error");
                }
                if (cartMapper.initializeCart(user.getUserId()) < 0){
                    userMapper.deleteById(user.getUserId());
                    farmerMapper.deleteById(user.getUserId());
                    throw new InternalException("failure to insert user data an account of cart mapper service error");
                }
                break;
            }
            case EXPERT -> {
                var expert = ExpertsScholarsDO.builder()
                        .userId(user.getUserId())
                        .institution(request.getInstitution())
                        .researchField(request.getResearchField())
                        .build();
                if (expertsScholarsMapper.insert(expert) < 0) {
                    userMapper.deleteById(user.getUserId());
                    throw new InternalException("failure to insert user data an account of expert mapper service error");
                }
                if (cartMapper.initializeCart(user.getUserId()) < 0){
                    userMapper.deleteById(user.getUserId());
                    expertsScholarsMapper.delete(new QueryWrapper<ExpertsScholarsDO>()
                            .eq("user_id",user.getUserId()));
                    throw new InternalException("failure to insert user data an account of cart mapper service error");
                }
                break;
            }
            case ADMIN -> {
                var admin = AdministratorDO.builder()
                        .userId(user.getUserId())
                        .department(request.getDepartment())
                        .build();
                if (administratorMapper.insert(admin) < 0) {
                    userMapper.deleteById(user.getUserId());
                    throw new InternalException("failure to insert user data an account of admin mapper service error");
                }
                if (cartMapper.initializeCart(user.getUserId()) < 0){
                    userMapper.deleteById(user.getUserId());
                    administratorMapper.deleteById(user.getUserId());
                    throw new InternalException("failure to insert user data an account of cart mapper service error");
                }
                break;
            }
            default -> {
                throw new InternalException("Unknown error: Failure to case UserType");
            }
        }
        var token = jwtService.generateToken(user);
        return Token.builder()
                .token(token)
                .build();
    }


    /**
     * 用户登录
     *
     * @param request UserLoginReqVO
     * @return token
     */
    public Token login(UserLoginReqVO request) {

        //spring security类内置的账户密码验证类, 用于处理身份验证请求
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getPhoneNumber(),
                        request.getName()
                )
        );
        if (Objects.isNull(authenticate)){
            throw new RuntimeException("Failure to Login");
        }
        var user = userMapper.findByName(request.getName());
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("User not found");
        }
        var token = jwtService.generateToken(user);
        return Token.builder()
                .token(token)
                .build();
    }


    public void logout(String token) {
        if (Boolean.FALSE.equals(jwtService.invalidateToken(token))) {
            throw new UserLogoutException("Failure to Logout");
        }
    }

    /**
     * 检查电话号码是否重复
     *
     * @param phoneNumber string
     * @return boolean of phone number non-existent
     */
    public Boolean isPhoneNumExistent(String phoneNumber) {
        return !Objects.isNull(userMapper.findByPhoneNumber(phoneNumber));
    }

    public UserDO getUserId(String phoneNumber){
        UserDO userDO = userMapper.findByPhoneNumber(phoneNumber);
        if (Objects.isNull(userDO)){
            throw new UserRegistrationException("Failure to Obtain UserId");
        }
        return userDO;
    }
}
