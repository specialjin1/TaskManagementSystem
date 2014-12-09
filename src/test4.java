import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class test4 extends JFrame {
	test4() {
		// I varchar varchar I
		// id first last age
		JTextField id = new JTextField("");
		JTextField first = new JTextField("");
		JTextField last = new JTextField("");
		JTextField age = new JTextField("");
		JButton bt = new JButton("Ãß°¡");
		setTitle("GridLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout grid = new GridLayout(5,2);
		grid.setVgap(5);
		setLayout(grid);

		add(new JLabel(" id"));
		add(id);
		add(new JLabel(" first"));
		add(first);
		add(new JLabel(" last"));
		add(last);
		add(new JLabel(" age"));
		add(age);
		add(new JLabel(""));
		add(bt);
		setSize(300,200);
		setResizable(false);
		setVisible(true);
		
	}
	
	public static void main(String[] args)
	{
		new test4();
	}
}
class MyActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		//new test4_2(id.getText(),first.getText(),last.getText(),age.getText());
		
	}
}