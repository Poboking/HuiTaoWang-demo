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
@TableName("plants")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class PlantsDO extends Model<PlantsDO> {
    @TableId(value = "plant_id", type = IdType.AUTO)
    private Integer plantId;
    @TableField("plant_name")
    private String plantName;
}
