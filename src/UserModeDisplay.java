import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class UserModeDisplay extends JFrame {
   UserModeDisplay() {
      setTitle("���� ���");
      setLayout(null);
      setResizable(false);
       setVisible(true);
       setSize(500,500);
      addWindowListener(new JFrameWindowClosingEventHandler());
      
      JPanel panel1 = new JPanel();
      String colNames[] = {
            "����","������","���� �Ⱓ","���� �ð�","�߿䵵"
      };
      Object rowData[][] = { };
      panel1.setLayout(new BorderLayout());
      JTable tabletest = new JTable(rowData,colNames);
      JScrollPane Scrtest = new JScrollPane(tabletest);
      panel1.add(Scrtest,BorderLayout.CENTER);
      panel1.setSize(400,300);
      panel1.setLocation(50,100 );
      getContentPane().add(panel1);
      
       JButton Complete = new JButton("Ȯ��");
        Complete.setFont(new Font("���� ���",Font.BOLD,13));
        Complete.setLocation(175,425);
        Complete.setSize(150,30);
        add(Complete);
        //Complete.addActionListener(new Complete_Action());      
      
         
   }
   static class JFrameWindowClosingEventHandler extends WindowAdapter {
      public void windowClosing(WindowEvent e) {
         JFrame frame = (JFrame)e.getWindow();
         frame.dispose();
      //   System.out.println("windowClosing()");
      }
   }
}
