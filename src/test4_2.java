import java.sql.*;
import java.util.Calendar;
public class test4_2 {
	
	test4_2(String id, String first, String last, String age) {
		
		try {
			// create a mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/registration";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl,"root","0000");
			
			// create a sql date object so we can use it in our INSERT statement
			Calendar calendar = Calendar.getInstance();
			java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
			
			// the mysql insert statement
			String query =
			" insert into users (id, first, last, age)"
			+ " values (?, ?, ?, ?)";
			
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, id);
		    preparedStmt.setString (2, first);
		    preparedStmt.setString (3, last);
		    preparedStmt.setString (4, age);
		    
		    // execute the preparedstatement
		    preparedStmt.execute();
			
		} catch (Exception e) {
			System.out.println("Error : ");
		}
	}
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		
	}
}
