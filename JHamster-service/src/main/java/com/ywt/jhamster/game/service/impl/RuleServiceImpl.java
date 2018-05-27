package com.ywt.jhamster.game.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywt.jhamster.common.enums.web.ResultCode;
import com.ywt.jhamster.common.exception.BussinessException;
import com.ywt.jhamster.dal.rule.RuleMapperExt;
import com.ywt.jhamster.entity.model.rule.Rule;
import com.ywt.jhamster.game.service.RuleService;

@Service("ruleService")
public class RuleServiceImpl implements RuleService{
	
	private final static Logger logger = LoggerFactory.getLogger(RuleServiceImpl.class);
	
	@Autowired
	private RuleMapperExt ruleMapperExt;
	
	@Override
	public List<Rule> queryRuleListBykey(String key) {
		try {
			return ruleMapperExt.queryRulesByKey(key);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new BussinessException(ResultCode.DB_ERROR);
		}
	}

	@Override
	public void saveRule(Rule rule) {
		try {
			ruleMapperExt.insert(rule);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new BussinessException(ResultCode.DB_ERROR);
		}
	}

	@Override
	public void deleteRule(Integer id) {
		try {
			ruleMapperExt.deleteByPrimaryKey(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new BussinessException(ResultCode.DB_ERROR);
		}
	}

	@Override
	public void updateRule(Rule rule) {
		try {
			ruleMapperExt.updateByPrimaryKeySelective(rule);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new BussinessException(ResultCode.DB_ERROR);
		}
	}
}
