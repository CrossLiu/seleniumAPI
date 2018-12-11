package com.seleniumAPI;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class getIEDriver {
	private static WebDriver driver=null;
	private static DesiredCapabilities desiredCapabilities=null;
	private String projectPath=System.getProperty("user.dir"); //获取项目路径
	
	@BeforeClass
	public void startIE() {
		System.setProperty("webdriver.ie.driver",projectPath+"/IEDriverServer.exe");
		desiredCapabilities=DesiredCapabilities.internetExplorer();
		desiredCapabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
		desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		desiredCapabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
		desiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		driver=new InternetExplorerDriver(desiredCapabilities);
	}
	
	@Test
	public void ss() {
		driver.get("http://www.baidu.com");
		driver.manage().window().maximize();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void releaseIE() {
		driver.quit();
	}
	

}
