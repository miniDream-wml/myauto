package com.job.app.circle;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.job.app.utils.propertiesHandle;

import net.sf.json.JSONObject;

import com.job.app.utils.headersBuild;
import com.job.app.utils.httpPost;
import com.job.app.utils.paramsBuild;

/**
 * @author wangmenglei
 * 2018/8/30
 * 本地圈广场信息流（全国动态）
 */

public class getLocalFeedList {
	
	@DataProvider(name="ex")
	public Object[][] data_provider(){
		Object[][] o = new Object[][]{
			//{"mode","circle_mode","excode","exmsg"}
			{"1","1","1","success"},
			{"2","2","1","success"},
			{"11","11","1","success"},
		};
		return o;
	}
	
	@BeforeClass
	public void setup() {
		System.out.println("本地圈本地动态接口测试开始！");
	}
	
	@AfterClass
	public void setdown() {
		System.out.println("本地圈本地动态接口测试结束！");
	}
	
	@Test(dataProvider="ex")
	public void test1(String mode,String circle_mode,String excode,String exmsg ){
		
		String testcircleUrl = propertiesHandle.readValue("testcircleUrl");
		String path  = "Circle/getLocalSquareFeeds";
		String url = testcircleUrl + path;
		
		Map<String, String> headerMap = headersBuild.headers_build();
		Map<String, String> bodyMap = paramsBuild.params_build();
		bodyMap.put("circle_mode", circle_mode);
		bodyMap.put("mode", mode);
		
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
