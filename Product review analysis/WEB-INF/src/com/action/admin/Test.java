package com.action.admin;

import java.lang.reflect.Array;

public class Test
{
public static void main(String[] args) {
	
	int a[]={1,-1,-2,3};
	int temp=0;
	for(int i=0;i<a.length;i++)
	{
		temp=temp+a[i];
		System.out.println("tem :"+temp);
				
		
	}
	
	
	if(temp>2)
	{
		System.out.println("good review");
	}
	if(temp<-2)
	{
		System.out.println("bad review");
	}
}
}
