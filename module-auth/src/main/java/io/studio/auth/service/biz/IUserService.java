package io.studio.auth.service.biz;

import io.studio.auth.controller.vo.biz.farmer.CropDetailsRespVO;
import io.studio.auth.controller.vo.biz.user.UserUpdateReqVO;
import io.studio.auth.dal.dataobject.ExpertsScholarsDO;

import java.util.List;

/**
 * Date:2023/12/6 9:09
 *
 * @Author:poboking
 */
public interface IUserService {
    /**
     * 上传文件
     *
     * @param fileContent 文件内容
     * @param fileName    文件名
     * @return upload file path
     */
    String uploadFile(byte[] fileContent, String fileName);

    /**
     * 更新用户信息
     *
     * @param updateReqVO 更新信息
     * @return boolean of update
     */
    Boolean updateUserInfo(UserUpdateReqVO updateReqVO);

    /**
     * 获取指定用户IDs的头像url列表
     *
     * @param Ids 用户ID
     * @return list of avatarUrl
     */
    List<String> getAvatarUrlList(List<Long> Ids);

    /**
     * 获取专家列表
     *
     * @return list
     */
    List<ExpertsScholarsDO> getExpertList();


    /**
     * 获取种植详情
     *
     * @return VO
     */
    CropDetailsRespVO getCorpDetail();
}
