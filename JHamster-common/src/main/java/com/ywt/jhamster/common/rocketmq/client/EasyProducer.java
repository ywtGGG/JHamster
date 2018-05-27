package com.ywt.jhamster.common.rocketmq.client;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 * rocketmq生产者简易封装
 * @author yuwentao
 *
 */
public class EasyProducer implements InitializingBean, DisposableBean {
	private static final Logger LOGGER = LoggerFactory.getLogger(EasyProducer.class);
    private long defaultTimeout = 3000;//默认3秒
    private String nameServerAddress;
    private String application;
    private String topic;

    private DefaultMQProducer producer;

    /**
     * 发送消息，使用默认topic和超时时间
     *
     * @param message
     * @return
     * @throws MQException
     */
    public SendResult sendMessage(MqMessageInfo message) {
        return sendMessage(this.topic, message, defaultTimeout);
    }

    /**
     * 发送消息，使用默认topic
     *
     * @param message
     * @param timeoutInMilliSeconds
     * @return
     * @throws MQException
     */
    public SendResult sendMessage(MqMessageInfo message, long timeoutInMilliSeconds) {
        return sendMessage(this.topic, message, timeoutInMilliSeconds);
    }

    /**
     * 发送消息，使用默认超时时间
     *
     * @param topic 指定topic，不指定使用sendMessage(StringMessage message)方法
     * @param message
     * @return
     * @throws MQException
     */
    public SendResult sendMessage(String topic, MqMessageInfo message) {
        return sendMessage(topic, message, defaultTimeout);
    }

    /**
     * 发送消息
     * @param topic 指定topic，不指定使用sendMessage(StringMessage message, long timeoutInMilliSeconds)方法
     * @param message
     * @param timeoutInMilliSeconds
     * @return
     * @throws MQException
     */
    public SendResult sendMessage(String topic, MqMessageInfo message, long timeoutInMilliSeconds) {
        Assert.notNull(topic);
        Assert.notNull(message);
        Assert.notNull(message.getBody());
        Assert.isTrue(timeoutInMilliSeconds > 0, "超时时间必须大于0");
        try {
            return producer
                    .send(new Message(topic, message.getTags(), message.getKeys(), message.getBody().getBytes()),
                            timeoutInMilliSeconds);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public DefaultMQProducer getProducer() {
        return producer;
    }

    @Override
    public void destroy() throws Exception {
        try {
            producer.shutdown();
        } finally {
            LOGGER.warn("EasyProducer called shutdown.");
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.hasText(nameServerAddress);
        Assert.hasText(application);
        //Assert.hasText(topic);
        
        producer = new DefaultMQProducer(this.application);
        producer.setNamesrvAddr(this.nameServerAddress);
        producer.setVipChannelEnabled(false);
        producer.start();
    }

	public long getDefaultTimeout() {
		return defaultTimeout;
	}

	public void setDefaultTimeout(long defaultTimeout) {
		this.defaultTimeout = defaultTimeout;
	}

	public String getNameServerAddress() {
		return nameServerAddress;
	}

	public void setNameServerAddress(String nameServerAddress) {
		this.nameServerAddress = nameServerAddress;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public void setProducer(DefaultMQProducer producer) {
		this.producer = producer;
	}
    
}
