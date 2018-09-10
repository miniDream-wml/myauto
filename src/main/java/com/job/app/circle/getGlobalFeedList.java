package com.job.app.circle;

import com.job.app.utils.httpPost;
import com.job.app.utils.propertiesHandle;
import com.job.app.utils.paramsBuild;
import com.google.gson.Gson;
import com.job.app.utils.headersBuild;
import com.job.app.utils.judgeType;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * @author wangmenglei
 * 2018/8/28、29
 * 本地圈广场信息流（全国动态）
 */

public class getGlobalFeedList {
	
	@DataProvider(name="ex")
	public Object[][] data_provider(){
		Object[][] o = new Object[][]{
			//{"mode","index","excode","exmsg"}
			{"1","","1","success"},
			//{"2","","1","success"},
			//{"2","6930012814702ccfe04a2416972978ff-64be2c5c669694dace6051e15ccee585","1","success"}
		};
		return o;
	}
	
	@BeforeClass
	public void setup() {
		System.out.println("本地圈全国动态接口测试开始！");
	}
	
	@AfterClass
	public void setdown() {
		System.out.println("本地圈全国动态接口测试结束！");
	}
	
	@Test(dataProvider="ex")
	public void test1(String mode,String index,String excode,String exmsg ){
		// 本地圈全国动态接口测试
			String testcircleUrl = propertiesHandle.readValue("testcircleUrl");
			String path = "Circle/getGlobalSquareFeeds";
			String url= testcircleUrl + path;
			//System.out.println(url);
			
			Map<String, String> headerMap = headersBuild.headers_build();			
			Map<String, String> bodyMap = paramsBuild.params_build();
			bodyMap.put("mode", mode);
			bodyMap.put("index", index);
			
			String result = httpPost.postMap(url,headerMap,bodyMap);
			JSONObject obj = JSONObject.fromObject(result);
			System.out.println("------请求返回数据------：" + result);	
			
			int ocode = Integer.parseInt(excode);

			int r_code = (Integer) obj.get("code");
			JSONObject r_data = (JSONObject) obj.get("data");
			String r_msg = (String) obj.get("msg");
	
//-------------------------------------- 解析结果 ----------------------------------------------
//			String r_index = (String) r_data.get("index");
//			JSONArray r_hottopic = (JSONArray) r_data.get("hot_topic");
//			JSONArray r_feedlist = (JSONArray) r_data.get("feed_list");
//					
//			System.out.println("------r_code------:" + r_code);	
//			System.out.println("------r_data------:" + r_data);
//			System.out.println("------r_msg------:" + r_msg);	
//			System.out.println("------r_index------:" + r_index);
//			System.out.println("------r_hottopic------:" + r_hottopic);
//			System.out.println("------r_feedlist------:" + r_feedlist);
//---------------------------------------------------------------------------------------------			
			
		    Assert.assertEquals(r_code,ocode);
			Assert.assertEquals(r_msg,exmsg);
	}
	

	
}
