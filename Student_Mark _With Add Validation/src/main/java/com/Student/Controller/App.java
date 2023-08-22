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
import com.Student.Service.ReachingByStudent;
import com.Student.Service.SeeallRechecking;
import com.Student.Service.UpdateStudentMark;



	public class App {
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        System.out.println("If you are Admin, enter 1");
	        System.out.println("If you are Student, enter 2");
	        try
	        {
	        int userType = Integer.parseInt(br.readLine());

	        if (userType == 1) {
	            adminMenu(br);
	        } else if (userType == 2) {
	            studentMenu(br);
	        } else {
	            System.out.println("Invalid Input");
	        }
	        }
	        catch (NumberFormatException e) {
	        	System.out.println("Enter Valid Input");
				
			}
	    }

	    private static void adminMenu(BufferedReader br) throws IOException {
	        while (true) {
	            System.out.println("Enter 1 to Save Student");
	            System.out.println("Enter 2 to Add Result");
	            System.out.println("Enter 3 ReCheck And Update");
	            System.out.println("Enter 4 to Show All Data");
	            System.out.println("Enter 5 to Exit");
	            try
	            {
	            int input = Integer.parseInt(br.readLine());

	            switch (input) {
	                case 1:
	               InputStudent obj=new InputStudent();
	                	obj.inputStudent();
	                    break;
	                case 2:
	                    AddResult addResult = new AddResult();
	                    addResult.addStudentWiseResult();
	                    break;
	                case 3:
	                    SeeallRechecking seeallRechecking = new SeeallRechecking();
	                    seeallRechecking.updateRequest();
	                    break;
	                case 4:
	                    GetAllStudentGrade getAllStudentGrade = new GetAllStudentGrade();
	                    getAllStudentGrade.getAllStudentMark();
	                    break;
	                case 5:
	                    return; // Exit the loop
	                default:
	                    System.out.println("Invalid Input");
	                    break;
	            }
	            }
	            catch(Exception e)
	            {
//	            	System.out.println("Invalid Input ");
	            	e.printStackTrace();
	            }
	            }
	        }
	    

	    private static void studentMenu(BufferedReader br) throws IOException {
	        while (true) {
	            System.out.println("Enter 1 for Mark Checking");
	            System.out.println("Enter 2 for Rechecking");
	            System.out.println("Enter 3 for Exit");
	            try
	            {
	            int input = Integer.parseInt(br.readLine());

	            switch (input) {
	                case 1:
	                    GetStudentMarksByGmail byGmail = new GetStudentMarksByGmail();
	                    System.out.println("Enter Gmail");
	                    String gmail = br.readLine();
	                    byGmail.getMarks(gmail);
	                    break;
	                case 2:
	                    System.out.println("Enter Gmail Id");
	                    String gmailId = br.readLine();
	                    ReachingByStudent reachingByStudent = new ReachingByStudent();
	                    reachingByStudent.reachingByStudent(gmailId);
	                    break;
	                case 3:
	                    return; // Exit the loop
	                default:
	                    System.out.println("Invalid Input");
	                    break;
	            }
	        }
	        
	        catch (NumberFormatException e) {
	        	
				System.out.println("Invalid Input");
			}
	        }
	    }
	}
