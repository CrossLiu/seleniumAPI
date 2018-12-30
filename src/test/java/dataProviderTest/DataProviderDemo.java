package dataProviderTest;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	private static WebDriver driver;
	@DataProvider(name="searchKeywords")
	public static Object[][] keywords() {
		return new Object[][] {{"������","����","���˶�"},{"����","����","����"},{"����Σ��","���","����ɭ"}};	
	}
	
	@Test(dataProvider="searchKeywords")
	public void test(String searchkeyword1,String searchkeyword2,String searchResult) {
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.sogou.com");//�����ѹ�
		
		driver.findElement(By.id("query")).sendKeys(searchkeyword1+" "+searchkeyword2); //�����
		driver.findElement(By.id("stb")).click();//���������ť
		
		assertTrue(driver.getPageSource().contains(searchResult));//�ж�����ҳ���Ƿ�������������е������Ĺؼ���
		driver.quit();
	}

}
