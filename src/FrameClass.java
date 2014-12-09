import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class FrameClass extends JFrame {
	
	
	FrameClass() {
		setTitle("Frmae Test");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		addWindowListener(new JFrameWindowClosingEventHandler());
		
		JPanel panel1 = new JPanel();
		
		JLabel name = new JLabel("������");
		JLabel deadline = new JLabel("���� �Ⱓ");
		JLabel start_time = new JLabel("���� �ð�");
		JLabel estimated_time = new JLabel("���� �ð�");
		JLabel importance = new JLabel("�߿䵵");
		
		name.setFont(new Font("���� ���",Font.BOLD,13));
		deadline.setFont(new Font("���� ���",Font.BOLD,13));
		start_time.setFont(new Font("���� ���",Font.BOLD,13));
		estimated_time.setFont(new Font("���� ���",Font.BOLD,13));
		importance.setFont(new Font("���� ���",Font.BOLD,13));
		
		name.setBorder(BorderFactory.createBevelBorder(0));
		deadline.setBorder(BorderFactory.createBevelBorder(0));
		start_time.setBorder(BorderFactory.createBevelBorder(0));
		estimated_time.setBorder(BorderFactory.createBevelBorder(0));
		importance.setBorder(BorderFactory.createBevelBorder(0));
		
		// �÷� ����
		String colNames[] = {
				"����","������","���� �Ⱓ","���� �ð�","���� �ð�","�߿䵵"
		};
		Object rowData[][] = {
				{"1","�ڹ�1",5,"11/29",3,10 },
				{"2","�ڹ�2",2,"11/29",6,2 },
				{"3","�ڹ�3",3,"11/29",9,3 },
				
		};
		panel1.setLayout(new BorderLayout());
		JTable tabletest = new JTable(rowData,colNames);
		JScrollPane Scrtest = new JScrollPane(tabletest);
		panel1.add(Scrtest,BorderLayout.CENTER);
		panel1.setSize(400,300);
		panel1.setLocation(100, 100);
		getContentPane().add(panel1);
		pack();
		/*************************************/
		
		
		
		// �������� ��ư
		JButton Management = new JButton("���� ����");
		Management.setFont(new Font("���� ���",Font.BOLD,13));
		Management.setLocation(150,500);
		Management.setSize(100,20);
		add(Management);
		Management.addActionListener(new Management_Action());
		
		// ������� ��ư
		JButton UserMode = new JButton("���� ���");
		UserMode.setFont(new Font("���� ���",Font.BOLD,13));
		UserMode.setLocation(300,500);
		UserMode.setSize(100,20);
		add(UserMode);
		UserMode.addActionListener(new UserMode_Action());
		
		setSize(600,600);
		setResizable(false);
		setVisible(true);
	}
	static class Management_Action implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			new Management();
		}
	}
	static class UserMode_Action implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			new UserModeInput();		
		}
	}
	
	static class JFrameWindowClosingEventHandler extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			JFrame frame = (JFrame)e.getWindow();
			frame.dispose();
			//System.out.println("windowClosing()");
		}
	}
	public static void main(String[] args)
	{
		new FrameClass();
	}
}