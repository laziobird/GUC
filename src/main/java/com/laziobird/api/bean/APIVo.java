package com.laziobird.api.bean;

/**
 * API 标准规范
 * @author laziobird
 *
 */
public class APIVo {

    private String apiVersion = "v1";

    private String status = "Success";

    private String message;

    private Object data;

	private int code = 200;

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "APIVo [apiVersion=" + apiVersion + ", status=" + status + ", message=" + message + ", data=" + data
				+ ", code=" + code + "]";
	}


}
