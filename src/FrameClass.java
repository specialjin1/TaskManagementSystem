import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class FrameClass extends JFrame {
	JPanel panel1 = new JPanel();
	JLabel name = new JLabel("과제명");
	JLabel deadline = new JLabel("남은 기간");
	JLabel start_time = new JLabel("시작 시간");
	JLabel estimated_time = new JLabel("예상 시간");
	JLabel importance = new JLabel("중요도");
	
	FrameClass() {
		setTitle("Frmae Test");
		setLayout(null);
		addWindowListener(new JFrameWindowClosingEventHandler());
		
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
		/*
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
		*/
		panel1.setSize(500,300);
		panel1.setLocation(50, 100);
		getContentPane().add(panel1);
		pack();
		TaskTable();
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
		}
	}
	
	public void TaskTable()
    {
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();

        //  Connect to an MySQL Database, run query, get result set
        String url = "jdbc:mysql://localhost:3306/taskmanagementsystem";
        String userid = "root";
        String password = "0000";
        String sql = "SELECT taskName,Deadline,imfortance,estimatedTime,startTime FROM taskinfo";

        // Java SE 7 has try-with-resources
        // This will ensure that the sql objects are closed when the program 
        // is finished with them
        try (Connection connection = DriverManager.getConnection(url,userid,password);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql ))
        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++)
            {
                columnNames.add( md.getColumnName(i) );
            }

            //  Get row data
            while (rs.next())
            {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.add( rs.getObject(i) );
                }

                data.add( row );
            }
        }
        catch (SQLException e)
        {
            System.out.println( e.getMessage() );
        }

        // Create Vectors and copy over elements from ArrayLists to them
        // Vector is deprecated but I am using them in this example to keep 
        // things simple - the best practice would be to create a custom defined
        // class which inherits from the AbstractTableModel class
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (int i = 0; i < data.size(); i++)
        {
            ArrayList subArray = (ArrayList)data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++)
            {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0; i < columnNames.size(); i++ )
            columnNamesVector.add(columnNames.get(i));

        //  Create table with database data    
        JTable table = new JTable(dataVector, columnNamesVector)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };

       JScrollPane scrollPane = new JScrollPane( table );
       panel1.add(scrollPane);
      // panel1.add(table);
       table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
       
       DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
       celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
       DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
       celAlignRight.setHorizontalAlignment(JLabel.RIGHT);
       table.getColumn("taskName").setPreferredWidth(60);
       table.getColumn("taskName").setCellRenderer(celAlignCenter);
       table.getColumn("Deadline").setPreferredWidth(60);
       table.getColumn("Deadline").setCellRenderer(celAlignCenter);
       table.getColumn("imfortance").setPreferredWidth(60);
       table.getColumn("imfortance").setCellRenderer(celAlignCenter);
       table.getColumn("estimatedTime").setPreferredWidth(60);
       table.getColumn("estimatedTime").setCellRenderer(celAlignCenter);
       table.getColumn("startTime").setPreferredWidth(240);
       table.getColumn("startTime").setCellRenderer(celAlignCenter);
       
    }
	
	public static void main(String[] args)
	{
		new FrameClass();
	}
}