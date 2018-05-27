package com.ywt.jhamster.common.rocketmq.client;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 * rocketmq PushConsumer简单封装
 * @author yuwentao
 *
 */
public class EasyPushConsumer implements InitializingBean, DisposableBean {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EasyPushConsumer.class);
	
    private String nameServerAddress;
    private String application;
    private String topic;
    private String tag;

    private MessageListener messageListener;

    private DefaultMQPushConsumer pushConsumer;


    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.hasText(nameServerAddress);
        Assert.hasText(application);
        Assert.hasText(topic);
        Assert.notNull(messageListener);
        if (!(messageListener instanceof MessageListenerConcurrently) && !(messageListener instanceof MessageListenerOrderly)) {
            throw new IllegalArgumentException("messageListener必须是MessageListenerConcurrently或MessageListenerOrderly类型");
        }

        pushConsumer = new DefaultMQPushConsumer(application.toUpperCase() + "_" + topic);
        pushConsumer.setNamesrvAddr(nameServerAddress);
        pushConsumer.subscribe(topic, tag);
        pushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        pushConsumer.setVipChannelEnabled(false);
        if (messageListener instanceof MessageListenerConcurrently) {
            pushConsumer.registerMessageListener((MessageListenerConcurrently) messageListener);
        } else {
            pushConsumer.registerMessageListener((MessageListenerOrderly) messageListener);
        }
        pushConsumer.start();

    }

    @Override
    public void destroy() throws Exception {
        try {
            pushConsumer.shutdown();
        } finally {
            LOGGER.warn("EasyPushConsumer called shutdown.");
        }
    }

	public String getNameServerAddress() {
		return nameServerAddress;
	}

	public void setNameServerAddress(String nameServerAddress) {
		this.nameServerAddress = nameServerAddress;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public MessageListener getMessageListener() {
		return messageListener;
	}

	public void setMessageListener(MessageListener messageListener) {
		this.messageListener = messageListener;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public DefaultMQPushConsumer getPushConsumer() {
		return pushConsumer;
	}

	public void setPushConsumer(DefaultMQPushConsumer pushConsumer) {
		this.pushConsumer = pushConsumer;
	}
    
}
