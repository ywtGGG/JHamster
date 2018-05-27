package com.ywt.jhamster.game.service;

import java.util.List;

import com.ywt.jhamster.entity.model.rule.Rule;

public interface RuleService {
	
	/**
	 * 通过key查询规则列表(按触发条件倒序排列)
	 * @param key
	 * @return
	 */
	List<Rule> queryRuleListBykey(String key);
	
	/**
	 * 保存规则
	 * @param rule
	 */
	void saveRule(Rule rule);
	
	/**
	 * 删除规则
	 * @param id
	 */
	void deleteRule(Integer id);
	
	/**
	 * 修改规则
	 * @param rule
	 */
	void updateRule(Rule rule);
}
