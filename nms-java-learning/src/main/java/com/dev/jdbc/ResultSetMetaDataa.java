package com.dev.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultSetMetaDataa {
	
	public static void getResultSetMetaData(Connection conn) {
		ResultSet myRest = null;
		Statement myStatement = null;
		
		try {
			myStatement = conn.createStatement();
			myRest = myStatement.executeQuery("Select empno, ename, sal, job from emp");
			
			ResultSetMetaData rmetaData = myRest.getMetaData();
			
			int columnCount = rmetaData.getColumnCount();
			
			for(int col = 1; col <= columnCount; col++) {
				System.out.println(rmetaData.getColumnName(col));
				System.out.println(rmetaData.getColumnTypeName(col));
				System.out.println(rmetaData.isNullable(col));
			}
			
		}catch(Exception e) {
			e.getStackTrace();
		}
	}

}
