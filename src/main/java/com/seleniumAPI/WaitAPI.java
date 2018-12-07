package com.seleniumAPI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitAPI {
	@Test
	public void waitAPI() {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.baidu.com");
		//��ʽ�ȴ�5�룬�Ա�����ÿ������Ԫ�ض������ã����ڲ�Ԫ�أ����û�ҵ����ڵȴ�5���ٲ���һ��
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("kw")).sendKeys("WebDriver");
		
		//��ʽ�ȴ�
		WebDriverWait wait=new WebDriverWait(driver, 10);//10��û�ҵ����쳣
		WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[id='su']")));
		element.click();
		
//		wait.until(new ExpectedCondition<WebElement>() {
//			public WebElement apply(WebDriver arg0) {
//				// TODO Auto-generated method stub
//				return arg0.findElement(By.cssSelector("input[id='su']"));
//			}
//		});
		boolean flag=isElementPresent(driver, By.cssSelector("input[id='su']"), 5);
		System.out.println(flag);
		}
	
	//�ж�Ԫ���Ƿ����
	public static boolean isElementPresent(WebDriver driver,final By by,long timeout) {
		boolean flag=true;
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		try {
			wait.until(new ExpectedCondition<WebElement>() {

				public WebElement apply(WebDriver driver) {
					// TODO Auto-generated method stub
					return driver.findElement(by);
				}
			});
			flag=true;
		} catch (Exception e) {
			// TODO: handle exception
			flag=false;
		}
		
		return flag;
	}
	}


