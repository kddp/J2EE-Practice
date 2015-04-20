

public class Box 
{
	/*public static int findFactorial(int num)
	{
		if(num>1)
		{
			int n = num * findFactorial(num-1);
			return n;
		}
		else
		{
			return 1;
		}
	}
	public static void main(String[] args)
	{
		int a = 10;
		int b = 6;
		System.out.println("1st Number => "+a+" 2nd Number => "+b);
		a = a + b;
		b = a - b; 
		a = a - b;
		System.out.println("1st Number => "+a+" 2nd Number => "+b);
	}
	
	public static void main(String[] args)
	{
		Float f = new Float(3.14f);
		short s = f.shortValue();
		System.out.println(s);
	}*/
	
	public static void main(String[] args)
	{
		//Program to Find LCM and HCF
		int a = 336;
		int b = 224;
		int p = a * b;
		int h = 1;
		for(int i=2;i<p;i++)
		{
			if((a%i==0)&&(b%i==0))
			{
				h = i;
			}
		}
		int l = p/h;
		System.out.println("HCF =>"+h+" LCM => "+l);
		
	}

}