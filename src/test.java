import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
	public static void main(String[] args)
	{
		try {
			Connection con = null;
			
			con = DriverManager.getConnection("jdbc:mysql://localhost","root","0000");
			java.sql.Statement st = null;
			ResultSet rs = null;
			st = con.createStatement();
			rs = st.executeQuery("use test");
			
			if(st.execute("Show tables")) {
				rs = st.getResultSet();
			}
			while(rs.next()) {
				String std = rs.getNString(1);
				System.out.println(std);
			}
			
			if(st.execute("select * from test")) {
				rs = st.getResultSet();
			}
			while(rs.next()) {
				int column_1 = rs.getInt("column_name1");
				String column_2 = rs.getString("column_name2");
				int column_3 = rs.getInt("column_name3");
				
				System.out.println(column_1 + " " + column_2 + " " + column_3);
			}
			
			
		} catch(SQLException sqex) {
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState : " + sqex.getSQLState());
		}
	}
}
