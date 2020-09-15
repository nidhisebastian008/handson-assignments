public class Result
{
	public static void main(String[]x)
	{
	for(int i=0;i<x.length;i++)
	{
		int mark=Integer.parseInt(x[i]);
		
		if(mark<0)System.out.println("Invalid MARKS");

		else
		{
		if(mark>=70)System.out.println("FIRST CLASS DIST");
		else if(mark>=60 && mark<70)System.out.println("FIRST CLASS");
		else if(mark>=50 && mark<60)System.out.println("SECOND CLASS ");
		else if(mark>=35 && mark<50)System.out.println("PASS");
		else System.out.println("FAIL");
		}
		
	}

}

}