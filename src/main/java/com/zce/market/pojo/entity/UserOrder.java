package com.zce.market.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 时光荒凉了来时路
 * @Date 2021/9/3 11:23
 */
public class UserOrder implements Serializable {
    /**
     * 订单的id
     */
    private String orderId;

    /**
     * 用户id
     */
    private Integer usrerId;

    /**
     * 订单总金额
     */
    private Double allCost;

    /**
     * 下单时间
     */
    private Date createTime;

    /**
     * 付款时间
     */
    private Date payTime;

    /**
     * 收货人的电话
     */
    private String receiverPhone;

    /**
     * 收获人的名字
     */
    private String receiverName;

    /**
     * 收货地址
     */
    private String receiveAddress;

    /**
     * 付款方式：支付宝，微信，银行卡
     */
    private String payType;

    /**
     * 订单状态：待付款，待收货，待评价，已退款，已取消
     */
    private String status;

    /**
     * 实际付款金额
     */
    private Double actualPayment;

    /**
     * 总减免
     */
    private Double totalDeduction;

    private static final long serialVersionUID = 1L;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getUsrerId() {
        return usrerId;
    }

    public void setUsrerId(Integer usrerId) {
        this.usrerId = usrerId;
    }

    public Double getAllCost() {
        return allCost;
    }

    public void setAllCost(Double allCost) {
        this.allCost = allCost;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getActualPayment() {
        return actualPayment;
    }

    public void setActualPayment(Double actualPayment) {
        this.actualPayment = actualPayment;
    }

    public Double getTotalDeduction() {
        return totalDeduction;
    }

    public void setTotalDeduction(Double totalDeduction) {
        this.totalDeduction = totalDeduction;
    }
}