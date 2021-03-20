package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBC {

	public static void main(String[] args) throws SQLException {
		//connection is returntype of connection, we declare here so that we can acess anywhere
		Connection con = null;
		
		//step 1 register the database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step 2 get connection for the db("default code of mysql is 3306")("project" id dabatabase name)
		//(control1 rename file you will get return statement )
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		
		// step3 create statement
		Statement stat = con.createStatement();
		
		//step4 execute the query(project1 is project name )
		ResultSet result =  stat.executeQuery("select * from project1");
		
		while(result.next())
		{
			System.out.println(result.getString(1) + "\t" + result.getString(2) + "\t" + result.getString(3));
		}
		
		//step5 close connection
		con.close();
		
	}

}
