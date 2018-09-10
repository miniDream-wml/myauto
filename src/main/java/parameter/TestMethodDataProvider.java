package parameter;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestMethodDataProvider {

	@DataProvider(name = "mydata")
	public Object[][] provideData(Method method){
		
		Object[][] result = null;
		if(method.getName().equals("dpTest1")) {
			result = new Object[][]{
				{"花轮",7,"北都小学"},
				{"多啦A梦",7,"北都小学"},
				{"张小花",7,"北都小学"}
			};
		}else if(method.getName().equals("dpTest2")) {
			result = new Object[][]{
				{"小美",6,"海淀小学"},
				{"小雅",6,"海淀小学"},
				{"小町",6,"海淀小学"}
			};
		}
			
		return result;
	}
	
	@Test(dataProvider = "mydata")
	public void dpTest1(String name,int age,String school) {
		System.out.println("name:" + name + ",age:" + age + ",school:"+ school);
	}
	
	@Test(dataProvider = "mydata")
	public void dpTest2(String name,int age,String school) {
		System.out.println("name:" + name + ",age:" + age + ",school:"+ school);
	}
	
}
