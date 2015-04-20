import java.util.*;

public class TestOccur 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Num to check =>");
		int num = sc.nextInt();
		boolean isPrime=true;
		for(int i=2;i<num;i++)
		{
			if(num%i==0)
			{
				isPrime=false;
				break;
			}
		}
		if(isPrime)
			System.out.println(num+" is Prime");
		else
			System.out.println(num+" is Not prime");
	}

}
