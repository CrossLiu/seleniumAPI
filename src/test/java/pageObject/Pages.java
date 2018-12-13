package pageObject;

import org.openqa.selenium.WebDriver;


public class Pages {
	
	private WebDriver driver;
	//�ٶ���ҳ
	private Do_ du;
	
	
	public Pages(WebDriver driver) {
		this.driver=driver;
		du=new Do_(driver);
		
	}
	
	//Pages������void���档����Page���ص���this,��ʾ��ǰҳ������������ô�ҳ�����������
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
