package io.studio.mall.dal.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * Date:2023/11/26 18:18
 *
 * @Author:poboking
 */
@TableName("coupon")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("all")
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class CouponDO extends Model<CouponDO> {
    private String couponCode;
    private Integer discount;
}
