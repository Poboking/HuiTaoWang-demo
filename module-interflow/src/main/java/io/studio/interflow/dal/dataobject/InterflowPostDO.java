package io.studio.interflow.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.sql.Timestamp;


/**
 * Date:2023/11/24 20:24
 *
 * @Author:poboking
 */
@TableName("interflow_post")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("all")
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class InterflowPostDO extends Model<InterflowPostDO> {
    @TableId(value = "post_id",type = IdType.AUTO)
    private Long postId;
    private Long userId;
    private String text;
    private String media;
    private Integer upvotes;
    private Integer replies;
    private Timestamp createdAt;
}
