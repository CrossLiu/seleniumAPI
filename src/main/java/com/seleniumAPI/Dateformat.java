package com.seleniumAPI;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Test;
@Test
public class Dateformat {
	//获取当前
	public void dateformat() {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar=Calendar.getInstance();
		String string=simpleDateFormat.format(calendar.getTime());
		System.out.println(string);
	}
	
	
	
	
	

}
