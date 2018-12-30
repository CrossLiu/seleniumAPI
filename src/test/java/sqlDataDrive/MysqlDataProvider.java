package sqlDataDrive;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

public class MysqlDataProvider {
	public WebDriver driver;
	String baseUrl="http://www.sogou.com";
	//ʹ��ע��DataProvider�������ݼ�������Ϊ��testData��
	@DataProvider(name="testData")
	public static Object[][] words() throws IOException{
	
		return getTestData("testdata");
		
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
	
	public static Object[][] getTestData(String tableName) {
		//����MySQL��������,���jdbc����jar��
		String driver="com.mysql.cj.jdbc.Driver";
		//���ݿ��ַ
		String url="jdbc:mysql://127.0.0.1:3306/sqldemo?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8";
		//���ݿ���������
		String user="root";
		String password="Test1234";
		//���������洢���ݿ����ݵ�list����
		List<Object[]> records=new ArrayList<>();
		try {
			//�趨����
			Class.forName(driver);
			//�����������ݿ����
			Connection connection=DriverManager.getConnection(url, user, password);
			if (!connection.isClosed()) {
				System.out.println("���ݿ����ӳɹ�");
			}
			//����Statement����
			Statement statement=connection.createStatement();
			//ʹ�ú���ƴ��Ҫִ�е�sql��䣬����������������������
			String sql="select * from "+tableName;
			//����ResultSet���󣬴�ȡִ��sql�󷵻ص����ݽ����
			ResultSet rs=statement.executeQuery(sql);
			//����һ��ResultSetMetadata����
			ResultSetMetaData rsMetaData=rs.getMetaData();
			//����ResultSetMetadata�����getColumnCount��ȡ����
			int cols=rsMetaData.getColumnCount();
			//ʹ��next�����������ݽ����������������
			while (rs.next()) {
			//����һ���ַ������ݣ����ݴ�Сʹ�������е��еĸ���
				String fields[]=new String[cols];
				int col=0;
				//���������������е����������ݣ��������ַ�������
				for (int i = 0; i < cols; i++) {
					fields[col]=rs.getString(i+1);
					col++;
				}
				//��ÿһ�е����ݴ洢���ַ����ݺ󣬴洢��records��
				records.add(fields);
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			rs.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			System.out.println("δ���ҵ�mysql������");
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
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
