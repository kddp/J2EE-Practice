import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import com.uttara.LengthComparator;


public class Outer
{
	public static void main(String [] args)
	{
		LengthComparator l = new LengthComparator();
		Set<String> al = new TreeSet<String>(l);
		
		al.add("Abhishek");
		al.add("Abhishek");
		al.add("Abhishek");
		al.add("Abhishek");
		al.add("Gaurav");
		al.add("Golu");
	
		System.out.println(al);
		
		
		
	}
	
}
