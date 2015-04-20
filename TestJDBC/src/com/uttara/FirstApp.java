package com.uttara;

import java.util.Scanner;

public class FirstApp {

	public static void main(String[] args) {
		
		int choice=0;
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		while(choice!=4)
		{
			System.out.println("Enter 1 to Add Name");
			System.out.println("Enter 2 to Update Name");
			System.out.println("Enter 3 to Delete Name");
			System.out.println("Enter 4 to Exit");
			choice=sc1.nextInt();
			
			switch(choice)
			{
				case 1:
						System.out.println("inside 1");
						break;
				case 2:
						System.out.println("inside 2");
						break;
				case 3:
					System.out.println("inside 3");
						
					break;
				case 4:
					System.out.println("inside 4");
					
					break;
				default:
						System.out.println("Enter Valid Integer Input");
						break;				
			}

	}

	}
}
