package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pages {
	
	private WebDriver driver;
	//百度首页
	//百度输入框
	@FindBy(id="kw")private WebElement textBoxElememt;
	//搜索按钮
	@FindBy(how=How.ID,id="su")private WebElement submit;
	
	
	public Pages(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void sendKey(String str) {
		textBoxElememt.sendKeys(str);
	}
	
	public void clickBaiduyixia() {
		submit.click();
	}
	
	public void navigateBaidu(String url) {
		driver.get(url);
	}
	
	

}
