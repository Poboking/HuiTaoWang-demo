package io.studio.tweet.controller.vo.industry.category;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/21 8:54
 *
 * @Author:poboking
 */
@Data
public class IndustryInfoCategoryBaseVO {
    @Schema(description = "类别ID",required = false,example = "1")
//    @NotNull(message = "类别ID不为空")
    private Long categoryId;

    @Schema(description = "类别名称",required = true,example = "桃子")
    @NotNull(message = "类别名称不为空")
    private String categoryName;
}
