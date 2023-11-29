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
@TableName("order_item")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("all")
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class OrderItemDO extends Model<OrderItemDO> {
    @TableId(value = "item_id",type = IdType.AUTO)
    private Long itemId;
    private Long orderId;
    private Long productId;
    private Integer quantity;
}
