package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tmb.constants.FrameworkConstants;
import com.tmb.exceptions.ExcelPathNotFoundException;
import com.tmb.exceptions.FrameworkExceptions;
//Below method is reading the given sheet name excel and providing data in the form of list of data maps.
//This class is used in Imethodintercepter to append values to test when execute is yes on testexcel.
public class ExcelUtils {
	
	private ExcelUtils()
	{}
	
	public static List<Map<String, String>> getTestDetails(String sheetname)
	{
		List<Map<String,String>> listofMaps = null;
		
	//if we keep the code which is causing exception like file not found exception when we are 
    //closing the file , we don't have to handle that exception if we keep the code in try
	// the file will be closed automatically once the work is done.
		try(FileInputStream  file =new FileInputStream(FrameworkConstants.getTestdataexcelpath());
				XSSFWorkbook wb=new XSSFWorkbook(file);) {
			 
			 
			XSSFSheet sheet=wb.getSheet(sheetname);
			
			int rows=sheet.getLastRowNum();
			int cols=sheet.getRow(0).getLastCellNum();
			
			Map<String,String> map;
			listofMaps = new ArrayList<>();
			for(int i=1;i<=rows;i++)
			{
				map=new HashMap<>();
				for(int j=0;j<cols;j++)
				{
					String key=sheet.getRow(0).getCell(j).getStringCellValue();
					String value=sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
		         	listofMaps.add(map); 
			}
			
		} catch (FileNotFoundException e) {
			throw new ExcelPathNotFoundException("excel file you are trying to read is having problem",e);
		} catch (IOException e) {
			
			throw new FrameworkExceptions("Some i/o exception happended while reading the excel file");
		} 
		
		
		return listofMaps;
		
	}
	

}
