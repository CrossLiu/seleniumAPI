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

	//读取csv文件的静态方法，使用csv文件的绝对文件路径作为函数参数
	public static Object[][] getTestData(String filePath) throws IOException, FileNotFoundException {

		//设定utf-8字符集，使用带缓冲区的字符输入流BufferedReader读取文件内容
		BufferedReader file=new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));
		//忽略读取csv文件的标题行，也就是第一行
		file.readLine();
		
	
		List<Object[]> records=new ArrayList<Object[]>();
		String record;	
		/**
		 * 遍历读取文件中除第一行外的其他所有行的行内容
		 * 并存储在名为records的ArrayList中
		 * 每一个records中存储的对象为一个String数组
		 */	
		while ((record=file.readLine())!=null) {
			String fileds[]=record.split(",");
			records.add(fileds);
		}
		//关闭文件对象
		file.close();
		
		//定义函数返回值，即Object[][]
		//将存储测试数据list转换为一个Object数组
		Object[][] results=new Object[records.size()][];
		//设置二维数组每行的值，每行都是一个object对象
		for (int i = 0; i < records.size(); i++) {
			results[i]=records.get(i);
		}
		return results;
	}
	
	@Test(dataProvider="testData")
	public void testSearch(String key1,String key2,String result) {
		driver.get(baseURL+"/");
		//使用csv中每行前2个单元格内容作为搜索词
		driver.findElement(By.id("query")).sendKeys(key1+" "+key2);
		driver.findElement(By.id("stb")).click();//单击搜索按钮
		
		//显示等待，确认页面已加载完毕，直到底部“SOGOU.COM”出现在页面上
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				// TODO Auto-generated method stub
				return input.findElement(By.id("s_footer")).getText().contains("SOGOU.COM");
			}
		});
		
		//CSV文件每行前两个词作为搜索词的情况下，断言搜索结果页面是否包括csv每行最后一个词
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
