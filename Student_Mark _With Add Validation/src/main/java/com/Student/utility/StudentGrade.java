package com.Student.utility;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value ="singleton")
final public class StudentGrade {

	public static String calculateGrade(double percentage, ArrayList<Integer> marks) {

		for (Integer m : marks) {if (m < 30) {return "F";}}
		
		double mark = percentage;
		if (mark > 30 && mark < 40) {
			return "D";
		} else if (mark >= 40 && mark <= 60) {
			return "C";
		} else if (mark >= 60 && mark <= 80) {
			return "B";
		} else if (mark >= 80 && mark <= 90) {
			return "A2";
		} else if (mark >= 80 && mark <= 100) {
			return "A1";
		} else {

			return "F";
		}

	}

}
