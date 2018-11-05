package rft;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;






import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWorks {

	XSSFWorkbook workbook=new XSSFWorkbook();
	XSSFSheet sheet=workbook.createSheet("SampleData");
	public void WriteExcel() throws IOException
	{
		Map<String,Object[]>data=new TreeMap<String,Object[]>();
		data.put("1", new Object[]{"ID","NAME","PROJECT"});
		data.put("2", new Object[]{"a-6757","LEVIN","ICAP"});
		data.put("3", new Object[]{"a-6787","VIVEK","ICAP"});
		
		Set<String> keyset=data.keySet();
		int rownum=0;
		
		for(String key:keyset)
		{
			Row row=sheet.createRow(rownum++);
			Object[]objarray=data.get(key);
			int cellnum=0;
			for(Object ob:objarray)
			{
				
				Cell cell= row.createCell(cellnum++);
				if(ob instanceof String)
				{
					cell.setCellValue((String)ob);
				}
				else if(ob instanceof Integer)
				{
					cell.setCellValue((Integer)ob);
				}
			}
		}
		
		FileOutputStream fos=new FileOutputStream("D:abc.xlsx");
		workbook.write(fos);
		fos.close();
	}
	public void ReadExcel()
	{
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ExcelWorks ob=new ExcelWorks();
		ob.WriteExcel();
	}

}
