package rft;

import com.aspose.ocr.ImageStream;
import com.aspose.ocr.OcrEngine;

public class OCR1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
			// TODO Auto-generated method stub
			OcrEngine ocr = new OcrEngine();
			ocr.setImage(ImageStream.fromFile("D:\\OCR\\images\\irc.jpg"));
			
	            if (ocr.process()) {
	                System.out.println("\ranswer -> " + ocr.getText());
	            }
	}

	}
