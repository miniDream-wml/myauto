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
 * 本地圈-删除动态
 */

public class deleteFeed {
	
	String testcircleUrl = propertiesHandle.readValue("procircleUrl");
	String path = "Circle/delete";
	String token = "f371f5d59d1b3585732711f59e7cd101cf24be41";

	@DataProvider(name="ex")
	public Object[][] data_provider(){
		Object[][] o = new Object[][]{
			//{"feed_id","uid","token","excode","exmsg"}
			{"8618d376edb4ba6b0f56d91f1a368bdd","806987",token,"1","success"}
			
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
	public void test1(String feed_id,String uid,String token,String excode,String exmsg ){

			String url= testcircleUrl + path;
			//System.out.println(url);
			
			Map<String, String> headerMap = headersBuild.headers_build();			
			Map<String, String> bodyMap = paramsBuild.params_build();
			bodyMap.put("feed_id", feed_id);
			bodyMap.put("uid", uid);
			bodyMap.put("token", token);
			bodyMap.put("security", "4e4c23eaeb7586c8f20059afc8b3bf03");
			bodyMap.put("time", "1535627821667");
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
