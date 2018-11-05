/*package test;

import java.awt.Frame;

import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.core.Robot;

 class TestAssertJ {

		// TODO Auto-generated method stub
	
        
        Thread.sleep(2000);
 
 //Finding the frame
        FrameFixture frame = findFrame(new GenericTypeMatcher<Frame>(Frame.class) {
                 protected boolean isMatching(Frame frame) {
                       
                       String frameName=frame.getName();
                       
                       System.out.println("sssss"+frameName);
                       
                     
                              if(frameName.equals("frame0"))
                              {
                                     
                                     System.out.println("Application is launched");
                                   
                                     return true;
                                     
                                    
                              }
                     
                       System.out.println("Application is not launched");
                 return false;
                 
                 }
               
               }).using(robot());
        
}
        
        
        private Robot robot() {
            Robot robot = BasicRobot.robotWithNewAwtHierarchy();
            robot.settings().delayBetweenEvents(50);
            return robot;
        }
	

}

*/