package test;

public class StringOperations {
	public static enum strop{concat};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		String param="key=Milestone;value=Received ;MileStoneDate;No_Pieces1;value=pcs";
		String result="";
		int n=param.split(";").length;
		for(i=1;i<n;i++)
		{
			String adder=param.split(";")[i].toString();
			if(adder.contains("value="))
			{
				adder=adder.split("=")[1].toString();
			}
			result=result+adder;
		}
		
		
		System.out.println("Final Result is");
		System.out.println(result);
	}

}
