package com.prestashop.utilities;

import java.util.List;
import java.util.Map;

public class TestingExcelUtil {

	public static void main(String[] args) {

		ExcelUtil excelObject=new ExcelUtil("src\\test\\resources\\com\\prestashop\\test-data\\Maruf.xlsx","Sheet1");
		
		System.out.println("columns: " + excelObject.columnCount() );
		System.out.println("row: " + excelObject.rowCount());

		
		List<String> columnsNames = excelObject.getColumnsNames();
		System.out.println(columnsNames);
		
//		String[][] dataArray=excelObject.getDataArray();
//		
//		for (String[] row : dataArray) {
//			
//			for (String value : row) {
//				System.out.print(value + "\t");
//			}
//			System.out.println();
//		}
		
		
		List<Map<String, String>> dataList = excelObject.getDataList();
		
		//System.out.println(dataList);
		
		for (Map<String, String> row : dataList) {
			System.out.println(row.get("Product"));
		}
		
		//name of the product in the 3rd row
		
//		System.out.println("Name of the product in the 3rd row");
//		System.out.println(dataList.get(3).get("Product"));
//		
//		System.out.println(excelObject.getCellData(0,0));
		
		
	}

}
