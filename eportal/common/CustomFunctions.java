package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimeZone;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;




public class CustomFunctions extends WebFunctions {
	
	
	
	String className=this.getClass().getSimpleName();	

	/*public enum sikuliFunctions {click,verify}
	public boolean sikuliFunction(String image,String action,String info) throws IOException
	{
		//Initialising screen and pattern
		String imagePath=sikuli_images+image+".png";
		Screen screen=new Screen();
		Pattern img=new Pattern(imagePath);
		String score="";
		String expectedResult="";
		String actualResult="";

		try
		{

			switch (sikuliFunctions.valueOf(action)) {

			case click:

				screen.click(img);


				break;

			case verify:

				String match = screen.exists(img).toString(); 
				 expectedResult="Image verification for the "+imagePath +" should be passed";

          System.out.println("match..."+match);

				if(match.contains("M"))
				{

					score=match.split(" ")[3].toString();

					if(match.contains("S:1.00"))
					{


						actualResult = "Image verification for the "+imagePath +" is passed";
						extentReports("Pass", "", expectedResult, actualResult, info,"tc");
						System.out.println("Image verification for "+imagePath+" is passed");

						return true;
					}
					else
					{
						//setting the name for snapshot
						
						String dest=captureScreenShot(info);
						actualResult = "Image verification for the "+imagePath +" is failed";
						extentReports("Fail", dest, expectedResult, actualResult, info,"tc"); 
						System.out.println("Image verification for "+imagePath+" is failed");
						return false;  
					}

				}

				else
				{  String dest=captureScreenShot(info);
					actualResult = "Image verification for the "+imagePath +" is failed";
					extentReports("Fail", dest, expectedResult, actualResult, info,"tc"); 
					System.out.println("Image verification for "+imagePath+" is failed");
					return false;

				}
			}
			return true;
		}

		catch(Exception e)
		{
			String dest=captureScreenShot(info);
			actualResult = "Image verification for the "+imagePath +" is failed";
			extentReports("Fail", dest, expectedResult, actualResult, info,"tc"); 
			System.out.println("Image verification for "+imagePath+" is failed");
			return false;
		}


	}
	*/
	public enum sikuliFunctions {click,verify}
	public boolean sikuliFunction(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws IOException
	{
		//Initialising screen and pattern
		String image=parameter.split(",")[0].toString();
		String action=parameter.split(",")[1].toString();
		String imagePath=sikuli_images+image+".png";
		Screen screen=new Screen();
		Pattern img=new Pattern(imagePath);
		String score="";
		String expectedResult="";
		String actualResult="";
		String info="";

		try
		{

			switch (sikuliFunctions.valueOf(action)) {

			case click:

				screen.click(img);


				break;

			case verify:

				String match = screen.exists(img).toString(); 
				 expectedResult="Image verification for the "+imagePath +" should be passed";

          System.out.println("match..."+match);

				if(match.contains("M"))
				{

					score=match.split(" ")[3].toString();

					if(match.contains("S:1.00"))
					{

						info=captureScreenShot(tcName+"_"+snapShotIndex);
						actualResult = "Image verification for the "+imagePath +" is passed";
						extentReports("Pass", "", expectedResult, actualResult, info,"tc");
						System.out.println("Image verification for "+imagePath+" is passed");

						return true;
					}
					else
					{
						//setting the name for snapshot
						
						info=captureScreenShot(tcName+"_"+snapShotIndex);
						actualResult = "Image verification for the "+imagePath +" is failed";
						extentReports("Fail", info, expectedResult, actualResult, info,"tc"); 
						System.out.println("Image verification for "+imagePath+" is failed");
						return false;  
					}

				}

				else
				{  String dest=captureScreenShot(info);
					actualResult = "Image verification for the "+imagePath +" is failed";
					extentReports("Fail", dest, expectedResult, actualResult, info,"tc"); 
					System.out.println("Image verification for "+imagePath+" is failed");
					return false;

				}
			}
			return true;
		}

		catch(Exception e)
		{
			String dest=captureScreenShot(info);
			actualResult = "Image verification for the "+imagePath +" is failed";
			extentReports("Fail", dest, expectedResult, actualResult, info,"tc"); 
			System.out.println("Image verification for "+imagePath+" is failed");
			return false;
		}


	}

	/**********TRIGGERING SOAP TEST CASE FROM SELENIUM*******/
	public enum soapSuits {SendMVTMessage,SendSSM,SentShipmentService,SentGetShipmentService,GetShipmentServiceSDB,SendFSUMessage,SendFWBMessage,killCmd}
	public void invokeSOAPTestSuit(String soapSuit,String message) throws InterruptedException, IOException
	{
	
		
		
	
		
		
		
		Runtime runtime = Runtime.getRuntime();
	
		
		switch (soapSuits.valueOf(soapSuit)) {

		
		
		case SendMVTMessage:
		try {
			
		
		//runtime.exec("cmd /c start D:\\Applns\\SoapUI-5.2.1\\bin\\testrunner.bat -s\"Send MVT\" -c\"Send\" -r -A -a -j -S -f \"D:\\SoapUIResults\" \"D:\\Sel_Project\\LCAG_TestFactory\\workspace\\EnvMon_ICAPSIT\\Send MVT Message.xml\"");
		//runtime.exec("D:\\Applns\\SoapUI-5.2.1\\bin\\testrunner.bat -s\"Send MVT\" -c\"Send\" -r -A -a -j -S -f \"D:\\SoapUIResults\" \"D:\\Sel_Project\\LCAG_TestFactory\\workspace\\EnvMon_ICAPSIT\\Send MVT Message.xml\"");
		

			
			runtime.exec(message);
		    
		    sleep(10000);
		   
		   /*** p1.destroy();
		    p1=null;***/
		    
		   
		  
		 
		//runtime.exec("taskkill /f /im cmd.exe") ;
		 
		    
		 
		  
		}
		
		catch(IOException ioException) {
		    System.out.println(ioException.getMessage() );
		}
		


		break;	
		
		case SendFSUMessage:
			try {
				
			
			//runtime.exec("cmd /c start D:\\Applns\\SoapUI-5.2.1\\bin\\testrunner.bat -s\"Send MVT\" -c\"Send\" -r -A -a -j -S -f \"D:\\SoapUIResults\" \"D:\\Sel_Project\\LCAG_TestFactory\\workspace\\EnvMon_ICAPSIT\\Send MVT Message.xml\"");
			//runtime.exec("D:\\Applns\\SoapUI-5.2.1\\bin\\testrunner.bat -s\"Send MVT\" -c\"Send\" -r -A -a -j -S -f \"D:\\SoapUIResults\" \"D:\\Sel_Project\\LCAG_TestFactory\\workspace\\EnvMon_ICAPSIT\\Send MVT Message.xml\"");
			

				
				runtime.exec(message);
			    
			    sleep(10000);
			   
			   /*** p1.destroy();
			    p1=null;***/
			    
			   
			  
			 
			//runtime.exec("taskkill /f /im cmd.exe") ;
			 
			    
			 
			  
			}
			
			catch(IOException ioException) {
			    System.out.println(ioException.getMessage() );
			}
			


			break;	
		case SendFWBMessage:
			try {
				
			
			//runtime.exec("cmd /c start D:\\Applns\\SoapUI-5.2.1\\bin\\testrunner.bat -s\"Send MVT\" -c\"Send\" -r -A -a -j -S -f \"D:\\SoapUIResults\" \"D:\\Sel_Project\\LCAG_TestFactory\\workspace\\EnvMon_ICAPSIT\\Send MVT Message.xml\"");
			//runtime.exec("D:\\Applns\\SoapUI-5.2.1\\bin\\testrunner.bat -s\"Send MVT\" -c\"Send\" -r -A -a -j -S -f \"D:\\SoapUIResults\" \"D:\\Sel_Project\\LCAG_TestFactory\\workspace\\EnvMon_ICAPSIT\\Send MVT Message.xml\"");
			

				
				runtime.exec(message);
			    
			    sleep(10000);
			   
			   /*** p1.destroy();
			    p1=null;***/
			    
			   
			  
			 
			//runtime.exec("taskkill /f /im cmd.exe") ;
			 
			    
			 
			  
			}
			
			catch(IOException ioException) {
			    System.out.println(ioException.getMessage() );
			}
			


			break;	
			
		
		
		case SendSSM:
			try {
			
			// runtime.exec("cmd /c start D:\\Applns\\SoapUI-5.2.1\\bin\\testrunner.bat -s\"Send SSM\" -c\"Send\" -r -A -a -j -S -f \"D:\\SoapUIResults\" \"D:\\SOAPAutomationProjects\\Send Schedule Message.xml\"");
				runtime.exec(message);
			    sleep(10000);
			    runtime.exec("taskkill /f /im cmd.exe") ;
			}
			
			catch(IOException ioException) {
			    System.out.println(ioException.getMessage() );
			}
			


			break;	
			
		case SentShipmentService:
			try {
			
			 //runtime.exec("D:\\Applns\\SoapUI-5.2.1\\bin\\testrunner.bat -s\"iCargo via ShipmentEIAAdapter\" -c\"get&store Shipment from&to_iCargo via ESB-ShipmentEAIAdapter\" -r -A -a -j -S -f \"D:\\SoapUIResults\" \"D:\\Sel_Project\\LCAG_TestFactory\\workspace\\EnvMon_ICAPSIT\\AutoSITCheck - ShipmentService - ESB-iCargo.xml\"");
				runtime.exec(message);
			    sleep(30000);
			    
			    System.out.println("mmmmmm"+message);
			   // runtime.exec("taskkill /f /im cmd.exe") ;
			}
			
			catch(IOException ioException) {
			    System.out.println(ioException.getMessage() );
			}
			


			break;	
		case SentGetShipmentService:
			try {
			
			//runtime.exec("D:\\Applns\\SoapUI-5.2.1\\bin\\testrunner.bat -s\"iCargo via ShipmentEIAAdapter\" -c\"getShipment to_iCargo via ESB-ShipmentEAIAdapter\" -r -A -a -j -S -f \"D:\\SoapUIResults\" \"D:\\Sel_Project\\LCAG_TestFactory\\workspace\\EnvMon_ICAPSIT\\AutoSITCheck - ShipmentService - ESB-iCargo.xml\"");
				runtime.exec(message);
			    sleep(30000);
			   // runtime.exec("taskkill /f /im cmd.exe") ;
			}
			
			catch(IOException ioException) {
			    System.out.println(ioException.getMessage() );
			}
			


			break;	
			
		case killCmd:
			runtime.exec("taskkill /f /im cmd.exe") ;
			break;
			
		case GetShipmentServiceSDB:
			try {
			
			
				runtime.exec(message);
				
				// runtime.exec("D:\\Applns\\SoapUI-5.2.1\\bin\\testrunner.bat -s\"Check Booking in SDB\" -c\"Check Booking in SDB\" -r -A -a -j -S -f \"D:\\SoapUIResults\" \"D:\\Sel_Project\\LCAG_TestFactory\\workspace\\EnvMon_ICAPSIT\\AutoSITCheck-getShipment-check_SDB-project.xml\"");
			    sleep(30000);
			   // runtime.exec("taskkill /f /im cmd.exe") ;
			}
			
			catch(IOException ioException) {
			    System.out.println(ioException.getMessage() );
			}
			


			break;	
			
			
			
			
		}
		
	
	}
	public void readTestSteps(String sheetName,String columnName,String tcName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		HashMap<String,String> hmap=new HashMap<String,String>();
		
		
		System.out.println("The final column Name is++++++"+columnName);
		boolean end=false;
		
		String keyword="";
		String parameter="";
		
		InputStream inp = null;
		XSSFWorkbook wb = null;
      

        int rowIndex = 1;
        int columnIndex = -1;
        Row row =null;

		try {
			String s2 = System.getProperty("user.dir");
	
			String path = s2 +"\\excels\\Testscript.xlsx";
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

                     if (String.valueOf(getCellValue(cell)).equals(columnName)) {

                            columnIndex = cell.getColumnIndex();

                            break;
                     }
              }
              if (columnIndex != -1)
                     break;
        }

        

        
		
		
		
		
		
		
	while(end==false)
	{
		
		keyword="";
		
		row = sheet.getRow(rowIndex);
        
		
		try
		{
		//keyword
        Cell cell = row.getCell(2, Row.CREATE_NULL_AS_BLANK);
        keyword=cell.toString();
		}
		
		catch(Exception e)
		{
			System.out.println("going to catchhhhh");
			break;
		}
        
        
       
		//parameter
		if(!keyword.equals(""))
		{
			
				Cell cell1 = row.getCell(columnIndex, Row.CREATE_NULL_AS_BLANK);
				parameter=cell1.toString();
			
		}

        if(!parameter.equals(""))
        {
        	//Setting the flags
        	
        	
        
        	 
        	//On pass
        	 Cell cell2 = row.getCell(5, Row.CREATE_NULL_AS_BLANK);
            String onPass=cell2.toString();
            
            //onFail
            Cell cell3 = row.getCell(6, Row.CREATE_NULL_AS_BLANK);
            String onFail=cell3.toString();
            
          //  Object
            Cell cell4 = row.getCell(1, Row.CREATE_NULL_AS_BLANK);
            String object=cell4.toString();
            
            //Class Name
            
            Cell cell5 = row.getCell(3, Row.CREATE_NULL_AS_BLANK);
            String className=cell5.toString();
            
            //TO_REPORT
            
            Cell cell6 = row.getCell(4, Row.CREATE_NULL_AS_BLANK);
            String toReport=cell6.toString();
            
            hmap.put("toReport", toReport);
           

            if(!keyword.startsWith("#"))
            { 	 
            	callFunction(className,object,keyword,onPass,onFail,parameter,tcName,hmap);


            	if(onPass.contains("goto"))
            	{
            		String onPassValue=onPass.split("goto=")[1].toString();
            		String onPassIndex="index="+onPassValue;


            		if(passFlag==true)
            		{

            			rowIndex=getRowIndex("Testscript", sheetName,onPassIndex);	 
            		}
            		else
            		{

            			try
            			{
            				String onFailValue=onFail.split("goto=")[1].toString();
            				String onFailIndex="index="+onFailValue; 
            				rowIndex=getRowIndex("Testscript", sheetName,onFailIndex);	 
            			}

            			catch(Exception e)
            			{

            			}
            		}


            	}
            }
        }


        rowIndex=rowIndex+1;






	}








	}

