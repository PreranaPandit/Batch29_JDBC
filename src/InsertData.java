import java.sql.*;

public class InsertData {

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
			String sql = "insert into employees"
					+"(first_name, last_name, email)"
					+ "values ('Brown','David','david.brown@gmail.com')";
			
			myStmt.executeUpdate(sql);
			
			System.out.println("Insert Completed");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
