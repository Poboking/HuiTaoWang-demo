package io.studio.tweet.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.tweet.dal.dataobject.IndustryInfoCategoryDO;
import org.apache.ibatis.annotations.*;

/**
 * Date:2023/11/1011:31
 *
 * @Author:poboking
 */
@Mapper
public interface IndustryInfoCategoryMapper extends BaseMapper<IndustryInfoCategoryDO> {
    /*
       继承BassMapper简单CRUD
     */
    /**
     * 插入数据并将ID返回至传参的ID属性上, 该方法返回值为插入条数
     *
     * @param categoryDO DO
     * @return int 插入条数
     */
//    @Insert("INSERT INTO industry_info_category(category_name)\n" +
//            "        VALUES (#{categoryDO.categoryName});")
//    @SelectKey(statement = "SELECT @@IDENTITY", keyProperty = "categoryDO.categoryId", before = false, resultType = Long.class)
//    @Select("SELECT @@IDENTITY")
    int insertAndGetId(@Param("categoryDO") IndustryInfoCategoryDO categoryDO);
}
