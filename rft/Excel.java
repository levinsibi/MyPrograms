package rft;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	
	XSSFWorkbook workbook=new XSSFWorkbook();
	XSSFSheet sheet=workbook.createSheet("SampleData");
	public void writeExcel() throws IOException
	{
		
		Map<String,Object[]>data=new TreeMap<String,Object[]>();
		data.put("1", new Object[]{"ID","NAME","LASTNAME"});
		data.put("2", new Object[]{"1","LEVIN","SIBI"});
		data.put("3", new Object[]{"2","MAHESH","SOBI"});
		
		Set<String>keyset=data.keySet();
		int rownum=0;
		for(String key:keyset)
		{
			Row row=sheet.createRow(rownum++);
			
			Object[]objarray=data.get(key);
			int cellnum=0;
			for(Object ob:objarray)
			{
				Cell cell=row.createCell(cellnum++);
				if(ob instanceof String)
				{
					cell.setCellValue((String)ob);
				}
				if(ob instanceof Integer)
				{
					cell.setCellValue((Integer)ob);
				}
			}
		}
		FileOutputStream fis=new FileOutputStream("D:\\Levin\\demo2.xlsx");
		workbook.write(fis);
		fis.close();
		
	}
	public  void Readexcel()
	{
		Iterator<Row>rowiterator=sheet.rowIterator();
		while(rowiterator.hasNext())
		{
			Row row=rowiterator.next();
			Iterator<Cell>celliterator=row.cellIterator();
			while(celliterator.hasNext())
			{
				Cell cell=celliterator.next();
				switch(cell.getCellType())
				{
				case Cell.CELL_TYPE_STRING:System.out.print(cell.getStringCellValue()+"\t\t");break;
				
				case Cell.CELL_TYPE_NUMERIC:System.out.print(cell.getNumericCellValue()+"\t\t");break;
				}
				
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		Excel 	ob=new Excel();
		ob.writeExcel();
		ob.Readexcel();
	}

}
