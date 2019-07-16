package com.capgemini.Trans;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.capgemini.utility.DBconnection;

public class TransactionDemo {

	public static void main(String[] args) {
		
		
		try {
			Connection connection=DBconnection.getConnection();
			connection.setAutoCommit(false);
			PreparedStatement statement=connection.prepareStatement("insert into emp(empno,ename,sal) values(?,?,?)");
			statement.setInt(1,1234);
			statement.setString(2,"vijaya");
			statement.setDouble(3,3456);
			int row=statement.executeUpdate();
			System.out.println(row+"updated");
			connection.commit();
			//connection.rollback();
			//Metadata info
	        //Database info
			DatabaseMetaData dbmd=connection.getMetaData();
			System.out.println("Name:" +dbmd.getDatabaseProductName());
			System.out.println("DB version:  "+dbmd.getDatabaseMajorVersion());
			System.out.println(" DB drivername:" +dbmd.getDriverName());
			System.out.println("username : "+dbmd.getUserName());
			System.out.println("URL:"+dbmd.getURL());
			//resultSet info
			statement=connection.prepareStatement("select * from emp");
			ResultSet resultset=statement.executeQuery();
			ResultSetMetaData rsmd=resultset.getMetaData();
			System.out.println(" table name:"+rsmd.getTableName(1));
			System.out.println("1st column name: "+rsmd.getColumnName(1));
			System.out.println("2nd column name: "+rsmd.getColumnLabel(2));
			System.out.println("No of columns:"+rsmd.getColumnCount());
			System.out.println("3rd column datatype: "+rsmd.getColumnType(3));
			} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		

	}

}
