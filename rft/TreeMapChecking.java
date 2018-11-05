package rft;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

class Address
{
	public int id;
	String name;
	Address(int No,String name)
	{
		this.id=No;
		this.name=name;
	}
	/*public boolean equals(Object ob)
	{
		Address obb=(Address)ob;
		if(obb.id==id)
			return true;
		else
			return false;
	}*/
	
}

public class TreeMapChecking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	TreeMap <Integer,Address>tm=new TreeMap<Integer,Address>();
		Address a1=new Address(123,"kaka");
		Address a2=new Address(145,"adsahd");
		Address a3=new Address(231,"dsfgsdj");
		Address a4=new Address(486,"dsfgsdj");
		System.out.println(a3.equals(a4));
		tm.put(1, a1);
		tm.put(13, a2);
		tm.put(5, a3);
		tm.put(7, a4);
		
		
		for(Integer k:tm.keySet())
		{
			Address ob=tm.get(k);
			if(ob.equals(a4))
			{
				System.out.println("founded");
				
				
			}
			
			System.out.println(" Number Is "+ob.id+" Name is "+ob.name);
		
		}

	}
/*
	public int compare(Address arg0, Address arg1) {
		// TODO Auto-generated method stub
		
		if(arg0.id==arg1.id)
		{
			return 0;
		}
		else 
			return 1;
	}*/
	
}
