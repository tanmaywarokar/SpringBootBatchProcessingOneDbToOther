package olivecrypto.upi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	public static void main(String[] args) {
		 Connection conn = null;
	      try {
	         // Register JDBC driver
	         Class.forName("com.mysql.cj.jdbc.Driver");

	         // Open a connection
	         System.out.println("Connecting to database...");
	         String url = "jdbc:mysql://localhost:3306/mydatabase";
	         String username = "root";
	         String password = "tiger";
	         conn = DriverManager.getConnection(url, username, password);

	         // Execute a query
	         System.out.println("Creating statement...");
	         Statement stmt = conn.createStatement();
	         System.out.println(stmt);
//	         String sql = "SELECT id, name, age FROM mytable";
//	         ResultSet rs = stmt.executeQuery(sql);
//
//	         // Extract data from result set
//	         while (rs.next()) {
//	            // Retrieve by column name
//	            int id = rs.getInt("id");
//	            String name = rs.getString("name");
//	            int age = rs.getInt("age");
//
//	            // Display values
//	            System.out.print("ID: " + id);
//	            System.out.print(", Name: " + name);
//	            System.out.println(", Age: " + age);
//	         }
	         // Clean-up environment
//	         rs.close();
	         stmt.close();
	         conn.close();
	      } catch (SQLException se) {
	         // Handle errors for JDBC
	         se.printStackTrace();
	      } catch (Exception e) {
	         // Handle errors for Class.forName
	         e.printStackTrace();
	      } finally {
	         // Finally block used to close resources
	         try {
	            if (conn != null)
	               conn.close();
	         } catch (SQLException se) {
	            se.printStackTrace();
	         }
	      }
	      System.out.println("Goodbye!");
	   }
	
}
