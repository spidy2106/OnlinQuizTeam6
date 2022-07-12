package com.crud.controller;

import java.util.List;

import com.crud.model.Admin;
import com.crud.service.AdminService;

//import com.curd.model.Student;
//import com.curd.service.StudentService;

public class AdminController {

AdminService adminservice;
	
	public AdminController() {
		adminservice=new AdminService();
	}


	public int insertRecord(Admin admin) {
		int result=adminservice.insertRecord(admin);
		return result;
	}


	public int updateRecord(Admin admin) {
		
		int result=adminservice.updateRecord(admin);
		return result;
	}

	
	public int deleteRecord(int id) {
		
		int result=adminservice.deleteRecord(id);
		return result;
	}

	
	public List<Admin> getAllRecords() {
		
		List <Admin> list=adminservice.getAllRecords();
		return list;
	}

	
	public Admin getAdminById(int id) {
		
		Admin admin=adminservice.getAdminById(id);
		return admin;
	}
}
