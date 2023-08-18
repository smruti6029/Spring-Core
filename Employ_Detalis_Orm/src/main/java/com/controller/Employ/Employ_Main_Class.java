package com.controller.Employ;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Service.Employ.InsertData;
import com.employ.Dao.EmployDao;
import com.employ.Detalis.Entity.Employ;

import con.configuration.configuration;

public class Employ_Main_Class {
	public static void main(String[] args) throws Exception {
		
	
		InsertData obj=new InsertData();
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	while(true)
	{
		System.out.println("Enter 1 to add");
		System.out.println("Enter 2 to update by Id");
		System.out.println("Enter 3 to See data by id");
		System.out.println("Enter 4 to see all data");
		System.out.println("Enter 5 to delete by id");
		System.out.println("Enter 6 to exit");
		int input=Integer.parseInt(br.readLine());
		if(input==1)
		{
			obj.insertData();
		}
		if(input==2)
		{
			System.out.println("Enter ID to Update");
			int id=Integer.parseInt(br.readLine());
			obj.updateByID(id);
			
		}
		if(input==3)
		{
			System.out.println("Enter ID to Update");
			int id=Integer.parseInt(br.readLine());
			
			System.out.println(obj.seeByID(id));
		}
		if(input==4)
		{

			List<Employ> allEmployes = obj.getAllEmploy();
			allEmployes.forEach(v -> System.out.println(v));
			
			
		}
		if(input==5)
		{
			System.out.println("Enter ID to Update");
			int id=Integer.parseInt(br.readLine());
			obj.deleteByid(id);
			System.out.println("Delete Successfully");
		}
		
		
		
		
		
		
		
		
		
		
		if(input==6)
		{
			break;
		}
	}
	
	}
	

}
