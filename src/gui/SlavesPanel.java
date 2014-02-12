package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SlavesPanel extends JPanel {

	private static final long serialVersionUID = 1L;

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
		
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(2, 1));
		grid.add(new JButton("Add"));
		grid.add(new JButton("Remove"));
		this.add(grid);
	}
}
