package com.seleniumAPI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Demo_iFrame {
	@Test
	public void iframe_test() {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://mail.163.com");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//找到iframe的元素
		WebElement iframeElement=driver.findElement(By.cssSelector("div[id=loginDiv] iframe"));
		//切换到iframe
		driver.switchTo().frame(iframeElement);
		//输入邮箱
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("xxxx");
		
		//退出iframe,切换回原主页面
		driver.switchTo().defaultContent();
	}
	

}
