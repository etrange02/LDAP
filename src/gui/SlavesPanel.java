package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SlavesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton addButton;
	private JButton removeButton;
	private JButton autodetectButton;
	private JTable table;

	public SlavesPanel() {
		super();
		initPanel();
	}
	
	private void initPanel() {
		this.setLayout(new BorderLayout());
		
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(1, 3));
		
		this.addButton= new JButton("Add");
		this.removeButton = new JButton("Remove");
		this.autodetectButton = new JButton("Auto detect");
		
		this.addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAction(e);
			}
		});
		this.removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAction(e);
			}
		});
		this.autodetectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				autodetectAction(e);
			}
		});
		
		grid.add(this.addButton);
		grid.add(this.removeButton);
		grid.add(this.autodetectButton);
		this.add(grid, BorderLayout.NORTH);
		
		String titles[] = {"Id", "IP address"};
		Object[][] data = {
				{"1", "213.254.132.132"},
				{"2", "123.123.123.123"}
		};
		this.table = new JTable(new SlaveTableModel(data, titles));
		this.add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	private void addAction(ActionEvent e) {
		System.out.println("Action button presses !");
		((SlaveTableModel) this.table.getModel()).addRow(new Object[] {"" + (this.table.getModel().getRowCount()+1), "654.3241.654.6354"});
	}
	
	private void removeAction(ActionEvent e) {
		System.out.println("Remove button presses !");
		
		int[] selectedLines = this.table.getSelectedRows();
		
		System.out.println(selectedLines.length);
		for (int i = selectedLines.length; i > 0; i--) {
			System.out.println(selectedLines[i-1]);
			((SlaveTableModel) this.table.getModel()).removeRow(selectedLines[i-1]);
		}
	}
	
	private void autodetectAction(ActionEvent e) {
		System.out.println("Auto detect button presses !");
	}
}
