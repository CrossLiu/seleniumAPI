package pageObject;






import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.seleniumAPI.WaitAPI;

public class Do_ {
	private WebDriver driver;
	private WaitAPI waitfor;
	public Do_(WebDriver driver) {
		this.driver=driver;
		waitfor=new WaitAPI(driver);


	}
	
	public WebElement what(By by,long timeout) {
		WebElement element=null;
		try {
			if (waitfor.isElementEnabled(by, timeout)) {
				element=driver.findElement(by);
			}
			
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("没有找到元素");
		}
		return element;
		
	}

	public List<WebElement> whats(By[] by,long timeout) {
		List<WebElement> list=new ArrayList<>();
		try {
			for (By by2 : by) {
				if (waitfor.isElementPresent(by2, timeout)) {
					list.add(driver.findElement(by2));	
				}
				
			}	
			
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("没有找到元素集");
		}
		return list;
		
	}
	

		
	
	

}
