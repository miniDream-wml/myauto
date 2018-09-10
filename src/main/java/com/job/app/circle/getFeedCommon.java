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
 * 本地圈-动态详情页评论
 */

public class getFeedCommon {

	@DataProvider(name="ex")
	public Object[][] data_provider(){
		Object[][] o = new Object[][]{
			//{"feed_id","uid","excode","exmsg"}
			{"2a06b72f55600033d280ffcbef800a52","877478","1","success"},
	        {"443gggg333","877478","1","success"},
			{"","","10004","抱歉,动态丢失了~"},
			
		};
		return o;
	}
	
	@BeforeClass
	public void setup() {
		System.out.println("动态详情页评论接口测试开始！");
	}
	
	@AfterClass
	public void setdown() {
		System.out.println("动态详情页评论接口测试结束！");
	}
	
	@Test(dataProvider="ex")
	public void test1(String feed_id,String uid,String excode,String exmsg ){
		// 本地圈全国动态接口测试
			String testcircleUrl = propertiesHandle.readValue("procircleUrl");
			String path = "Circle/getComment";
			String url= testcircleUrl + path;
			//System.out.println(url);
			
			Map<String, String> headerMap = headersBuild.headers_build();			
			Map<String, String> bodyMap = paramsBuild.params_build();
			bodyMap.put("feed_id", feed_id);
			bodyMap.put("uid", uid);
			bodyMap.put("security", "007e128eace7311d386bb613d3bd7cb5");
			bodyMap.put("time", "1535620194969");
			
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
	