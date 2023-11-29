package io.studio.mall.controller.address;

import io.studio.mall.controller.address.vo.AddressCreateReqVO;
import io.studio.mall.controller.address.vo.AddressRespVO;
import io.studio.mall.controller.address.vo.AddressUpdateReqVO;
import io.studio.mall.convert.address.AddressConvert;
import io.studio.mall.dal.dataobject.AddressDO;
import io.studio.mall.service.impl.AddressServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pojo.CommonResult;

import javax.validation.Valid;

import java.util.List;

import static pojo.CommonResult.success;
import static pojo.CommonResult.error;

/**
 * Date:2023/11/26 20:35
 *
 * @Author:poboking
 */
@Tag(name = "电商管理 - 地址管理")
@RestController
@RequestMapping("/api/mall/address")
@Validated
@Slf4j
public class AddressController {
    @Resource
    private AddressServiceImpl addressService;

    @PostMapping("/create")
    @Operation(summary = "创建地址项")
    public CommonResult<Long> createAddress(@Valid @RequestBody AddressCreateReqVO createReqVO){
        log.info("[{}]: being address created of process", createReqVO);
        Long addressId = addressService.insertAddress(createReqVO);
        if (addressId < 0){
            return error(500,"address create failure on account of internal error");
        }
        return success(addressId);
    }

    @DeleteMapping("/delete/{addressId}")
    @Operation(summary = "删除地址项")
    public CommonResult<Object> deleteAddress(@Valid @PathVariable("addressId") Long addressId){
        log.info("[{}]: being address deleted of process", addressId);
        if (Boolean.FALSE.equals(addressService.checkOutAddress(addressId))){
            return error(400,"address delete failure on account of the addressId non-existent");
        }
        if (Boolean.FALSE.equals(addressService.deleteAddress(addressId))) {
            return error(500,"address delete failure on account of internal error");
        }
        return success(true);
    }

    @PutMapping("/update")
    @Operation(summary = "更新地址项")
    public CommonResult<Object> updateAddress(@Valid @RequestBody AddressUpdateReqVO updateReqVO){
        log.info("[{}]: being address updated of process", updateReqVO);
        if (Boolean.FALSE.equals(addressService.checkOutAddress(updateReqVO.getAddressId()))){
            return error(400,"address update failure on account of the addressId non-existent");
        }
        if (Boolean.FALSE.equals(addressService.updateAddress(updateReqVO))) {
            return error(500,"address update failure on account of internal error");
        }
        return success(true);
    }

    @GetMapping("/list/{userId}")
    @Operation(summary = "获取地址列表")
    public CommonResult<List<AddressRespVO>> getAddressList(@Valid @PathVariable("userId") Long userId){
        log.info("[{}]: being address list get of process", userId);
        List<AddressDO> addressList = addressService.getAddressList(userId);
        if (addressList.isEmpty()){
            return error(500,"address list get failure on account of internal error");
        }
        return success(AddressConvert.INSTANCE.convertList(addressList));
    }
}
