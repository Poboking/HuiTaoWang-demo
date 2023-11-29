package io.studio.mall.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * Date:2023/11/26 18:17
 *
 * @Author:poboking
 */
@TableName("address")
@Data
@Builder
@SuppressWarnings("all")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class AddressDO extends Model<AddressDO> {
    @TableId(value = "address_id",type = IdType.AUTO)
    private Long addressId;
    private Long userId;
    private String addressLine1;
    private String addressLine2;
    private String zip;
    private String phone;
    private String name;
}
