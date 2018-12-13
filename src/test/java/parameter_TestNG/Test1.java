package parameter_TestNG;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {
	//参数TestData1传给testdata1，TestData2->testdata2.如果TestData1没有值，则传Optional的值
	@Parameters({"TestData1","TestData2"})
	@Test
	public void test(@Optional("\\aaa") String testdata1,@Optional("\\bbb") String testdata2) {
		System.out.println(System.getProperty("user.dir")+testdata1+testdata2); 
	}

}
