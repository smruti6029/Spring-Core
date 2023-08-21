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
		ArrayList<String> showSubject = showSubject();

		if (student != null) {

			List<StudentResult> AllSubresult = resultDao.getresultByStudent(student.getId());
		


			for(String str:showSubject)
			{
			String sub = str;
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
	public ArrayList<String> showSubject() throws IOException
	{
		List<Subject> allSubject = subjectDao.getAllSubject();
		ArrayList<String> subject=new ArrayList<>();
		for(Subject s:allSubject)
		{
			System.out.println(s.getSubject());
			System.out.println("Enter yes to Recheck No to Not Recheck");
			String readLine = bf.readLine();
			if(readLine.equalsIgnoreCase("yes"))
			{
				subject.add(s.getSubject());
			}
		}
		return subject;
		
	}

}
