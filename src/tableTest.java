import javax.swing.*;

public class tableTest extends JFrame {
	public tableTest() {
		String colNames[] = {
				"상품번호","상품이름","상품가격","상품설명"
		};
		Object rowData[][] = {
				{"1","맛동산",100,"오리온" },
				{"2","아폴로",200,"불량식품" },
				{"3","칸초코",300,"레전드" }
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
