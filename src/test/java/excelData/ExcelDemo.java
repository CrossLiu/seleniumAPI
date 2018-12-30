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

//��Ҫpoi jar��
public class ExcelDemo {
	public WebDriver driver;
	String baseUrl="http://www.sogou.com";
	//ʹ��ע��DataProvider�������ݼ�������Ϊ��testData��
	@DataProvider(name="testData")
	public static Object[][] words() throws IOException{
	
		return getTestData("D:\\JavaProject\\JavaPro\\seleniumFramework\\src\\test\\java\\excelData\\","data.xlsx","Sheet1");
		
	}
	@Test(dataProvider="testData")
	public void testSearch(String searchWord1,String searchWord2,String searchResult) {
		driver.get(baseUrl);
		//ʹ��excel��ÿ�е�ǰ������Ԫ��������Ϊ������
		//�������������м�Ӹ��ո�
		driver.findElement(By.id("query")).sendKeys(searchWord1+" "+searchWord2);
		//����������ť
		driver.findElement(By.id("stb")).click();
		//ʹ����ʾ�ȴ���ȷ��ҳ���Ѿ�������ɣ�ֱ���ײ���SOGOU.COM��������ҳ����
		new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				// TODO Auto-generated method stub
				return input.findElement(By.id("s_footer")).getText().contains("SOGOU.COM");
			}
		});
		//��Excelÿ�е�ǰ������Ԫ��������Ϊ�����ʻ������£������������ҳ���Ƿ����Excel�ļ�ÿ�е�������Ԫ�����ݵĹؼ���
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
	
	
	
	//��Excel�ļ��л�ò������ݵľ�̬����,excel·����sheet����
	public static Object[][] getTestData(String filePath, String fileName, String sheetName) throws IOException {
	   //����һ��file�ļ�����
		File file=new File(filePath+"\\"+fileName);
		//����FileInputStream�������ڶ�ȡExcel�ļ�
		FileInputStream inputStream=new FileInputStream(file);
		//����һ��workbook����
		Workbook workbook=null;
		//��ȡ�ļ�����������չ�����ж���xlsx����xls
		String fileExtensionName=fileName.substring(fileName.indexOf("."));
		//�ж���xlsx����ʹ��XSSFWorkbook�������ʵ����
		//�ж�xls����ʹ��HSSFWorkbook�������ʵ����
		if (fileExtensionName.equals(".xlsx")) {
			workbook=new XSSFWorkbook(inputStream);
		}
		else if (fileExtensionName.equals(".xls")) {
			workbook=new HSSFWorkbook(inputStream);
		}
		//ͨ��sheetName����Sheet����
		Sheet Sheet=workbook.getSheet(sheetName);
		//��ȡExcel�����ļ�sheet1�����ݵ�������getLastRowNum������ȡ���ݵ����һ���к�
		//getFirstRowNum��ȡ���ݵ�һ�е��кţ����֮��õ����ݵ�����
		//ע�⣺Excel��������������0��ʼ��
		int rowCount=Sheet.getLastRowNum()-Sheet.getFirstRowNum();
		//������Ϊrecords��list���������Excel������
		List<Object[]> records=new ArrayList<Object[]>();
		for (int i = 1; i < rowCount+1; i++) {
			//ʹ��getRow��������ж���
			Row row=Sheet.getRow(i);
			//����һ�����������洢Excel�����ļ�ÿ�е��������ݣ�����Ĵ�С��getLastCellNum��������̬����
			//��ʵ�ֲ������ݸ����������Сһ��
			String fields[]=new String[row.getLastCellNum()-1];
			for (int j = 0; j < fields.length; j++) {
				//����getCell��getStringCellValue��ȡExcel�ļ��е�Ԫ������
				//��ȡ����ǰ���õ�Ԫ������
				row.getCell(j).setCellType(CellType.STRING);
				fields[j]=row.getCell(j).getStringCellValue();
			}
			//��fields���ݴ浽records��list��
		
			records.add(fields);
		}
		
		//���巵�غ�������Object[][]
		//��listת��ΪObject��ά����
		Object[][] results=new Object[records.size()][];
		//���ö�ά����ÿ�е�ֵ��ÿ�ж���һ��Object����
		for (int i = 0; i < records.size(); i++) {
			results[i]=records.get(i);
		}
		return results;
	}

}
