package sikuli;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;

public class SS {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		/*Screen s =new Screen();
		
		ScreenImage img=s.capture();
		FileOutputStream fos=new FileOutputStream("D:\\SS\\"+img);*/
		
		Screen s =new Screen();
		
		BufferedImage bf = s.capture().getImage();
		File file1 = new File("D:\\SS\\destFile.png");
		ImageIO.write(bf, "png", file1);
	}

}
