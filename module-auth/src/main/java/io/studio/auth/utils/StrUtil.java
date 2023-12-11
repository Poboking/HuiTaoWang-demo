package io.studio.auth.utils;

/**
 * Date:2023/12/8 17:01
 *
 * @Author:poboking
 */
public class StrUtil {

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
