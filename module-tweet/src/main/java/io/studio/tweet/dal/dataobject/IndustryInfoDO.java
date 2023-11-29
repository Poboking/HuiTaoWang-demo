package io.studio.tweet.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import javax.annotation.Nullable;
import java.security.Timestamp;

/**
 * Date:2023/11/1011:29
 *
 * @Author:poboking
 */
@Data
@TableName("industry_info")
@Builder
@SuppressWarnings("all")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class IndustryInfoDO extends Model<IndustryInfoDO> {
    @TableId(value = "info_id",type = IdType.AUTO)
    private Long infoId;
    private Long userId;
    private Long categoryId;
    private Integer recommended;
    private String title;
    private String content;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @Nullable
    private String image;
    @TableField(exist = false)
    private String authorName;
}
