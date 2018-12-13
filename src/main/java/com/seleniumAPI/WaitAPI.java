package com.seleniumAPI;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitAPI {
//	@Test
	//public void waitAPI() {
//		WebDriver driver=new FirefoxDriver();
//		driver.get("http://www.baidu.com");
//		//隐式等待5秒，对本类中每个查找元素都起作用；先在查元素，如果没找到，在等待5秒再查找一遍
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.findElement(By.id("kw")).sendKeys("WebDriver");
		

		//显式等待
//		WebDriverWait wait=new WebDriverWait(driver, 10);//10秒没找到抛异常
//		WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[id='su']")));
//		element.click();
		
//		wait.until(new ExpectedCondition<WebElement>() {
//			public WebElement apply(WebDriver arg0) {
//				// TODO Auto-generated method stub
//				return arg0.findElement(By.cssSelector("input[id='su']"));
//			}
//		});
//		boolean flag=isElementPresent(driver, By.cssSelector("input[id='su']"), 5);
//		System.out.println(flag);
//		}
	
	private WebDriver driver;
	
	public WaitAPI(WebDriver driver) {
		this.driver=driver;
	}
	//判断元素是否存在
	public boolean isElementPresent(final By by,long timeout) {
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
	
	//判断元素是否可见，如按钮，checkbox，radiobox input，select，和textarea上
			public boolean isElementEnabled(final By by,long timeout) {
				boolean flag=true;
				WebDriverWait wait=new WebDriverWait(driver, timeout);
				try {
					flag=wait.until(new ExpectedCondition<Boolean>() {

						public Boolean apply(WebDriver driver) {
							// TODO Auto-generated method stub
							return driver.findElement(by).isEnabled();
						}
					});
				
				} catch (Exception e) {
					// TODO: handle exception
					flag=false;
				}
				
				return flag;
			}
	}


