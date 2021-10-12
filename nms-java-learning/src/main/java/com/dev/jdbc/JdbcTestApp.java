package com.dev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTestApp {

	public static void main(String[] args) {
		final String DATABASEURL = "jdbc:mysql://localhost:3306/db?useSSL=false";
		final String USERNAME = "student";
		final String PASSWORD = "student";
		
		Connection conn = null;
		try {
			//Get the Connection first
			conn = DriverManager.getConnection(DATABASEURL, USERNAME, PASSWORD);
			System.out.println("Connected to the Database successfully");
			
//			//JDBC Basic Operations
//			JDBCBasicOperations.insert(conn);
//			JDBCBasicOperations.delete(conn);
//			JDBCBasicOperations.update(conn);
//			
//			//JDBC Stored Procedure
//			StoredProcedureOperations.storedProcedureOperations(conn);
//			
//			//JDBC transection
//			Transection.handleTransection(conn, true);
//			
//			Databasemetadata.getAllMetaDataDetails(conn);
			
			
			BLOBHandling.handleBlob(conn);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void displayData(ResultSet res) {
		try {
			while(res.next()) {
				System.out.println(res.getString(1) + " " + 
								   res.getString(2) + " " +
								   res.getString(3) + " " +
								   res.getString(4) + " " +
								   res.getString(5) + " " +
								   res.getString(6) + " " +
								   res.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
