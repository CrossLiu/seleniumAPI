package com.seleniumAPI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class API {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	@Test
	public static void openURLandQuit() throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.baidu.com");
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//ÒþÊ½µÈ´ý30Ãë£¬
		   //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("kw")).sendKeys("WebDriver");
		driver.findElement(By.cssSelector("input[id='su']")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.quit();
	}
	

}
