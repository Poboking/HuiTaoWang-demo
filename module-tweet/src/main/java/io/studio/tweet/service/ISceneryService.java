package io.studio.tweet.service;

import io.studio.tweet.controller.vo.scenery.SceneryCreateReqVO;
import io.studio.tweet.controller.vo.scenery.SceneryRespVO;
import io.studio.tweet.controller.vo.scenery.SceneryUpdateReqVO;
import io.studio.tweet.dal.dataobject.SceneryDO;

import java.util.List;

/**
 * Date:2023/11/11 16:59
 *
 * @Author:poboking
 */
public interface ISceneryService {
    /**
     * 添加桃园风光推文
     *
     * @param createReqVO VO
     * @return 主键ID
     */
     Long createScenery(SceneryCreateReqVO createReqVO);

    /**
     * 根据ID删除桃园风光推文
     *
     * @param SceneryId int
     * @return 结果
     */
     boolean deleteSceneryById(Long SceneryId);

    /**
     * 更新桃园风光推文
     *
     * @param updateReqVO VO
     * @return 结果
     */
     boolean updateScenery(SceneryUpdateReqVO updateReqVO);

    /**
     * 获取桃园风光分页列表
     *
     * @param current 当前页码
     * @param size 每页条数
     * @return 结果
     */
     List<SceneryDO> getSceneryPage(int current, int size);
    /**
     * 获取桃园风光列表
     *
     * @return 结果
     */
     List<SceneryRespVO> getSceneryList();
}
