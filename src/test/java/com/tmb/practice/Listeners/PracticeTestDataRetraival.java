package com.tmb.practice.Listeners;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.*;


import org.testng.annotations.*;

import com.tmb.constants.FrameworkConstants;

public class PracticeTestDataRetraival {

	
	
	
	@Test(dataProvider = "testdata1")
	public void Test1(Object[] data)
	{
		List<String> tests=new ArrayList<>();
		Map<String,Object> map;
		for(int i=0;i<data.length;i++)
		{
			
			map=(Map<String, Object>) data[i];
			String str=(String) map.get("execute");
			if(str.equals("yes"))
			{
			tests.add((String) map.get("testname"));
			}
		}
	
		for(String str:tests) {
		System.out.println(str);
		}
		//System.out.println("Test data is -----------"+data.toString());
		
	}
	
	@DataProvider(name = "testdata1")
	public Object[] TestData() throws Exception
	{
		FileInputStream file=new FileInputStream(FrameworkConstants.getTestdataexcelpath());
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		int row=sheet.getLastRowNum();
		int col=sheet.getRow(0).getLastCellNum();
		
		Object[] data=new Object[row];
		
		Map<String,Object> map;
		
		for(int i=1;i<=row;i++)
		{
			map=new HashMap<>();
			for(int j=0;j<col;j++)
			{
				 
				String key= sheet.getRow(0).getCell(j).getStringCellValue();
				String value=sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
				
				data[i-1]=map;
				
				
			}
		}
		
		
		
		return data;
	}
	
	
	
	
	
	
}
