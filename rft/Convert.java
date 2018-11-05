package rft;
import java.io.*;
import java.util.Iterator;
import java.text.DateFormat;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.math.BigDecimal;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.DateUtil;
public class Convert {
	private static final String OUTPUT_DATE_FORMAT= "yyyy-MM-dd";
    /**
     * Comma separated characters
     */
    private static final String CVS_SEPERATOR_CHAR=",";
    /**
     * New line character for CSV file
     */
    private static final String NEW_LINE_CHARACTER="\r\n";
	public static void excelToCSV(String excelFileName,String csvFileName) throws IOException {
        checkValidFile(csvFileName);
        HSSFWorkbook myWorkBook = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(excelFileName)));
        HSSFSheet mySheet = myWorkBook.getSheetAt(0);
        Iterator  rowIter =  mySheet.rowIterator();
        String csvData="";
        while (rowIter.hasNext()) {
                HSSFRow myRow = (HSSFRow) rowIter.next();
                for ( int i=0;i<myRow.getLastCellNum();i++){
                      csvData += getCellData(myRow.getCell(i));
                }
                csvData+=NEW_LINE_CHARACTER;
        }
        writeCSV(csvFileName, csvData);
}
	private static void writeCSV(String csvFileName,String csvData) throws IOException {
        FileOutputStream writer = new FileOutputStream(csvFileName);
        writer.write(csvData.getBytes());
        writer.close();
    }
	private static void checkValidFile(String fileName){
        boolean valid=true;
        
            File f = new File(fileName);
            if ( !f.exists() || f.isDirectory() ){
                valid=false;
            }
        
        if ( !valid){
            System.out.println("File doesn't exist: " + fileName);
            System.exit(0);
        }
    }
	private static String getNumericValue(HSSFCell myCell)  {
        String cellData="";
         if ( HSSFDateUtil.isCellDateFormatted(myCell) ){
               cellData += new SimpleDateFormat(OUTPUT_DATE_FORMAT).format(myCell.getDateCellValue()) +CVS_SEPERATOR_CHAR;
           }else{
               cellData += new BigDecimal(myCell.getNumericCellValue()).toString()+CVS_SEPERATOR_CHAR ;
           }
        return cellData;
    }
	private static String getCellData( HSSFCell myCell){
        String cellData="";
         if ( myCell== null){
             cellData += CVS_SEPERATOR_CHAR;;
         }else{
             switch(myCell.getCellType() ){
                 case  HSSFCell.CELL_TYPE_STRING  :
                 case  HSSFCell.CELL_TYPE_BOOLEAN  :
                          cellData +=  myCell.getRichStringCellValue ()+CVS_SEPERATOR_CHAR;
                          break;
                 case HSSFCell.CELL_TYPE_NUMERIC :
                         cellData += getNumericValue(myCell);
                         break;
                 case  HSSFCell.CELL_TYPE_FORMULA :
                         cellData +=  getFormulaValue(myCell);
             default:
                 cellData += CVS_SEPERATOR_CHAR;;
             }
         }
         return cellData;
    }
	private static String getFormulaValue(HSSFCell myCell){
        String cellData="";
         if ( myCell.getCachedFormulaResultType() == HSSFCell.CELL_TYPE_STRING  || myCell.getCellType () ==HSSFCell.CELL_TYPE_BOOLEAN) {
             cellData +=  myCell.getRichStringCellValue ()+CVS_SEPERATOR_CHAR;
         }else  if ( myCell.getCachedFormulaResultType() == HSSFCell.CELL_TYPE_NUMERIC ) {
             cellData += getNumericValue(myCell)+CVS_SEPERATOR_CHAR;
         }
         return cellData;
    }
	public static void main(String[]args) throws IOException
	{
		
		String excelfileName1="D:\\conversion\\TestData.xls";
        String csvFileName1="D:\\conversion\\TestData.csv";
        excelToCSV(excelfileName1,csvFileName1);
	 }

}
