package com.job.app.utils;

import java.util.HashMap;
import java.util.Map;

import com.job.app.utils.propertiesHandle;

/**
 * @author wangmenglei
 * 2018/8/28
 * 此函数的作用是构建一个包含header参数的文件
 */

public class headersBuild {
	
	private static String kongread = propertiesHandle.readValue("kongread");
	
	public static Map<String,String> headers_build(){
		Map<String,String> headersMap = new HashMap<String,String>();
		headersMap.put("kongread", kongread);
		return headersMap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(headers_build());
	}
}
