import java.sql.*;
import java.util.Calendar;
public class test2 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		
		try {
			// create a mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/test";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl,"root","0000");
			
			// create a sql date object so we can use it in our INSERT statement
			Calendar calendar = Calendar.getInstance();
			java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
			
			// the mysql insert statement
			String query =
			" insert into users (first_name, last_name, date_created, is_admin, num_points)"
			+ " values (?, ?, ?, ?, ?)";
			
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, "Barney");
		    preparedStmt.setString (2, "Rubble");
		    preparedStmt.setDate   (3, startDate);
		    preparedStmt.setBoolean(4, false);
		    preparedStmt.setInt    (5, 5000);
			
		    // execute the preparedstatement
		    System.out.println(preparedStmt.execute());
			
		} catch (Exception e) {
			System.out.println("Error : ");
		}
	}
}
