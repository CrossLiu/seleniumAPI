package com.seleniumAPI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import com.seleniumAPI.GetWebDriver.browserTypeName;

public class GetWebDriver {
	private static WebDriver driver;
	public GetWebDriver(WebDriver driver) {
		GetWebDriver.driver=driver;
	}
	/**
	 * @browserName Internet explorer, Chrome, Firefox
	 */
	public static  WebDriver getWebDriver(String browserName) {
			if (browserName.equalsIgnoreCase(BrowserType.CHROME)) {
				driver=new ChromeDriver();
			} else if (browserName.equalsIgnoreCase(BrowserType.IE)) {
				driver=new InternetExplorerDriver();
			}else if (browserName.equalsIgnoreCase(BrowserType.FIREFOX)) {
				driver=new FirefoxDriver();
			}
			return driver;
		}

	/**
	 * ‚÷…¢browserTypeName.xxx(xxx´ú±ížgÓ[Æ÷)
	 * @author BJQT
	 *
	 */
	   public enum browserTypeName {IE,Firefox,Chrome}
	   public static WebDriver getWebDriver(browserTypeName type) {
			switch (type) {
			case IE:
				driver=new InternetExplorerDriver();
				break;
			case Firefox:
				driver=new FirefoxDriver();
				break;
			case Chrome:
				driver=new ChromeDriver();
				break;
			default:
			}
			return driver;
		}

}
