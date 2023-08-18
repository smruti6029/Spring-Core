package com.Student.Service;

import java.io.BufferedReader;
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
import com.Student.configu.JavaConfiguration;
import com.Student.utility.StudentGrade;

public class GetStudentMarksByGmail {

	ApplicationContext con = new AnnotationConfigApplicationContext(JavaConfiguration.class);
	Result_DAO resultDao = con.getBean("result_dao", Result_DAO.class);
	Student_DAO studentDao = con.getBean("studentDao", Student_DAO.class);
	Subject_DAO subjectDao = con.getBean("subjectDao", Subject_DAO.class);

	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public void getMarks(String gmail) {

		Student student = studentDao.getBygmail(gmail);
		if(student!=null)
		{

		List<StudentResult> AllSubresult = resultDao.getresultByStudent(student.getId());
		ArrayList<Integer> marks = new ArrayList();
		int mark = 0;

		if (AllSubresult != null) {

			for (StudentResult res : AllSubresult) {
				mark += res.getMarks();
				marks.add(res.getMarks());
			}
			double percentage = mark / 6;
			String Grade = StudentGrade.calculateGrade(percentage, marks);
			System.out.println("______________________________________");
			System.out.println("Name Of The Student :-" + student.getName());
			System.out.println("gmail Of the Student :-" + student.getEmail());
			System.out.println("Student Roll No :" + student.getId());
			
			System.out.println("_________________________________________");

			AllSubresult.forEach(rs -> {
				System.out.println(rs.getSubject().getSubject());
				System.out.println("Marks" + rs.getMarks());
				System.out.println("--------------------------");

			});
			System.out.println("Total Marks :-" + mark);
			System.out.println("Grade :-" + Grade);
			System.out.println("Percentage :-" + percentage);
			System.out.println("------------------------");

		} else {
			System.out.println("Invalid Credentials");
		}
		}
		else
		{
			System.out.println("invalid Email");
			System.out.println("Try Again");
		}
	}

}
