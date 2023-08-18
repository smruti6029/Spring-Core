package com.Collection;

import java.util.List;
import java.util.ListIterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	ApplicationContext context=new ClassPathXmlApplicationContext("Collection.xml");
    	EmployENtity CollectionExample = (EmployENtity) context.getBean("Emp1");
    	System.out.println(CollectionExample);
    	
    	List<String> list=CollectionExample.getPhone();
    	ListIterator<String> itrator=list.listIterator();
    	while(itrator.hasNext())
    	{
    		System.out.println("phone"+itrator.next());
    	}
    	
    	list.toString();
//    	list.forEach(System.out::println);
    	
    }
}
