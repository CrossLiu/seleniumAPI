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
		String hander=driver.getWindowHandle();//��ǰ�������ǰ������
		
		Actions actions=new Actions(driver);
		WebElement element=driver.findElement(By.linkText("��ҵ����"));
		actions.click(element).perform();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		Set<String> handers=driver.getWindowHandles();
		for (String string : handers) {
			if (string!=hander) {
				driver.switchTo().window(hander); //��ǰ���ڲ���������hander���л���������
			}
		}
		
	}

}
