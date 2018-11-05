package rft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Workbook;

public class ExcelTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream file = new FileInputStream(new File("D:\\howtodoinjava_demo.xlsx"));
		XSSFWorkbook workbook1 = new XSSFWorkbook(file);
		XSSFSheet sheet1=workbook1.getSheet("Employee Data");
		Cell Cell = sheet1.getRow(1).getCell(1);
		 
			String CellData = Cell.getStringCellValue();

			System.out.println(CellData);
			Cell.setCellValue("Nicholas");
			FileOutputStream out = new FileOutputStream(new File("D:\\howtodoinjava_demo.xlsx"));
            workbook1.write(out);	
	}

}
