package com.seleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.Set;


/**
 * timeout:秒
 * @author BJQT
 *
 */
public class Utilities {
	
	 private static WebDriver driver;
		/**
		 * 
		 * @param browserName:internet explorer,firefox,chrome
		 * @return
		 */
	    public static WebDriver getDriver(String browserName) {
			if (browserName.equalsIgnoreCase(BrowserType.CHROME)) {
				driver=new ChromeDriver();
			} else if (browserName.equalsIgnoreCase(BrowserType.IE)) {
				driver=new InternetExplorerDriver();
			}else if (browserName.equalsIgnoreCase(BrowserType.FIREFOX)) {
				driver=new FirefoxDriver();
			}
			return driver;
		}
	//判断元素是否存在
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
	//判断元素是否存在, 使用公共变量driver=getDriver()
	public static boolean isElementPresent(final By by,long timeout) {
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
	//判断元素是否存在，另外一种方式
		public static boolean isElementPresence(WebDriver driver,final By by,long timeout) {
			boolean flag=true;
			WebDriverWait wait=new WebDriverWait(driver, timeout);
			try {
				flag=wait.until(new ExpectedCondition<Boolean>() {

					public Boolean apply(WebDriver driver) {
						// TODO Auto-generated method stub
						return driver.findElement(by).isDisplayed();
					}
				});
			
			} catch (Exception e) {
				// TODO: handle exception
				flag=false;
			}
			
			return flag;
		}
		
		//判断元素是否可见，如按钮，checkbox，radiobox input，select，和textarea上
		public static boolean isElementEnabled(WebDriver driver,final By by,long timeout) {
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
		
		//判断元素是否被选中，如按钮，checkbox，radiobox input，select，和textarea上
				public static boolean isElementSelected(WebDriver driver,final By by,long timeout) {
					boolean flag=true;
					WebDriverWait wait=new WebDriverWait(driver, timeout);
					try {
						flag=wait.until(new ExpectedCondition<Boolean>() {

							public Boolean apply(WebDriver driver) {
								// TODO Auto-generated method stub
								return driver.findElement(by).isSelected();
							}
						});
					
					} catch (Exception e) {
						// TODO: handle exception
						flag=false;
					}
					
					return flag;
				}
				
				//切换窗口通用方法
				public void switchToWindow(WebDriver driver,String windowsTitle) {
					java.util.Set<String> windowHanders=driver.getWindowHandles();
					for (String hander : windowHanders) {
						driver.switchTo().window(hander);
						String title=driver.getTitle();
						if (windowsTitle.endsWith(title)) {
							break;
						}
					}

				}
}
