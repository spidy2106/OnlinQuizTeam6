package com.crud.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crud.model.Admin;
import com.crud.service.AdminConnection;
//import com.curd.model.Student;
//import com.curd.service.StudentConnection;

public class AdminService implements AdminCrud {

	@Override
	public int insertRecord(Admin admin) {
		int result=0;
		try{
			Connection con=AdminConnection.getConnection();
			java.sql.Date sdob=new java.sql.Date(admin.getDob().getTime());
			//To insert records 
			PreparedStatement ps=con.prepareStatement("insert into admindetails(id, adminname,dob,email,phone,address) values(?,?,?,?,?,?)");
			ps.setInt(1,admin.getId());
			ps.setString(2,admin.getAdminname());
			ps.setDate(3, sdob);
			ps.setString(4, admin.getEmail());
			ps.setInt(5, admin.getPhone());
			ps.setString(6, admin.getAddress());
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		return result;
	}

	@Override
	public int updateRecord(Admin admin) {
		int result=0;
		try{
			Connection con=AdminConnection.getConnection();
			java.sql.Date sdob=new java.sql.Date(admin.getDob().getTime());
			
			//To insert records 
			PreparedStatement ps=con.prepareStatement("update admindetails set adminname=?,dob=?,email=?,phone=?,address=? where id=?");
			
			ps.setString(1,admin.getAdminname());
			ps.setDate(2, sdob);
			ps.setString(3, admin.getEmail());
			ps.setInt(4, admin.getPhone());
			ps.setString(5, admin.getAddress());
			ps.setInt(6,admin.getId());
			result=ps.executeUpdate();
			con.close();
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return result;
	}

	@Override
	public int deleteRecord(int id) {
		int result=0;
		try{
			Connection con=AdminConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from admindetails where id=?");
			
			ps.setInt(1,id);
			
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return result;
	}

	@Override
	public Admin getAdminById(int id) {
		Admin admin=null;
		try{
			Connection con=AdminConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("Select * from admindetails where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery(); 
			if(rs.next())
				admin=new Admin(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getInt(5),rs.getString(6));
			
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return admin;
	}

	@Override
	public List<Admin> getAllRecords() {
		ArrayList<Admin> list=new ArrayList<>();
		try{
		Connection con=AdminConnection.getConnection();
		//To get all Records
		java.sql.Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from admindetails");
		//Add all Records in ArrayList		
						
		while(rs.next()) {
			
			list.add(new Admin(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getInt(5),rs.getString(6)));
			//Student student=new Student(rs.getInt(1),rs.getString(2),rs.getDate(3));
			//list.add(student);
					
		}
		stmt.close();
		con.close();
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
