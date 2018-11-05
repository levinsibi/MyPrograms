package test;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JTextArea;

import org.netbeans.jemmy.ClassReference;
import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JTextAreaOperator;
import org.netbeans.jemmy.operators.JTextAreaOperator.JTextAreaFinder;
import org.netbeans.jemmy.operators.JTextFieldOperator;

public class TestJemmy {

	public static void main(String[] args) throws InterruptedException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException {
		// TODO Auto-generated method stub

		
		new ClassReference("apps.AWB").startApplication(); //Main class
        
        Thread.sleep(2000);
        
        

        JFrameOperator mainFrame = new JFrameOperator();
        
        
        
        JTextFieldOperator textField = new JTextFieldOperator(mainFrame, "");
        textField.enterText("7658943");
        
        Thread.sleep(2000);
        
        JTextFieldOperator textField2 = new JTextFieldOperator(mainFrame, 1);
        textField2.enterText("2");
        Thread.sleep(2000);
        System.out.println("result is "+textField2.getText());
        
        JButtonOperator btn = new JButtonOperator(mainFrame, 0);
        btn.clickMouse();
        Thread.sleep(1000);
        /*JButtonOperator btn2 = new JButtonOperator(mainFrame, 1);
        btn2.clickMouse();
        Thread.sleep(1000);*/
        
        JTextArea area=new JTextArea();
        
        

	}

}
