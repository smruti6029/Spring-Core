package com.Student.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Student.DAO.Result_DAO;
import com.Student.DAO.Student_DAO;
import com.Student.DAO.Subject_DAO;
import com.Student.Entity.Student;
import com.Student.Entity.StudentResult;
import com.Student.configu.JavaConfiguration;
import com.Student.utility.StudentGrade;

public class GetAllStudentGrade {
	ApplicationContext con = new AnnotationConfigApplicationContext(JavaConfiguration.class);
	Result_DAO resultDao = con.getBean("result_dao", Result_DAO.class);
	
	@Autowired
	public StudentGrade studentGrade;

	public void getAllStudentMark() {

		List<StudentResult> allStudent = resultDao.getAll();
		
		Map<String, Map<String, Integer>> student = new TreeMap<>();
		
		Map<String, Integer> subject = new HashMap<>();

		for (StudentResult s : allStudent) {
			String subjectName = s.getSubject().getSubject();
			int marks = s.getMarks();

			if (student.containsKey(s.getStudent().getName())) {

				Map<String, Integer> existingSubjectMarks = student.get(s.getStudent().getName());

				existingSubjectMarks.put(subjectName, marks);
			} else {

				Map<String, Integer> newSubjectMarks = new HashMap<>();
				newSubjectMarks.put(subjectName, marks);

				student.put(s.getStudent().getName(), newSubjectMarks);
			}
		}

		for (String StudentName : student.keySet()) {
			double mark = 0;
			ArrayList<Integer> allMarks = new ArrayList<>();
			
			
			Map<String, Integer> map = student.get(StudentName);
			System.out.println("______________________________________________");
			System.out.println("Name     :-  " + StudentName);
			System.out.println("                     ");
			for (String sub : map.keySet()) {
				System.out.println("Subject  -  " + sub + " - Mark -  " + map.get(sub));
				System.out.println("........................................");
				mark += map.get(sub);
				allMarks.add(map.get(sub));
			}

			Double percentage = mark / 6;
			String calculateGrade = studentGrade.calculateGrade(percentage, allMarks);
			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			System.out.println("Grade -  " + calculateGrade + " \nPercentage -" + decimalFormat.format(percentage));
			System.out.println("_________________________________________________");
				
		}

	}

}
