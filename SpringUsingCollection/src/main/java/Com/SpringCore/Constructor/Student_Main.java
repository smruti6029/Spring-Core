package Com.SpringCore.Constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Student_Main {

	public static void main(String[] args) {
		
			ApplicationContext cont=new ClassPathXmlApplicationContext("constructor.xml");
			Student student=(Student) cont.getBean("Constructor");
			
			System.out.println(student);
			
	}

}
