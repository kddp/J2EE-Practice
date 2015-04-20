
public class TriTest 
{
	public static void main(String[] args) 
	{
		int a = 101;
		int b = (a/2)+1;
		int c = (a/2)+1;
		
		for(int i=1;i<=(a/2)+1;i++)
		{
			for(int j=1;j<=a;j++)
			{
				if(j<=b && j>=c)
				{
					System.out.print("*");
				}
				else
				{
					System.out.print(" ");
				}
			}
			b=b+1;
			c=c-1;
			System.out.println();
		}
		
	}

}
