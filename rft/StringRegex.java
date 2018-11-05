package rft;

import java.util.regex.Pattern;

public class StringRegex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//regex
		
		String str="abc123cdef";
		/*
		1	[abc]	a, b, or c (simple class)
		2	[^abc]	Any character except a, b, or c (negation)
		3	[a-zA-Z]	a through z or A through Z, inclusive (range)
		4	[a-d[m-p]]	a through d, or m through p: [a-dm-p] (union)
		5	[a-z&&[def]]	d, e, or f (intersection)
		6	[a-z&&[^bc]]	a through z, except for b and c: [ad-z] (subtraction)
		7	[a-z&&[^m-p]]	a through z, and not m through p: [a-lq-z](subtraction)*/
		
		
		System.out.println(Pattern.matches("[a-z&&[^m-p]]*","abfgdfg"));
		System.out.println(Pattern.matches("[^abc]", "d"));
		
		System.out.println(Pattern.matches("[a-zA-Z0-9]*", "d9asdfhslfhsf4s6f4s4fs4f64df4sa4fd"));//alphanumeric
		
		System.out.println(Pattern.matches("[a-zA-Z0-9]{5}", "dsda5"));//aplphanumeric exactly 5
		
		System.out.println(Pattern.matches("[0-9]{8}", "58964280"));//numeric exactly 8
		
		
		
		//splitting of a string
		
		String s1="java is    a very   good language";
		
		String []splits=s1.split(" ");//based on single whitespace splits
		for(String st:splits)
		{
			System.out.println(st);
		}
		
		
				
		String splits1[]=s1.split("\\s+");//based on whitespace splits
		for(String st:splits1)
		{
			System.out.println(st);
		}
		
		String splits2[]=s1.split("\\s+",2);//based on whitespace splits into two
		
		
		for(String st:splits2)
		{
			System.out.println(st);
		}
		
		
	}

}
