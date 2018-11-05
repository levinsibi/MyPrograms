package rft;

public class ThrowsException {  
	   void checkAge(int age)throws ArithmeticException{  
		int t=age/0; 
	   }  
	   public static void main(String args[]){  
		ThrowsException obj = new ThrowsException();
		try
		{
		obj.checkAge(13);  
		}
		catch(ArithmeticException ex)
		{
		System.out.println("End Of execution "+ex);  
		}
	   }  
	}