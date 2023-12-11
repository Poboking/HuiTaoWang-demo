package io.studio.auth.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("administrator")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class AdministratorDO extends Model<AdministratorDO> {
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;
    private String department;
}
