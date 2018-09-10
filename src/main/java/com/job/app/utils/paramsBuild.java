package com.job.app.utils;

import java.util.HashMap;
import java.util.Map;

import com.job.app.utils.propertiesHandle;

/**
 * @author wangmenglei
 * 2018/8/28
 * 此函数的作用是构建一个包含公共参数的params文件
 */

public class paramsBuild {
	
	private static String region_id = propertiesHandle.readValue("region_id_linzhou");
	private static String udid = propertiesHandle.readValue("udid");
	private static String version = propertiesHandle.readValue("version");
	
	public static Map<String,String> params_build(){
		
		Map<String,String> buildMap = new HashMap<String,String>();
		buildMap.put("region_id", region_id);
		buildMap.put("udid", udid);
		buildMap.put("version", version);
		
		return buildMap;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(params_build());
				

	}

}
