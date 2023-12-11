package io.studio.auth.controller;

import io.studio.auth.common.pojo.CommonResult;
import io.studio.auth.controller.vo.biz.expert.ExpertsScholarsRespVO;
import io.studio.auth.controller.vo.biz.farmer.CropDetailsRespVO;
import io.studio.auth.controller.vo.biz.user.UserUpdateReqVO;
import io.studio.auth.convert.expert.ExpertsScholarsConvert;
import io.studio.auth.dal.dataobject.ExpertsScholarsDO;
import io.studio.auth.service.biz.Impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
//import jakarta.validation.Valid;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static io.studio.auth.common.pojo.CommonResult.error;
import static io.studio.auth.common.pojo.CommonResult.success;

/**
 * Date:2023/12/4 16:08
 *
 * @Author:poboking
 */
@Tag(name = "鉴权管理 - 用户管理")
@RestController
@RequestMapping("/api/auth/user")
@RequiredArgsConstructor
@Validated
@Slf4j
public class UserController {
    @Resource
    private final UserServiceImpl service;


    @RequestMapping("/homepage")
    @Operation(summary = "首页跳转项")
    public String toHomePage(){
        return "redirect:/test/homepage.html";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)//当抛出异常时，使用指定的Http状态码
    @PostMapping("/file/upload")
    @Operation(summary = "上传文件项")
    public CommonResult<String> uploadFile(@RequestParam("file") @Valid MultipartFile file, HttpServletResponse response){
        try {
            String path = service.uploadFile(file.getBytes(), file.getOriginalFilename());
            if (path.isBlank()){
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                return error(500,"Failure to upload File");
            }
            return success(path);
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return error(500,"Failure to upload File");
        }
    }


    @PostMapping("/update")
    @Operation(summary = "更新用户信息项")
    public CommonResult<Object> updateUser(@RequestBody @Valid UserUpdateReqVO updateReqVO,HttpServletResponse response){
        if (Boolean.FALSE.equals(service.updateUserInfo(updateReqVO))) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return error(500,"Failure to update User");
        }
        return success(true);
    }

    @GetMapping("/expert/list/get")
    @Operation(summary = "获取专家列表")
    public CommonResult<List<ExpertsScholarsRespVO>> getExpertList(HttpServletResponse response){
        List<Long> ids = new ArrayList<>();
        List<ExpertsScholarsDO> list = service.getExpertList();
        if (list.isEmpty()){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return error(500,"Failure to obtain expert list");
        }

        /*
            获取指定顺序的id列表
         */
        list.forEach(DO ->ids.add(DO.getUserId()) );
        List<String> avatarUrlList = service.getAvatarUrlList(ids);
        List<ExpertsScholarsRespVO> respVOList = ExpertsScholarsConvert.INSTANCE.convertList(list);
        /*
            设置指定ID顺序的avatarUrl
         */
        IntStream.range(0,respVOList.size()).forEach(index ->
                respVOList.forEach(resp ->resp.setAvatarUrl(avatarUrlList.get(index))));
        return success(respVOList);
    }

    @GetMapping("/crop/detail/get")
    @Operation(summary = "获取种植详情")
    public CommonResult<CropDetailsRespVO> getCropDetail(){
        return success(service.getCorpDetail());
    }
}
