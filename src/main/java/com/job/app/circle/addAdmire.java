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
 * 本地圈-点赞接口
 */

public class addAdmire {
	
	@DataProvider(name="ex")
	public Object[][] data_provider(){
		Object[][] o = new Object[][]{
			//{"feed_id","uid","token","excode","exmsg"}
			{"db65bf70d089c884a5dbea031ad24963","877478","51411d1af8945827ab4e0239e38468415e493da7","1","success"},
			{"db65bf70d089c884a5dbea031ad24963","877478","","15000","亲，请登录呀~"},
			{"","877478","51411d1af8945827ab4e0239e38468415e493da7","1","success"},
			
		};
		return o;
	}

	@BeforeClass
	public void setup() {
		System.out.println("点赞接口测试开始！");
	}
	
	@AfterClass
	public void setdown() {
		System.out.println("点赞接口测试结束！");
	}
	
	@Test(dataProvider="ex")
	public void test1(String feed_id,String uid,String token,String excode,String exmsg ){
		// 本地圈全国动态接口测试
			String testcircleUrl = propertiesHandle.readValue("procircleUrl");
			String path = "Circle/admire";
			String url= testcircleUrl + path;
			//System.out.println(url);
			
			Map<String, String> headerMap = headersBuild.headers_build();			
			Map<String, String> bodyMap = paramsBuild.params_build();
			bodyMap.put("feed_id", feed_id);
			bodyMap.put("uid", uid);
			bodyMap.put("token", token);
			bodyMap.put("security", "c9d2c72cef2d3ed640fd8bcdb38325dc");
			bodyMap.put("time", "1535623925112");
			
			String result = httpPost.postMap(url,headerMap,bodyMap);
			JSONObject obj = JSONObject.fromObject(result);
			System.out.println("------请求返回数据------：" + result);	
			
			int ocode = Integer.parseInt(excode);

			int r_code = (Integer) obj.get("code");
			JSONObject r_data = (JSONObject) obj.get("data");
			String r_msg = (String) obj.get("msg");
			
		    Assert.assertEquals(r_code,ocode);
			Assert.assertEquals(r_msg,exmsg);
	}
}
