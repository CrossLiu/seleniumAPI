package com.seleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class ActionsDemo {
	
	private static WebDriver driver=null;
	private static DesiredCapabilities desiredCapabilities=null;
	private static String projectPath=System.getProperty("user.dir"); //获取项目路径@Test
	@Test
	public static void name() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",projectPath+"/chromedriver.exe");
		desiredCapabilities=DesiredCapabilities.chrome();
		driver=new ChromeDriver(desiredCapabilities);
		driver.get("http://www.baidu.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		WebElement element=driver.findElement(By.id("kw"));
		element.sendKeys("Selenium");
		//driver.findElement(By.id("kw")).sendKeys("Selenium");
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("input[id='su']")).click();
		Thread.sleep(5000);
		
		Actions action=new Actions(driver);
		action.click(driver.findElement(By.linkText("Web Browser Automation")));
		Thread.sleep(2000);
		driver.quit();
		
	
	
		
	} 

}
