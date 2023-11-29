package io.studio.tweet.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * Date:2023/11/1011:29
 *
 * @Author:poboking
 */
@Data
@TableName("industry_info_category")
@Builder
@SuppressWarnings("all")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class IndustryInfoCategoryDO extends Model<IndustryInfoCategoryDO> {
    @TableId(value = "category_id", type = IdType.AUTO)
    private Long categoryId;
    private String categoryName;
}
