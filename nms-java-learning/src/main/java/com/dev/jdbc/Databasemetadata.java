package com.dev.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Databasemetadata {
	
	public static void getAllMetaDataDetails(Connection conn) {
		try {
			DatabaseMetaData databaseMetaData = conn.getMetaData();
			
			System.out.println("Database Product name: " + databaseMetaData.getDatabaseProductName());
			System.out.println("Database Product version: " + databaseMetaData.getDatabaseProductVersion());
			System.out.println("Database Driver name: " + databaseMetaData.getDriverName());
			System.out.println("Database Driver Version: " + databaseMetaData.getDriverVersion());
			
			System.out.println("\n\n");
			
			//Get Schema details
			
			String catalog = null;
			String schemaPattern = null;
			String tableNamePattern = null;
			String columnNamePatten = null;
			String[] types = null;
			
			ResultSet myReslt = databaseMetaData.getTables(catalog, schemaPattern, tableNamePattern, types);
			System.out.println("List Of tables: ");
			while(myReslt.next()) {
				System.out.println(myReslt.getString("TABLE_NAME"));
			}
			
			ResultSet myReslt2 = databaseMetaData.getColumns(catalog, schemaPattern, "emp", columnNamePatten);
			System.out.println("List Of Column of Emp Table: ");
			while(myReslt2.next()) {
				System.out.println(myReslt2.getString("COLUMN_NAME"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
