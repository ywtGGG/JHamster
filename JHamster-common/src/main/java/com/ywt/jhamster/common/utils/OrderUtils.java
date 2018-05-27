package com.ywt.jhamster.common.utils;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;
import com.ywt.jhamster.common.constant.CommonConstant;

/**
 * 订单工具类
 * @author yuwentao
 *
 */
public class OrderUtils {
	
	/**
	 * 获取全局唯一订单号 总长20位
	 * 组成部分：第1位为前缀"Y"，第2位为商品类型，第3、4位为服务器，第5位为支付方式
	 * 			第6-13位为订单时间，精确到天，第14-20位为随机数
	 * @param goodsType 商品类型-虚拟／实物
	 * @param payType  支付方式
	 * @param gameServer  服务器
	 * @return
	 */
	public static String getOrderNum(Integer goodsType,Integer gameServer,Integer payType){
		StringBuffer sb = new StringBuffer(CommonConstant.ORDER_PREFIX);
		sb.append(goodsType.toString()).append(gameServer.toString())
			.append(payType.toString()).append(getSerialNumber());
		return sb.toString();
	}
	
	/**
	 * 产生唯一 的序列号。
	 * 
	 * @return String
	 */
	public static String getSerialNumber() {
		int hashCode = UUID.randomUUID().toString().hashCode();
		if (hashCode < 0) {
			hashCode = -hashCode;
		}
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(DateUtils.getNow())+ String.format("%010d", hashCode).substring(3);
	}
	
	public static void main(String[] args){
		Map<String, Object> messageMap = new HashMap<String,Object>();
		messageMap.put("name", "张三");
		messageMap.put("age", 14);
		JSONObject jsonObject =new JSONObject(messageMap);
		System.out.println(jsonObject.toJSONString());
		
		
		String orderNum = OrderUtils.getOrderNum(0,99,1);
		System.out.println(orderNum+"  size="+orderNum.length());
	}
}
