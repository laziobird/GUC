package com.laziobird.util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author 蒋志伟
 * @version 创建时间：2018年11月9日 下午3:59:11
 */
public class JSONUtils {
	public static String fillResultString(Integer status, String message, Object result) {
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject() {
				{
					put("status", status);
					put("message", message);
					put("result", result);
				}
			};
			return jsonObject.toString();
		} catch (JSONException e) {
			return "Server error: " + e.getMessage()+" | message : "+message;
		}		
	}
}
