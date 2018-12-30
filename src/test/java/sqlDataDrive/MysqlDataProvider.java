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
	//使用注释DataProvider，将数据集合命名为‘testData’
	@DataProvider(name="testData")
	public static Object[][] words() throws IOException{
	
		return getTestData("testdata");
		
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
	
	public static Object[][] getTestData(String tableName) {
		//声明MySQL数据驱动,添加jdbc驱动jar包
		String driver="com.mysql.cj.jdbc.Driver";
		//数据库地址
		String url="jdbc:mysql://127.0.0.1:3306/sqldemo?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8";
		//数据库名和密码
		String user="root";
		String password="Test1234";
		//声明用来存储数据库数据的list对象
		List<Object[]> records=new ArrayList<>();
		try {
			//设定驱动
			Class.forName(driver);
			//声明连接数据库对象
			Connection connection=DriverManager.getConnection(url, user, password);
			if (!connection.isClosed()) {
				System.out.println("数据库连接成功");
			}
			//创建Statement对象
			Statement statement=connection.createStatement();
			//使用函数拼接要执行的sql语句，此语句用来获得所有数据行
			String sql="select * from "+tableName;
			//声明ResultSet对象，存取执行sql后返回的数据结果集
			ResultSet rs=statement.executeQuery(sql);
			//声明一个ResultSetMetadata对象
			ResultSetMetaData rsMetaData=rs.getMetaData();
			//调用ResultSetMetadata对象的getColumnCount获取列数
			int cols=rsMetaData.getColumnCount();
			//使用next方法遍历数据结果集中所有数据行
			while (rs.next()) {
			//声明一个字符型数据，数据大小使用数据行的列的个数
				String fields[]=new String[cols];
				int col=0;
				//遍历所有数据行中的所有列数据，并存在字符数组中
				for (int i = 0; i < cols; i++) {
					fields[col]=rs.getString(i+1);
					col++;
				}
				//将每一行的数据存储到字符数据后，存储到records中
				records.add(fields);
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			rs.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			System.out.println("未能找到mysql驱动类");
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
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
