package groups_TestNG;

import org.testng.annotations.Test;

public class Test_group {
	
	@Test(groups="mygroup1")
	public void test1() {
		System.out.println("This is test1");
	}
	@Test(groups="mygroup1")
	public void test1_1() {
		System.out.println("This is test1_1");
	}
	@Test(groups="mygroup2")
	public void test2() {
		System.out.println("This is test2");
	}
	@Test(groups="mygroup3")
	public void test3() {
		System.out.println("This is test3");
	}

}
