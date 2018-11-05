package apps;





import java.awt.*;
import java.awt.event.*;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintStream;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Date;


import javax.swing.*;


public class AWB extends JFrame implements ActionListener
{
 JLabel l1,l2,l3,l4;
 JButton b1,b2;
 JTextField t1,t2;
 TextArea t3;

 
 AWB()
 {
  l1=new JLabel("Enter 7 digit number");
  l2=new JLabel("Enter Range");
  l3=new JLabel("OUTPUT");
  l4=new JLabel("INVALID INPUT...");
  b1=new JButton("Generate ");
  b2=new JButton("Clear");
  t3=new TextArea();
 
  //t3.setCaretPosition(t3.getDocument().getLength());
  //t3.getScrollableBlockIncrement(arg0, arg1, arg2)
  
  t1=new JTextField(10);
 
  
  t2=new JTextField(10);
 
  
  
  
  add(l1);
  add(t1);
  add(l2);
  add(t2);
  add(l4);
  add(l3);
  add(t3);
  add(b1);
  add(b2);
 
  
  

  
  Font font = new Font("Courier New", Font.BOLD,15);
  l4.setVisible(false);
  l3.setVisible(false);
  b1.addActionListener(this);
  b2.addActionListener(this);
  setSize(500,500); 
  setLayout(new FlowLayout());
  b1.setToolTipText("generate the awb");
  t1.setToolTipText("Enter a 7 digit number");
  b1.setFont(font);
  b2.setFont(font);
  b1.setBackground(Color.GREEN);
  b2.setBackground(Color.RED);
  setTitle("AWB GENERATOR@LEVIN@");
 }

 public void actionPerformed(ActionEvent ae)
 {
  
  int rem,val,i,b;

  
  
  
  
  if(ae.getSource()==b1)
  { 
	  /*DateFormat o=new DateFormat("\yyyy\mm\day");*/
	  
	  
	//  Date date=new Date();
	  
	  	 /*Date date=new Date();
		 String name =date.toString(); //example
		 String normalized = Normalizer.normalize(name, Form.NFD);
		 String result = normalized.replaceAll("[^A-Za-z0-9]", "");
		 System.out.println(result);
		 
		 
	  //String store=String.valueOf(System.currentTimeMillis());
	 // System.out.println(System.currentTimeMillis());
		 File file=new File("D:\\"+result+".txt");
		 
		 PrintStream ps=null;
		 try 
		 {
			 ps = new PrintStream(file);
		 } 
		 catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	  
	  
	  
	  int h=t1.getText().length();
	  /*&&t1.getText()== "\\d+"*/
	 
	  if(h==7&t2.getText().matches("[1-9]+")&t1.getText().matches(("[0-9]+")))//regular expression to validate text box contains numbers only
	  {
		  b=Integer.parseInt(t2.getText());
		  
			  
		  
		   l4.setVisible(false);
		   val=Integer.parseInt(t1.getText());
		   
		   int a[]=new int[b];
		   rem=val%7;
		   a[0]=val*10+rem;
		   String ac=Integer.toString(val);
		   for(i=1;i<b;i++)
		   {
			   rem=(a[i-1]/10)%7;
			   if(rem==6)
			   {
				   a[i]=a[i-1]+4;
			   }
			   else
			   {
				   a[i]=a[i-1]+11;
			   }
		   }
		   		for( i=0;i<b;i++)
		   		{
		   			
		   			
		   			//ps.println(a[i]);
		   			
		   			/*System.out.println(a[i]);
		   			ps.println();*/
		   			/*if(ac.startsWith("0"))
		   			{
		   				
		   			}
		   			else
		   			{*/
		   			t3.append(String.valueOf(String.format("%08d", a[i]))+"\n\n");
		   			
		   			//ps.println(String.valueOf(String.format("%08d", a[i])));
		   		}
		   		//ps.close();
	
   		}
	  
	  else
	  {
		  
		  l3.setVisible(false);
		  l4.setVisible(true);
	  }
  }	
  else if(ae.getSource()==b2)
  {
	  //ps.close();
	  t1.setText("");
	  t2.setText("");
	  t3.setText("");
	  l4.setVisible(false);
  }
  
 }
 
 
 public static void main(String args[])
 {

	 
  AWB a=new AWB();
  a.setVisible(true);
  a.setLocation(400,100);
  
 }

}

