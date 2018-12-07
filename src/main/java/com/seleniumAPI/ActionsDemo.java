package com.seleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsDemo {
	@Test
	public static void name() throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.baidu.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("kw")).sendKeys("Selenium");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id='su']")).click();
		Thread.sleep(2000);
		WebElement element=driver.findElement(By.partialLinkText("Web Browser Automation"));
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	} 

}
