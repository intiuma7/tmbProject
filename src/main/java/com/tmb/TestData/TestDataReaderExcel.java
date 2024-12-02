package com.tmb.TestData;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tmb.constants.FrameworkConstants;

public class TestDataReaderExcel {
	//This class is for practice..not gonna used in framework.
	//here we are taking object array as return type.

	public static Object[] TestData() throws Exception
	{
		FileInputStream file=new FileInputStream(FrameworkConstants.getTestdataexcelpath());
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet sheet=wb.getSheet("TESTDATA");
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
