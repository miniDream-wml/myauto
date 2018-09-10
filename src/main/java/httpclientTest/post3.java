package httpclientTest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class post3 {

	public static String postMap(String url,Map<String,String> headerMap,Map<String, String> contentMap) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        List<NameValuePair> content = new ArrayList<NameValuePair>();
        Iterator iterator = contentMap.entrySet().iterator();           //将content生成entity
        while(iterator.hasNext()){  
            Entry<String,String> elem = (Entry<String, String>) iterator.next();  
            content.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));  
        }
        CloseableHttpResponse response = null;
        try {
            Iterator headerIterator = headerMap.entrySet().iterator();          //循环增加header
            while(headerIterator.hasNext()){  
                Entry<String,String> elem = (Entry<String, String>) headerIterator.next();  
                post.addHeader(elem.getKey(),elem.getValue());
            }
            if(content.size() > 0){  
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(content,"UTF-8");  
                post.setEntity(entity);
            }
            response = httpClient.execute(post);            //发送请求并接收返回数据
            if(response != null && response.getStatusLine().getStatusCode() == 200)
            {
                HttpEntity entity = response.getEntity();       //获取response的body部分
                result = EntityUtils.toString(entity);          //读取reponse的body部分并转化成字符串
            }
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
                if(response != null)
                {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url= "http://kong-test-outer.benditoutiao.com/app/circle/Circle/getGlobalSquareFeeds";
		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("kongread", "a88d406aefaf380af998f8a7d0a87ccb");
		Map<String, String> bodyMap = new HashMap<String, String>();
		bodyMap.put("region_id", "401011");
		String res = postMap(url,headerMap,bodyMap);
		System.out.println(res);

	}

}
