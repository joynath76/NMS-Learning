package com.dev.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

public class StoredProcedureOperations {
	public static void storedProcedureOperations(Connection conn) {
		try {
			CallableStatement cs = conn.prepareCall("call greet_me(?)");
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setString(1, "Joynath");
			cs.execute();
			
			CallableStatement cs1 = conn.prepareCall("call get_count_of_dept(?,?)");
			cs1.setString(1, "MANAGER");
			cs1.registerOutParameter(2, Types.INTEGER);
			cs1.execute();
			System.out.println(cs1.getInt(2));
			
			
			CallableStatement cs2 = conn.prepareCall("call get_employee_for_depts(?)");
			cs2.setString(1, "CLERK");
			cs2.execute();
			ResultSet myRest = cs2.getResultSet();
			JdbcTestApp.displayData(myRest);
			
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
}
