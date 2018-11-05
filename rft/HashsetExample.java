package rft;

import java.util.HashSet;

public class HashsetExample {

	int id;
	String name;
	
	public HashsetExample(int id,String name) {

this.id=id;
this.name=name;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet<HashsetExample>hs=new HashSet<HashsetExample>();
		HashsetExample ob1=new HashsetExample(6757, "levin");
		HashsetExample ob2=new HashsetExample(6737, "amar");
		HashsetExample ob3=new HashsetExample(7757, "kannan");
		
		
		hs.add(ob1);
		hs.add(ob2);
		hs.add(ob3);
		hs.add(ob3);
		hs.add(ob3);
		
		for(HashsetExample ob:hs)
		{
			System.out.println(ob.id+"----"+ob.name);
		}
		
		
		
	}

}
