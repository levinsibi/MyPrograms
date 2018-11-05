package rft;



import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;


public class WebApp extends JFrame implements ActionListener
{
 JLabel l1,l2,l3,l4;
 JButton b1,b2;
 JTextField t1,t2;
 TextArea t3;

 
 WebApp()
 {
  l1=new JLabel("Enter the Website URL");

  b1=new JButton("Go");
  b2=new JButton("Clear");
 
  t1=new JTextField(10);
     
  add(l1);
  add(t1);
  add(b1);
  add(b2);
 
  
  

  
  b1.addActionListener(this);
  b2.addActionListener(this);
  setSize(500,100);
  setLayout(new FlowLayout());
  setTitle("Browser Launch");
 }

 public void actionPerformed(ActionEvent ae)
 {
  
 
  
  if(ae.getSource()==b1)
  {
	  String str=t1.getText();
	  
	  try {
		Desktop.getDesktop().browse(new URI(str));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }	
  else if(ae.getSource()==b2)
  {
	  t1.setText("");
	  
  }
  
 }

 public static void main(String args[])
 {
	 WebApp a=new WebApp();
  a.setVisible(true);
  a.setLocation(200,200);
  
 }

}

