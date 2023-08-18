package com.SpringCore.Ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsingRefernce {
	
	public static void main(String[] args) 
	
	{
		
		ApplicationContext context =new ClassPathXmlApplicationContext("ref.xml");
		A a=(A)context.getBean("Ref2");
		
		System.out.println(a);
//		System.out.println(a.getObj().getAddress());
		
		
		
		
		
	}
						
	
	
	

}
