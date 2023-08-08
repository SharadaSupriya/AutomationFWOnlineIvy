package WeekendPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws Throwable {
		Driver driverRef= new Driver();
		
		//Step 1: 
		DriverManager.registerDriver(driverRef);
		//Step2:
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb");
		//step 3:
		Statement state = con.createStatement();
		
		//step 4:
		ResultSet result = state.executeQuery("select * from sample;");
		while(result.next())
		{
		System.out.println(result.getString(1)+" "+ result.getString(2)+""+ result.getString(3));
		
		}
		//step 5:
		con.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
