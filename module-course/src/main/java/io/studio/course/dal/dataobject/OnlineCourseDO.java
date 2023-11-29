package io.studio.course.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.security.Timestamp;

/**
 * Date:2023/11/23 11:29
 *
 * @Author:poboking
 */

@TableName("online_course")
@Builder
@Data
@SuppressWarnings("all")
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public class OnlineCourseDO extends Model<OnlineCourseDO> {
    @TableId(value = "course_id",type = IdType.AUTO)
    private Long courseId;
    private Long categoryId;
    private Long expertId;
    private String courseName;
    private String courseUrl;
    private String description;
    private Integer recommended;
    private Timestamp createdTime;
}
