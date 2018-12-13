package parseProperties;
//½âÎöpropertiesÎÄ¼þ

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ParseProperties {
	private Properties pro= new Properties();
	String value=null;
	public ParseProperties(String propertiesPath) {
		this.loadproperities(propertiesPath);
	}
	private void loadproperities(String propertiesPath) {
		// TODO Auto-generated method stub
		try {
			InputStream in=new FileInputStream(propertiesPath);
			InputStreamReader inputStreamReader=new InputStreamReader(in);
			BufferedReader bReader=new BufferedReader(inputStreamReader);
			pro.load(bReader);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public String getValue(String keyName) {
		value=pro.getProperty(keyName).trim();
		try {
			value=new String(value.getBytes("UTF-8"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	public static void main(String[] args) {
		ParseProperties parseProperties=new ParseProperties("D:\\JavaProject\\JavaPro\\seleniumFramework\\src\\main\\java\\parseProperties\\test.properties");
		String string=parseProperties.getValue("url");
		System.out.println(string);
	}

}
