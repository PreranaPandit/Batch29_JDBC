import java.sql.*;

public class UpdateData {

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
			String sql = "update employees"
					+ " set email='fghfghfg@gmail.com'"
					+ " where id=6";
			
			myStmt.executeUpdate(sql);
			
			System.out.println("Update Completed");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
