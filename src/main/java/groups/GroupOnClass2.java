package groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupOnClass2 {
	public void stu1() {
		System.out.println("这是group2-stu1");
	}
	
	public void stu2() {
		System.out.println("这是group2-stu2");
	}
}
