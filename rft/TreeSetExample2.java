package rft;

import java.util.HashSet;
import java.util.TreeSet;

public class TreeSetExample2 implements Comparable<TreeSetExample2> {

	int id;
	String name;
	
	public TreeSetExample2(int id,String name) {

this.id=id;
this.name=name;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeSet<TreeSetExample2>hs=new TreeSet<TreeSetExample2>();
		TreeSetExample2 ob1=new TreeSetExample2(6757, "levin");
		TreeSetExample2 ob2=new TreeSetExample2(6737, "amar");
		TreeSetExample2 ob3=new TreeSetExample2(7757, "kannan");
		
		
		hs.add(ob1);
		hs.add(ob2);
		hs.add(ob3);
		hs.add(ob3);
		hs.add(ob3);
		
		for(TreeSetExample2 ob:hs)
		{
			System.out.println(ob.id+"----"+ob.name);
		}
		
		
		
	}
	public int compareTo(TreeSetExample2 ob) {
		// TODO Auto-generated method stub
		if(id>ob.id)
		{
			return 1;
		}
		else if(id<ob.id)
		{
			return -1;
		}
		return 0;
	}

}