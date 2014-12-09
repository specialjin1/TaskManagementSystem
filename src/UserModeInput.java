import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

// 유저모드에서 입력을 받는 창을 띄우는 클래스
public class UserModeInput extends JFrame {
	int time_para;
	UserModeInput() {
		setTitle("확인");
		setVisible(true);
		setSize(200,150);
		setResizable(false);
		addWindowListener(new JFrameWindowClosingEventHandler());
		
		JTextField time = new JTextField("여유시간을 입력하세요.");
		time.setSize(100,20);
		time.setLocation(100, 100);
		
		
		JButton time_click = new JButton("확인");
		time_click.setSize(100,20);
		time_click.setLocation(100,125);
		time_click.addActionListener(new Management_Action());
		
		JPanel panel = new JPanel();
		add(panel);
		panel.add(time);
		panel.add(time_click);
	}
	
	static class Management_Action implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			new UserModeDisplay();
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
