package io.studio.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.studio.mall.controller.address.AddressController;
import io.studio.mall.controller.address.vo.AddressCreateReqVO;
import io.studio.mall.controller.address.vo.AddressUpdateReqVO;
import io.studio.mall.convert.address.AddressConvert;
import io.studio.mall.dal.dataobject.AddressDO;
import io.studio.mall.dal.mysql.AddressMapper;
import io.studio.mall.service.IAddressService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Date:2023/11/27 14:22
 *
 * @Author:poboking
 */
@Service
public class AddressServiceImpl implements IAddressService {
    @Resource
    private AddressMapper addressMapper;

    /**
     * 新增地址
     *
     * @param createReqVO 创建信息
     * @return addressID
     */
    @Override
    public Long insertAddress(AddressCreateReqVO createReqVO) {
        AddressDO addressDO = AddressConvert.INSTANCE.convert(createReqVO);
        if (addressMapper.insertAndGetId(addressDO) < 0) {
            return -1L;
        }
        return addressDO.getAddressId();
    }

    /**
     * 删除地址
     *
     * @param addressId 地址ID
     * @return boolean delete
     */
    @Override
    public Boolean deleteAddress(Long addressId) {
        return addressMapper.deleteById(addressId) > 0;
    }

    /**
     * 更新地址
     *
     * @param updateReqVO 更新信息
     * @return boolean update
     */
    @Override
    public Boolean updateAddress(AddressUpdateReqVO updateReqVO) {
        return addressMapper.updateById(AddressConvert.INSTANCE.convert(updateReqVO)) > 0;
    }

    /**
     * 检查指定ID地址是否存在
     *
     * @param addressId 主键ID
     * @return boolean checkOut
     */
    @Override
    public Boolean checkOutAddress(Long addressId) {
        return !Objects.isNull(getAddress(addressId));
    }

    /**
     * 获取指定ID地址
     *
     * @param addressId 地址ID
     * @return addressDO
     */
    @Override
    public AddressDO getAddress(Long addressId) {
        return addressMapper.selectById(addressId);
    }

    /**
     * 获取指定用户地址列表
     *
     * @param userId 用户ID
     * @return list
     */
    @Override
    public List<AddressDO> getAddressList(Long userId) {
        return addressMapper.selectList(new QueryWrapper<AddressDO>().eq("user_id", userId));
    }
}
