package com.seleniumAPI;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class Window_handle {
	@Test
	public void switch_handle() {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://mail.163.com");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		String hander=driver.getWindowHandle();//当前句柄，当前主窗口
		
		Actions actions=new Actions(driver);
		WebElement element=driver.findElement(By.linkText("企业邮箱"));
		actions.click(element).perform();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		Set<String> handers=driver.getWindowHandles();
		for (String string : handers) {
			if (string!=hander) {
				driver.switchTo().window(hander); //当前窗口不是主窗口hander，切换到主窗口
			}
		}
		
	}

}
