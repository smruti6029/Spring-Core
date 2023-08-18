package com.Student.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.Student.Service.AddResult;
import com.Student.Service.GetAllStudentGrade;
import com.Student.Service.GetStudentMarksByGmail;
import com.Student.Service.InputStudent;
import com.Student.Service.InputSubject;

public class App {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStudent obj = new InputStudent();
		InputSubject obj1 = new InputSubject();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("If you are Admin Enter 1");
		System.out.println("If you are Student Enter 2");

		int input1 = Integer.parseInt(br.readLine());

		if (input1 == 1) {
			while (true) {

				System.out.println("Enter 1 To Save Student");
//				System.out.println("Enter 2 for add subject");
				System.out.println("Enter 3 to Add Result");
				System.out.println("Enter 4 to show all data");
				System.out.println("enter 5 to exit");

				int input = Integer.parseInt(br.readLine());

				if (input == 1) {

					obj.inputStudent();

				}
//				if (input == 2) {
//					obj1.inputSubject();
//				}

				if (input == 3) {
					AddResult obj2 = new AddResult();
					obj2.addStudentWiseResult();
				}
				if (input == 4) {
					GetAllStudentGrade getAllStudentGrade = new GetAllStudentGrade();
					getAllStudentGrade.getAllStudentMark();
				}
					if (input == 5) {
						break;
					}

				}
			}

			if (input1 == 2) {

				GetStudentMarksByGmail byGmail = new GetStudentMarksByGmail();
				System.out.println("Enter Gmail");
				String gmail = br.readLine();
				byGmail.getMarks(gmail);
			}

			else {
				System.out.println("Enter Invalid Input");
			}

		}

	}

