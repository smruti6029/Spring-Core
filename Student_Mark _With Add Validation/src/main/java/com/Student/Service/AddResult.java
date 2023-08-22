package com.Student.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Student.DAO.Result_DAO;
import com.Student.DAO.Student_DAO;
import com.Student.DAO.Subject_DAO;
import com.Student.Entity.Student;
import com.Student.Entity.StudentResult;
import com.Student.Entity.Subject;
import com.Student.configu.JavaConfiguration;

public class AddResult {

	ApplicationContext con = new AnnotationConfigApplicationContext(JavaConfiguration.class);
	Result_DAO resultDao = con.getBean("result_dao", Result_DAO.class);
	Student_DAO studentDao = con.getBean("studentDao", Student_DAO.class);
	Subject_DAO subjectDao = con.getBean("subjectDao", Subject_DAO.class);
	
	

	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public void addStudentWiseResult() throws IOException {
		try
		{

		int flag = 1;
		boolean vallidUser = true;
		List<Subject> subject = subjectDao.getAllSubject();
	
		System.out.println("Enter Student gmail");
		String gmail = bf.readLine();
		Student student = studentDao.getBygmail(gmail);

		List<StudentResult> allStudentResult = resultDao.getAll();
		if(allStudentResult!=null)
		{
		for (StudentResult student_res : allStudentResult) {
			if (student_res.getStudent().getId() == student.getId()) {

				vallidUser = false;
				break;
			} else {
				vallidUser = true;
				System.out.println(vallidUser);
				break;
			}
		}

		if (vallidUser) {
			ArrayList<StudentResult> studentmarks = new ArrayList();
			if (student != null) {

				for (Subject s : subject) {
					System.out.println(s.getSubject());
					System.out.println("Enter Marks");
					int marks = Integer.parseInt(bf.readLine());
					if (marks > 0 && marks < 100) {
						StudentResult obj = new StudentResult();
						obj.setMarks(marks);
						obj.setStudent(student);
						obj.setSubject(s);
						studentmarks.add(obj);
					} else {
						System.out.println("Enter again");
						flag = 0;
						break;
					}

				}
			}
			if (flag != 0) {
				resultDao.addResult(studentmarks);
			}
		}

		else {
			System.out.println("Mark already  added For This Student");
		}
	}
		}
		catch (NumberFormatException e) {
			System.out.println("Enter Valid Input");
		}
			
		}
	}


