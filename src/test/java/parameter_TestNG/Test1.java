package parameter_TestNG;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {
	//����TestData1����testdata1��TestData2->testdata2.���TestData1û��ֵ����Optional��ֵ
	@Parameters({"TestData1","TestData2"})
	@Test
	public void test(@Optional("\\aaa") String testdata1,@Optional("\\bbb") String testdata2) {
		System.out.println(System.getProperty("user.dir")+testdata1+testdata2); 
	}

}
