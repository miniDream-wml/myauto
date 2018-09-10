package com.job.app.news;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class FlowListTest {
	
	String testUrl="flow/list";
	String path="flow/list";
	String baseUrl="http://kong-prod-outer.benditoutiao.com";
	String host = "http://kong-prod-outer.benditoutiao.com";
	String channel_id; //1-推荐， 2-本地， 其他订阅的tag
	String mode; //1 - 自动刷新， 2 - 下拉 3 - 上拉
	String time; //刷新时间小于20分钟时返回空
	String offset; //当前已展示资讯数
	String ad_offset; //当前频道已刷新广告数
	String score; //在本地频道，需要传，其他传空就好
	String kongread="a88d406aefaf380af998f8a7d0a87ccb";
	String region_id="401011";
	String security="3a581df00d53344cd8f94fc09d5395a7";
	
		
//	@DataProvider(name="ex")
//	public Object[][] Parameter() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException{
//    	return new Object[][]{
//        	{"1", "1", "", "0", "0", "", "1", "success"},
//        	{"2", "1", "", "0", "0", "", "1", "success"},
//        	//{channel_id,, "1", "success"},
//        }; 
//	}
	
	@BeforeClass
	public void setUp() throws UnsupportedEncodingException {
		System.out.println("新版资讯信息流接口测试开始！");
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("新版资讯信息流接口测试结束！");
	}
	
	@Test()
	public void loginTest() throws ClientProtocolException, IOException{	
    	String url = baseUrl + testUrl + "?channel_id=2&mode=2&region_id=101010&security=3a581df00d53344cd8f94fc09d5395a7&time=1535370950720&udid=86e6aade833847e19f0a0e8c16ed791c";
        System.out.println(url);
        
    
        CloseableHttpClient httpCilent = HttpClients.createDefault();//Creates CloseableHttpClient instance with default configuration.
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        try {

        	CloseableHttpResponse response = httpCilent.execute(httpGet);
        	System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpCilent.close();//释放资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
       
//        String result = HTTPPost.httpPostForm(url, params);
//        System.out.println(result);
//        
//        int code = Integer.parseInt(excode);
//        
//        Gson gs = new Gson();
//        TestJSonResult final_res = gs.fromJson(result, TestJSonResult.class);
//        
//        Assert.assertEquals(final_res.code,code);
//        Assert.assertEquals(final_res.msg,exmsg);
 /*       
      //判断app首页本地圈推广位／本地资讯／全国资讯是否存在
        JSONObject res=final_res.getData();
		JSONObject circleObj=res.getJSONObject("circle");
		if (circleObj.optString("feed_id").isEmpty()) {
			System.out.println("本地圈推广位返回为空啦！！");
		}
		
		JSONArray arts=res.getJSONArray("card_list"); 
		JSONArray  localart=arts.getJSONObject(0).getJSONArray("items");//本地资讯
		JSONArray  globalart=arts.getJSONObject(1).getJSONArray("items");//全国资讯
		
		if (localart.isEmpty()) {
			System.out.println("本地资讯返回为空啦！！");
		}else {
			int locallen=localart.size();
			System.out.println("本地资讯条数："+locallen);
		}
		if (globalart.isEmpty()) {
			System.out.println("全国资讯返回为空啦！！");
		}else {
			int glioballen=globalart.size();
			System.out.println("全国资讯条数："+glioballen);
			
			//输出精品卡的位置
			for(int i=0;i<globalart.size();i++) {
				JSONObject specialObj =(JSONObject) globalart.get(i);
				int position=i+1;
				int style=specialObj.getInt("style");
				if (style==12) {
					System.out.println("精品卡位置："+position+"\t精品卡名称:"+specialObj.getString("specially_name")+"\t文章名称:"+specialObj.getString("title")+"\t文章ID:"+specialObj.getString("news_id"));
				}
			}
		}
*/		
		
	}	
}
