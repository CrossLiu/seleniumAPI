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




/**
 * timeout:��
 * @author BJQT
 *
 */
public class Utilities {
	
	private static  WebDriver driver; 
	public Utilities(WebDriver driver) {
		Utilities.driver=driver;
	}
	

	//�ж�Ԫ���Ƿ����
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
		//�ж�Ԫ���Ƿ���ڣ�����һ�ַ�ʽ
		public  boolean isElementDisplayed(final By by,long timeout) {
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
		
		//�ж�Ԫ���Ƿ�ɼ����簴ť��checkbox��radiobox input��select����textarea��
		public  boolean isElementEnabled(final By by,long timeout) {
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
		
		//�ж�Ԫ���Ƿ�ѡ�У��簴ť��checkbox��radiobox input��select����textarea��
				public boolean isElementSelected(final By by,long timeout) {
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
				
				//�л�����ͨ�÷���
				public  void switchToWindow(String windowsTitle) {
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
