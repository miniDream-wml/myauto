package suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SuiteCofig {
	
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("-----");
	}
	
	@AfterSuite
	public void afterSuite(){
		System.out.println("------");
	}
}
