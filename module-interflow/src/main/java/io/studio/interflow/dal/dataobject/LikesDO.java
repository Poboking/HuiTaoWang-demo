package io.studio.interflow.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * Date:2023/11/24 20:24
 *
 * @Author:poboking
 */
@TableName("likes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("all")
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class LikesDO extends Model<LikesDO> {
    @TableId(value = "like_id",type = IdType.AUTO)
    private Long likeId;
    private Long postId;
    private Long userId;
}
