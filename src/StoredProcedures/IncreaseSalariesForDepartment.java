package StoredProcedures;
import java.sql.*;


public class IncreaseSalariesForDepartment {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		try {
			//get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stored_61","root","root");
			
			String theDepartment = "Engineering";
			int theIncreaseAmount = 10000;
			
			//Show salaries BEFORE
			System.out.println("Salaries BEFORE\n");
			showSalaries(myConn, theDepartment);
			
			//Prepare the stored procedure call
			myStmt = myConn
					.prepareCall("{call increase_salaries_for_department(?,?)}");
			
			//Set the parameters
			myStmt.setString(1, theDepartment);
			myStmt.setDouble(2, theIncreaseAmount);
			
			//Call stored procedure
			System.out.println("\n\nCalling stored procedure.  increase_salaries_for_department('" + theDepartment + "', " + theIncreaseAmount + ")");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");

			//Show salaries AFTER
			System.out.println("\n\nSalaries AFTER\n");
			showSalaries(myConn, theDepartment);
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			close(myConn, myStmt, null);
		}

		
	}


	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {
		// TODO Auto-generated method stub
		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}


	private static void showSalaries(Connection myConn, String theDepartment) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			// Prepare statement
			myStmt = myConn
					.prepareStatement("select * from employees where department=?");

			myStmt.setString(1, theDepartment);
			
			// Execute SQL query
			myRs = myStmt.executeQuery();

			// Process result set
			while (myRs.next()) {
				String lastName = myRs.getString("last_name");
				String firstName = myRs.getString("first_name");
				double salary = myRs.getDouble("salary");
				String department = myRs.getString("department");
				
				System.out.printf("%s, %s, %s, %.2f\n", lastName, firstName, department, salary);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			close(myStmt, myRs);
		}

		
	}


	private static void close(Statement myStmt, ResultSet myRs) throws SQLException {
		// TODO Auto-generated method stub
		
		close(null, myStmt, myRs);
	}



}
