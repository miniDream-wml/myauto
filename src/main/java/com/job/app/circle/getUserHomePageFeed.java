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
 * 本地圈-个人主页动态
 */

public class getUserHomePageFeed {
	@DataProvider(name="ex")
	public Object[][] data_provider(){
		Object[][] o = new Object[][]{
			//{"target_uid","uid","excode","exmsg"}
			{"2201830","877478","1","success"},
			{"2201830","7478","1","success"},
			{"30","","1","success"},
			
		};
		return o;
	}
	
	@BeforeClass
	public void setup() {
		System.out.println("获取个人主页动态接口测试开始！");
	}
	
	@AfterClass
	public void setdown() {
		System.out.println("获取个人主页动态接口测试结束！");
	}
	
	@Test(dataProvider="ex")
	public void test1(String target_uid,String uid,String excode,String exmsg ){
		// 本地圈全国动态接口测试
			String testcircleUrl = propertiesHandle.readValue("procircleUrl");
			String path = "Circle/getCircleUserHomePageFeeds";
			String url= testcircleUrl + path;
			//System.out.println(url);
			
			Map<String, String> headerMap = headersBuild.headers_build();			
			Map<String, String> bodyMap = paramsBuild.params_build();
			bodyMap.put("target_uid", target_uid);
			bodyMap.put("uid", uid);
			bodyMap.put("security", "75d260290e889f5abdc61740699371c3");
			bodyMap.put("time", "1535617412140");
			
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
