package rft;

public  class Test implements Cloneable{
	static int b;
	int data=10;
	Test(String ab,int id)
	{
		System.out.println(ab+" ");
	}
	void show()
	{
		System.out.println("invoked");
	}
	void display(Test ob1)
	{
		data=ob1.data+50;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		
		//System.out.println("superb");
		
		/*System.out.println(b);
		
		Test ob=new Test("abc",1);
		Test ob1=(Test)ob.clone();//object cloning
		ob1.show();
		ob1.display(ob1);//call by value method by passing object
		System.out.println(ob1.data);
		System.out.println(ob.data);*/
		
		String a="levin";
		a="0"+a;
		System.out.println(a);
	}

}
