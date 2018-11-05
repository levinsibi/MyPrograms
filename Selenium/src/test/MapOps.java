package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MapOps {
	static Object[][]dataset=null;
	static Map<Object,Object>map=null;
	static FileInputStream file;
	static XSSFWorkbook workbook1;
	static XSSFSheet sheet1;
	
	 public static void getContent() throws IOException{
		  


			file = new FileInputStream(new File("D:\\Example.xlsx"));
		    workbook1 = new XSSFWorkbook(file);
			sheet1=workbook1.getSheet("Employee Data");
			
			
			
			int lastRowNum = sheet1.getLastRowNum() ;
		    int lastCellNum = sheet1.getRow(0).getLastCellNum();
			 dataset = new Object[lastRowNum][1];
		    for (int i = 0; i < lastRowNum; i++) {
		    	Map<Object, Object> datamap = new HashMap<>();
		        for (int j = 0; j < lastCellNum; j++) {
		        	datamap.put(sheet1.getRow(0).getCell(j).toString(), sheet1.getRow(i+1).getCell(j).toString());
		        }
		        dataset[i][0]=datamap;
		    }	
		    
			
			for(int h=0;h<dataset.length;h++)
			{
				System.out.println(dataset[h][0]);
			}
	  
	  
	  }
	 public static void modify() throws IOException
	 {
		 sheet1.getRow(2).getCell(2).setCellValue("testted");
		 FileOutputStream fos=new FileOutputStream(new File("D:\\Example.xlsx"));
		 workbook1.write(fos);
		 
	 }
	/* public static void show()
	 {
		 
		 for(Object key:map.keySet())
		 {
			 System.out.println(map.get(key));
		 }
		 
	 }*/
	 

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		getContent();
		modify();
		getContent();
		
	}

}
