package rft;

//import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.apache.http.client.utils.DateUtils;

public class DateCheck {

	public static void main(String[] args) throws ParseException {
		/*// TODO Auto-generated method stub
		
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMMyy");  
	    try {  
	        Date date = formatter.parse("07OCT17");  
	        System.out.println("Date is: "+date);  
	    } catch (ParseException e) {e.printStackTrace();}  */
		
		
		/*SimpleDateFormat format1 = new SimpleDateFormat("ddMMMYY");
        SimpleDateFormat format2=new SimpleDateFormat("dd-MMM-YY");   
   Date date=format1.parse("02Oct17");
  System.out.println(format2.format(date).toUpperCase());*/
		
		SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yy:HH");
        SimpleDateFormat format2=new SimpleDateFormat("ddMMMyyyy:HH:mm:ss");   
   Date date=format1.parse("06-Mar-97:22");
  System.out.println(format2.format(date).toUpperCase());

	}  
		
	
	
		//System.out.println("ddMMMyy >>>" + DateUtils.parseDate("07oct17", new String[] { "ddMMMyy" }));

		
		
	  
	}


