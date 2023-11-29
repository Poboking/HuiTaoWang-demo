package io.studio.mall.service.enums;

import lombok.Getter;

/**
 * Date:2023/11/28 16:19
 *
 * @Author:poboking
 */
@Getter
public enum OrderStatus {
    PENDING_PAYMENT("待支付"),
    PROCESSING("处理中"),
    SHIPPED("已发货"),
    DELIVERED("已送达"),
    CANCELED("已取消"),
    COMPLETED("已完成");

    private final String displayName;
    OrderStatus(String displayName) {
        this.displayName = displayName;
    }

}
