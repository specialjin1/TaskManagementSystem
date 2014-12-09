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
		
		JLabel name = new JLabel("과제명");
		JLabel deadline = new JLabel("남은 기간");
		JLabel start_time = new JLabel("시작 시간");
		JLabel estimated_time = new JLabel("예상 시간");
		JLabel importance = new JLabel("중요도");
		
		name.setFont(new Font("맑은 고딕",Font.BOLD,13));
		deadline.setFont(new Font("맑은 고딕",Font.BOLD,13));
		start_time.setFont(new Font("맑은 고딕",Font.BOLD,13));
		estimated_time.setFont(new Font("맑은 고딕",Font.BOLD,13));
		importance.setFont(new Font("맑은 고딕",Font.BOLD,13));
		
		name.setBorder(BorderFactory.createBevelBorder(0));
		deadline.setBorder(BorderFactory.createBevelBorder(0));
		start_time.setBorder(BorderFactory.createBevelBorder(0));
		estimated_time.setBorder(BorderFactory.createBevelBorder(0));
		importance.setBorder(BorderFactory.createBevelBorder(0));
		
		// 컬럼 벡터
		String colNames[] = {
				"순위","과제명","남은 기간","시작 시간","예상 시간","중요도"
		};
		Object rowData[][] = {
				{"1","자바1",5,"11/29",3,10 },
				{"2","자바2",2,"11/29",6,2 },
				{"3","자바3",3,"11/29",9,3 },
				
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
		
		
		
		// 과제관리 버튼
		JButton Management = new JButton("과제 관리");
		Management.setFont(new Font("맑은 고딕",Font.BOLD,13));
		Management.setLocation(150,500);
		Management.setSize(100,20);
		add(Management);
		Management.addActionListener(new Management_Action());
		
		// 유저모드 버튼
		JButton UserMode = new JButton("유저 모드");
		UserMode.setFont(new Font("맑은 고딕",Font.BOLD,13));
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