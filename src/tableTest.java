import javax.swing.*;

public class tableTest extends JFrame {
	public tableTest() {
		String colNames[] = {
				"��ǰ��ȣ","��ǰ�̸�","��ǰ����","��ǰ����"
		};
		Object rowData[][] = {
				{"1","������",100,"������" },
				{"2","������",200,"�ҷ���ǰ" },
				{"3","ĭ����",300,"������" }
		};
	
		JTable tabletest = new JTable(rowData,colNames);
		JScrollPane Scrtest = new JScrollPane(tabletest);
		add(Scrtest);

		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args)
	{
		new tableTest();
	}
}
