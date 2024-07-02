package com.xmldem;
import java.sql.*;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class xmldemc extends HttpServlet   {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) {
		
		String a = req.getParameter("dname");
		String b = req.getParameter("dpass");
		
		
		 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		//String que = "create table tbl(name varchar(250), address varchar(250))";
		String que = "insert into tbl(name, address) values(?,?)";
		PreparedStatement ps = con.prepareStatement(que);
		ps.setString(1,  a);
		ps.setString(2,  b);
		  ps.executeUpdate();
		  con.close();
		
		   System.out.println("table created");
		   System.out.println(a);
			System.out.println(b);} catch(Exception e) { 
				
				System.out.println("error");
			}
			
	
	} 
		
} 
		
		
		
	

	
	
	

