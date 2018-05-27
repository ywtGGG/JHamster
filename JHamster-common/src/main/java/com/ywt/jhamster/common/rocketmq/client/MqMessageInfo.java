package com.ywt.jhamster.common.rocketmq.client;

import java.io.Serializable;

/**
 * rocketmq消息体
 * @author yuwentao
 *
 */
public class MqMessageInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String body;
    private String keys;
    private String tags;

    public MqMessageInfo(String body) {
        this.body = body;
    }

    public MqMessageInfo(String body, String keys) {
        this.body = body;
        this.keys = keys;
    }

    public MqMessageInfo(String body, String keys, String tags) {
        this.body = body;
        this.keys = keys;
        this.tags = tags;
    }

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getKeys() {
		return keys;
	}

	public void setKeys(String keys) {
		this.keys = keys;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
    
}
