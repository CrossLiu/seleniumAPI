package demo1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Demo2 {
	@Test
	public static void name2() {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.baidu.com");
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		driver.quit();
		}
		
	}
