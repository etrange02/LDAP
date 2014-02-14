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
	private PlanTestTree planTestTree;

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
		
		this.slaveButton = new JButton("Slaves");
		this.slaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showSlavesPanel();
			}
		});
		
		this.monitoringButton = new JButton("Monitoring");
		this.monitoringButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showMonitoringPanel();
			}
		});
		
		grid.add(this.slaveButton);
		grid.add(this.monitoringButton);
		container.add(grid, BorderLayout.NORTH);
		
		this.planTestTree = new PlanTestTree();
		container.add(this.planTestTree, BorderLayout.CENTER);

	    this.add(container, BorderLayout.WEST);
	    this.slavePanel = new SlavesPanel();
	    this.slavePanel.setVisible(false);
	    
	    this.monitoringPanel = new MonitoringPanel();
	    this.monitoringPanel.setVisible(false);
	    
	    JPanel center = new JPanel();
	    center.add(this.slavePanel);
	    center.add(this.monitoringPanel);
	    this.add(center, BorderLayout.CENTER);
	}
	
	private void showSlavesPanel() {
		this.slavePanel.setVisible(true);
		this.monitoringPanel.setVisible(false);
	}
	
	private void showMonitoringPanel() {
		this.monitoringPanel.setVisible(true);
		this.slavePanel.setVisible(false);
	}

}
