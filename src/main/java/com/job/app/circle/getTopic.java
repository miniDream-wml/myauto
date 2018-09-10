package com.job.app.circle;

import java.util.Map;

import org.testng.Assert;
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
 * 获取话题主页
 */

public class getTopic {
	
	@DataProvider(name="ex")
	public Object[][] dataProvider(){
		Object[][] o = new Object[][]{
			//{"topic_name","circle_app_mode","circle_mode","mode","excode","exmsg"},
			{"happy","0","1","1","1","success"},
			{"图书馆","0","1","1","1","success"},
		};
		return o;
	}
	
	@BeforeClass
	public void setup() {
		System.out.println("话题主页接口测试开始！");
	}
	
	@AfterClass
	public void setdown() {
		System.out.println("话题主页接口测试结束！");
	}
	
	@Test(dataProvider="ex")
	public void test1(String topic_name,String circle_app_mode,String circle_mode,String mode,String excode,String exmsg ){
		
		String testcircleUrl = propertiesHandle.readValue("procircleUrl");
		String path  = "Circle/getTopic";
		String url = testcircleUrl + path;
	    System.out.println(url);
		
		Map<String, String> headerMap = headersBuild.headers_build();
		Map<String, String> bodyMap = paramsBuild.params_build();
		bodyMap.put("topic_name", topic_name);
		bodyMap.put("circle_app_mode", circle_app_mode);
		bodyMap.put("circle_mode", circle_mode);
		bodyMap.put("mode", mode);
		bodyMap.put("security", "a64cde46436685c7739cb6185c0c1fd2");
		bodyMap.put("time", "1535616267300");
		
		String result = httpPost.postMap(url, headerMap, bodyMap);
		JSONObject obj = JSONObject.fromObject(result);
		System.out.println(obj);
		
		int r_code = obj.getInt("code");
		String code = obj.getString("code");
		JSONObject r_data = (JSONObject) obj.get("data");
		String r_msg = obj.getString("msg");
		
		Assert.assertEquals(code, excode);
		Assert.assertEquals(r_msg, exmsg);
	}
}
