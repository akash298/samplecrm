package com.qa.util;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.TestBase;

public class TestUtil extends  TestBase{

	
	public TestUtil() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICITLY_WAIT=20;
	
	public static String datapath="C:\\Users\\DELL\\workspace\\FreeCRMTest\\src\\main\\java\\com\\qa\\testdata\\FreeCRMTestData.xlsx";
	
	
	static XSSFWorkbook xw;
	static XSSFSheet xs;
	
	public static  Object[][] gettestdata(String filepath) throws Exception
	{
		FileInputStream src = null;
		try {
			src = new FileInputStream(datapath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		xw=new XSSFWorkbook(src);
		xs=xw.getSheet(filepath);
		
		Object[][] obj=new Object[xs.getLastRowNum()][xs.getRow(0).getLastCellNum()];
		
		for(int i=0;i<xs.getLastRowNum();i++)
		{
			for(int k=0;k<xs.getRow(0).getLastCellNum();k++)
			{
				obj[i][k]=xs.getRow(i+1).getCell(k).toString();
			}
		}
		
		return obj;
	}
	
	public static void takescreenshotonexception() throws Exception
	{
		
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentdir=System.getProperty("user.dir");
		FileUtils.copyFile(src,new File(currentdir+"\\screenshot\\"+System.currentTimeMillis()+".png"));
	}

		
}	
		

