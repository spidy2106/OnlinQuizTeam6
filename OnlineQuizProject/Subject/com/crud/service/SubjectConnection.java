package com.crud.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class SubjectConnection {
	public static Connection getConnection() {
		Connection con=null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		
			 
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root","21061999");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return con;
		
	}
}