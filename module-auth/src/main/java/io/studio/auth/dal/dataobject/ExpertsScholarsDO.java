package io.studio.auth.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * Date:2023/12/4 17:38
 *
 * @Author:poboking
 */
@Data
@TableName("expert_scholar")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class ExpertsScholarsDO extends Model<ExpertsScholarsDO> {
    @TableId(value = "expert_id", type = IdType.AUTO)
    private Integer expertId;
    @TableField("user_id")
    private Long userId;
    @TableField("institution")
    private String institution;
    @TableField("research_field")
    private String researchField;
}
