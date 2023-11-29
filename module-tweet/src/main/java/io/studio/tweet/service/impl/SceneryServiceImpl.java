package io.studio.tweet.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.studio.tweet.controller.vo.scenery.SceneryCreateReqVO;
import io.studio.tweet.controller.vo.scenery.SceneryRespVO;
import io.studio.tweet.controller.vo.scenery.SceneryUpdateReqVO;
import io.studio.tweet.convert.scenery.SceneryConvert;
import io.studio.tweet.dal.dataobject.SceneryDO;
import io.studio.tweet.dal.mysql.SceneryMapper;
import io.studio.tweet.service.ISceneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Date:2023/11/11 17:23
 *
 * @Author:poboking
 */
@Service
public class SceneryServiceImpl implements ISceneryService {
    @Autowired
    private SceneryMapper sceneryMapper;

    /**
     * 添加桃园风光推文
     *
     * @param createReqVO VO
     * @return 主键ID
     */
    @Override
    public Long createScenery(SceneryCreateReqVO createReqVO) {
        //Convert to entity
        SceneryDO sceneryDO = SceneryConvert.INSTANT.convert(createReqVO);
        if (sceneryMapper.insertAndGetId(sceneryDO) > 0) {
            return sceneryDO.getSceneryId();
        }
        return -1L;
    }

    /**
     * 根据ID删除桃园风光推文
     *
     * @param sceneryId int
     * @return 结果
     */
    @Override
    public boolean deleteSceneryById(Long sceneryId) {
        return sceneryMapper.deleteById(sceneryId) > 0;
    }

    /**
     * 更新桃园风光推文
     *
     * @param updateReqVO VO
     * @return 结果
     */
    @Override
    public boolean updateScenery(SceneryUpdateReqVO updateReqVO) {
        //Convert to entity
        SceneryDO sceneryDO = SceneryConvert.INSTANT.convert(updateReqVO);
        /*
          查询是否存在该推文
         */
        if (Objects.isNull(sceneryMapper.selectById(sceneryDO.getSceneryId()))) {
            return false;
        }
        return sceneryMapper.updateById(sceneryDO) > 0;
    }

    /**
     * 获取桃园风光推文列表
     *
     * @param current currentPage
     * @param size pageSize
     * @return 结果
     */
    @Override
    public List<SceneryDO> getSceneryPage(int current, int size) {
        Page<SceneryDO> page = new Page<>(current, size);
        page.setSearchCount(false);
        page.setOptimizeCountSql(false);

        IPage<SceneryDO> result = sceneryMapper.selectPage(page, null);
        return result.getRecords();
    }

    /**
     * 获取桃园风光列表
     *
     * @return 结果
     */
    @Override
    public List<SceneryRespVO> getSceneryList() {
        List<SceneryDO> list = sceneryMapper.selectList(null);
        return SceneryConvert.INSTANT.convertList(list);
    }
}
