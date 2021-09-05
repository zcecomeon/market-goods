package com.zce.market.util;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;

@Component
public class ResourceUtil {
    @Resource
    MessageSource resourceBundleMessageSource;// 这里待定

    public String getResourceValue(String resourceKey) {
        try {
            return resourceBundleMessageSource.getMessage(resourceKey, null, Locale.getDefault());
        } catch (NoSuchMessageException e) {

        }
        return null;
    }

    /**
     * 判断字符串不为null
     *
     * @param arg
     * @return
     */
    public static boolean notNull(String arg) {
        return !isNull(arg);
    }

    public static boolean isNull(String arg) {
        if ("".equals(arg) || arg == null) {
            return true;
        }
        return false;
    }

}
