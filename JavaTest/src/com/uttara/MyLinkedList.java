package com.uttara;

public class MyLinkedList 
{
	private Node first;
	private Node last;
	private int count;
	
	public void add(int val)
	{
		Node n = new Node(val);
		if((first==last)&& first ==null)
		{
			first=last=n;
			count++;
		}
		else
		{
			last.setNext(n);
			last=n;
			count++;
		}
	}
	
	public void printValues()
	{
		Node temp= first;
		for (int i = 0; i < count; i++) 
		{
			System.out.println("val at pos "+i+" = "+temp.getValue());
			temp=temp.getNext();
		}
	}
	
	public boolean search(int val)
	{
		Node temp  = first;
		for(int i=0;i<count;i++)
		{
			if(temp.getValue()==val)
				return true;
			else
				temp=temp.getNext();
		}
		return false;
	}
	
	public int size()
	{
		return count;
	}
	
	public boolean remove(int val)
	{
		Node temp=first;
		Node prev=null;
		for(int i=0;i<count;i++)
		{
			if(temp.getValue()==val)
			{
				if(first==temp)
				{
					first=temp.getNext();
					temp.setNext(null)
					count--;
					break;
				}
				else
				{
					if(temp.getNext()!=null)
						prev.setNext(temp.getNext());
					temp.setNext(null);
					count--;
					break;
				}
			}
			else
			{
				prev =temp;
				temp = temp.getNext()
			}
			return false;
		}
	}
	
	public MyLinkedList sublist(int from,int to)
	{
		if(from>count || to>count)
			throw new IllegalArgumentException();
		MyLinkedList ll = new MyLinkedList();
		for(int i=from;i<to;i++)
		{
			ll.add(this.getVal(i));
		}
		return ll;
	}
	
	public MyLinkedList reverse()
	{
		if(count>0)
		{
			MyLinkedList ll = new MyLinkedList();
			for(int i=count-1;i>=0;i--)
			{
				ll.add(this.getVal(i));
			}
			return ll;
		}
		else
			return null;
	}
}