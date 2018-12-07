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
		//�ҵ�iframe��Ԫ��
		WebElement iframeElement=driver.findElement(By.cssSelector("div[id=loginDiv] iframe"));
		//�л���iframe
		driver.switchTo().frame(iframeElement);
		//��������
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("xxxx");
		
		//�˳�iframe,�л���ԭ��ҳ��
		driver.switchTo().defaultContent();
	}
	

}
