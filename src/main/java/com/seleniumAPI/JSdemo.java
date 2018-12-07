package com.seleniumAPI;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class JSdemo {
	@Test
	public void testJS() throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.baidu.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("kw")).sendKeys("SEN");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id='su']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor) driver; 
		js.executeScript("scrollTo(0,10000)");//×îµ×²¿

	}
	

}
