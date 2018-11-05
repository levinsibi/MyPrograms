package rft;

import java.util.HashMap;
import java.util.HashSet;

public class HashMapExample {

	int id;
	String name;
	
	public HashMapExample(int id,String name) {

this.id=id;
this.name=name;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer,HashMapExample>hm=new HashMap<Integer,HashMapExample>();
		HashMapExample ob1=new HashMapExample(6757, "levin");
		HashMapExample ob2=new HashMapExample(6737, "amar");
		HashMapExample ob3=new HashMapExample(7757, "kannan");
		
		
		hm.put(4, ob1);
		hm.put(6, ob3);
		hm.put(3, ob2);
		hm.put(3, ob2);
	for(Integer k:hm.keySet())
	{
		HashMapExample ob=hm.get(k);
		
		System.out.println(ob.id+"----"+ob.name);
	}
		
	
		
		
		
		
	}

}