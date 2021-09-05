package com.zce.market.config.wxpay;

import com.github.wxpay.sdk.WXPayConfig;
import com.github.wxpay.sdk.WXPayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 微信支付的一个配置类
 */
public class WxConfig implements WXPayConfig {
    static Logger logger = LoggerFactory.getLogger(WxConfig.class);
    public static final String APPID = "wx90b07e7298f25616";
    // ngrok 一款免费的内网穿透工具
    public static final String DOM_URL = "http://xianhuazf.com/";

    public static final String APPSCRET = "e993417d2e7629101e2911b47af4f108";

    public static final String MYKEY = "500222199110025451151001lhaijj13";// 这个是你自己在微信后台设置的密码

    private byte[] certData;


    public static WxConfig wxConfig;

    static {
        try {
            wxConfig = new WxConfig();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("微信证书读取失败，请联系管理员！");
        }
    }

    public WxConfig() throws IOException {
        //必须这样才能读取到jar包中的文件，如果放在classPath下面，那么在程序之中要读取这个文件，就需要用到ClassPathResource类
        ClassPathResource resource = new ClassPathResource("apiclient_cert.p12");
        InputStream certStream = resource.getInputStream();//要的就是输入流
        this.certData = new byte[1024];
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100]; //buff用于存放循环读取的临时数据
        int rc = 0;
        while ((rc = certStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        this.certData = swapStream.toByteArray(); //in_b为转换之后的结果
        certStream.read(this.certData);
        certStream.close();
    }

    @Override
    public String getAppID() {
        return APPID;
    }

    @Override
    public String getMchID() {
        return "1500995971";
    }

    @Override
    public String getKey() {
        return "500222199110025451151001lhaijj13";
    }

    @Override
    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    /**
     * 告诉微信异步通知的时候，告诉微信我收到了，你不要再给我发用户付款成功的消息了
     *
     * @return
     */
    public static String notifyWxImGet() {
        Map<String, String> resMap = new HashMap<>();
        resMap.put("return_code", "SUCCESS");
        resMap.put("return_msg", "OK");
        //将map转换成xml字符串返回给微信，我收到了，你别再发了
        try {
            return WXPayUtil.mapToXml(resMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    // 获取微信返回的数据xml变成map
    public static Map<String, String> getWxResMap(HttpServletRequest request) {

        try {
            InputStream inStream = request.getInputStream();
            if (inStream != null) {
                //将流转换成字符串,用Scanner
                Scanner s = new Scanner(inStream);
                String resStr = "";
                while (s.hasNext()) {
                    resStr += s.next();
                }
                // resStr="<xml><appid><![CDATA[wx90b07e7298f25616]]></appid><bank_type><![CDATA[CFT]]></bank_type><cash_fee><![CDATA[50]]></cash_fee><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[1500995971]]></mch_id><nonce_str><![CDATA[d27f6b2a957547ec8fecf8230132b870]]></nonce_str><openid><![CDATA[o_sxo1fgVOZgC9SpXe9QOLgUgqCw]]></openid><out_trade_no><![CDATA[1532079492910-814227]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[7F76BA0C13868E69D061AA8153718479]]></sign><time_end><![CDATA[20180720173839]]></time_end><total_fee>50</total_fee><trade_type><![CDATA[MWEB]]></trade_type><transaction_id><![CDATA[4200000135201807209960939374]]></transaction_id></xml>";
                //将XML格式转化成MAP格式数据
                Map<String, String> resultMap = WXPayUtil.xmlToMap(resStr);//拿到了微信过来的Map
                return resultMap;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }

    //获得客户端访问的IP地址
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if (ip.indexOf(",") != -1) {
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


    @Override
    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }
}
