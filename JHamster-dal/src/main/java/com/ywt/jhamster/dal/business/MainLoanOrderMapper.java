/**
 * 
 * Copyright From 2015, 微贷（杭州）金融信息服务有限公司. All rights reserved.
 * 
 * MainLoanOrderMapper.java
 * 
 */
package com.ywt.jhamster.dal.business;

import com.ywt.jhamster.entity.model.business.MainLoanOrder;

/**
 * <p>
 * 表 : main_loan_order的 Mapper 类
 * 
 * @author 	system
 * @date 	2018年01月18日
 */
public interface MainLoanOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(MainLoanOrder record);

    int insertSelective(MainLoanOrder record);

    MainLoanOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MainLoanOrder record);

    int updateByPrimaryKey(MainLoanOrder record);
}