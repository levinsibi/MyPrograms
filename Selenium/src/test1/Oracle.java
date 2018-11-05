package test1;

import java.sql.*;  
class Oracle{  
public static void main(String args[]){  
try{  
//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@lx-lcag-icargo-db07-sit.lsy.fra.dlh.de:1850:XICGOPS","ICO_APP_READ","rh1ewLTu");  
  
//step3 create the statement object  
Statement stmt=con.createStatement();  
  
//step4 execute query  
ResultSet rs=stmt.executeQuery("select * from CAPBKGMST");  
/*while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));*/  
  
//step5 close the connection object  
con.close();  
  
}catch(Exception e){ System.out.println(e);}  
  
}  
}