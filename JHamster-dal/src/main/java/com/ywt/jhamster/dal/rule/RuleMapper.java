/**
 * 
 * Copyright From 2015, 微贷（杭州）金融信息服务有限公司. All rights reserved.
 * 
 * RuleMapper.java
 * 
 */
package com.ywt.jhamster.dal.rule;

import com.ywt.jhamster.entity.model.rule.Rule;

/**
 * <p>
 * 表 : rule的 Mapper 类
 * 
 * @author 	system
 * @date 	2017年11月13日
 */
public interface RuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Rule record);

    int insertSelective(Rule record);

    Rule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Rule record);

    int updateByPrimaryKey(Rule record);
}