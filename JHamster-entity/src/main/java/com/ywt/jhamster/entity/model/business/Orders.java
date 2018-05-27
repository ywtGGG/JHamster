/**
 * 
 * Orders.java
 * 
 */
package com.ywt.jhamster.entity.model.business;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 表 : orders的 Model 类
 * 
 * @author 	system
 * @date 	2017年11月06日
 */
public class Orders {
    /** 字段:id，订单号 */
    private String id;

    /** 字段:uid */
    private Integer uid;

    /** 字段:ref_order_id，外部单号 */
    private String refOrderId;

    /** 字段:subject，订单标题 */
    private String subject;

    /** 字段:goods_type，商品类型 0-虚拟商品  1-真实商品 */
    private Integer goodsType;

    /** 字段:word_server，世界服务器 1-hytn冒险岛 */
    private Integer wordServer;

    /** 字段:character_id，角色id */
    private Integer characterId;

    /** 字段:character_name，角色名字 */
    private String characterName;

    /** 字段:total_amount，订单金额 */
    private BigDecimal totalAmount;

    /** 字段:receipt_amount，实际收款金额 */
    private BigDecimal receiptAmount;

    /** 字段:pay_type，支付方式 */
    private Integer payType;

    /** 字段:status，状态 0-等待付款  1-支付成功  2-支付失败 */
    private Integer status;

    /** 字段:remark，备注信息 */
    private String remark;

    /** 字段:create_time，创建时间 */
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRefOrderId() {
        return refOrderId;
    }

    public void setRefOrderId(String refOrderId) {
        this.refOrderId = refOrderId == null ? null : refOrderId.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getWordServer() {
        return wordServer;
    }

    public void setWordServer(Integer wordServer) {
        this.wordServer = wordServer;
    }

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName == null ? null : characterName.trim();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(BigDecimal receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}