//package com.quiz.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.crud.controller.AdminController;
import com.crud.controller.SubjectController;
import com.crud.model.Admin;
import com.crud.model.Subject;
import com.quiz.controller.ScoreController;
import com.quiz.model.QuizScore;

import crud.model.Teacher;
import crud.model.TeacherController;

public class Main {
	
	public static void ScoreCRUD() {
		ScoreController scorectl = new ScoreController();
        int result;
        QuizScore quizscore = null;
        int studentid;
        int testid = 0;
        int teacherid = 0;
        int score;
        int choice;
        while(true)
        {
        	System.out.println("1. Add Score");
    		System.out.println("2. Update Score");
    		System.out.println("3. Delete Score");
    		System.out.println("4. View All Scores");
    		System.out.println("5. View a Student Mark");
    		System.out.println("0. Exit ");
    		Scanner sc = new Scanner(System.in);
    		System.out.println("Enter your choice");
    		 choice = sc.nextInt();
    
        switch (choice) {
		case 1:
			System.out.println("Enter Student Id, Test Id, Teacher Id, Score");
			studentid = sc.nextInt();
			testid=sc.nextInt();
			teacherid=sc.nextInt();
			score=sc.nextInt();
			quizscore = new QuizScore(studentid,testid,teacherid,score);
			result = scorectl.insertScore(quizscore);
			if (result > 0)
				System.out.println("Score Inserted");
			else
				System.out.println("Score not inserted");
			break;
			
		case 2:
			System.out.println("Enter Student Id, Test Id, Teacher Id, Score");
			studentid = sc.nextInt();
			testid=sc.nextInt();
			teacherid=sc.nextInt();
			score=sc.nextInt();
			quizscore = new QuizScore(studentid,testid,teacherid,score);
			result = scorectl.updateScore(quizscore);
			if (result > 0)
				System.out.println("Score Updated");
			else
				System.out.println("Score not Updated");
			break;
		case 3:
			System.out.println("Enter Studentid");
			studentid=sc.nextInt();
			result=scorectl.deleteScore(studentid);
			if (result > 0)
				System.out.println("Score deleted");
			else
				System.out.println("Score not found");
			break;
			
		case 4:
			
			List<QuizScore> list=scorectl.getAllScores();
			for(QuizScore qs : list){
				System.out.println(qs.getStudentid()+"\t"+qs.getTestid()+" "+qs.getTeacherid()+" "+qs.getScore());
			}
		break;
		case 5:
			System.out.println("Enter studentid");
			studentid=sc.nextInt();
			quizscore=scorectl.getScoreByStudentId(studentid);
			System.out.println("Student ID: "+ quizscore.getStudentid());
			System.out.println("Test ID: "+ quizscore.getTestid());
			System.out.println("Teacher ID: "+ quizscore.getTeacherid());
			System.out.println("Score: "+ quizscore.getScore());
			
		break;	
		case 0: System.exit(0);
		
       
	}
        }
	}
	
	
	//subject
	
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
	
	
	//Admin
	public static void AdminCRUD() {
	AdminController adminctrl = new AdminController();
	int result;
	Admin admin = null;
	int id;
	String name;
	Date dob = null;
	String email;
	int phone;
	String address;
	int choice;
	// Crud Operation Menu
	while(true){
	System.out.println("1. Add Record");
	System.out.println("2. Update Record");
	System.out.println("3. Delete Record");
	System.out.println("4. View Records");
	System.out.println("5. View a Record");
	System.out.println("0. Exit ");
	System.out.println("**********************************");
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter your choice");
	 choice = sc.nextInt();
	
	switch (choice) {
	case 1:
		System.out.println("Enter id, name, dob , email , phone ,address");
		id = sc.nextInt();
		sc.nextLine();
		name = sc.nextLine();
		try {
			dob = new SimpleDateFormat("yyyy-MM-dd").parse(sc.nextLine());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		email=sc.nextLine();
		//sc.nextLine();
		phone=sc.nextInt();
		sc.nextLine();
		address=sc.nextLine();
		

		admin = new Admin(id, name, dob, email , phone ,address);
		result = adminctrl.insertRecord(admin);
		if (result > 0)
			System.out.println("Record Inserted");
		else
			System.out.println("Record not inserted");
		break;
	case 2:
		System.out.println("Enter rollno, name, dob, email , phone ,address");
		id = sc.nextInt();
		sc.nextLine();
		name = sc.nextLine();
		try {
			dob = new SimpleDateFormat("yyyy-MM-dd").parse(sc.nextLine());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		email=sc.nextLine();
		phone=sc.nextInt();
		sc.nextLine();
		address=sc.nextLine();

		admin = new Admin(id, name, dob, email , phone ,address);
		result = adminctrl.insertRecord(admin);
		result = adminctrl.updateRecord(admin);
		if (result > 0)
			System.out.println("Record updated");
		else
			System.out.println("Record not found");
		break;

	case 3:
		System.out.println("Enter id");
		id = sc.nextInt();
		result = adminctrl.deleteRecord(id);
		if (result > 0)
			System.out.println("Record deleted");
		else
			System.out.println("Record not found");
		break;
	case 4:
		List<Admin> list=adminctrl.getAllRecords();
		System.out.println("AdminID"+"\t"+"Name"+"\t\t"+"DOB"+"\t\t"+"EMAIL"+"\t\t\t\t"+"PHONE_NO"+"\t\t"+"ADDRESS");
		System.out.println("********************************************************************************************************");
		for(Admin admin1 : list){
			//System.out.println("AdminID"+"\t"+"Name"+"\t\t"+"DOB"+"\t\t"+"EMAIL"+"\t\t\t\t"+"PHONE_NO"+"\t\t"+"ADDRESS");
			System.out.println(admin1.getId()+"\t"+admin1.getAdminname()+"\t"+admin1.getDob()+"\t"+admin1.getEmail()+"\t"+admin1.getPhone()+"\t"+admin1.getAddress());
		}
	break;
	
	case 5:
		System.out.println("Enter id");
		id=sc.nextInt();
		admin=adminctrl.getAdminById(id);
		System.out.println("Id="+admin.getId());
		System.out.println("name="+admin.getAdminname());
		System.out.println("DOB="+admin.getDob());
		System.out.println("EMAIL="+admin.getEmail());
		System.out.println("PHONE_NO="+admin.getPhone());
		System.out.println("ADDRESS="+admin.getAddress());
		break;
	case 0: System.exit(0);

	}
	}
	}
	
	public static void TeacherCRUD() {
		TeacherController teacherctrl = new TeacherController();
		int result;
		Teacher teacher = null;
		int tid;
		String name;
		String email;
		int phoneno;
		int choice;
		
		while(true){
		System.out.println("1. Add Record");
		System.out.println("2. Update Record");
		System.out.println("3. Delete Record");
		System.out.println("4. View Records");
		System.out.println("5. View a Record");
		System.out.println("0. Exit ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice");
		 choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("Enter tid, name, email, phoneno");
			tid = sc.nextInt();
			sc.nextLine();
			name = sc.nextLine();
		    email=sc.nextLine();
		    phoneno=sc.nextInt();

			teacher = new Teacher(tid, name, email, phoneno);
			result = teacherctrl.insertRecord(teacher);
			if (result > 0)
				System.out.println("Record Inserted");
			else
				System.out.println("Record not inserted");
			break;
		case 2:
			System.out.println("Enter tid, name, email, phoneno");
			tid = sc.nextInt();
			sc.nextLine();
			name = sc.nextLine();
			email=sc.nextLine();
			phoneno=sc.nextInt();
			
			teacher = new Teacher(tid, name, email, phoneno);
			result = teacherctrl.insertRecord(teacher);
			result = teacherctrl.updateRecord(teacher);
			if (result > 0)
				System.out.println("Record updated");
			else
				System.out.println("Record not found");
			break;

		case 3:
			System.out.println("Enter tid");
			tid = sc.nextInt();
			result = teacherctrl.deleteRecord(tid);
			if (result > 0)
				System.out.println("Record deleted");
			else
				System.out.println("Record not found");
			break;
		case 4:
			List<Teacher> list=teacherctrl.getAllRecords();
			for(Teacher teac : list){
				System.out.println(teac.getTid()+"\t"+teac.getName()+" "+teac.getEmail()+" "+teac.getPhone_no());
			}
		break;
		
		case 5:
			System.out.println("Enter tid");
			tid=sc.nextInt();
			teacher=teacherctrl.getTeacherByid(tid);
			System.out.println("Tid="+teacher.getTid());
			System.out.println("name="+teacher.getName());
			System.out.println("email="+teacher.getEmail());
			System.out.println("Phoneno="+teacher.getPhone_no());
			break;
		case 0: System.exit(0);
	}
		}
	}
        
      
        
	
	public static void main(String[] args) throws Exception {
       
			
		
		System.out.print("Enter a choice: ");
		
		Scanner sc = new Scanner(System.in); 
		  int a=sc.nextInt();
		  
		  
		  if(a==1) { 
			  ScoreCRUD(); 
		}
		  
		  else if(a==2) {
			  subjectCRUDoperation();
		  }
		  else if(a==3) {
			  AdminCRUD();
		  }
		  else if(a==4) {
			  TeacherCRUD();
		  }
		 
       
       
        
	}
	

   }
