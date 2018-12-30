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
		return new Object[][] {{"蝙蝠侠","主演","迈克尔"},{"超人","导演","唐纳"},{"生化危机","编剧","安德森"}};	
	}
	
	@Test(dataProvider="searchKeywords")
	public void test(String searchkeyword1,String searchkeyword2,String searchResult) {
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.sogou.com");//访问搜狗
		
		driver.findElement(By.id("query")).sendKeys(searchkeyword1+" "+searchkeyword2); //输入框
		driver.findElement(By.id("stb")).click();//点击搜索按钮
		
		assertTrue(driver.getPageSource().contains(searchResult));//判断搜索页面是否包括测试数据中的期望的关键字
		driver.quit();
	}

}
