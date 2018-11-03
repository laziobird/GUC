package com.laziobird;

public enum CommonEnum {

	USER_UPDATE_SUCCESS("用户更新成功", 1, "用户状态"), 
	USER_UPDATE_FAIL("用户更新失败", -1, "用户状态"), 		
	
	USER_STATUS_OK("用户正常", 1, "用户状态"), 
	USER_STATUS_FREEZE("用户冻结", 0, "可以登录没有权限"), 
	USER_STATUS_DELETE("用户删除", -1,"删除不能恢复");

	private String key;
	private int value;
	private String desc;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private CommonEnum(String key, int value, String desc) {
		this.key = key;
		this.value = value;
		this.desc = desc;
	}

	public String getKey() {
		return key;
	}

	public int getValue() {
		return value;
	}

}
