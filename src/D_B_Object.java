import javax.swing.*;

import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class D_B_Object {
	static private String taskName;
	static private int deadline;
	static private int imfortance;
	static private int estimatedTime;
	static private long startTime;
	static private int primaryKey;
	
	D_B_Object(String taskName,int deadline, int imfortance, int estimatedTime, long startTime, int primaryKey) {
		// data 초기값 초기화
		this.taskName = taskName;
		this.deadline = deadline;
		this.imfortance = imfortance;
		this.estimatedTime = estimatedTime;
		this.startTime = startTime;
		this.primaryKey = primaryKey;
	}
	
	public static void Add_Query() {
		// 데이터를 추가하는 메소드
		try {
			// create a mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/TaskManagementSystem";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl,"root","0000");
			
			// create a sql date object so we can use it in our INSERT statement
			// Calendar calendar = Calendar.getInstance();
			// java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

			// the mysql insert statement
			String query =
			" insert into taskinfo (primaryKey, taskName,  Deadline, imfortance, estimatedTime,startTime)"
			+ " values (?, ?, ?, ?, ?,?)";
			
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt (1, primaryKey);		// primaryKey
		    preparedStmt.setString (2, taskName);		// taskName
		    preparedStmt.setInt (3, deadline);			// Deadline
		    preparedStmt.setInt (4, imfortance);		// imfortance
		    preparedStmt.setInt (5, estimatedTime);		// estimatedTime
		    preparedStmt.setInt (6, (int)(System.currentTimeMillis()/1000));			// startTime
			
		    // execute the preparedstatement
		    System.out.println(preparedStmt.execute());
		} catch (Exception e) {
			
		}
	}
	
	public static void Delete_Query() {
		// 데이터를 삭제하는 메소드
	}
	
	public static void Get_Query() {
		// 데이터를 얻는 메소드
		String myDriver = "org.gjt.mm.mysql.Driver";
		String myUrl = "jdbc:mysql://localhost/TaskManagementSystem";
		Vector data = new Vector();
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			Class.forName(myDriver);
			conn = DriverManager.getConnection(myUrl,"root","0000");
			String sql = "select * from taskinfo by primaryKey asc";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				//int primaryKey = rs.getInt(primaryKey);
				
			}
			
		} catch(Exception e) {
			
		}
	}
}
