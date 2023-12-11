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
@TableName("village")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class VillageDO extends Model<VillageDO> {
    @TableId(value = "village_id", type = IdType.AUTO)
    private Integer villageId;
    @TableField("village_name")
    private String villageName;
}