	public void callFunction(String clsName,String object,String keyword,String onPass,String onFail,String parameter,String tcName,HashMap<String, String> hmap) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		System.out.println("object....."+object);
		System.out.println("keyword....."+keyword);
		System.out.println("onPass....."+onPass);
		System.out.println("onFail....."+onFail);
		System.out.println("parameter....."+parameter);
		System.out.println("tcName....."+tcName);

		Object[] obj={object,onPass,onFail,parameter,tcName,hmap};





		Class<?> params[] = new Class[obj.length];
		for (int i = 0; i < obj.length; i++) {
			if (obj[i] instanceof Integer) {
				params[i] = Integer.TYPE;
			} else if (obj[i] instanceof String) {
				params[i] = String.class;
			}
			else if (obj[i] instanceof HashMap) {
				params[i] = HashMap.class;
			}
			// you can do additional checks for other data types if you want.
		}




		String methodName=keyword;
		String className = clsName;
		Class<?> cls = Class.forName(className);
		Object _instance = cls.newInstance();


		Method myMethod = cls.getDeclaredMethod(methodName, params);


		//Has issue 
		myMethod.invoke(_instance, object,onPass,onFail,parameter,tcName,hmap);
		
		//Need to pass instance of that class and No.of arguments that method is expecting



	}
	public void readTestScript(String tcName,String module) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, IOException
	{


		String value="";
		dataSheetName=module;
		InputStream inp = null;
		XSSFWorkbook wb = null;


		int rowIndex = 1;
		int columnIndex = -1;
		Row row =null;

		try {
			String s2 = System.getProperty("user.dir");

			String path = s2 +"\\excels\\Testscript.xlsx";
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
		Sheet sheet = wb.getSheet("MasterDatapool");
		Iterator<Row> rows = sheet.rowIterator();
		while (rows.hasNext()) {
			row = rows.next();


			for (Cell cell : row) {

				if (String.valueOf(getCellValue(cell)).equals(tcName)) {

					if(!tcName.startsWith("#"))
					{

						columnIndex = cell.getColumnIndex();

						break;
					}
				}
			}
			if (columnIndex != -1)
				break;
		}










		do
	{
		
	     value="";
		row = sheet.getRow(rowIndex);
		
		
        try
        {
        Cell cell = row.getCell(columnIndex, Row.CREATE_NULL_AS_BLANK);
        value=cell.toString();
        }
        
        catch(Exception e)
        {
        	
        }
		
        
        System.out.println("valueeee"+value);
        
        if(!value.equals(""))
        {
        	 if(!value.startsWith("#"))
             {
        String sheetName=value.split("=")[0].split("/")[0].toString();
        String columnName=value.split("=")[1].toString();
        
        System.out.println("sheetName"+sheetName);
        System.out.println("columnName"+columnName);
        System.out.println("tcName"+tcName);
        
       readTestSteps(sheetName,columnName,tcName);
        
             }
        }
        
        rowIndex=rowIndex+1;
        
        
	}
		
	 while(!value.equals(""));
	
	

		
	}
	public enum time_zones {German}
	public long create_unix_timestamp(String zone) throws InterruptedException, ParseException
	{
		
	
		String reqdt="";
		String formattedDate="";
		SimpleDateFormat gmtDateFormat=null;
		Date date=null;
		

		/****** System Date**********/
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
		Calendar calendar = Calendar.getInstance();





		reqdt = format.format(calendar.getTime());
		date=format.parse(reqdt);


		
	switch (time_zones.valueOf(zone)) {

		
		
		case German:
		/****Converting to desired time zone*****/
		
		

		gmtDateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
		gmtDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
		formattedDate=gmtDateFormat.format(date);

		System.out.println("Current date of Germany is...."+formattedDate);


		//Converting to unix time stamp

		String UNIX_DATE_FORMAT = formattedDate;

		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
		Date date1 = dateFormat.parse(UNIX_DATE_FORMAT );
		long unixTime = (long) date1.getTime()/1000;
		System.out.println("UNIX time stamp is...."+unixTime );

		return unixTime;
		
		
	}
	
	return 1234567890;
	}
	
	
	/******** GETTING THE SOAP RESULTS*****/
	public enum soapResults {GetShipmentServiceIniCargo,StoreShipmentServiceIniCargo,GetShipmentServiceIniCargoFromBE,
		GetShipmentServiceInSDBFromBEVerifyReturnCode,GetShipmentServiceInSDBFromBEVerifyAWB,GetShipmentServiceInSDBFromBEVerifyPcs,
		GetShipmentServiceInSDBFromBEVerifyWt,GetShipmentServiceInSDBFromBEVerifyCustomer}
	public void getSOAPResults(String soapResult) throws InterruptedException
	{
		String returnCode="";
		switch (soapResults.valueOf(soapResult)) {
		
		case GetShipmentServiceIniCargo:
			
			 returnCode=getCellValue(dataSheet,parameters.get("testcaseName"),Integer.parseInt(parameters.get("rowCount")), "ReturnCode_GetShipment");
			 System.out.println("RETTTTURN CODE GET SHIPMENT"+returnCode);
			if(returnCode.equals("BP0029"))
			{
				extentReports("Pass", "", "", "GetShipment service in iCargo is processed successfully with return code BP0029", "","tc");	
			}
		
			else
			{
				extentReports("Fail", "", "", "GetShipment service in iCargo is not processed successfully : return code is "+returnCode, "","tc");	
			}
	
		
			
			
			
		 break;

		case GetShipmentServiceIniCargoFromBE:
			
			 returnCode=getCellValue(dataSheet,parameters.get("testcaseName"),Integer.parseInt(parameters.get("rowCount")), "ReturnCode_GetShipment");
			
			if(returnCode.equals("BP0000"))
			{
				extentReports("Pass", "", "", "GetShipment service in iCargo is processed successfully with return code BP0000", "","tc");	
			}
		
			else
			{
				extentReports("Fail", "", "", "GetShipment service in iCargo is not processed successfully : return code is "+returnCode, "","tc");	
			}
	
		
			
			
			
		 break;
		 
		
		 
		case StoreShipmentServiceIniCargo:
			
           returnCode=getCellValue(dataSheet,parameters.get("testcaseName"),Integer.parseInt(parameters.get("rowCount")), "ReturnCode_StoreShipment");
			
           System.out.println("RETTTTURN CODE STORE SHIPMENT"+returnCode);
			if(returnCode.equals("BP0000"))
			{
				extentReports("Pass", "", "", "StoreShipment service in iCargo is processed successfully with return code BP0000", "","tc");	
			}
		
			else
			{
				extentReports("Fail", "", "", "StoreShipment service in iCargo is not processed successfully : return code is "+returnCode, "","tc");	
			}
			
			 break;
			 
			 
		    case GetShipmentServiceInSDBFromBEVerifyReturnCode:
			
	           returnCode=getCellValue(dataSheet,parameters.get("testcaseName"),Integer.parseInt(parameters.get("rowCount")), "ReturnCode_GetShipment");
				
	         
				if(returnCode.equals("BP0000"))
				{
					extentReports("Pass", "", "", "GetShipment service in iCargo is processed successfully with return code BP0000", "","tc");	
				}
			
				else
				{
					extentReports("Fail", "", "", "GetShipment service in iCargo is not processed successfully : return code is "+returnCode, "","tc");	
				}
				
				 break;
			
		case GetShipmentServiceInSDBFromBEVerifyAWB:
			
			 String expectedAwb=getCellValue(dataSheet,parameters.get("testcaseName"),Integer.parseInt(parameters.get("rowCount")), "AWBNo");
			 String actualAwb=getCellValue(dataSheet,parameters.get("testcaseName"),Integer.parseInt(parameters.get("rowCount")), "AWBNumber_GetShipment");
			
			if(expectedAwb.equals(actualAwb))
			{
				extentReports("Pass", "", "", "Verification for 'awb number' is passed in the web service response.AWB showing as "+actualAwb, "","tc");	
			}
		
			else
			{
				extentReports("Fail", "", "", "Verification for 'awb number' is failed in the web service response.AWB showing as "+actualAwb, "","tc");	
			}
	
		
			
	
		
			
			
			
		 break;
		 
		case GetShipmentServiceInSDBFromBEVerifyPcs:
			
			 String expectedPcs=getCellValue(dataSheet,parameters.get("testcaseName"),Integer.parseInt(parameters.get("rowCount")), "Pieces");
			 String actualPcs=getCellValue(dataSheet,parameters.get("testcaseName"),Integer.parseInt(parameters.get("rowCount")), "Pcs_GetShipment");
			
			if(expectedPcs.equals(actualPcs))
			{
				extentReports("Pass", "", "", "Verification for 'shipment pieces' is passed in the web service response.Pieces showing as "+actualPcs, "","tc");	
			}
		
			else
			{
				extentReports("Fail", "", "", "Verification for 'shipment pieces' is failed in the web service response.Pieces showing as "+actualPcs, "","tc");	
			}
	
		
			
			
			
		 break;
		 
		case  GetShipmentServiceInSDBFromBEVerifyWt	 :
			
			 String expectedWt=getCellValue(dataSheet,parameters.get("testcaseName"),Integer.parseInt(parameters.get("rowCount")), "Weight");
			 String actualWt=getCellValue(dataSheet,parameters.get("testcaseName"),Integer.parseInt(parameters.get("rowCount")), "Wt_GetShipment");
			
			if(expectedWt.equals(actualWt))
			{
				extentReports("Pass", "", "", "Verification for 'shipment weight' is passed in the web service response.Weight showing as "+actualWt, "","tc");	
			}
		
			else
			{
				extentReports("Fail", "", "", "Verification for 'shipment weight' is failed in the web service response.Weight showing as "+actualWt, "","tc");	
			}
	
		
			
			
			
		 break;
		
		case  GetShipmentServiceInSDBFromBEVerifyCustomer	 :
			
			 String expectedCustomerCode=getCellValue(dataSheet,parameters.get("testcaseName"),Integer.parseInt(parameters.get("rowCount")), "Customer");
			 String actualCustomerCode=getCellValue(dataSheet,parameters.get("testcaseName"),Integer.parseInt(parameters.get("rowCount")), "Customer_GetShipment");
			
			if(expectedCustomerCode.equals(actualCustomerCode))
			{
				extentReports("Pass", "", "", "Verification for 'customer code' is passed in the web service response.Customer code showing as "+actualCustomerCode, "","tc");	
			}
		
			else
			{
				extentReports("Fail", "", "", "Verification for 'customer code' is failed in the web service response.Customer code showing as "+actualCustomerCode, "","tc");	
			}
	
		
			
			
			
		 break; 
		 
		
		 
		 
		
		
		
		}
		
		
		
	}
	
	
	
	
	
	/******** STRING OPERATIONS STORING TO EXCEL FILE*****/
	public enum stringOps {Substring,Concat}
	public String stringOperations(String stringOperation,String values,String stringValue)
	{
		String actualValue="";
		
		////"Substring","3",flightNo
		switch (stringOps.valueOf(stringOperation)) {
		
		case Substring:
			
		
			
		int lenValues=values.split(";").length;
		
		
		
		if(lenValues==1)
		{
			actualValue=stringValue.substring(Integer.parseInt(values));
		}
		
		
		
		return actualValue;
		
		
		
		case Concat:
			
		 int contactValLen=stringValue.split(";").length;
		 String toBeConcatinatedValue="";
		 
		 for(int i=0;i<contactValLen;i++)
		{
			
			
			 toBeConcatinatedValue=stringValue.split(";")[i].toString();
			
			 actualValue= actualValue+getCellValue(dataSheet,parameters.get("testcaseName"),Integer.parseInt(parameters.get("rowCount")), toBeConcatinatedValue);
		 }
			
			
			
	    return actualValue;
			
			
		}
		
		
		
		
		
		return actualValue;
		
		
		
	}
	
	
	
	
	/******** CREATE Flight number FROM THE STOCK AND STORING TO EXCEL FILE*****/
	public enum flightTypes {FullFlightNumber,FlightNumber}
	public void createFlight(String flightType,String excelName,String sheetName,int rowValue,String columnValue)
	{
		
		String propValue="flight_range_from";
		//loading the property file
        String value=readData(propValue);
        String valToStore="";
        int val=Integer.parseInt(value)+1;
        		
		switch (flightTypes.valueOf(flightType)) {
		
		
        
		case FullFlightNumber:
			value="LH"+value+"R";	
			
            
            
			
			break;
			
          case FlightNumber:
        	 value=value+"R";	
			
			break;	
		
		}
		 valToStore=Integer.toString(val);
		 writeData(valToStore,propValue);
		 setCellValue(excelName, sheetName, rowValue, columnValue,value);
	}
	
	
	/******** CREATE AWB FROM THE STOCK AND STORING TO EXCEL FILE*****/
	//public void createDateFormats(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap)
	/*public boolean enterAwb(String excelName,String sheetName,int rowValue,String columnValue) {
		
		try
		{
			String propValue="stock_range_from";
			  
			//loading the property file
              String value=readData(propValue);
              
               
			  
			//loading the property file
            
              
              int val=Integer.parseInt(value);
              int modValue=val%7;
              
              String awbNumber=Integer.toString(val)+Integer.toString(modValue);
              
              if(awbNumber.length()<8)
              {
                    awbNumber="0"+awbNumber;
              }
              String valToStore=Integer.toString(val+1);
              
              if(valToStore.length()<7)
              {
                    valToStore="0"+valToStore;
              }
              writeData(valToStore,propValue);
             
              
           
              setCellValue(excelName, sheetName, rowValue, columnValue,awbNumber);
			  
			  
			return true;
		}
		
		
		catch(Exception e)
		{
			return false;
		}
	}*/

	
	/******** CREATE AWB FROM THE STOCK AND STORING TO EXCEL FILE*****/
public boolean CreateAWB(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) {
		
		try
		{
			String propValue="stock_range_from";
			  
			//loading the property file
              String value=readData(propValue);
              
              int rowVal=getRowIndex(dataSheet,dataSheetName , tcName);
			  
			//loading the property file
             
              
              int val=Integer.parseInt(value);
              int modValue=val%7;
              
              String awbNumber=Integer.toString(val)+Integer.toString(modValue);
              
              if(awbNumber.length()<8)
              {
                    awbNumber="0"+awbNumber;
              }
              String valToStore=Integer.toString(val+1);
              
              if(valToStore.length()<7)
              {
                    valToStore="0"+valToStore;
              }
              writeData(valToStore,propValue);
             
              
           
              setCellValue(dataSheet, dataSheetName, rowVal, parameter,awbNumber);
			  
			  
			return true;
		}
		
		
		catch(Exception e)
		{
			return false;
		}
	}
	

}
