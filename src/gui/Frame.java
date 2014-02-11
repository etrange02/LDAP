package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public Frame() {
		super();
		initialize();
		this.setVisible(true);
	}
	
	private void initialize() {
		this.setTitle("PerfTest");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.initMenu();
		this.getContentPane().add(new PlanTestTree(), BorderLayout.WEST);
		this.getContentPane().add(new ScalabilityTest(), BorderLayout.CENTER);
	}
	
	private void initMenu() {
		JMenuBar bar = new JMenuBar();
		this.setJMenuBar(bar);
		
		JMenu fileMenu = new JMenu("File");
		
		JMenu newMenu = new JMenu("New");

		JMenuItem newWorkloadItem = new JMenuItem("Workload test");
		JMenuItem newScalabilityItem = new JMenuItem("Scalability test");
		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem saveItem = new JMenuItem("Save");
		
		JMenuItem quitItem = new JMenuItem("Quit");
		quitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		fileMenu.add(newMenu);
		newMenu.add(newScalabilityItem);
		newMenu.add(newWorkloadItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(quitItem);
		bar.add(fileMenu);
	}

}
