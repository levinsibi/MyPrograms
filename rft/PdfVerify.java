package rft;

import java.io.*;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;


public class PdfVerify {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String path="D:\\img5.pdf";
		FileInputStream fis=new FileInputStream(path);
		
		PdfReader reader=new PdfReader(fis);
		
		String arg=PdfTextExtractor.getTextFromPage(reader, 1);
		System.out.println(arg);
		System.out.println("Finished");
	}

}
