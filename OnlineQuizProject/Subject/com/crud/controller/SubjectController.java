package com.crud.controller;

import java.util.List;

//import com.crud.model.Student;
import com.crud.model.Subject;
import com.crud.service.SubjectService;

public class SubjectController {
	
	SubjectService subService = new SubjectService();
	
	public int insertRecord(Subject subject) {
		
		int result=0;
		result=subService.insertRecord(subject);
		return result;
		
	}

	
	public int updateRecord(Subject subject) {
		int result=subService.updateRecord(subject);
		return result;
	}

	
	public int deleteRecord(int subjectId) {
		
		int result=subService.deleteRecord(subjectId);
		return result;
		
	}

	
	public List<Subject> getAllRecords() {
		
		List<Subject> list=subService.getAllRecords();
		return list;
		
	}

	
	public Subject getSubjectById(int subjectId) {
		Subject subject=subService.getSubjectById(subjectId);
		return subject;
		
	}

}
