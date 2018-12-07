package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyTest1 {

	public static void test(String[] args) {
		// TODO Auto-generated method stub
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://wwww.baidu.com");
		driver.findElement(By.id("kw")).sendKeys("WebDriver");;
		driver.findElementByCssSelector("input[id='su']").click();
		driver.quit();

	}

}
