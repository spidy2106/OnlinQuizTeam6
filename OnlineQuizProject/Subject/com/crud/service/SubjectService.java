package com.crud.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.crud.model.Subject;

public class SubjectService implements SubjectCRUD {

	@Override
	public int insertRecord(Subject subject) {
		
		int result=0;
		try{
			Connection con=SubjectConnection.getConnection();
	
			PreparedStatement ps=con.prepareStatement("insert into SubjectDetails(subjectid, subjectname) values(?,?)");
			ps.setInt(1,subject.getSubjectId());
			ps.setString(2,subject.getSubjectName());
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		return result;
		
	}

	@Override
	public int updateRecord(Subject subject) {
		int result=0;
		try{
			Connection con=SubjectConnection.getConnection();
	
			PreparedStatement ps=con.prepareStatement("update subjectdetails set subjectname=? where subjectid=?");
			ps.setInt(2,subject.getSubjectId());
			ps.setString(1,subject.getSubjectName());
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		return result;
		
		
	}

	@Override
	public int deleteRecord(int subjectId) {
		int result=0;
		try{
			Connection con=SubjectConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from subjectdetails where subjectid=?");
			
			ps.setInt(1,subjectId);
			
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return result;
	}

	@Override
	public List<Subject> getAllRecords() {
		
		ArrayList<Subject> list=new ArrayList<>();
		try{
		Connection con=SubjectConnection.getConnection();
		//To get all Records
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from subjectdetails");
		//Add all Records in ArrayList		
						
		while(rs.next()) {
			
			list.add(new Subject(rs.getInt(1),rs.getString(2)));
					
		}
		stmt.close();
		con.close();
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Subject getSubjectById(int subjectId) {
		
		Subject subject=null;
		try{
			Connection con=SubjectConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("Select * from subjectdetails where subjectid=?");
			ps.setInt(1, subjectId);
			ResultSet rs=ps.executeQuery(); 
			if(rs.next())
				subject=new Subject(rs.getInt(1),rs.getString(2));
			
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return subject;
	}
	
	

}
