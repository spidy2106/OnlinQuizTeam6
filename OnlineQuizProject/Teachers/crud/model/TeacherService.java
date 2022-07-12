package crud.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import crud.model.Teacher;
public class TeacherService implements TeacherCrud{

	public int insertRecord(Teacher teacher) {
		int result=0;
		try{
			Connection con= TeacherConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into teacherDetails(tid,name,email,phone_no) values(?,?,?,?)");
			ps.setInt(1,teacher.getTid());
			ps.setString(2,teacher.getName());
			ps.setString(3,teacher.getEmail());
			ps.setInt(4,teacher.getPhone_no());
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		return result;
	}


	public int updateRecord(Teacher teacher) {
		int result=0;
		try{
			Connection con=TeacherConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update teacherDetails set name=?,email=?,phone_no where tid=?");
			
			ps.setString(1,teacher.getName());
			ps.setString(2,teacher.getEmail());
			ps.setInt(3,teacher.getPhone_no());
			result=ps.executeUpdate();
			con.close();
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return result;
	}


	public int deleteRecord(int tid) {
		int result=0;
		try{
			Connection con=TeacherConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from teacherdetails where tid=?");
			
			ps.setInt(1,tid);
			
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return result;
	}

	public List<Teacher> getAllRecords() {
		
		ArrayList<Teacher> list=new ArrayList<>();
		try{
		Connection con=TeacherConnection.getConnection();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from teacherdetails");	
						
		while(rs.next()) {
			
			list.add(new Teacher(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			
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
	public Teacher getTeacherBytid(int tid) {
		
		Teacher teacher=null;
		try{
			Connection con=TeacherConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("Select * from teacherdetails where tid=?");
			ps.setInt(1, tid);
			ResultSet rs=ps.executeQuery(); 
			if(rs.next())
				teacher=new Teacher(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
			
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return teacher;
	}



}


