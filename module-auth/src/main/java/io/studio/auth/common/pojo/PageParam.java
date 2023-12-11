package io.studio.auth.common.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotNull;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * Date:2023/11/20 10:49
 *
 * @Author:poboking
 */
@Schema(description = "分页参数")
public class PageParam implements Serializable {
    private static final Integer PAGE_NO = 1;
    private static final Integer PAGE_SIZE = 10;
    @Schema(description = "页码，从1开始",required = true,example = "1")
    @NotNull(message = "页码不为空")
    @Min(value = 1,message = "页码最小值为1")
    private Integer PageNo;
    @Schema(description = "每页条数，最大值100",required = true,example = "100")
    @NotNull(message = "每页条数不为空")
    @Min(value = 1,message = "每页条数最小值为1")
    @Max(value = 100,message = "每页条数最大值为100")
    private Integer PageSize;
}
