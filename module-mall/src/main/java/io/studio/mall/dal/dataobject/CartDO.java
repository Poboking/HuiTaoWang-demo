package io.studio.mall.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * Date:2023/11/26 18:16
 *
 * @Author:poboking
 */
@TableName("cart")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("all")
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class CartDO extends Model<CartDO> {
    @TableId(value = "cart_id",type = IdType.AUTO)
    private Long cartId;
    private Long userId;
}
