package rft;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;

import org.apache.xmlbeans.impl.common.IOUtil;

import com.itextpdf.text.Document;
import com.itextpdf.*;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;

public class HtmlToPDF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder contentBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader("D:\\mypage1.html"));
			String str;
			while ((str = in.readLine()) != null) {
				contentBuilder.append(str);
			}
			in.close();
		} catch (IOException e) {
		}
		String content = contentBuilder.toString();

		try {


			OutputStream file = new FileOutputStream(new File("D:\\Test.pdf"));
			Document document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			HTMLWorker htmlWorker = new HTMLWorker(document);
			htmlWorker.parse(new StringReader(content));
			document.close();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
