package rft;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Webopen {

	public static void main(String[] args) throws IOException, URISyntaxException {
		// TODO Auto-generated method stub

		
		Desktop.getDesktop().browse(new URI("http://www.google.com"));
	}

}
