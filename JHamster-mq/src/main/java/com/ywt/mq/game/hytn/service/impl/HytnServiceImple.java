package com.ywt.mq.game.hytn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywt.mq.entity.CharacterRechargeRecord;
import com.ywt.mq.game.hytn.mapper.CharacterRechargeRecordMapperExt;
import com.ywt.mq.game.hytn.service.HytnService;

@Service("HytnService")
public class HytnServiceImple implements HytnService {
	
	@Autowired
	private CharacterRechargeRecordMapperExt characterRechargeRecordMapperExt;
	
	@Override
	public void saveCharacterRechargeRecord(CharacterRechargeRecord record) {
		CharacterRechargeRecord recordDB = characterRechargeRecordMapperExt.selectByPrimaryKey(record.getCharacterId());
		if (null == recordDB) {
			characterRechargeRecordMapperExt.insert(record);
		} else {
			characterRechargeRecordMapperExt.addCharacterRechargeMoney(record.getRechargeMoney());
		}
		
	}
	
}
