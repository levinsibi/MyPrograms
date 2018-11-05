package rft;

import java.util.*;
import java.awt.AWTException;
import java.awt.Event;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
 
class Notepad {
  public static void main(String[] args) throws AWTException, IOException, InterruptedException {
    
	  
	 
	  Runtime rs=Runtime.getRuntime();
	  rs.exec("notepad.exe");
	  System.out.println(System.getProperties());
	  Thread.sleep(10000);
	 /* System.out.println("available processors are"+rs.availableProcessors());
	  String str=System.getProperty("user.name");
	 //A-6757 String str="........bbye..............................";
	  StringSelection ss=new StringSelection(str);
	 
	  Clipboard cb=Toolkit.getDefaultToolkit().getSystemClipboard();
	  cb.setContents(ss, ss);
	  Robot ro=new Robot();
	  
	  ro.keyPress(KeyEvent.VK_CONTROL);
	  ro.keyPress(KeyEvent.VK_V);
	  ro.keyRelease(KeyEvent.VK_CONTROL);
	  ro.keyRelease(KeyEvent.VK_V);
	
	  Thread.sleep(3000);
	  StringSelection s2=new StringSelection("Good Bye :)");
		 
	  cb=Toolkit.getDefaultToolkit().getSystemClipboard();
	  cb.setContents(s2, s2);
	  
	  
	  ro.keyPress(KeyEvent.VK_CONTROL);
	  ro.keyPress(KeyEvent.VK_V);
	  ro.keyRelease(KeyEvent.VK_CONTROL);
	  ro.keyRelease(KeyEvent.VK_V);*/
	  String str=System.getProperty("user.name");
	  System.out.println(System.getProperty("user.home"));
	 StringSelection s=null;
	 Robot ro=new Robot();
	  Clipboard cb=Toolkit.getDefaultToolkit().getSystemClipboard();
	  String []ar=new String[]{"Hello Dear ",str," \n\nits been a long day i was waiting for you "," \n\nwe will meet again soon","\n\ntil then............ ","good bye",":)"};
	  for(int i=0;i<ar.length;i++){
		  
		  s=new StringSelection(ar[i]);
		  cb=Toolkit.getDefaultToolkit().getSystemClipboard();
		  cb.setContents(s, s);
		  ro.keyPress(KeyEvent.VK_CONTROL);
		  ro.keyPress(KeyEvent.VK_V);
		  ro.keyRelease(KeyEvent.VK_CONTROL);
		  ro.keyRelease(KeyEvent.VK_V);
		  Thread.sleep(3000);
	  }
	 
	  
  }
}
