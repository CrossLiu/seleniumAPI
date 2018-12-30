package csvData;

import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class CSVdemo {
	public WebDriver driver;
	String baseURL="http://www.sogou.com";
	
	@DataProvider(name="testData")
	public static Object[][] words() throws IOException {
		return getTestData("D:\\JavaProject\\JavaPro\\seleniumFramework\\src\\test\\java\\csvData\\test.csv");
		
	}

	//��ȡcsv�ļ��ľ�̬������ʹ��csv�ļ��ľ����ļ�·����Ϊ��������
	public static Object[][] getTestData(String filePath) throws IOException, FileNotFoundException {

		//�趨utf-8�ַ�����ʹ�ô����������ַ�������BufferedReader��ȡ�ļ�����
		BufferedReader file=new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));
		//���Զ�ȡcsv�ļ��ı����У�Ҳ���ǵ�һ��
		file.readLine();
		
	
		List<Object[]> records=new ArrayList<Object[]>();
		String record;	
		/**
		 * ������ȡ�ļ��г���һ��������������е�������
		 * ���洢����Ϊrecords��ArrayList��
		 * ÿһ��records�д洢�Ķ���Ϊһ��String����
		 */	
		while ((record=file.readLine())!=null) {
			String fileds[]=record.split(",");
			records.add(fileds);
		}
		//�ر��ļ�����
		file.close();
		
		//���庯������ֵ����Object[][]
		//���洢��������listת��Ϊһ��Object����
		Object[][] results=new Object[records.size()][];
		//���ö�ά����ÿ�е�ֵ��ÿ�ж���һ��object����
		for (int i = 0; i < records.size(); i++) {
			results[i]=records.get(i);
		}
		return results;
	}
	
	@Test(dataProvider="testData")
	public void testSearch(String key1,String key2,String result) {
		driver.get(baseURL+"/");
		//ʹ��csv��ÿ��ǰ2����Ԫ��������Ϊ������
		driver.findElement(By.id("query")).sendKeys(key1+" "+key2);
		driver.findElement(By.id("stb")).click();//����������ť
		
		//��ʾ�ȴ���ȷ��ҳ���Ѽ�����ϣ�ֱ���ײ���SOGOU.COM��������ҳ����
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				// TODO Auto-generated method stub
				return input.findElement(By.id("s_footer")).getText().contains("SOGOU.COM");
			}
		});
		
		//CSV�ļ�ÿ��ǰ��������Ϊ�����ʵ�����£������������ҳ���Ƿ����csvÿ�����һ����
		assertTrue(driver.getPageSource().contains(result));
	}
	
	@BeforeMethod
	public void beforeM() {
		driver=new FirefoxDriver();

	}
	@AfterMethod
	public void afterM() {
		driver.quit();
	}

}
