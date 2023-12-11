package io.studio.auth.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * Date:2023/12/4 17:39
 *
 * @Author:poboking
 */
@Data
@TableName("cooperation")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class CooperationDO extends Model<CooperationDO> {
    @TableId(value = "cooperation_id", type = IdType.AUTO)
    private Integer cooperationId;
    @TableField("cooperation_name")
    private String cooperationName;
}
