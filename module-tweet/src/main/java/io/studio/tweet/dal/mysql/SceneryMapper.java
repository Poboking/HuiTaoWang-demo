package io.studio.tweet.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.tweet.dal.dataobject.SceneryDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Date:2023/11/1011:30
 *
 * @Author:poboking
 */
@Mapper
public interface SceneryMapper extends BaseMapper<SceneryDO> {
    /*
       继承BassMapper简单CRUD
     */

    /**
     * 插入数据并将ID返回至传参的ID属性上, 该方法返回值为插入条数
     *
     * @param sceneryDO DO
     * @return int 插入条数
     */
    int insertAndGetId(@Param("sceneryDO") SceneryDO sceneryDO);
}
