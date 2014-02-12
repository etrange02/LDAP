package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton slaveButton;
	private JButton monitoringButton;
	private SlavesPanel slavePanel;
	private MonitoringPanel monitoringPanel;

	public Frame() {
		super();
		initialize();
		this.setVisible(true);
	}

	private void initialize() {
		this.setTitle("PerfTest");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.initMenu();
		this.initPanels();
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

	private void initPanels() {
		JPanel container = new JPanel(new BorderLayout());
		
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(2, 1));
		
		slaveButton = new JButton("Slaves");
		slaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showSlavesPanel();
			}
		});
		
		monitoringButton = new JButton("Monitoring");
		monitoringButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showMonitoringPanel();
			}
		});
		
		grid.add(slaveButton);
		grid.add(monitoringButton);
		container.add(grid, BorderLayout.NORTH);
		
		container.add(new PlanTestTree(), BorderLayout.CENTER);

	    this.add(container, BorderLayout.WEST);
	    slavePanel = new SlavesPanel();
	    slavePanel.setVisible(false);
	    
	    monitoringPanel = new MonitoringPanel();
	    monitoringPanel.setVisible(false);
	    
	    JPanel center = new JPanel();
	    center.add(slavePanel);
	    center.add(monitoringPanel);
	    this.add(center, BorderLayout.CENTER);
	}
	
	private void showSlavesPanel() {
		slavePanel.setVisible(true);
		monitoringPanel.setVisible(false);
	}
	
	private void showMonitoringPanel() {
		monitoringPanel.setVisible(true);
		slavePanel.setVisible(false);
	}

}
