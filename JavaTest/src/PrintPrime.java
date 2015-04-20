import java.util.HashMap;
import java.util.Map;

public class PrintPrime {

	public static void main(String[] args)
	{
		int num =20;
		for(int i=1;i<num;i++)
		{
			boolean isPrime = true;
			for(int j=2;j<i;j++)
			{
				if(i%j==0)
				{
					isPrime=false;
					break;
				}
			}
			if(isPrime)
				System.out.println(i+" is Prime");

	}
	}
}

