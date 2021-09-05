package com.zce.market.consts;

/**
 * @Author 时光荒凉了来时路
 * @Date 2021/9/4 22:49
 */
public class GoodsConsts {


    /**
     * 可以表示是否是SVIP,权限是否展示
     */
    public static final String NO_UPLOAD_IMG = "/images/logo/logo.png/";
    /**
     * 可以表示是否是SVIP,权限是否展示
     */
    public static final Double AREA_RANGE = 5.0;


    /**
     * 可以表示是否是SVIP,权限是否展示
     */
    public static final String YES = "YES";
    /**
     * 可以表示是否是SVIP,权限是否展示
     */
    public static final String NO = "NO";


    public static final String WINDOW_UPLOAD_PATH = "C:\\";
    public static final String LINUX_UPLOAD_PATH = "/";

    public static final String WINDOW_CONFIG_UPLOAD_PATH = "file:C:\\upload\\";
    public static final String LINUX_CONFIG_UPLOAD_PATH = "file:/upload/";


    /**
     * 获取上传文件路径配置的方法
     *
     * @return
     */
    public static String getConfigUploadPath() {
        String realPath = GoodsConsts.LINUX_CONFIG_UPLOAD_PATH;// 写死。也就是规定好，这些文件就放到哪里去
        String systemType = System.getProperty("os.name");// 获取系统的类别, Window 8
        if (systemType.toLowerCase().contains("windows")) {// 此时是windows系统
            realPath = GoodsConsts.WINDOW_CONFIG_UPLOAD_PATH;
        }
        return realPath;

    }

    /**
     * 获取上传文件路径的方法
     *
     * @return
     */
    public static String getUploadPath() {
        String realPath = GoodsConsts.LINUX_UPLOAD_PATH;// 写死。也就是规定好，这些文件就放到哪里去
        String systemType = System.getProperty("os.name");// 获取系统的类别, Window 8
        if (systemType.toLowerCase().contains("windows")) {// 此时是windows系统
            realPath = GoodsConsts.WINDOW_UPLOAD_PATH;
        }
        return realPath;
    }




}
