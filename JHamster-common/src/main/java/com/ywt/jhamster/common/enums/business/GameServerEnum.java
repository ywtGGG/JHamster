package com.ywt.jhamster.common.enums.business;

/**
 * 游戏服务器枚举
 * @author yuwentao
 *
 */
public enum GameServerEnum {
	
	HYTN(10,"回忆童年"),
	OTHER(99,"其他");
	;
	
	private Integer code;
	private String desc;
	GameServerEnum(Integer code,String desc){
		this.code = code;
		this.desc = desc;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static GameServerEnum getEnumByCode(Integer code){
		for (GameServerEnum e : GameServerEnum.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	public static String getDescByCode(Integer code){
		for (GameServerEnum e : GameServerEnum.values()) {
			if (e.getCode().equals(code)) {
				return e.getDesc();
			}
		}
		return "";
	}
}
