package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate 
{

	private static Connection con;

	public static void main(String[] args) throws SQLException 
	{
		Connection con = null;
		try 
		{
			//step 1 register the database
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
		
			//Step 2 get connection for the db
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		
			//step 3 create statement
			Statement stat = con.createStatement();
		
			//step4 execute update
			int result = stat.executeUpdate("insert into project1(project_name)values('prj_nm0')");
			if(result ==1)
				{
					System.out.println("query execute");
				}
			else
				{
					System.out.println("not execute");
				}
		}
		catch(Exception e)
		{
			
		}
		finally 
		{
			//step 5
			con.close();
			System.out.println("connection closed");
		}
	}
}
