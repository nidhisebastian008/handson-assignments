public class Tax
{
	public static void main(String[]x)
	{
		int a=Integer.parseInt(x[1]);
		switch(x[0])
		{
			case "kar":
			System.out.println(a+(10*a)/100);
			break;
			case "del":
			System.out.println(a+(9.5*a)/100);
			break;
			case "tamil":
			System.out.println(a+(5*a)/100);
			break;
			
}

				
			
		

	
	}
}