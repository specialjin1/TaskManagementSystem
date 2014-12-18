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
		
		JButton Add = new JButton("�߰�");
	    Add.setFont(new Font("���� ���",Font.BOLD,13));
	    Add.setLocation(50,100);
	    Add.setSize(175,30);
	    add(Add);
	    Add.addActionListener(new Add_Action());   
	    
	    // ���� ��ư
	    JButton Delete = new JButton("����");
	    Delete.setFont(new Font("���� ���",Font.BOLD,13));
	    Delete.setLocation(275,100);
	    Delete.setSize(175,30);
	    add(Delete);
	    Delete.addActionListener(new Delete_Action());
	    
	    // �Ϸ� ��ư
	    JButton Complete = new JButton("�Ϸ�");
	    Complete.setFont(new Font("���� ���",Font.BOLD,13));
	    Complete.setLocation(50,430);
	    Complete.setSize(175,30);
	    add(Complete);
	    Complete.addActionListener(new Complete_Action());   
	    
	    // ��� ��ư
	    JButton Cancel = new JButton("���");
	    Cancel.setFont(new Font("���� ���",Font.BOLD,13));
	    Cancel.setLocation(275,430);
	    Cancel.setSize(175,30);
	    add(Cancel);
	    Cancel.addActionListener(new Cancel_Action());
	      
	    
	    // ������
	    JLabel Task_Name = new JLabel("������");
	    Task_Name.setSize(100,20);
	    Task_Name.setLocation(20,20);
	    Task_Name.setFont(new Font("���� ���",Font.BOLD,13));
	    add(Task_Name);
	    TaskName = new JTextField("");
	    TaskName.setSize(100,20);
	    TaskName.setLocation(20, 40);      
	    add(TaskName);
	    
	    // �߿䵵
	    JLabel Impor_tance = new JLabel("�߿䵵");
	    Impor_tance.setSize(100,20);
	    Impor_tance.setLocation(140,20);
	    Impor_tance.setFont(new Font("���� ���",Font.BOLD,13));
	    add(Impor_tance);
	    Importance = new JTextField("");
	    Importance.setSize(100,20);
	    Importance.setLocation(140, 40);
	    add(Importance);
	    
	    // ����ð�
	    JLabel Estimated_Time = new JLabel("����ð�");
	    Estimated_Time.setSize(100,20);
	    Estimated_Time.setLocation(260,20);
	    Estimated_Time.setFont(new Font("���� ���",Font.BOLD,13));
	    add(Estimated_Time);
	    EstimatedTime = new JTextField("");
	    EstimatedTime.setSize(100,20);
	    EstimatedTime.setLocation(260, 40);
	    add(EstimatedTime);
	    
	    // �������
	    JLabel dead_line = new JLabel("�������");
	    dead_line.setSize(100,20);
	    dead_line.setLocation(380,20);
	    dead_line.setFont(new Font("���� ���",Font.BOLD,13));
	    add(dead_line);
	    Deadline = new JTextField("");
	    Deadline.setSize(100,20);
	    Deadline.setLocation(380, 40);
	    add(Deadline);  
	    
	    JPanel panel1 = new JPanel();
	      
	    JLabel name = new JLabel("������");
	    JLabel deadline = new JLabel("���� �Ⱓ");
	    JLabel estimated_time = new JLabel("���� �ð�");
	    JLabel importance = new JLabel("�߿䵵");
	      
	    name.setFont(new Font("���� ���",Font.BOLD,13));
	    deadline.setFont(new Font("���� ���",Font.BOLD,13));
	    estimated_time.setFont(new Font("���� ���",Font.BOLD,13));
	    importance.setFont(new Font("���� ���",Font.BOLD,13));
	      
	    name.setBorder(BorderFactory.createBevelBorder(0));
	    deadline.setBorder(BorderFactory.createBevelBorder(0));
	    estimated_time.setBorder(BorderFactory.createBevelBorder(0));
	    importance.setBorder(BorderFactory.createBevelBorder(0));
	    
	    // �÷� ����
	    String colNames[] = {
	          "������","���� �Ⱓ","���� �ð�","�߿䵵"
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
			complete.setTitle("�߰�");
			complete.setVisible(true);
			complete.setSize(200,150);
			complete.setResizable(false);
			
			JLabel com = new JLabel("���ο� ������ �߰��Ǿ����ϴ�.");
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
