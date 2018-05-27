/**
 * 
 * Copyright From 2015, 微贷（杭州）金融信息服务有限公司. All rights reserved.
 * 
 * RuleMapperExt.java
 * 
 */
package com.ywt.jhamster.dal.rule;

import java.util.List;

import javax.annotation.Resource;

import com.ywt.jhamster.entity.model.rule.Rule;

/**
 * <p>
 * RuleMapper的扩展 Mapper 接口
 * 
 * @author 	system
 * @date 	2017年11月13日
 */
@Resource
public interface RuleMapperExt extends RuleMapper {
	
	/**
	 * 通过key查询规则列表
	 * @param key
	 * @return
	 */
	List<Rule> queryRulesByKey(String key);
}