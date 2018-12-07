package com.seleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * timeout:秒
 * @author BJQT
 *
 */
public class Utilities {
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
}
