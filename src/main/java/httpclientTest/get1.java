package httpclientTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class get1 {
	//搞不清楚，反正能跑了，哎
	
	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpCilent = HttpClients.createDefault();//Creates CloseableHttpClient instance with default configuration.
        String url = "http://www.baidu.com";
		
        try {
        	HttpGet httpGet = new HttpGet(url);
        	CloseableHttpResponse response = httpCilent.execute(httpGet);
        	System.out.println(response.toString());
        	
        	ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

        		
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };

            HttpEntity entity1 = response.getEntity();
        	String responseBody = httpCilent.execute(httpGet, responseHandler);
            System.out.println(responseBody);
            EntityUtils.consume(entity1);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpCilent.close();//释放资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
}
