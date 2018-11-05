package rft;
import java.io.*;
public class Trimmethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//method eliminates leading and trailing spaces.The string trim() method doesn't omits middle spaces.
		
		String str="       levin       sibi         kalappurackal      ";
		
		System.out.println(str.substring(15));//substring starting from index 15
		
		String str1=str.trim().replaceAll("l", "f");
		System.out.println(str1);
		
		
		String str3="ds_col=Origin;ds_value=BLR";
		
		String station=str3.split(";")[1].split("=")[1].toString();
		System.out.println("station value is --- "+station);
		StringBuffer str2=new StringBuffer("levins");
		System.out.println(str2.reverse());
		
		char []ch={'l','e'};
		String s=new String(ch);
		
		System.out.println(s);
		
		
		
		
		String s1="levin";
		String s2="sibi";
		String s3=s1+s2;
		System.out.println(s3);
		
		String rev="";
		int l=s1.length();
		for(int i=l-1;i>=0;i--)
		{
			rev+=s1.charAt(i);
		}
		System.out.println(rev);
		String s5="hello";
		String s6="hello";		
		
		String s7=new String("hello");
		System.out.println(s5.equals(s6));//true
		System.out.println(s5==s6);//true
		System.out.println(s5.equals(s7));//true
		System.out.println(s5==s7);//false because s7 refers to instance created in non-pool
		
	}

}
