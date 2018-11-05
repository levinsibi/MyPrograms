package rft;





import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperationAll {

	/**
	 * @param args
	 * @throws IOException 
	 * 
	 */
	public static int getRowIndex(String tcname) throws IOException
	{
		FileInputStream fis=new FileInputStream(new File("D:\\Datasheet.xlsx"));
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		Iterator<Row>rowiterator=sheet.rowIterator();
		int rownum=-1;
		while(rowiterator.hasNext())
		{
			rownum=rownum+1;
			String s=rowiterator.next().getCell(0).getStringCellValue();
			if(s.equalsIgnoreCase(tcname))
			{
				break;
			}
		}
		return rownum;
		
	}
	public static void getcell(int rowNum,String Cellname) throws IOException
	{
		FileInputStream fis=new FileInputStream(new File("D:\\Datasheet.xlsx"));
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		
		Row row=sheet.getRow(0);
		Iterator<Cell>celliterator=row.cellIterator();
		int colIndex=-1;
		while(celliterator.hasNext())
		{
			colIndex=colIndex+1;
			Cell cell=celliterator.next();
			if(cell.getStringCellValue().equalsIgnoreCase(Cellname))
			{
				 break;
			}
		}
		System.out.println("the cellindex is "+(colIndex+1));
		
		Cell cell=sheet.getRow(rowNum).getCell(colIndex);
		System.out.println("cell value for column "+Cellname+" "+cell.toString());
		
	}
	public static void setcell(int rowNum,String Cellname,String Value) throws IOException
	{
		FileInputStream fis=new FileInputStream(new File("D:\\Datasheet.xlsx"));
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		
		Row row=sheet.getRow(0);
		Iterator<Cell>celliterator=row.cellIterator();
		int colIndex=-1;
		while(celliterator.hasNext())
		{
			colIndex=colIndex+1;
			Cell cell=celliterator.next();
			if(cell.getStringCellValue().equalsIgnoreCase(Cellname))
			{
				 break;
			}
		}
		System.out.println("the cellindex is "+(colIndex+1));
		
		sheet.getRow(rowNum).getCell(colIndex).setCellValue(Value);
		FileOutputStream fos=new FileOutputStream(new File("D:\\Datasheet.xlsx"));
		wb.write(fos);
		System.out.println("After value stored  "+sheet.getRow(rowNum).getCell(colIndex).toString());
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//ExcelOperationsAll ob=new ExcelOperationsAll();
		String TCName="test2";
		int r=getRowIndex(TCName);
		System.out.println("Row Num is "+(r+1));
		getcell(r, "Destination");
		setcell(r, "Destination","DEL");
	}

}

