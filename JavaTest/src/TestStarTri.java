import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestStarTri
{

	/*public static void main(String[] args)
	{
		int a = 21;
		int b = (a+1)/2;
		int c = (a+1)/2;
		for(int i=0;i<(a+1)/2;i++)
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
			System.out.println(" ");
		}
	}


	public static void main(String [] args)
	{
		List<String> al = new ArrayList();
		al.add("asdsd");
		System.out.println(al);
		int num = 1_00_000;
		System.out.println(num);
	}*/

	public static void main(String [] args)
	{
		CharSequence email="nfffefref56546^#ag@gmail.com";
		String regex = "[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}";

		Pattern p = Pattern.compile(regex );
		Matcher m = p.matcher(email);

		if(m.find())
		{
		  System.out.println(email + " is a valid email address.");
		}
		else
		{
		  System.out.println(email + " is a invalid email address");
		}
	}

}
