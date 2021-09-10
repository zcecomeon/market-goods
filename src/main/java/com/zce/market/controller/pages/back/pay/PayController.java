//package com.zce.market.controller.pages.back.pay;
//
//
//import okhttp3.MediaType.*;
//import okhttp3.RequestBody.*;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.alipay.api.AlipayApiException;
//import com.alipay.api.request.AlipayTradePagePayRequest;
//import com.alipay.api.request.AlipayTradeWapPayRequest;
//
//import com.github.wxpay.sdk.WXPay;
//import com.github.wxpay.sdk.WXPayUtil;
////import com.sun.mail.iap.Response;
//
//import com.zce.market.config.alipay.AlipayConfig;
//import com.zce.market.config.wxpay.WxConfig;
//import com.zce.market.pojo.entity.UserOrder;
//import com.zce.market.service.OrderService;
//import com.zce.market.util.device.DeviceUtil;
//import jdk.nashorn.internal.ir.RuntimeNode;
//import okhttp3.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Author 时光荒凉了来时路
// * @Date 2021/9/5 19:58
// */
//public class PayController {
//    Logger logger = LoggerFactory.getLogger(PayController.class);
//
//    @Resource
//    OrderService orderService;
//
//    // 阿里电脑扫码支付的表单回传到页面，让他自行提交生成二维码
//    @RequestMapping("aliWapPay")
//    @ResponseBody
//    Object aliWapPay(HttpServletRequest request) {
//        return request.getAttribute("alipayResForm");
//    }
//
//
//    @RequestMapping("/unifiedPay")
//    String unifiedPay(UserOrder order, HttpServletRequest request, @RequestHeader("user-agent") String userAgent) throws AlipayApiException {
//        String payType = order.getPayType();// 先获取用户选择的付款是
//        order = orderService.getOrderDetailByOrderId(order.getOrderId());
//
//        if ("余额支付".equals(payType)) {// 暂时没写
//
//        } else {
//            if ("支付宝".equals(payType)) {
//                Map<String, Object> paramerMap = new HashMap<>();
//                paramerMap.put("out_trade_no", order.getOrderId());// 商户订单编号
//                paramerMap.put("total_amount", order.getActualPayment()); // 订单要付款金额
//                paramerMap.put("subject", "商城购物付款"); // 订单描述
//                paramerMap.put("timeout_express", "30m"); // 付款有效时长
//                paramerMap.put("product_code", "FAST_INSTANT_TRADE_PAY");// 产品id，固定
//
//                String content = JSON.toJSONString(paramerMap);// 把参数变成JSON字符串
//                String result;// 定义一个字符串表单结果
//                if (DeviceUtil.isMobile(userAgent)) {// 手机
//                    // 手机支付API
//                    AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();
//                    //设置支付宝同步通知地址
//                    alipayRequest.setReturnUrl(AlipayConfig.return_url);
//                    //设置支付宝异步通知地址
//                    alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
//                    //业务请求参数的集合，最大长度不限，除公共参数外所有请求参数都必须放在这个参数中传递
//                    alipayRequest.setBizContent(content);//销售产品码，与支付宝签约的产品码名称。 注：目前仅支持FAST_INSTANT_TRADE_PAY
//                    //发送请求，支付宝将返回一个支付请求的表单数据串
//                    result = AlipayConfig.getAlipayClient().pageExecute(alipayRequest).getBody();
//
//                } else {//  电脑
//                    AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
//                    //设置支付宝同步通知地址
//                    alipayRequest.setReturnUrl(AlipayConfig.return_url);
//                    //设置支付宝异步通知地址
//                    alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
//                    //业务请求参数的集合，最大长度不限，除公共参数外所有请求参数都必须放在这个参数中传递
//                    alipayRequest.setBizContent(content);//销售产品码，与支付宝签约的产品码名称。 注：目前仅支持FAST_INSTANT_TRADE_PAY
////                    发送请求，支付宝将返回一个支付请求的表单数据串 ,这个是html 文档字符串是一个表单
//                    result = AlipayConfig.getAlipayClient().pageExecute(alipayRequest).getBody();
//                }
//                request.setAttribute("alipayResForm", result);
//                //将返回结果输出至页面，将再次向支付宝发起请求，此次请求将直接跳转至支付宝支付页面
//                return "forward:/pages/back/pay/aliWapPay";
//
//
//            }
//            if ("微信支付".equals(payType)) {// 微信支付
//
//                WXPay wxpay = new WXPay(WxConfig.wxConfig);// 创建一个微信支付的客户端
//                // 定义个装参数的map
//                Map<String, String> data = new HashMap<>();
//                //沙箱环境
////            WXPay wxpay = new WXPay(config, WXPayConstants.SignType.MD5, true);
//                data.put("body", "商城购物付款");//描述
//                data.put("out_trade_no", order.getOrderId());//订单编号
//                data.put("fee_type", "CNY");//货币类型
//                data.put("nonce_str", WXPayUtil.generateNonceStr()); //随机字符串
//                //订单有效支付时间yyyyMMddHHmmss,格式(必须)
//                //29分钟后到期
//                String youxiaoDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis() + 1000 * 60 * 29));
//                data.put("time_expire", youxiaoDate);// 订单有效支付时间
//                int zonge = (int) (order.getActualPayment() * 100);// int类型的金额单位是分，微信支付的单位是分
//                data.put("total_fee", String.valueOf(zonge));//总金额
//                //设置ip地址
//                data.put("spbill_create_ip", WxConfig.getIpAddr(request));
//                logger.debug("客户的ip是：" + WxConfig.getIpAddr(request));
//                //支付结果通知路径
//                data.put("notify_url", WxConfig.DOM_URL + "/pages/front/pay/wxPayRes"); // 异步通知路径
//                try {
//                    data.put("sign", WXPayUtil.generateSignature(data, WxConfig.wxConfig.getKey()));// 签名
//                } catch (Exception e) {
//                    e.printStackTrace();
//
//                }
//                // 数据全部封装之后，开始调用支付
//                try {
//                    if (DeviceUtil.isMobile(userAgent)) {// 手机
//                        System.err.println(WxConfig.DOM_URL);
//
//                        data.put("scene_info", "{\"h5_info\": {\"type\":\"Wap\",\"wap_url\": \"" + WxConfig.DOM_URL + "\",\"wap_name\": \"华夏超市联盟\"}}");
//                        data.put("trade_type", "MWEB");  // 此处指定为H5支付。
//                        Map<String, String> resp = wxpay.unifiedOrder(data);// 统一下单
//                        System.err.println(resp);
//                        String url = resp.get("mweb_url");
//                        return "redirect:" + url;
//                    } else {// 电脑
//                        data.put("trade_type", "NATIVE");// 此处指定为扫码支付。
//                        //正式签名
//                        Map<String, String> resp = wxpay.unifiedOrder(data);// 统一下单
//                        String url = resp.get("code_url");// 获取二维码链接
//                        System.err.println(url); // 格式：weixin://sdhdfcuishusdi
//                        request.setAttribute("qrcodeUrl", url);
//                        request.setAttribute("allCost", order.getActualPayment());
//                        request.setAttribute("orderId", order.getOrderId());
//                        return "pages/back/pay/wx-saomaPay";
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return "";
//    }
//
//    //微信内置浏览器下单 （稍微特殊）
//    @ResponseBody
//    @RequestMapping("wxBXiadan")
//    Map<String, String> wxBXiadan(UserOrder order, HttpServletRequest request) {
//        String subject = "仿京东超市付款";
//        Double allCost = order.getAllCost();
////        try {
//        WXPay wxpay = new WXPay(WxConfig.wxConfig);
//        String code = request.getParameter("code");// 这个code取之易
//        OkHttpClient client = new OkHttpClient();// 一个http请求工具
//        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + WxConfig.wxConfig.getAppID() + "&secret=" + WxConfig.APPSCRET + "&code=" + code + "&grant_type=authorization_code";
//        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//        String json = "";
//        RequestBody body = RequestBody.create(JSON, json);
//        RuntimeNode.Request OKrequest = new RuntimeNode.Request.Builder()
//                .url(url)
//                .post(body)
//                .build();
//        JSONObject jsonObject = null;
//        String openid = "";
//        try {
//            Response response = client.newCall(OKrequest).execute();
//            if (response.isSuccessful()) {//如果拿到openid
//                String res = response.body().string();
//                jsonObject = com.alibaba.fastjson.JSON.parseObject(res);
//                openid = jsonObject.getString("openid");
//                //沙箱环境
////            WXPay wxpay = new WXPay(config, WXPayConstants.SignType.MD5, true);
//                Map<String, String> data = new HashMap<>();
//                data.put("body", subject);//描述
//                data.put("out_trade_no", order.getOrderId());//订单编号
//                data.put("fee_type", "CNY");//货币类型
//                data.put("nonce_str", WXPayUtil.generateNonceStr());//随机字符串
//                //订单有效时间
//                String youxiaoDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis() + 1000 * 60 * 29));
//                data.put("time_expire", youxiaoDate);//随机字符串
//                int zonge = (int) (100 * allCost);
//                data.put("total_fee", String.valueOf(zonge));//总金额
//                data.put("spbill_create_ip", WxConfig.getIpAddr(request));
//                //支付结果通知路径
//                data.put("notify_url", WxConfig.DOM_URL + "/pages/front/pay/wxPayRes");
//                data.put("trade_type", "JSAPI");  // 此处指定为H5支付,内置浏览器支付。
//                //wxJSAPI支付需要传openid
//                data.put("openid", openid);
//                //正式签名
////                data.put("sign", WXPayUtil.generateSignature(data,"500222199110025451151001lhaijj13"));
//                data.put("sign", WXPayUtil.generateSignature(data, "500222199110025451151001lhaijj13"));//签名
//                Map<String, String> resp = wxpay.unifiedOrder(data);
//                String prepay_id = resp.get("prepay_id");
//                if (!StringUtils.isEmpty(prepay_id)) {
//                    Map<String, String> resMap = new HashMap<>();
//                    resMap.put("package", prepay_id);
//                    resMap.put("appid", WxConfig.APPID);
//                    resMap.put("key", WxConfig.MYKEY);
//                    return resMap;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
