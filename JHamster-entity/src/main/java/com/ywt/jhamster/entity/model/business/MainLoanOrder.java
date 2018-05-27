/**
 * 
 * Copyright From 2015, 微贷（杭州）金融信息服务有限公司. All rights reserved.
 * 
 * MainLoanOrder.java
 * 
 */
package com.ywt.jhamster.entity.model.business;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 表 : main_loan_order的 Model 类
 * 
 * @author 	system
 * @date 	2017年10月10日
 */
public class MainLoanOrder implements Serializable {
    private static final long serialVersionUID = 5938426467137542292L;
    /** 字段:id，进件订单编号 */
    private String id;

    /** 字段:ref_loan_id，关联进件订单编号 */
    private String refLoanId;
    
    /** 字段:out_order_id，统一外部单号 */
    private String outOrderId;

    /** 字段:father_loan_id，父级订单号，此字段有值说明是辅助订单 */
    private String fatherLoanId;

    /** 字段:order_type，订单类型  1:车抵贷  2:车分期 3:易起投 4:房贷 5:微出行 6:微易融 7:随享贷 8:微米贷 9:网链通 10:车乐贷 */
    @NotNull(message = "orderType not be null!")
    private Integer orderType;

    /** 字段:product_name，产品名称 1:新车 2:二手车 4:大车商 5:机速贷 6:机抵贷 7:机分期 8:微贷金服 11:微易融授信 12:微易融公积金授信 13:微易融标 14:微易融公积金标  20:渠道Q产品 */
    private Integer productName;

    /** 字段:flow_type，流程类型 1: 新增（正常）,6:续贷 */
    private Integer flowType;

    /** 字段:loan_type，贷款类型  0：抵押 1:质押 ,3 授信 */
    private Integer loanType;

    /** 字段:status，订单状态,1:申请中， 4：已受理
， 5：补充材料， 6：数据变更， 10：等待审核， 13：等待放款， 16：回款中， 17：逾期， 21：取消， 22：拒绝， 23：结束， 25：异常 */
    @NotNull(message = "status not be null!")
    private Integer status;

    /** 字段:order_source，订单来源 1:各业务线web 2:微贷app 3:渠道进件系统进件 4:微易融app 5:先锋号app  6金服app 7:易起投app 8:微管家app */
    @NotNull(message = "orderSource not be null!")
    private Integer orderSource;

    /** 字段:uid，借款人会员编号 */
    @NotNull(message = "uid not be null!")
    private Integer uid;

    /** 字段:uid_name，借款人会员名称 */
    @NotNull(message = "uidName not be null!")
    private String uidName;

    /** 字段:support_uid，辅助借款人uid */
    private Integer supportUid;

    /** 字段:support_uid_name，辅助借款人姓名 */
    private String supportUidName;

    /** 字段:apply_amount，贷款金额 */
    @DecimalMin(value="0",message="贷款金额不规范!")
    private BigDecimal applyAmount;

    /** 字段:loan_total_amount，贷款总金额，所有订单总额 */
    private BigDecimal loanTotalAmount;

    /** 字段:period，贷款期限 */
    private Integer period;

    /** 字段:perion_unit，周期单位  0、天标，1、月标 */
    private String perionUnit;

    /** 字段:repay_mode，还款方式  0：月还息到期还本    1：等额本息 */
    private Integer repayMode;

    /** 字段:annual_rate，年利率 */
    private BigDecimal annualRate;

    /** 字段:is_extended，是否续贷过 */
    private Integer isExtended;

    /** 字段:out_status，外部状态 WAIT_VERIFY：待初审 ，TENDERTING：投标中， VERIFY_NOT_PASS ：初审不通过，WAIT_RE_VERIFY：待复审，REPAYING：还款中，RE_VERIFY_NOT_PASS：复审不通过，REVOKE：撤标，CLOSE：已结案                                                                */
    private String outStatus;

    /** 字段:uid_cus，所属客服loginName */
    private String uidCus;

    /** 字段:uid_cusName，所属客服名称 */
    private String uidCusname;

    /** 字段:cid，所属营业部编号 */
    private Long cid;

    /** 字段:cid_name，所属营业部名称 */
    private String cidName;

    /** 字段:sale_id，所属业务员 */
    private String saleId;

    /** 字段:sale_man，所属业务员名称 */
    private String saleMan;

    /** 字段:team_major_id，团队经理id */
    private Long teamMajorId;

    /** 字段:team_major_name，团队经理名称 */
    @Size(max=30,message="团队经理名称只能输入30个字符")
    private String teamMajorName;

    /** 字段:company_id，省分公司 */
    private Long companyId;

    /** 字段:remark，备注 */
    @Size(max=256,message="备注只能输入256个字符")
    private String remark;

    /** 字段:creator_id，创建人 */
    private String creatorId;

    /** 字段:modified_id，修改人 */
    private String modifiedId;

    /** 字段:create_time，创建时间 */
    private Date createTime;

    /** 字段:modified_time，修改时间 */
    private Date modifiedTime;

    /** 字段:channel_id，渠道编号 */
    private String channelId;

    /** 字段:child_status，订单子状态 ： 51:待复核  61:意向订单申请中  62:意向订单已受理  63意向订单结束 */
    private Integer childStatus;

    /** 字段:order_flag，1 表示  超额子标 */
    private Integer orderFlag;

