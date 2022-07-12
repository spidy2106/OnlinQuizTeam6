package com.crud.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.crud.controller.AdminController;
import com.crud.model.Admin;

//import com.curd.controler.StudentController;
//import com.curd.model.Student;

public class AdminView {

	public static void main(String[] args) throws ParseException {
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
			dob = new SimpleDateFormat("yyyy-MM-dd").parse(sc.nextLine());
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
			dob = new SimpleDateFormat("yyyy-MM-dd").parse(sc.nextLine());
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

	

}
