package com.dev.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Transection {
	public static void handleTransection(Connection conn, boolean isOk) {
		
		try {
			
			conn.setAutoCommit(false);
			Statement myStatement = conn.createStatement();
			myStatement.executeUpdate("update emp set sal = sal + 200 where job = 'Manager'");
			myStatement.executeUpdate("update emp set sal = sal - 100 where job = 'Manager'");
			
			if(isOk) conn.commit();
			else conn.rollback();
			ResultSet myRest = myStatement.executeQuery("select * from emp");
			while(myRest.next()) {
				System.out.println(myRest.getString(1) + " " + 
								   myRest.getString(2) + " " +
								   myRest.getString(3) + " " +
								   myRest.getString(4) + " " +
								   myRest.getString(5) + " " +
								   myRest.getString(6) + " " +
								   myRest.getString(7));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
