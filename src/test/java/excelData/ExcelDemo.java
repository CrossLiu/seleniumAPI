package excelData;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//需要poi jar包
public class ExcelDemo {
	public WebDriver driver;
	String baseUrl="http://www.sogou.com";
	//使用注释DataProvider，将数据集合命名为‘testData’
	@DataProvider(name="testData")
	public static Object[][] words() throws IOException{
	
		return getTestData("D:\\JavaProject\\JavaPro\\seleniumFramework\\src\\test\\java\\excelData\\","data.xlsx","Sheet1");
		
	}
	@Test(dataProvider="testData")
	public void testSearch(String searchWord1,String searchWord2,String searchResult) {
		driver.get(baseUrl);
		//使用excel中每行的前两个单元格内容作为搜索词
		//在两个搜索词中间加个空格
		driver.findElement(By.id("query")).sendKeys(searchWord1+" "+searchWord2);
		//单击搜索按钮
		driver.findElement(By.id("stb")).click();
		//使用显示等待，确认页面已经加载完成，直到底部“SOGOU.COM”出现在页面上
		new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				// TODO Auto-generated method stub
				return input.findElement(By.id("s_footer")).getText().contains("SOGOU.COM");
			}
		});
		//在Excel每行的前两个单元格内容作为搜索词汇的情况下，断言搜索结果页面是否包括Excel文件每行第三个单元格内容的关键字
		Assert.assertTrue(driver.getPageSource().contains(searchResult));
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver=new FirefoxDriver();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	
	
	//从Excel文集中获得测试数据的静态方法,excel路径和sheet名字
	public static Object[][] getTestData(String filePath, String fileName, String sheetName) throws IOException {
	   //声明一个file文件对象
		File file=new File(filePath+"\\"+fileName);
		//创建FileInputStream对象用于读取Excel文件
		FileInputStream inputStream=new FileInputStream(file);
		//声明一个workbook对象
		Workbook workbook=null;
		//获取文件名参数的扩展名，判断是xlsx还是xls
		String fileExtensionName=fileName.substring(fileName.indexOf("."));
		//判断是xlsx，则使用XSSFWorkbook对象进行实例化
		//判断xls，则使用HSSFWorkbook对象进行实例化
		if (fileExtensionName.equals(".xlsx")) {
			workbook=new XSSFWorkbook(inputStream);
		}
		else if (fileExtensionName.equals(".xls")) {
			workbook=new HSSFWorkbook(inputStream);
		}
		//通过sheetName生成Sheet对象
		Sheet Sheet=workbook.getSheet(sheetName);
		//获取Excel数据文件sheet1中数据的行数，getLastRowNum方法获取数据的最后一行行号
		//getFirstRowNum获取数据第一行的行号，相减之后得到数据的行数
		//注意：Excel的行数和列数从0开始的
		int rowCount=Sheet.getLastRowNum()-Sheet.getFirstRowNum();
		//创建名为records的list对象来存放Excel的数据
		List<Object[]> records=new ArrayList<Object[]>();
		for (int i = 1; i < rowCount+1; i++) {
			//使用getRow方法获得行对象
			Row row=Sheet.getRow(i);
			//声明一个数组用来存储Excel数据文件每行的三个数据，数组的大小用getLastCellNum方法来动态声明
			//，实现测试数据个数和数组大小一致
			String fields[]=new String[row.getLastCellNum()-1];
			for (int j = 0; j < fields.length; j++) {
				//调用getCell和getStringCellValue获取Excel文件中单元格数据
				//读取数据前设置单元格类型
				row.getCell(j).setCellType(CellType.STRING);
				fields[j]=row.getCell(j).getStringCellValue();
			}
			//将fields数据存到records的list中
		
			records.add(fields);
		}
		
		//定义返回函数，即Object[][]
		//将list转换为Object二维数组
		Object[][] results=new Object[records.size()][];
		//设置二维数组每行的值，每行都是一个Object对象
		for (int i = 0; i < records.size(); i++) {
			results[i]=records.get(i);
		}
		return results;
	}

}
