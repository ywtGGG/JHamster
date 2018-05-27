/**
 * 
 * 
 * OrdersMapper.java
 * 
 */
package com.ywt.jhamster.dal.business;

import com.ywt.jhamster.entity.model.business.Orders;

/**
 * <p>
 * 表 : orders的 Mapper 类
 * 
 * @author 	system
 * @date 	2017年11月06日
 */
public interface OrdersMapper {
    int deleteByPrimaryKey(String id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}