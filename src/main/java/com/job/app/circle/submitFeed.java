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
 * 本地圈-发布图文动态
 */

public class submitFeed {
	
	String testcircleUrl = propertiesHandle.readValue("procircleUrl");
	String path = "Circle/submit";
	String pics = "[{\"width\":\"720\",\"path\":\"https:\\/\\/oss-cn-hangzhou.aliyuncs.com\\/bdq\\/video\\/15356254900804B6F7904-41CB-4390-B53A-2B75F16BFB9B.jpeg\",\"height\":\"688\"},{\"width\":\"828\",\"path\":\"https:\\/\\/oss-cn-hangzhou.aliyuncs.com\\/bdq\\/video\\/1535624574915811D1F70-5A00-4C10-841F-1953056CBD10.jpeg\",\"height\":\"1472\"}]";
	String token = "f371f5d59d1b3585732711f59e7cd101cf24be41";
	
	@DataProvider(name="ex")
	public Object[][] data_provider(){
		Object[][] o = new Object[][]{
			//{"pics","content","tag_names","uid","token","excode","exmsg"}
			{pics,"这是代码编写的内容#happy#","[\"鹿晗啊\"]","877478",token,"1","success"},
			{pics,"无话题","[\"鹿晗啊\"]","877478",token,"1","success"},
			{"","无图测试","[\"鹿晗啊\"]","877478",token,"1","success"},
			{pics,"","[\"鹿晗啊\"]","877478",token,"1","success"},
			{pics,"无标签","[\"鹿晗啊\"]","877478",token,"1","success"},
			{pics,"无token，吼吼","[\"鹿晗啊\"]","877478","","15000","亲，请登录呀~"},
			{"","","","877478",token,"1","success"},
			{pics,"无uid","[\"鹿晗啊\"]","",token,"10002","发布失败，请稍后重试~"},
			//无region_id时，结果同无uid
			
		};
		return o;
	}

	@BeforeClass
	public void setup() {
		System.out.println("发布动态接口测试开始！");
	}
	
	@AfterClass
	public void setdown() {
		System.out.println("发布动态接口测试结束！");
	}
	
	@Test(dataProvider="ex")
	public void test1(String pics,String content,String tag_name,String uid,String token,String excode,String exmsg ){

			String url= testcircleUrl + path;
			//System.out.println(url);
			
			Map<String, String> headerMap = headersBuild.headers_build();			
			Map<String, String> bodyMap = paramsBuild.params_build();
			bodyMap.put("pic_infos", pics);
			bodyMap.put("content", content);
			bodyMap.put("tag_name", tag_name);
			bodyMap.put("uid", uid);
			bodyMap.put("token", token);
			bodyMap.put("security", "4017c5c60220c6abc09a99959571a3bc");
			bodyMap.put("time", "1535626806488");
			//System.out.println(bodyMap);

			
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
