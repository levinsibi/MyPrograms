package test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



public class PropertyFile {
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("D:\\db.properties");
		
		Properties p=new Properties(); 
		p.load(fis);
		System.out.println(p.getProperty("name"));
		System.out.println(p.getProperty("paswd"));
		p.setProperty("name", "PP");
		FileOutputStream fos=new FileOutputStream("D:\\db.properties");
		p.store(fos, null);
		

	}

}
