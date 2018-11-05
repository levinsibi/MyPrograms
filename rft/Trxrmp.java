package rft;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Trxrmp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub



File file=new File("D:\\trxrmp2.txt");
BufferedReader br=new BufferedReader(new FileReader(file));
String st;

String header=br.readLine();

String splith=header.split("TCMAGT82TCM:PIMA+")[1].split(":")[1].toString().split("\\+")[1].toString();

String footer="";
System.out.println("header-ID is-->"+splith);

while((st=br.readLine())!=null)
{
	footer=st;
	
	System.out.println(st);
	
}
	

System.out.println("footeris"+footer);

String splitf=footer.split("\\+")[4].toString();

System.out.println("Footer Id is-->"+splitf);

if(splith.equals(splitf))
{
	System.out.println("Fine");
}
else
{
	System.out.println("Failed");
}

	}

}
