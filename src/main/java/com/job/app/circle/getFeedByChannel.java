package com.job.app.circle;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.job.app.utils.headersBuild;
import com.job.app.utils.httpPost;
import com.job.app.utils.paramsBuild;
import com.job.app.utils.propertiesHandle;

import net.sf.json.JSONObject;

/**
 * @author wangmenglei
 * 2018/8/30
 * 获取频道动态
 */

public class getFeedByChannel {
	
	@DataProvider(name="ex")
	public Object[][] dataPorvider(){
		Object[][] o = new Object[][] {
			//{"channel_id","mode","excode","exmsg"}
			{"10","1","1","success"},
			{"11","1","1","success"}
		};
		return o;
	}
	@BeforeClass
	public void setup() {
		System.out.println("频道动态接口测试开始！");
	}
	
	@AfterClass
	public void setdown() {
		System.out.println("频道动态接口测试结束！");
	}
	
	@Test(dataProvider="ex")
	public void test1(String channel_id,String mode,String excode,String exmsg ){
		String testcircleUrl = propertiesHandle.readValue("testcircleUrl");
		String path = "Circle/getFeedByChannel";
		String url  = testcircleUrl + path;
		
		Map<String, String> headerMap = headersBuild.headers_build();
		Map<String, String> bodyMap = paramsBuild.params_build();
		bodyMap.put("channel_id", channel_id);
		bodyMap.put("mode", mode);
		
		String result = httpPost.postMap(url, headerMap, bodyMap);
		JSONObject obj = JSONObject.fromObject(result);
		System.out.println(obj);
	}
}
