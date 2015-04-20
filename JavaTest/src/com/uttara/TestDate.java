package com.uttara;



public class TestDate {

	public static void main(String[] args) 
	{
		/*Date dt = new Date();
		//System.out.println("Current Date =>"+dt);
		DateFormat f = new SimpleDateFormat("hh:mm:ss a E dd-MM-yyyy");
		String myDate = f.format(dt);
		System.out.println("After Formating date is =>"+myDate);
	*/
		
		//Java Program to Sort the elements in Array
		
		int [] nums = {25,65,5,89,14,6,87};
		int temp;
		System.out.println("Length of the Array => "+nums.length);
		int l = nums.length;
		for(int i=0;i<l-1;i++)
			for(int j=0;j<l-i-1;j++)
			{
				if(nums[j]<nums[j+1])
				{
					temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;		
				}
			}
		for(int n :nums)
		{
			System.out.print(" "+n);
		}
	}

}
