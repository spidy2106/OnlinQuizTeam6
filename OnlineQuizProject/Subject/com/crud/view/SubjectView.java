package com.crud.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.crud.controller.SubjectController;


import com.crud.model.Subject;

public class SubjectView {
	
	public static void subjectCRUDoperation() {
		String cont;
		
		do{
		System.out.println("***********************subject Management**********************");
		System.out.println(" 1. Add Record");
		System.out.println("2. Update Record");
		System.out.println("3. Delete Record");
		System.out.println("4. View Records");
		System.out.println("5. View a Record");
		System.out.println("************************************************************************");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your choice");
		int choice =sc.nextInt();
		
		SubjectController subjectctrl=new SubjectController();
		Subject subject;
		int subjectId;
		String subjectName;
		
		int result;
		switch(choice){
		case 1: 
			System.out.println("Enter Subject Id,  subjectName");
			subjectId=sc.nextInt();sc.nextLine();
			subjectName=sc.nextLine();
			
			subject=new Subject(subjectId, subjectName);
			 result=subjectctrl.insertRecord(subject);
			
			 if(result>0)
				System.out.println("Record Inserted");
			else
				System.out.println("Record not inserted");
			break;
			
			
		case 2:
			System.out.println("Enter subjectId, subjectName");
			
			subjectId=sc.nextInt();sc.nextLine();
			subjectName=sc.nextLine();
			
			
			subject=new Subject(subjectId,subjectName);
			
			result=subjectctrl.updateRecord(subject);
			if(result>0)
				System.out.println("Record Updated");
			else
				System.out.println("Record not Updated");
			break;
			
		case 3:
			System.out.println("Enter subjectId");
			subjectId=sc.nextInt();
			result=subjectctrl.deleteRecord(subjectId);
				if(result>0)
					System.out.println("Record Deleted");
				else
					System.out.println("Record not Deleted");
			break;
		
		case 4:
			List<Subject> list=subjectctrl.getAllRecords();
			if(list==null)
				System.out.println("No Record found");
			else{
			for(Subject stud : list){
				System.out.println(stud.getSubjectId()+"\t"+stud.getSubjectName());
			}
			}
			break;
		case 5:
			System.out.println("Enter subjectId");
			subjectId=sc.nextInt();
			subject=subjectctrl.getSubjectById(subjectId);
			if(subject==null)
				System.out.println("Record not found");
			else{
					System.out.println("subjectId="+subject.getSubjectId());
					System.out.println("subjectName="+subject.getSubjectName());
					
				}
			break;
		default: System.out.println("Wrong option");
		}
		System.out.println("Want to perform next operation? ");
		 cont=sc.next();
		}while(cont.equalsIgnoreCase("y"));
	}

	public static void main(String[] args) throws Exception{
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Press one for Subject Crud operation");
		int ans=sc.nextInt();
		
		if(ans==1) {
			subjectCRUDoperation();
		}
		
	}

		
		

	

}