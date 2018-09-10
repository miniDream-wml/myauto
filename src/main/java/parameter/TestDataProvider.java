package parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {
	
	@DataProvider(name = "mydata")
	public Object[][] provideData(){
		return new Object[][]{
			{"花轮",6,"北都小学"},
			{"多啦A梦",5,"南岸小学"},
			{"张小花",7,"海淀小学"}
		};
	}
	
	@Test(dataProvider = "mydata")
	public void dpTest(String name,int age,String school) {
		System.out.println("name: " + name + ",age: " + age + ",school: "+ school);
	}
	
	
}
