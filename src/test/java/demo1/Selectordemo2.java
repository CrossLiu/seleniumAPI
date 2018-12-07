package demo1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Selectordemo2 {
	@Test
	public static void name2() {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.baidu.com");
		driver.manage().window().maximize();
		Actions actions=new Actions(driver);
		WebElement element=driver.findElement(By.linkText("…Ë÷√"));
		actions.click(element).click().perform();
		WebElement webElement=driver.findElement(By.linkText("∏ﬂº∂À—À˜"));
		actions.click(webElement).perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement eleSelect=driver.findElement(By.cssSelector("select[name='ft']"));
		Select select=new Select(eleSelect);
		//select.selectByIndex(2);
		List<WebElement> list=select.getAllSelectedOptions();
		String string=null;
		for (WebElement webElement2 : list) {
		string=	webElement2.getText();
		System.out.println(string);
		}
		

	}
	}
