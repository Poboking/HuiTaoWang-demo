package io.studio.tweet.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.tweet.dal.dataobject.IndustryInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Date:2023/11/1011:30
 *
 * @Author:poboking
 */
@Mapper
public interface IndustryInfoMapper extends BaseMapper<IndustryInfoDO> {
    /*
       继承BassMapper简单CRUD
     */

    /**
     * 插入数据并将ID返回至传参的ID属性上, 该方法返回值为插入条数
     *
     * @param industryInfoDO DO
     * @return int 插入条数
     */
    //以下是注解版的mapper方法
//    @Insert("INSERT INTO industry_info(user_id, title, image, content, category_id, recommended)\n" +
//            "        VALUES (#{infoDO.userId}, #{infoDO.title}, #{infoDO.image}, #{infoDO.content},\n" +
//            "            #{infoDO.categoryId}, #{infoDO.recommended});")
//    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "infoDO.infoId", before = false, resultType = Long.class)
    int insertAndGetId(@Param("infoDO") IndustryInfoDO industryInfoDO);
}
