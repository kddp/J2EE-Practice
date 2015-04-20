package com.uttara;

class BingoThread extends Thread
{
	public void run() 
	{
		System.out.println("inside BingoThread run()");
	}
}

public class Dog
{
	public static void main(String[] args) 
	{
		BingoThread bt = new BingoThread();
		//Thread t = new Thread(bt);
		bt.start();
		bt.run();
		bt.run();
		bt.run();
		bt.run();
		bt.start();
		//bt.start();
		System.out.println("inside main thread");
	}
}