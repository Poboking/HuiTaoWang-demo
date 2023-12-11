package io.studio.auth.dal.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * Date:2023/12/6 9:35
 *
 * @Author:poboking
 */
@Data
@TableName("invalid_tokens")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class InvalidTokensDO extends Model<InvalidTokensDO> {
    @Schema(description = "失效TokenID")
    private Integer id;

    @Schema(description = "失效Token")
    private String token;
}
