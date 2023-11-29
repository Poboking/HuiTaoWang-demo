package io.studio.mall.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * Date:2023/11/26 18:17
 *
 * @Author:poboking
 */
@TableName("orders")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("all")
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class OrderDO extends Model<OrderDO> {
    @TableId(value = "order_id",type = IdType.AUTO)
    private Long orderId;
    private Long userId;
    private BigDecimal totalAmount;
    private String status;
    private Timestamp createdAt;
    private String couponCode;
    private String transactionId;
    private Integer addressId;
}
