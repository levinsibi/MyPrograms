package rft;

class parent{
	parent()
	{
		System.out.println("im parent");
	}
	void show()
	{
		System.out.println("parent override");
	}
}
public class Child  extends parent implements Cloneable{
	
	 int id;
	Child(int id)
	{
		//super();//by default calls parent constructor
		this.id=id;
		System.out.println("im child"+id);
		
	}
	void show()
	{
		System.out.println("child override");
		super.show();
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub

		Child ob=new Child(5);
		Child ob1=(Child)ob.clone();//object cloning
		ob1.show();
		System.out.println(ob.equals(ob1));//true since equlas overrided.equals checks content
		System.out.println(ob==ob1);//== checks same reference or not
	}
	public boolean equals(Object e)//overriding equals method
	{
		Child ob=(Child)e;
		if(ob.id==id)
		{
			return true;
		}
		else
			return false;
		
	}
}

