package apps;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FullScreen {

	public static void main(String[] args) throws AWTException, IOException {
		
		
		// TODO Auto-generated method stub

		
		String format="jpg";
		String FileName="D:\\ScreenShot\\"+"screenshot."+format;
		
		Robot robot=new Robot();
		
		Rectangle rec=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage BI=robot.createScreenCapture(rec);
		ImageIO.write(BI, format, new File(FileName));
		
		System.out.println("Done................");
	}

}
