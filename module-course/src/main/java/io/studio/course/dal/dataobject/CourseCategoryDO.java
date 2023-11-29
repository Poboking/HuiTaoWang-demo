package io.studio.course.dal.dataobject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * Date:2023/11/23 11:30
 *
 * @Author:poboking
 */
@TableName("course_category")
@Builder
@Data
@SuppressWarnings("all")
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public class CourseCategoryDO extends Model<CourseCategoryDO>{
    @TableId(value = "category_id",type = IdType.AUTO)
    private Long categoryId;
    private String categoryName;
}
