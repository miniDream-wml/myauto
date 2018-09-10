package com.job.app.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author wangmenglei
 * 2018/8/28 
 * 解析properties文件数据
 */

public class propertiesHandle {
	
	public static String readValue(String key) {
		Properties props = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream("config.properties"));
			props.load(in);
			String value = props.getProperty(key);
			return value;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res = readValue("username");
		System.out.println(res);

	}

}
