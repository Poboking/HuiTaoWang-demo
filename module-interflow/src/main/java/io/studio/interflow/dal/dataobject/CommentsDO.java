package io.studio.interflow.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.sql.Timestamp;

/**
 * Date:2023/11/24 20:25
 *
 * @Author:poboking
 */
@TableName("comments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("all")
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class CommentsDO extends Model<CommentsDO> {
    @TableId(value = "comment_id",type = IdType.AUTO)
    private Long commentId;
    private Long postId;
    private Long userId;
    private String content;
    private Timestamp createdAt;
}
