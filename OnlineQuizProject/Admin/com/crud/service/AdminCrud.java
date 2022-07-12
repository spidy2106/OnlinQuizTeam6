package com.crud.service;

import java.util.List;

import com.crud.model.Admin;

public interface AdminCrud {

	

		int insertRecord(Admin admin);
		int updateRecord(Admin admin);
		int deleteRecord(int id);
		Admin getAdminById(int id);
		List<Admin> getAllRecords();
		
		
	

}
