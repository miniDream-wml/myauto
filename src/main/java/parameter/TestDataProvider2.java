package parameter;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider2 {
	
	 @Test(dataProvider = "dbconfig")
	    public void testConnection(Map<String, String> map) {

	        for (Map.Entry<String, String> entry : map.entrySet()) {
	            System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
	        }

	    }

	    @DataProvider(name = "dbconfig")
	    public Object[][] provideDbConfig() {
	        Map<String, String> map = readDbConfig();
	        return new Object[][] { { map } };
	    }

	    public Map<String, String> readDbConfig() {

	        Properties prop = new Properties();
	        InputStream input = null;
	        Map<String, String> map = new HashMap<String, String>();

	        try {
	            //input = getClass().getClassLoader().getResourceAsStream("db.properties");?不懂，也不懂为啥报错
	        	InputStream in = new BufferedInputStream(new FileInputStream("db.properties"));
	            prop.load(in);

	            map.put("jdbc.driver", prop.getProperty("jdbc_driver"));
	            map.put("jdbc.url", prop.getProperty("jdbc_url"));
	            map.put("jdbc.username", prop.getProperty("jdbc_username"));
	            map.put("jdbc.password", prop.getProperty("jdbc_password"));

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (input != null) {
	                try {
	                    input.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	        return map;

	    }

}
