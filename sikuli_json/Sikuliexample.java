package sikuli;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;




import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Sikuliexample {

	public static void main(String[] args) throws FindFailed, IOException, URISyntaxException, InterruptedException {
		// TODO Auto-generated method stub

		//Desktop.getDesktop().browse(new URI("www.google.com"));
		Screen s =new Screen();
		Thread.sleep(10000);
		/*if(s.exists("D:\\Capture.PNG") != null)
		{
			System.out.println("got it");
			s.click();
		}
		else
		{
			System.out.println("not found");
		}
		*/
	//	s.dragDrop((Pattern)map.get("thumbnail.png"), (Pattern)map.get("placeholder.png"));
	
		
		Pattern source=new Pattern("D:\\sikuli1.PNG");
		Pattern dest=new Pattern("D:\\sikuli2.PNG");
		s.dragDrop(source, dest);
	}

}
