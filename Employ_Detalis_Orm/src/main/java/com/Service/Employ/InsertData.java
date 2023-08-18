package com.Service.Employ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.employ.Dao.EmployDao;
import com.employ.Detalis.Entity.Employ;

import con.configuration.configuration;

public class InsertData {
	
	ApplicationContext con=new AnnotationConfigApplicationContext(configuration.class);
	EmployDao dao=con.getBean("employdao",EmployDao.class);
	
	public void insertData() throws NumberFormatException, IOException
	{
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Employ Name :");
		System.out.println("Enter Employ  ID :");
		System.out.println("Enter Employ Phone No: ");
		String name=br.readLine();
		int id=Integer.parseInt(br.readLine());
		String phone=br.readLine();
		Employ emp=new Employ(id,name,phone);
		dao.insert(emp);
		
	}

	public void updateByID(int id) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Employ Name :");
		System.out.println("Enter Employ Phone No: ");
		String name=br.readLine();
		String phone=br.readLine();
		Employ emp=new Employ(id,name,phone);
		dao.update(emp);
		
		
	}

	public List<Employ> getAllEmploy() {
		List<Employ> employes = dao.getAll();
		return employes;
		
	}

	public Employ seeByID(int id) {
		Employ id2 = dao.getId(id);
		return id2;
		
		
	}

	public void deleteByid(int id) {
		dao.delete(id);
		
	}

	 

}
