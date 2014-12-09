import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class UserModeDisplay extends JFrame {
	UserModeDisplay() {
		setTitle("유저 모드");
		setLayout(null);
		addWindowListener(new JFrameWindowClosingEventHandler());
		
		JButton yes = new JButton("확인");
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

