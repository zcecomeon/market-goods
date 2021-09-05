package com.zce.market.pojo.dto;

import lombok.Data;

/**
 * creator：Administrator
 * date:2019/12/18
 */
@Data
public class ResponseDTO {
    /**
     * 服务器返回给客户端的消息
     */
    private String msg;
    /**
     * 返回的结果
     */
    private Boolean res;

    /**
     * 返回的数据
     */
    private Object data;

    /**
     * 返回的状态
     */
    private Integer status = 200;
    /**
     * 错误代码
     */
    private Integer errorCode;
    public ResponseDTO(String msg, Boolean res, Object data, Integer status, Integer errorCode) {
        this.msg = msg;
        this.res = res;
        this.data = data;
        this.status = status;
        this.errorCode = errorCode;
    }

    /**
     * 返回简单成功消息，只返回成功的消息
     *
     * @param msg
     * @return
     */
    public static ResponseDTO ok(String msg) {
        return new ResponseDTO(msg, true, null, 200, null);
    }

    /**
     * 返回简单成功消息，只返回成功的消息
     * 并且返回data数据
     *
     * @param msg
     * @return
     */
    public static ResponseDTO ok(String msg, Object data) {
        return new ResponseDTO(msg, true, data, 200, null);
    }

    /**
     * 返回简单成功消息，只返回成功的消息
     * 并且返回data数据
     *
     * @param msg
     * @return
     */
    public static ResponseDTO fail(String msg, Object data, Integer status, Integer errorCode) {
        return new ResponseDTO(msg, false, data, status, errorCode);
    }

    /**
     * 返回简单成功消息，只返回成功的消息
     *
     * @param msg
     * @return
     */
    public static ResponseDTO fail(String msg) {
        return new ResponseDTO(msg, false, null, null, null);
    }

}
