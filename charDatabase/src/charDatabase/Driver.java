package charDatabase;

import java.sql.*;

public class Driver {
	
	public static void main(String[] args) {
		//needed to get connection
		String url = "jdbc:mysql://localhost:3306/jbdcDNDdb";
		String user = "root";
		String pass = "temp";
		
		try {
			//get connection to database
			Connection myConn = DriverManager.getConnection(url, user, pass);
			//Make statement
			Statement myStmt = myConn.createStatement();
			
			
			//testing dbdc sql stuff.
			
			//insert
			String sqlTest1 = "insert into player "+ 
							 " (firstNamePlayer, lastNamePlayer) "+ 
							 " values ('Marco', 'Romagna')";
			//update
			String sqlTest2 = "update player "+ 
					 " set firstNamePlayer='NotMarco'"+ 
					 " where idPlayer = 1";
			//delete
			String sqlTest3 = "delete from Player where firstNamePlayer='Marco'";
			
			//execute statement
			//int rowsAffected = myStmt.executeUpdate(sqlTest3);
			//System.out.println("Rows affected: "+ rowsAffected);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
