package rft;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {
	
	int id;
	String name;
	ArrayListExample(int id,String name)
	{
		this.id=id;
		this.name=name;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayListExample>al=new ArrayList<ArrayListExample>();
		al.add(new ArrayListExample(6757, "Levin"));
		al.add(new ArrayListExample(6747, "Ashwin"));
		al.add(new ArrayListExample(5457, "amar"));
		
		Iterator<ArrayListExample>itr=al.iterator();
		while(itr.hasNext())
		{
			ArrayListExample ob=itr.next();
			System.out.println("name is-->"+ob.name+" id is-->"+ob.id);
		}
		for(ArrayListExample ob:al)
		{
			System.out.println("name is-->"+ob.name+" id is-->"+ob.id);
		}
		

	}

}
