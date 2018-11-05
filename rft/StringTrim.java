package rft;
import java.io.*;
public class StringTrim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String str="      levin is a good boy         ";
		
		String str1=str.trim().replaceAll("l", "f");
		System.out.println(str1);
	}

}
