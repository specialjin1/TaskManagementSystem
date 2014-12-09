import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;


public class D_B_Object {
	static private String taskName;
	static private int deadline;
	static private int imfortance;
	static private int estimatedTime;
	static private long startTime;
	static private int primaryKey;
	
	D_B_Object(String taskName,int deadline, int imfortance, int estimatedTime, long startTime, int primaryKey) {
		// data �ʱⰪ �ʱ�ȭ
		this.taskName = taskName;
		this.deadline = deadline;
		this.imfortance = imfortance;
		this.estimatedTime = estimatedTime;
		this.startTime = startTime;
		this.primaryKey = primaryKey;
	}
	
	public static void Add_Query() {
		// �����͸� �߰��ϴ� �޼ҵ�
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
			preparedStmt.setInt (1, primaryKey++);		// primaryKey
		    preparedStmt.setString (2, taskName);		// taskName
		    preparedStmt.setInt (3, deadline);			// Deadline
		    preparedStmt.setInt (4, imfortance);				// imfortance
		    preparedStmt.setInt (5, estimatedTime);				// estimatedTime
		    preparedStmt.setInt (6, (int)(System.currentTimeMillis()/1000));			// startTime
			
		    // execute the preparedstatement
		    System.out.println(preparedStmt.execute());
			
		} catch (Exception e) {
			System.out.println("Error : ");
		}
	}
	
	public static void Delete_Query() {
		// �����͸� �����ϴ� �޼ҵ�
	}
	
	public static void Get_Query() {
		// �����͸� ��� �޼ҵ�
	}
}
