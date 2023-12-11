package io.studio.auth.controller.vo.biz.expert;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * Date:2023/12/7 8:55
 *
 * @Author:poboking
 */
@Data
public class ExpertsScholarsBassVO {

    @Schema(description = "专家ID", required = true,example = "12")
    @NotNull(message = "专家ID不为空")
    private Integer expertId;

    @Schema(description = "专家姓名",required = true,example = "李国玮")
    @NotBlank(message = "专家姓名不为空")
    private String name;

    @Schema(description = "所处机构",required = true,example = "清华大学")
    @NotBlank(message = "所处机构不为空")
    private String institution;
}
