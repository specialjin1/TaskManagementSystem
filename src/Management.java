import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Management_Add, Management_Delete, Management_Display
public class Management extends JFrame {
	Management() {
		setTitle("Management");
		setSize(500,500);
		setLayout(null);
		addWindowListener(new JFrameWindowClosingEventHandler());
		setVisible(true);
		
		JLabel taskName = new JLabel("°ϊΑ¦Έν");
		
	}
	
	static class JFrameWindowClosingEventHandler extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			JFrame frame = (JFrame)e.getWindow();
			frame.dispose();
		//	System.out.println("windowClosing()");
		}
	}
}
