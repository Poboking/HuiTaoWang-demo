package io.studio.modulemall;

import io.studio.mall.service.enums.OrderStatus;
import org.junit.jupiter.api.Test;

/**
 * Date:2023/11/28 17:13
 *
 * @Author:poboking
 */
public class TempTest {
    @Test
    void test(){
        System.out.println(OrderStatus.PENDING_PAYMENT.getDisplayName().equals("待支付"));

        System.out.println(Boolean.FALSE.equals(true));
    }
}
