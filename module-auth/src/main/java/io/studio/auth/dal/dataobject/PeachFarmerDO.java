package io.studio.auth.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.models.auth.In;
import lombok.*;

/**
 * Date:2023/12/4 17:38
 *
 * @Author:poboking
 */
@Data
@TableName("peach_farmer")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class PeachFarmerDO extends Model<PeachFarmerDO> {
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;
    @TableField("village_id")
    private Integer villageId;
    @TableField("cooperation_id")
    private Integer cooperationId;
    @TableField("plant_id")
    private Integer plantId;
    @TableField("crop_area")
    private Integer cropArea;
    @TableField("crop_count")
    private Integer cropCount;
}
