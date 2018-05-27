package com.ywt.jhamster.common.function;

import java.util.HashMap;
import java.util.Map;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.ywt.jhamster.common.enums.web.ResultCode;
import com.ywt.jhamster.common.exception.BussinessException;
import com.ywt.jhamster.common.rocketmq.client.EasyProducer;
import com.ywt.jhamster.common.rocketmq.client.MqMessageInfo;
import com.ywt.jhamster.common.utils.SpringContextHolder;
import com.ywt.jhamster.entity.params.game.GameRechargeVO;


/**
 * mq统一发送消息
 * @author yuwentao
 *
 */
public class MqSender {
	
	private final static Logger logger = LoggerFactory.getLogger(MqSender.class);
	
	
	/**
	 * 测试用
	 * @return
	 */
	public boolean sendMessage(){
		Map<String, Object> messageMap = new HashMap<String,Object>();
		messageMap.put("name", "张三");
		messageMap.put("age", 14);
		JSONObject jsonObject =new JSONObject(messageMap);
		try {
			EasyProducer easyProducer = SpringContextHolder.getBean(EasyProducer.class);
			SendResult result = easyProducer.sendMessage(new MqMessageInfo(jsonObject.toJSONString()));
            logger.info("MqSender sendMessage return :"+ result.toString());
            if (SendStatus.SEND_OK == result.getSendStatus()) {
                return true;
            }
        }
        catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BussinessException(ResultCode.SYS_ERROR);
        }
        return false;
	}
	
	/**
	 * 发送充值成功的mq消息
	 * @param gameRechargeVO
	 */
	public static void sendRechargeMessage(GameRechargeVO gameRechargeVO){
		try {
			EasyProducer easyProducer = SpringContextHolder.getBean(EasyProducer.class);
			SendResult result = easyProducer.sendMessage(new MqMessageInfo(JSONObject.toJSONString(gameRechargeVO)));
            if (SendStatus.SEND_OK == result.getSendStatus()) {
            	logger.info("MqSender sendMessage return :"+ result.toString());
            }else{
            	logger.error("MqSender sendMessage return :"+ result.toString());
            }
        }
        catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BussinessException(ResultCode.SYS_ERROR);
        }
	}
	
	public  void test(){
		GameRechargeVO vo = new GameRechargeVO();
		try {
			vo.getCharName().equals("");
		} catch (Exception e) {
			throw e;
		}
		
	}
	public static void test1(){
		throw new BussinessException("测试异常");
	}
	
	public static String test2(){
		return "success-hha";
	}
}
