package apps;



import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import javax.swing.text.PlainDocument;

/*class jtextfieldlimit extends PlainDocument
{
	private int limi;
	jtextfieldlimit(int limit)
	{
		super();
		this.limi=limit;
	}
	 jtextfieldlimit(int limit,boolean upper) {
		// TODO Auto-generated constructor stub
	super();
	this.limi=limit;
	 }
	
}*/
public class AWB1 extends JFrame implements ActionListener
{
 JLabel l1,l2,l3,l4;
 JButton b1,b2;
 JTextField t1,t2;
 TextArea t3;

 
 AWB1()
 {
  l1=new JLabel("Enter 7 digit no");
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
 
  
  

  l4.setVisible(false);
  b1.addActionListener(this);
  b2.addActionListener(this);
  setSize(500,1000);
  setLayout(new FlowLayout());
  setTitle("AWB GENERATOR@LEVIN@");
 }

 public void actionPerformed(ActionEvent ae)
 {
  
  int rem,val,i,b;
  
  if(ae.getSource()==b1)
  {
	  
	  int h=t1.getText().length();
	  if(h==7)
	  {
		   l4.setVisible(false);
		   val=Integer.parseInt(t1.getText());
		   b=Integer.parseInt(t2.getText());
		   int a[]=new int[b];
		   rem=val%7;
		   a[0]=val*10+rem;
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
		   		
		   			
		   		
		   	t3.append(String.valueOf(String.format("%07d", a[i]))+"\n\n");
		   			
		   		}
	
   		}
	  else
	  {
		  
		  l3.setVisible(false);
		  l4.setVisible(true);
	  }
  }	
  else if(ae.getSource()==b2)
  {
	  t1.setText("");
	  t2.setText("");
	  t3.setText("");
	  l4.setVisible(false);
  }
  
 }

 public static void main(String args[])
 {
  AWB1 a=new AWB1();
  a.setVisible(true);
  a.setLocation(200,200);
  
 }

}
