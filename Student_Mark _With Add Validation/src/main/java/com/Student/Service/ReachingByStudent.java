package com.Student.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Student.DAO.Result_DAO;
import com.Student.DAO.Student_DAO;
import com.Student.DAO.Subject_DAO;
import com.Student.Entity.Student;
import com.Student.Entity.StudentResult;
import com.Student.Entity.Subject;
import com.Student.configu.JavaConfiguration;
import com.Student.utility.StudentGrade;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class ReachingByStudent {

	ApplicationContext con = new AnnotationConfigApplicationContext(JavaConfiguration.class);
	Student_DAO studentDao = con.getBean("studentDao", Student_DAO.class);
	Subject_DAO subjectDao = con.getBean("subjectDao", Subject_DAO.class);
	Result_DAO resultDao = con.getBean("result_dao", Result_DAO.class);

	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public void reachingByStudent(String gmailId) throws NumberFormatException, IOException {

		Student student = studentDao.getBygmail(gmailId);
		ArrayList<String> showSubject = showSubject(student);

		if (student != null) {

			List<StudentResult> AllSubresult = resultDao.getresultByStudent(student.getId());

			for (String subject_name : showSubject) {
				String sub = subject_name;
				int subject_id = 0;
				int resId = 0;

				for (StudentResult v : AllSubresult) {

					if (v.getSubject().getSubject().equalsIgnoreCase(sub)) {
						resId = v.getId();
						subject_id = v.getSubject().getId();
					}
				}

				Subject subject = subjectDao.get(subject_id);
				if (subject != null) {

					StudentResult resultId = resultDao.getResultId(resId);

					StudentResult obj = new StudentResult();
					obj.setId(resultId.getId());
					obj.setStudent(student);
					obj.setSubject(subject);
					resultDao.update(obj);
				} else {
					System.out.println("Try again");
				}

			}
		}
	}

	public ArrayList<String> showSubject(Student student) throws IOException {
		List<Subject> allSubject = subjectDao.getAllSubject();
		ArrayList<String> list=new ArrayList<>();
		
		List<StudentResult> AllSubresult = resultDao.getresultByStudent(student.getId());
					
				for(StudentResult x:AllSubresult)
				{
					try
					{
						if(x.get_Is_active()==false)
						{
							list.add(x.getSubject().getSubject());
						}
					}
					catch (Exception e) 
					{
						
					}
				}
				
//				list.forEach(v ->{
//					System.out.println("Inside List "+v);
//				});
		
		
		
		
		
		ArrayList<String> subject = new ArrayList<>();
		
		for (Subject s : allSubject) {
			System.out.println(s.getSubject());
			System.out.println("Enter yes to Recheck No to Not Recheck");
			String readLine = bf.readLine();
			
			
			
			if (readLine.equalsIgnoreCase("yes")) {
				
				Boolean check=true;
				for(StudentResult x:AllSubresult)
				{
					if(x.getSubject().getSubject().equalsIgnoreCase(s.getSubject()))
					{
						check=x.get_Is_active();
						System.out.println("Test   "+check);
					}
					
				}
					
					if(check==null)
					{
					subject.add(s.getSubject());
					System.out.println("You Have Selected " + s.getSubject());
					}
					
					else if(check==true)
					{
						System.out.println("Already - Processing Your Subject To recheck -  " + s.getSubject());
					}
					else
					{
						System.out.println("Already Apply For it ");
					}
				
			}
		}
		return subject;

	}

}
