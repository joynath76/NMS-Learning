package com.dev.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCBasicOperations {
	
	static Statement myStatement = null;
	public static void insert(Connection conn) {
		try {
			myStatement = conn.createStatement();
			int res = myStatement.executeUpdate("insert into emp values ('7323','SMITH','CLERK','7902','17-DEC-2005','800',NULL,'20')");
			System.out.println("Upadated row num: "+res);
//			PreparedStatement ps = conn.prepareStatement("select * from emp where sal >= ?");
//			ps.setInt(1, 3000);
//			
//			myRest = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void delete(Connection conn) {
		try {
			myStatement = conn.createStatement();
			int res = myStatement.executeUpdate("delete from emp where empno = '7323'");
			System.out.println("Updated row num: "+res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void update(Connection conn) {
		try {
			myStatement = conn.createStatement();
			int res = myStatement.executeUpdate("update emp set ename = 'JOYNATH' where empno = '7323'");
			System.out.println("Upadated row num: "+res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
