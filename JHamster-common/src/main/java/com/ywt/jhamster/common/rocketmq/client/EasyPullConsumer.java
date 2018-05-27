package com.ywt.jhamster.common.rocketmq.client;
//package com.ywt.rocketmq.config;
//
//
//import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
//import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
//import org.apache.rocketmq.client.consumer.listener.MessageListener;
//import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
//import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
//import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.util.Assert;
//
//
///**
// * rocketmq消费者（pull模式）简易封装
// * @author yuwentao
// *
// */
//public class EasyPullConsumer implements InitializingBean,DisposableBean{
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(EasyPushConsumer.class);
//	
////    private String nameServerAddress;
////    private String application;
////    private String topic;
////    private String tag;
////
////    private MessageListener messageListener;
////
////    private DefaultMQPullConsumer pullConsumer;
////
////
////    @Override
////    public void afterPropertiesSet() throws Exception {
////        Assert.hasText(nameServerAddress);
////        Assert.hasText(application);
////        Assert.hasText(topic);
////        Assert.notNull(messageListener);
////        if (!(messageListener instanceof MessageListenerConcurrently) && !(messageListener instanceof MessageListenerOrderly)) {
////            throw new IllegalArgumentException("messageListener必须是MessageListenerConcurrently或MessageListenerOrderly类型");
////        }
////
////        pullConsumer = new DefaultMQPullConsumer(application.toUpperCase() + "_" + topic);// http://blog.csdn.net/a417930422/article/details/50663639
////        pullConsumer.setNamesrvAddr(nameServerAddress);
////        pullConsumer.subscribe(topic, tag);
////        pullConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
////        pullConsumer.setVipChannelEnabled(false);
////        if (messageListener instanceof MessageListenerConcurrently) {
////        	pullConsumer.registerMessageListener((MessageListenerConcurrently) messageListener);
////        } else {
////        	pullConsumer.registerMessageListener((MessageListenerOrderly) messageListener);
////        }
////        pushConsumer.start();
////
////    }
////
////    @Override
////    public void destroy() throws Exception {
////        try {
////        	pullConsumer.shutdown();
////        } finally {
////            LOGGER.warn("SimplePushConsumer called shutdown.");
////        }
////    }
//}
