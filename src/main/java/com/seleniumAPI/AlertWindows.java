package com.seleniumAPI;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AlertWindows {
	@Test
	public void alertTest() throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		String url="file:///D://JavaProject//JavaPro//seleniumFramework//demo.html";
		driver.get(url);
		WebElement alertElement=driver.findElement(By.cssSelector("input[name='alterbutton']"));
		alertElement.click();
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		//alert.accept();
		//alert.dismiss();
		System.out.println(alert.getText());
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void confirmTest() throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		String url="file:///D://JavaProject//JavaPro//seleniumFramework//demo.html";
		driver.get(url);
		WebElement alertElement=driver.findElement(By.cssSelector("input[name='confirmbutton']"));
		alertElement.click();
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		//alert.accept();
		alert.dismiss();
		System.out.println(alert.getText());
		Thread.sleep(2000);
		driver.quit();
	}
}
