package groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupOnClass1 {
	
	public void stu1() {
		System.out.println("这是group1-stu1");
	}
	
	public void stu2() {
		System.out.println("这是group1-stu2");
	}
}
