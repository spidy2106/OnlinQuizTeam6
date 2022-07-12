package com.crud.service;

import java.util.List;

import com.crud.model.Subject;

public interface SubjectCRUD {

	int insertRecord(Subject subject);
	int updateRecord(Subject subject);
	int deleteRecord(int subjectId);
	List<Subject> getAllRecords();
	Subject getSubjectById(int subjectId);
	
}
