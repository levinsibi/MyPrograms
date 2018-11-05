package rft;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ComparatorExample {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList al=new ArrayList();
		al.add(new student(1,"abhi"));
		
		al.add(new student(5,"karun"));
		al.add(new student(3,"varun"));
		
		System.out.println("By name sorting");
		Collections.sort(al,new nameComparator());
		Iterator itr=al.iterator();  
		while(itr.hasNext()){  
		student st=(student)itr.next();  
		System.out.println(st.id+" "+st.name);  
		}
		
		System.out.println("By age sorting");
		Collections.sort(al,new ageComparator());
		Iterator itr2=al.iterator();  
		while(itr2.hasNext()){  
			student st=(student)itr2.next();  
		System.out.println(st.id+" "+st.name);
		}  
	}

}

class student
{
	int id;
	String name;
	student(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	
}

class ageComparator implements Comparator
{
	
	
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		
		student s1=(student)arg0;
		student s2=(student)arg1;
		if(s1.id==s2.id)
		{
			return 0;
		}
		else if(s1.id>s2.id)
		{
			return 1;
		}
		else return-1;
	}
}
class nameComparator implements Comparator
{
	
	
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		
		student s1=(student)arg0;
		student s2=(student)arg1;
		return s1.name.compareTo(s2.name);
	}
}
	