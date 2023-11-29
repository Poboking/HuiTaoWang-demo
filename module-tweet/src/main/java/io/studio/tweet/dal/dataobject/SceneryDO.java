package io.studio.tweet.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.security.Timestamp;


/**
 * Date:2023/11/10 11:29
 *
 * @Author:poboking
 */
@Data
@TableName("scenery")
@Builder
@SuppressWarnings("all")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class SceneryDO extends Model<SceneryDO> {
    @TableId(value = "scenery_id",type = IdType.AUTO)
    private Long sceneryId;
    private Long userId;
    private String title;
    private String image;
    private String content;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
