import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

// Management_Add, Management_Delete, Management_Display
public class Management extends JFrame {
	static JTextField TaskName,Importance,EstimatedTime,Deadline;
	static int count=0;
	Management() {
		setTitle("Management");
		setLayout(null);
		addWindowListener(new JFrameWindowClosingEventHandler());
		// String taskName,int deadline, int imfortance, int estimatedTime, long startTime, int primaryKey
		D_B_Object test = new D_B_Object("test",5,9,10,System.currentTimeMillis()/1000,count++);
		test.Add_Query();
		
		JButton Add = new JButton("추가");
	    Add.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    Add.setLocation(50,100);
	    Add.setSize(175,30);
	    add(Add);
	    Add.addActionListener(new Add_Action());   
	    
	    // 삭제 버튼
	    JButton Delete = new JButton("삭제");
	    Delete.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    Delete.setLocation(275,100);
	    Delete.setSize(175,30);
	    add(Delete);
	    Delete.addActionListener(new Delete_Action());
	    
	    // 완료 버튼
	    JButton Complete = new JButton("완료");
	    Complete.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    Complete.setLocation(50,430);
	    Complete.setSize(175,30);
	    add(Complete);
	    Complete.addActionListener(new Complete_Action());   
	    
	    // 취소 버튼
	    JButton Cancel = new JButton("취소");
	    Cancel.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    Cancel.setLocation(275,430);
	    Cancel.setSize(175,30);
	    add(Cancel);
	    Cancel.addActionListener(new Cancel_Action());
	      
	    
	    // 과제명
	    JLabel Task_Name = new JLabel("과제명");
	    Task_Name.setSize(100,20);
	    Task_Name.setLocation(20,20);
	    Task_Name.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    add(Task_Name);
	    TaskName = new JTextField("");
	    TaskName.setSize(100,20);
	    TaskName.setLocation(20, 40);      
	    add(TaskName);
	    
	    // 중요도
	    JLabel Impor_tance = new JLabel("중요도");
	    Impor_tance.setSize(100,20);
	    Impor_tance.setLocation(140,20);
	    Impor_tance.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    add(Impor_tance);
	    Importance = new JTextField("");
	    Importance.setSize(100,20);
	    Importance.setLocation(140, 40);
	    add(Importance);
	    
	    // 예상시간
	    JLabel Estimated_Time = new JLabel("예상시간");
	    Estimated_Time.setSize(100,20);
	    Estimated_Time.setLocation(260,20);
	    Estimated_Time.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    add(Estimated_Time);
	    EstimatedTime = new JTextField("");
	    EstimatedTime.setSize(100,20);
	    EstimatedTime.setLocation(260, 40);
	    add(EstimatedTime);
	    
	    // 제출기한
	    JLabel dead_line = new JLabel("제출기한");
	    dead_line.setSize(100,20);
	    dead_line.setLocation(380,20);
	    dead_line.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    add(dead_line);
	    Deadline = new JTextField("");
	    Deadline.setSize(100,20);
	    Deadline.setLocation(380, 40);
	    add(Deadline);  
	    
	    JPanel panel1 = new JPanel();
	      
	    JLabel name = new JLabel("과제명");
	    JLabel deadline = new JLabel("남은 기간");
	    JLabel estimated_time = new JLabel("예상 시간");
	    JLabel importance = new JLabel("중요도");
	      
	    name.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    deadline.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    estimated_time.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    importance.setFont(new Font("맑은 고딕",Font.BOLD,13));
	      
	    name.setBorder(BorderFactory.createBevelBorder(0));
	    deadline.setBorder(BorderFactory.createBevelBorder(0));
	    estimated_time.setBorder(BorderFactory.createBevelBorder(0));
	    importance.setBorder(BorderFactory.createBevelBorder(0));
	    
	    // 컬럼 벡터
	    String colNames[] = {
	          "과제명","남은 기간","예상 시간","중요도"
	    };
	    
	    Object rowData[][] = { };
	    panel1.setLayout(new BorderLayout());
	    JTable tabletest = new JTable(rowData,colNames);
	    JScrollPane Scrtest = new JScrollPane(tabletest);
	    panel1.add(Scrtest,BorderLayout.CENTER);
	    panel1.setSize(300,200);
	    panel1.setLocation(100, 200);
	    getContentPane().add(panel1);
	    pack();
	    
	    setSize(500,500);
		setResizable(false);
		setVisible(true);
	}
	
	// static JTextField TaskName,Importance,EstimatedTime,Deadline;
	// String taskName,int deadline, int imfortance, int estimatedTime, long startTime, int primaryKey
	static class Add_Action implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			new D_B_Object(TaskName.getText(),Integer.parseInt(Deadline.getText())
				,Integer.parseInt(Importance.getText()),Integer.parseInt(EstimatedTime.getText())
				,(int)(System.currentTimeMillis()/1000),3).Add_Query();
			JFrame complete = new JFrame();
			complete.setTitle("추가");
			complete.setVisible(true);
			complete.setSize(200,150);
			complete.setResizable(false);
			
			JLabel com = new JLabel("새로운 과제가 추가되었습니다.");
			com.setSize(100,20);
			com.setLocation(25,75);
			complete.add(com);
			
		}
	}
	static class Delete_Action implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			
		}
	}
	static class Complete_Action implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			
		}
	}
	static class Cancel_Action implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			
		}
	}
	static class JFrameWindowClosingEventHandler extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			JFrame frame = (JFrame)e.getWindow();
			frame.dispose();
		//	System.out.println("windowClosing()");
		}
	}
}
