package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excel 
{
	
  public static String getPropertyValue(String key){
		
		Properties prop=new Properties();
		String s2 = System.getProperty("user.dir");
		String path=s2+"\\src\\resources\\GlobalVariable.properties";
	     try {
			prop.load(new FileInputStream(path));
		} catch (Exception e) {
			
		}
	     
	     String value=prop.getProperty(key);
		return value;			
	}
  
 
	
	public static int getRowCount(String path,String sheet)
	{
		int r=0;
		try{
			
			r=WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
		return r;
	}
	
	public static int getColumnCount(String path,String sheet,int row)
	{
		int c=0;
		try{
			
			c=WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getRow(row).getLastCellNum();
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
		return c;
	}
	public static String getCellValue(String path,String sheet,int r,int c)
	{
		String v="";
		try{
			
			v=WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
		return v;
	}
	
 public static int getColumnCount(String path,String sheet)
	{
		int c=0;
		try{
			
			c=WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getRow(0).getLastCellNum();
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
		return c;
	}
	
	public static void setCellValue(String path,String sheet,int r,int c,String Value)
	{		
		try{
			
			FileInputStream fis=new FileInputStream(path);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(sheet);
			Row row=sh.getRow(r);
			Cell cell=row.createCell(c);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			cell.setCellValue(Value);
			FileOutputStream fos=new FileOutputStream(path);
			wb.write(fos);
			fos.close();
			}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
		
	}
	 public static void deleteXmlinXmlFiles() throws IOException 
	  {
		   String rootdir = System.getProperty("user.dir");
		   String subdir=Excel.getPropertyValue("filepath");
		  String folderpath = rootdir+subdir+Excel.getPropertyValue("xmlfilepath");
			
			File file = new File(folderpath);
			// Object files contains all the files under the selected folder
			File[] files = file.listFiles();
			if (files != null) {
				FileUtils.cleanDirectory(file);
				System.out.println("Delete operation is Completed.");
			}
		}
}
