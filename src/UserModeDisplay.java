import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class UserModeDisplay extends JFrame {
	UserModeDisplay() {
		setTitle("���� ���");
		setLayout(null);
		addWindowListener(new JFrameWindowClosingEventHandler());
		
		JButton yes = new JButton("Ȯ��");
		yes.setLocation(250, 250);
		add(yes);
		setSize(300,300);
		setVisible(true);
	}
	static class JFrameWindowClosingEventHandler extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			JFrame frame = (JFrame)e.getWindow();
			frame.dispose();
		//	System.out.println("windowClosing()");
		}
	}
}

