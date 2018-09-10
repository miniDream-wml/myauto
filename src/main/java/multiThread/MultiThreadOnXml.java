package multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnXml {
	
	@Test
	public void Test1() {
		System.out.printf("Thread Id : %s%n",Thread.currentThread());
	}
	
	@Test
	public void Test2() {
		System.out.printf("Thread Id : %s%n",Thread.currentThread());
	}
	
	@Test
	public void Test3() {
		System.out.printf("Thread Id : %s%n",Thread.currentThread());
	}
	
	@Test
	public void Test4() {
		System.out.printf("Thread Id : %s%n",Thread.currentThread());
	}
	
}
