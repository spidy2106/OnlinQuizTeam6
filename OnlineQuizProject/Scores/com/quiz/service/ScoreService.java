package com.quiz.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.quiz.model.QuizScore;

public class ScoreService implements ScoreCrud {
	
	@Override
	public int insertScore(QuizScore quizscore) {
		int result=0;
		try{
			Connection con=ScoreConnection.getConnection();
			//To insert records 
			PreparedStatement ps=con.prepareStatement("insert into quizscore(studentid, testid,teacherid,score) values(?,?,?,?)");
			ps.setInt(1,quizscore.getStudentid());
			ps.setInt(2, quizscore.getTestid());
			ps.setInt(3, quizscore.getTeacherid());
			ps.setInt(4, quizscore.getScore());
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		return result;
	
	}

	@Override
	public int updateScore(QuizScore quizscore) {
		int result=0;
		try{
			Connection con=ScoreConnection.getConnection();
			
			
			//To insert records 
			PreparedStatement ps=con.prepareStatement("update quizscore set score=? where studentid=?");
			ps.setInt(2,quizscore.getStudentid());
			ps.setInt(1, quizscore.getScore());
			result=ps.executeUpdate();
			con.close();
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return result;
	}

	@Override
	public int deleteScore(int studentid) {
		int result=0;
		try{
			Connection con=ScoreConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from quizscore where studentid=?");
			
			ps.setInt(1,studentid);
			
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return result;
	
	}

	@Override
	public List<QuizScore> getAllScores() {
		
			ArrayList<QuizScore> list=new ArrayList<>();
			try{
			Connection con=ScoreConnection.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from quizscore");	
			while(rs.next()) {
				
				list.add(new QuizScore(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4)));
						
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
	public List<QuizScore> getScoresByTeacherId(int teacherid) {
		ArrayList<QuizScore> list=new ArrayList<>();
		try{
		Connection con=ScoreConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("Select * from quizscore where teacherid=?");
		ps.setInt(1, teacherid);
		ResultSet rs=ps.executeQuery(); 
//		Statement stmt=con.createStatement();
//		stmt.setInt(1,teacherid);
//		ResultSet rs=stmt.executeQuery("select * from quizscore");	
		
		while(rs.next()) {
			
			list.add(new QuizScore(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4)));
					
		}
		ps.close();
		con.close();
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<QuizScore> getScoresByTestId(int testid) {
		ArrayList<QuizScore> list=new ArrayList<>();
		try{
		Connection con=ScoreConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("Select * from quizscore where testid=?");
		ps.setInt(1, testid);
		ResultSet rs=ps.executeQuery(); 
//		Statement stmt=con.createStatement();
//		stmt.setInt(1,teacherid);
//		ResultSet rs=stmt.executeQuery("select * from quizscore");	
		
		while(rs.next()) {
			
			list.add(new QuizScore(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4)));
					
		}
		ps.close();
		con.close();
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public QuizScore getScoreByStudentId(int studentid) {
		
		QuizScore quizscore=null;
		try{
			Connection con=ScoreConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("Select * from quizscore where studentid=?");
			ps.setInt(1, studentid);
			ResultSet rs=ps.executeQuery(); 
			if(rs.next())
				quizscore=new QuizScore(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
			
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return quizscore;
	}

}
