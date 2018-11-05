package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {


	private String xpathXLSPath;

	
	public String getCellValue(String excelName,String sheetName, int rowIndex, int colIndex) {
		InputStream inp = null;
		XSSFWorkbook wb = null;
		try {
			String s2 = System.getProperty("user.dir");
	
			String path = s2 +"\\excels\\"+ excelName+".xlsx";
			inp = new FileInputStream(path);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	

		try {
			wb = new XSSFWorkbook(inp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(colIndex);
		
	

		return cell.getStringCellValue();
		
	
	}
	
	public boolean setCellValue(String excelName,String sheetName,String rowValue, String columnValue,String cellValue)
	{
		
		try
		{
		InputStream inp = null;
		XSSFWorkbook wb = null;
		String path="";
		FileOutputStream fileOutputStream = null;
		try {
			String s2 = System.getProperty("user.dir");
	
			 path = s2 +"\\excels\\"+ excelName+".xlsx";
			inp = new FileInputStream(path);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	

		try {
			wb = new XSSFWorkbook(inp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet(sheetName);
		
		
		
		Iterator<Row> rows = sheet.rowIterator();
        int columnIndex = -1;
        int rowIndex = -1;
        while (rows.hasNext()) {
              Row row = rows.next();
              row.getRowNum();
              
              for (Cell cell : row) {
            	 System.out.println("cell"+cell);
                     if (String.valueOf(getCellValue(cell)).equals(columnValue)) {
                    	  
                            columnIndex = cell.getColumnIndex();
                         
                            break;
                     }
              }
              if (columnIndex != -1)
                     break;
        }

        rows = sheet.rowIterator();
        while (rows.hasNext()) {
              Row row = rows.next();
              for (Cell cell : row) {
            	  System.out.println("cell"+cell);
                     if (String.valueOf(getCellValue(cell)).equals(rowValue)) {
                            rowIndex = row.getRowNum();
                          
                            break;
                     }
              }
              if (rowIndex != -1)
                     break;
        }

        Row row = sheet.getRow(rowIndex);
        Cell cell = row.getCell(columnIndex, Row.CREATE_NULL_AS_BLANK);
        
        
        cell.setCellValue(cellValue);
        
     
       
        fileOutputStream = new FileOutputStream(path);
        wb.write(fileOutputStream);
        return true;
        
		}
		
		catch(Exception e)
		{
			return false;
		}
		
		
		
		
		
	}
	
	public void setCellValue(String excelName,String sheetName,int rowNum,int columnNum, String columnValue)
	{
		
		InputStream inp = null;
		XSSFWorkbook wb = null;
      

      
        
        Row row =null;

		try{
			String s2 = System.getProperty("user.dir");
	
			String path = s2 +"\\excels\\"+ excelName+".xlsx";
			inp = new FileInputStream(path);
		
			wb = new XSSFWorkbook(inp);
		
		Sheet sheet = wb.getSheet(sheetName);
		 
		
		 System.out.println("path"+path);
		 System.out.println("sheetName"+sheetName);
        System.out.println("rooow"+rowNum);
        System.out.println("columnNum"+columnNum);
        System.out.println("columnValue"+columnValue);

        row = sheet.getRow(rowNum);

        Cell cell=row.getCell(columnNum, Row.CREATE_NULL_AS_BLANK);
     
        cell.setCellValue(columnValue);
      
      
        FileOutputStream out = new FileOutputStream(new File(path));
        wb.write(out);
		
		}
		catch(Exception ex)
		{
			
		}
		
		
		
		
			
		
	}
	public void setCellValue(String excelName,String sheetName,int rowNum,String columnName, String columnValue)
	{
		
		
		
		InputStream inp = null;
		XSSFWorkbook wb = null;
      

      
        
        Row row =null;

		try{
			String s2 = System.getProperty("user.dir");
	
			String path = s2 +"\\excels\\"+ excelName+".xlsx";
			inp = new FileInputStream(path);
		
			wb = new XSSFWorkbook(inp);
		
		Sheet sheet = wb.getSheet(sheetName);
		 
		
		Row r=sheet.getRow(0);
		int cellindex=0;
		int limit=r.getPhysicalNumberOfCells();
		for(int i=0;i<limit;i++)
		{
			Cell cell=r.getCell(i);
			if(cell.toString().equals(columnName))
			{
				
				cellindex=i;
				break;
			}
		}

        

        /*row = sheet.getRow(rowNum);

        Cell cell=row.getCell(cellindex);
     
        cell.setCellValue(columnValue);*/
		
		sheet.getRow(rowNum).getCell(cellindex).setCellValue(columnValue);
      
		
        FileOutputStream out = new FileOutputStream(new File(path));
        wb.write(out);
		
		}
		catch(Exception ex)
		{
			
		}
		
		
		
		
		
		
	}
	
	public String getCellValue(String excelName,String sheetName,int rowNum, String columnValue)
	{
		
		String value="";
		
		InputStream inp = null;
		XSSFWorkbook wb = null;
      

        int rowIndex = rowNum;
        int columnIndex = -1;
        Row row =null;

		try {
			String s2 = System.getProperty("user.dir");
	
			String path = s2 +"\\excels\\"+ excelName+".xlsx";
			inp = new FileInputStream(path);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	

		try {
			wb = new XSSFWorkbook(inp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet(sheetName);
		  Iterator<Row> rows = sheet.rowIterator();
          while (rows.hasNext()) {
              row = rows.next();


              for (Cell cell : row) {

                     if (String.valueOf(getCellValue(cell)).equals(columnValue)) {

                            columnIndex = cell.getColumnIndex();

                            break;
                     }
              }
              if (columnIndex != -1)
                     break;
        }

        

        row = sheet.getRow(rowIndex);

        Cell cell = row.getCell(columnIndex, Row.CREATE_NULL_AS_BLANK);
        value=cell.toString();
		
		
		
		return value;
		
		
		
		
		
		
		
	}
	public String getCellValue(String excelName,String sheetName,String rowValue, String columnValue)
	{
		String value="";
		
		InputStream inp = null;
		XSSFWorkbook wb = null;
      

        int rowIndex = -1;
        int columnIndex = -1;
        Row row =null;

		try {
			String s2 = System.getProperty("user.dir");
	
			String path = s2 +"\\excels\\"+ excelName+".xlsx";
			inp = new FileInputStream(path);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	

		try {
			wb = new XSSFWorkbook(inp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet(sheetName);
		  Iterator<Row> rows = sheet.rowIterator();
          while (rows.hasNext()) {
              row = rows.next();


              for (Cell cell : row) {

                     if (String.valueOf(getCellValue(cell)).equals(columnValue)) {

                            columnIndex = cell.getColumnIndex();

                            break;
                     }
              }
              if (columnIndex != -1)
                     break;
        }

        rows = sheet.rowIterator();

          while (rows.hasNext()) {
              row = rows.next();
              for (Cell cell : row) {

                     if (String.valueOf(getCellValue(cell)).equals(rowValue)) {
                            rowIndex = row.getRowNum();

                            break;
                     }
              }
              if (rowIndex != -1)
                     break;
        }

        row = sheet.getRow(rowIndex);

        Cell cell = row.getCell(columnIndex, Row.CREATE_NULL_AS_BLANK);
        value=cell.toString();
		return value;
	}
	public int getRowIndex(String excelName,String sheetName,String rowValue)
	{
		
		InputStream inp = null;
		XSSFWorkbook wb = null;
      

        int rowIndex = -1;
        int columnIndex = -1;
        Row row =null;

		try {
			String s2 = System.getProperty("user.dir");
			System.out.println("The path is"+s2);
			String path = s2 +"\\excels\\"+ excelName+".xlsx";
			
			
			inp = new FileInputStream(path);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	

		try {
			wb = new XSSFWorkbook(inp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet(sheetName);
		  Iterator<Row> rows = sheet.rowIterator();
        /*  while (rows.hasNext()) {
              row = rows.next();


              for (Cell cell : row) {

                     if (String.valueOf(getCellValue(cell)).equals(columnValue)) {

                            columnIndex = cell.getColumnIndex();

                            break;
                     }
              }
              if (columnIndex != -1)
                     break;
        }

        rows = sheet.rowIterator();*/

          while (rows.hasNext()) {
              row = rows.next();
              for (Cell cell : row) {

                     if (String.valueOf(getCellValue(cell)).contains(rowValue)) {
                            rowIndex = row.getRowNum();

                            break;
                     }
              }
              if (rowIndex != -1)
                     break;
        }

       
		return rowIndex;
	}
	public static Object getCellValue(Cell cell){
	     XSSFCell hssfCell = (XSSFCell) cell;
	     if (XSSFCell.CELL_TYPE_NUMERIC == hssfCell.getCellType()) {
	            return hssfCell.getNumericCellValue();}
	            else if (XSSFCell.CELL_TYPE_NUMERIC == hssfCell.getCellType()) {
	            DecimalFormat df = new DecimalFormat("#.000000000");
	            String numeric = df.format(cell.getNumericCellValue());
	            numeric = numeric + "";
	            String[] strArray = (numeric.replace(".", "-")).split("-");
	            if(strArray.length > 1 ){
	                  if((strArray[1].replace("0", "")).trim().length() == 0 ){
	                         numeric =  strArray[0];
	                  }                          
	            }
	            return numeric;

	     } else if (XSSFCell.CELL_TYPE_STRING == hssfCell.getCellType()) {
	            return hssfCell.getStringCellValue();
	     } else if (XSSFCell.CELL_TYPE_NUMERIC == hssfCell.getCellType()) {
	            return hssfCell.getNumericCellValue();
	     }else if (XSSFCell.CELL_TYPE_BOOLEAN == hssfCell.getCellType()) {
	            return hssfCell.getBooleanCellValue();
	     } else if (XSSFCell.CELL_TYPE_BLANK == hssfCell.getCellType()) {
	            return "";
	     } 
	     return "";
	}


public int getRowCount(String excelName,String sheetName)
{
	int rowCount=0;
	
	InputStream inp = null;
	XSSFWorkbook wb = null;
	try {
		String s2 = System.getProperty("user.dir");

		String path = s2 +"\\excels\\"+ excelName+".xlsx";
		inp = new FileInputStream(path);
	} catch (FileNotFoundException e) {

		e.printStackTrace();
	}


	try {
		wb = new XSSFWorkbook(inp);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Sheet sheet = wb.getSheet(sheetName);
	 rowCount = sheet.getLastRowNum();
	//rowCount = sheet.getPhysicalNumberOfRows();
	return rowCount;
}


    public String getCellValue(String sheetName, String key) {
        Cell retCell = null;
        InputStream inp = null;
        XSSFWorkbook wb = null;

        try {
               String s2 = System.getProperty("user.dir");
               String path = s2 + xpathXLSPath;
               inp = new FileInputStream(path);
               wb = new XSSFWorkbook(inp);
        } catch (FileNotFoundException e) {
               System.out.println("File not found");
               e.printStackTrace();
        } catch (IOException e) {
               System.out.println("An error occured while accessing the file");
               e.printStackTrace();
        }

        Sheet sheet = wb.getSheet(sheetName);
        for (Row row : sheet) {
               for (Cell cell : row) {
                     cell.setCellType(Cell.CELL_TYPE_STRING);
                     if (cell.getStringCellValue().equalsIgnoreCase(key)) {
                            int currentRow = cell.getRowIndex();
                            int curentCol = cell.getColumnIndex();
                            retCell = sheet.getRow(currentRow).getCell(curentCol + 1);
                            // break from the loop
                            break;
                     }
               }
               // Break if received the cell value
               if (retCell != null) {
                     break;
               }
        }
        return retCell.getStringCellValue();
 }

	
}