    /** 字段:remit_type，打款类型 0-未打款 1-预打款 2-满标复审打款 */
    private Integer remitType;

    /** 字段:remit_time，打款时间 */
    private Date remitTime;
    
    /** 字段:fund_channel，资金渠道 */
    private String fundChannel;
    
    /** 修改时间，用于作为乐观锁 */
    private Date oldModifiedTime;
    
    /** 字段:loan_purpose，借款用途 */
    private String loanPurpose;
    
    /** 字段:level，规则返回的星级 */
    private String level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRefLoanId() {
        return refLoanId;
    }

    public void setRefLoanId(String refLoanId) {
        this.refLoanId = refLoanId == null ? null : refLoanId.trim();
    }
    
    public String getOutOrderId() {
		return outOrderId;
	}

	public void setOutOrderId(String outOrderId) {
		this.outOrderId = outOrderId;
	}

	public String getFatherLoanId() {
        return fatherLoanId;
    }

    public void setFatherLoanId(String fatherLoanId) {
        this.fatherLoanId = fatherLoanId == null ? null : fatherLoanId.trim();
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getProductName() {
        return productName;
    }

    public void setProductName(Integer productName) {
        this.productName = productName;
    }

    public Integer getFlowType() {
        return flowType;
    }

    public void setFlowType(Integer flowType) {
        this.flowType = flowType;
    }

    public Integer getLoanType() {
        return loanType;
    }

    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUidName() {
        return uidName;
    }

    public void setUidName(String uidName) {
        this.uidName = uidName == null ? null : uidName.trim();
    }

    public Integer getSupportUid() {
        return supportUid;
    }

    public void setSupportUid(Integer supportUid) {
        this.supportUid = supportUid;
    }

    public String getSupportUidName() {
        return supportUidName;
    }

    public void setSupportUidName(String supportUidName) {
        this.supportUidName = supportUidName == null ? null : supportUidName.trim();
    }

    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }

    public BigDecimal getLoanTotalAmount() {
        return loanTotalAmount;
    }

    public void setLoanTotalAmount(BigDecimal loanTotalAmount) {
        this.loanTotalAmount = loanTotalAmount;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getPerionUnit() {
        return perionUnit;
    }

    public void setPerionUnit(String perionUnit) {
        this.perionUnit = perionUnit == null ? null : perionUnit.trim();
    }

    public Integer getRepayMode() {
        return repayMode;
    }

    public void setRepayMode(Integer repayMode) {
        this.repayMode = repayMode;
    }

    public BigDecimal getAnnualRate() {
        return annualRate;
    }

    public void setAnnualRate(BigDecimal annualRate) {
        this.annualRate = annualRate;
    }

    public Integer getIsExtended() {
        return isExtended;
    }

    public void setIsExtended(Integer isExtended) {
        this.isExtended = isExtended;
    }

    public String getOutStatus() {
        return outStatus;
    }

    public void setOutStatus(String outStatus) {
        this.outStatus = outStatus == null ? null : outStatus.trim();
    }

    public String getUidCus() {
        return uidCus;
    }

    public void setUidCus(String uidCus) {
        this.uidCus = uidCus == null ? null : uidCus.trim();
    }

    public String getUidCusname() {
        return uidCusname;
    }

    public void setUidCusname(String uidCusname) {
        this.uidCusname = uidCusname == null ? null : uidCusname.trim();
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCidName() {
        return cidName;
    }

    public void setCidName(String cidName) {
        this.cidName = cidName == null ? null : cidName.trim();
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId == null ? null : saleId.trim();
    }

    public String getSaleMan() {
        return saleMan;
    }

    public void setSaleMan(String saleMan) {
        this.saleMan = saleMan == null ? null : saleMan.trim();
    }

    public Long getTeamMajorId() {
        return teamMajorId;
    }

    public void setTeamMajorId(Long teamMajorId) {
        this.teamMajorId = teamMajorId;
    }

    public String getTeamMajorName() {
        return teamMajorName;
    }

    public void setTeamMajorName(String teamMajorName) {
        this.teamMajorName = teamMajorName == null ? null : teamMajorName.trim();
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    public String getModifiedId() {
        return modifiedId;
    }

    public void setModifiedId(String modifiedId) {
        this.modifiedId = modifiedId == null ? null : modifiedId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    public Integer getChildStatus() {
        return childStatus;
    }

    public void setChildStatus(Integer childStatus) {
        this.childStatus = childStatus;
    }

    public Integer getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(Integer orderFlag) {
        this.orderFlag = orderFlag;
    }

    public Integer getRemitType() {
        return remitType;
    }

    public void setRemitType(Integer remitType) {
        this.remitType = remitType;
    }

    public Date getRemitTime() {
        return remitTime;
    }

    public void setRemitTime(Date remitTime) {
        this.remitTime = remitTime;
    }

    public Date getOldModifiedTime() {
        return oldModifiedTime;
    }

    public void setOldModifiedTime(Date oldModifiedTime) {
        this.oldModifiedTime = oldModifiedTime;
    }

	public String getFundChannel() {
		return fundChannel;
	}

	public void setFundChannel(String fundChannel) {
		this.fundChannel = fundChannel;
	}
	
	public String getLoanPurpose() {
		return loanPurpose;
	}

	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}
	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
}