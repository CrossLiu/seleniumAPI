package pageObject;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.seleniumAPI.GetWebDriver;




//�ٶ���ҳ����������д
public class Testcase {
   private WebDriver driver;
	@BeforeClass
	public void setUp() {
		driver=GetWebDriver.getWebDriver("firefox");
	}
	
	@Test
    public void baiduTest() {
		
		try {
			Pages pages=new Pages(driver);
			pages.navigateBaidu("http://www.baidu.com");
			pages.sendKey("TestCase");
			pages.clickBaiduyixia();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
}
