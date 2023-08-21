package com.Student.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Student.DAO.Result_DAO;
import com.Student.DAO.Student_DAO;
import com.Student.Entity.Student;
import com.Student.Entity.StudentResult;
import com.Student.configu.JavaConfiguration;

public class UpdateStudentMark {

	ApplicationContext con = new AnnotationConfigApplicationContext(JavaConfiguration.class);
	Result_DAO resultDao = con.getBean("result_dao", Result_DAO.class);
	Student_DAO studentDao = con.getBean("studentDao", Student_DAO.class);

	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public void updateStudent(String mail) throws NumberFormatException, IOException {

		

		Student student = studentDao.getBygmail(mail);

		if (student != null) {

			List<StudentResult> AllSubresult = resultDao.getresultByStudent(student.getId());

			for (StudentResult result : AllSubresult) {
				if (result.get_Is_active() == true) {
					System.out.println(result.getSubject().getSubject());
					System.out.println(result.getMarks());
					StudentResult obj = new StudentResult();
					obj.setId(result.getId());
					obj.setIs_active(false);
					System.out.println("Enter Subject Mark");
					int mark = Integer.parseInt(bf.readLine());
					
					obj.setMarks(mark);
					resultDao.updateStudent(obj);

				}
			}

		} else {
			System.out.println("Student Not Present");
		}

	}
}
