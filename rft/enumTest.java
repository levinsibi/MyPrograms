package rft;

class enumTest
{
	enum modules{
		etracking(60),fwb(10),recco(50);
	
	int count;
		modules(int count)
	{
		this.count=count;
	}
		
	}
	

	public static void main(String[]args)
	{
		for(modules m:modules.values())
		{
			System.out.println("module "+m+" count is"+m.count);
		}
	}
}

