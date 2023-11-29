package io.studio.mall.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Date:2023/11/26 18:06
 *
 * @Author:poboking
 */
@TableName("product")
@Data
@Builder
@SuppressWarnings("all")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class ProductDO extends Model<ProductDO> {
    @TableId(value = "product_id",type = IdType.AUTO)
    private Long productId;
    private Integer recommend;
    private String name;
    private String subhead;
    private BigDecimal price;
    private String description;
    private String imageUrl;
    private Timestamp createdAt;
}
