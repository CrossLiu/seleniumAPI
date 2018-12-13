package pageObject;

import org.openqa.selenium.WebDriver;


public class Pages {
	
	private WebDriver driver;
	//百度首页
	private Do_ du;
	
	
	public Pages(WebDriver driver) {
		this.driver=driver;
		du=new Do_(driver);
		
	}
	
	//Pages可以用void代替。但是Page返回的是this,表示当前页面可以连续调用此页面的其他方法
	public Pages sendKey(String str) {
		du.what(By_locator.by_textBox, 5).sendKeys(str);
		return this;
	}
	
	public void clickBaiduyixia() {
		du.what(By_locator.by_submot, 5).click();
	}
	
	public void navigateBaidu(String url) {
		driver.get(url);
	}
	
	

}
