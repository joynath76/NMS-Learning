package com.dev.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BLOBHandling {
	public static void handleBlob(Connection conn) throws IOException, SQLException{
		
		FileInputStream input = new FileInputStream(new File("C:\\Users\\jborm\\eclipse-workspace\\JDBC-test\\src\\com\\dev\\jdbc\\Medical Self Declaration-Final Approved.pdf"));
		PreparedStatement ps = conn.prepareStatement("update emp set resume = ? where empno = ?");
		ps.setBinaryStream(1, input);
		ps.setInt(2, 7499);
		ps.execute();
	}
}
