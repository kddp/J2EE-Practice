package com.uttara;

public class Node 
{
	private int next;
	private int value;
	public Node(int val)
	{
		this.value = val;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
