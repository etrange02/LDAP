package gui;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SlavesPanel extends JPanel {

	public SlavesPanel() {
		super();
		initPanel();
	}
	
	private void initPanel() {
		
		String titles[] = {"Id", "IP address"};
		Object[][] data = {
				{"1", "213.254.132.132"},
				{"2", "123.123.123.123"}
		};
		JTable table = new JTable(data, titles);
		this.add(new JScrollPane(table));
	}
}
