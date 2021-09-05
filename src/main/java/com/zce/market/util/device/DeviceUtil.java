package com.zce.market.util.device;

/**
 * creator：Administrator
 * 判断设备用的
 * date:2019/11/11
 */
public class DeviceUtil {
    /**
     * 根据头信息判断用户是手机还是电脑
     *
     * @param userAgent
     * @return
     */
    public static boolean isMobile(String userAgent) {
        if (userAgent.contains("Android") || userAgent.contains("iPhone")) {
            return true;
        }
        return false;
    }
}
