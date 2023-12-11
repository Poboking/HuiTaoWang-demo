package io.studio.auth.common.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Date:2023/11/20 11:15
 *
 * @Author:poboking
 */
@Schema(description = "分页结果")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> implements Serializable {
    @Schema(description = "数据",required = true)
    private List<T> list;
    @Schema(description = "总量",required = true)
    private Long total;

    public PageResult(Long total){
        this.list = new ArrayList<>();
        this.total = total;
    }

    /**
     * 创建一个空的 PageResult 对象
     * @return 对应总量的 PageResult对象
     * @param <T> 指定类型的List
     */
    public static <T> PageResult<T> empty(){
        return empty(0L);//0L 表示传入一个Long类型的0字面量。
    }
    public static <T> PageResult<T> empty(Long total){
        return new PageResult<>(total);
    }

}
