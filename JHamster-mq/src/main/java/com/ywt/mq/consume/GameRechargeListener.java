package com.ywt.mq.consume;

import java.util.List;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.ywt.jhamster.entity.params.game.GameRechargeVO;
import com.ywt.mq.entity.CharacterRechargeRecord;
import com.ywt.mq.game.hytn.service.HytnService;

public class GameRechargeListener implements MessageListenerConcurrently{
	
	@Autowired
	private HytnService hytnService;
	
	@Override
	public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
		for (MessageExt messageExt : msgs) {
			String message = new String(messageExt.getBody());
			System.out.println("START GameRechargeListener ----"+message);
			GameRechargeVO rechargeVO = JSONObject.parseObject(message,GameRechargeVO.class);
			CharacterRechargeRecord record = new CharacterRechargeRecord();
			record.setCharacterId(rechargeVO.getCharId());
			record.setCharacterName(rechargeVO.getCharName());
			record.setRechargeMoney(rechargeVO.getRealDJ().intValue());//游戏里记录充值+赠送
			hytnService.saveCharacterRechargeRecord(record);
		}
		return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
	}

}
