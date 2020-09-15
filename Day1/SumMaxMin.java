public class SumMaxMin
{
	public static void main(String[]x)
	{
		int sum=0;int max=0;int min=Integer.parseInt(x[0]);
		for(int i=0;i<x.length;i++)
			{
				int a=Integer.parseInt(x[i]);
				sum+=a;
				if(max<a)max=a;
				if(min>a)min=a;
			}
		System.out.println("sum"+sum);
		System.out.println("max"+max);
		System.out.println("min"+min);

	
	}
}