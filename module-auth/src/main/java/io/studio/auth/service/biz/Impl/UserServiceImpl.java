package io.studio.auth.service.biz.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.studio.auth.common.exception.UserUpdateException;
import io.studio.auth.controller.vo.biz.farmer.CropDetailsRespVO;
import io.studio.auth.controller.vo.biz.user.UserUpdateReqVO;
import io.studio.auth.dal.dataobject.ExpertsScholarsDO;
import io.studio.auth.dal.dataobject.UserDO;
import io.studio.auth.dal.mysql.ExpertsScholarsMapper;
import io.studio.auth.dal.mysql.PeachFarmerMapper;
import io.studio.auth.dal.mysql.UserMapper;
import io.studio.auth.service.biz.IUserService;
import io.studio.auth.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Date:2023/12/6 9:08
 *
 * @Author:poboking
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    @Resource
    private final UserMapper userMapper;
    @Resource
    private final ExpertsScholarsMapper expertMapper;
    @Resource
    private final PeachFarmerMapper farmerMapper;

    /**
     * 上传用户头像
     *
     * @param fileContent 文件内容
     * @param fileName    文件名
     * @return upload file path
     */
    @Override
    public String uploadFile(byte[] fileContent, String fileName) {
        try {
            return FileUtils.write(fileContent, fileName);
        } catch (IOException e) {
            return "";
        }
    }

    /**
     * 更新用户信息
     *
     * @param updateReqVO 更新信息
     * @return boolean of update
     */
    @Override
    public Boolean updateUserInfo(UserUpdateReqVO updateReqVO) {
        if (Objects.isNull(updateReqVO.getUserId())) {
            throw new UserUpdateException("Failure to update User info an account of userId required");
        }
        if (!Objects.isNull(updateReqVO.getPhoneNumber())) {
            if (!Objects.isNull(userMapper.findByPhoneNumberExcludeUserId(updateReqVO.getPhoneNumber(),updateReqVO.getUserId()))) {
                throw new UserUpdateException("Failure to update User info an account of the phoneNumber existent");
            }
        }
        if (!Objects.isNull(updateReqVO.getName())) {
            if (!Objects.isNull(userMapper.findByNameExcludeUserId(updateReqVO.getName(), updateReqVO.getUserId()))) {
                throw new UserUpdateException("Failure to update User info an account of the name existent");
            }
        }

        var user = UserDO.builder()
                .userId(updateReqVO.getUserId())
                .avatar(updateReqVO.getAvatar())
                .nickName(updateReqVO.getNickname())
                .gender(updateReqVO.getGender())
                .name(updateReqVO.getName())
                .phoneNumber(updateReqVO.getPhoneNumber())
                .build();
        return userMapper.updateIfNoNull(user) > 0;
    }

    /**
     * 获取指定用户IDs的头像url列表(顺序一致）
     *
     * @param ids 用户ID
     * @return list of avatarUrl
     */
    @Override
    public List<String> getAvatarUrlList(List<Long> ids) {
        return userMapper.getAvatarUrlListByUserId(ids);
    }

    /**
     * 获取专家列表
     *
     * @return list
     */
    @Override
    public List<ExpertsScholarsDO> getExpertList() {
        return expertMapper.selectList(new QueryWrapper<>(null));
    }

    /**
     * 获取种植详情(总亩数、合作社亩数、村庄亩数）
     *
     * @return VO
     */
    @Override
    public CropDetailsRespVO getCorpDetail() {
        int total, artel, village;
        total = farmerMapper.findAllCropArea().stream().mapToInt(Integer::intValue).sum();
        artel = farmerMapper.findAllCooperationCropArea().stream().mapToInt(Integer::intValue).sum();
        village = farmerMapper.findAllVillageCropArea().stream().mapToInt(Integer::intValue).sum();
        return CropDetailsRespVO.builder()
                .cropTotalArea(total)
                .cropVillageArea(village)
                .cropArtelArea(artel)
                .build();
    }
}
