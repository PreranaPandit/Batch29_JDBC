import java.sql.*;

public class DeleteData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "root";
		
		try {
			//1. Get a connection to database
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			//3. Execute SQL Query
			String sql = "delete from employees where last_name='David'";
			
			int rowsAffected = myStmt.executeUpdate(sql);
			
			
			System.out.println("Rows affected: "+ rowsAffected);
			System.out.println("Deleted Successfully!!..");
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
