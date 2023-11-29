package io.studio.mall.service;

import io.studio.mall.controller.address.vo.AddressCreateReqVO;
import io.studio.mall.controller.address.vo.AddressRespVO;
import io.studio.mall.controller.address.vo.AddressUpdateReqVO;
import io.studio.mall.dal.dataobject.AddressDO;

import java.util.List;

/**
 * Date:2023/11/26 20:30
 *
 * @Author:poboking
 */
public interface IAddressService {
    /**
     * 新增地址
     *
     * @param createReqVO 创建信息
     * @return addressID
     */
    Long insertAddress(AddressCreateReqVO createReqVO);

    /**
     * 删除地址
     *
     * @param addressId 地址ID
     * @return boolean delete
     */
    Boolean deleteAddress(Long addressId);

    /**
     * 更新地址
     *
     * @param updateReqVO 更新信息
     * @return boolean update
     */
    Boolean updateAddress(AddressUpdateReqVO updateReqVO);

    /**
     * 检查指定ID地址是否存在
     * @param addressId 主键ID
     * @return boolean checkOut
     */
    Boolean checkOutAddress(Long addressId);

    /**
     * 获取指定ID地址
     *
     * @param addressId 地址ID
     * @return addressDO
     */
    AddressDO getAddress(Long addressId);

    /**
     * 获取指定用户地址列表
     *
     * @param userId 用户ID
     * @return list
     */
    List<AddressDO> getAddressList(Long userId);
}
