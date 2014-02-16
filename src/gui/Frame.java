package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import tools.Constants;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton slaveButton;
	private JButton monitoringButton;
	private SlavesPanel slavePanel;
	private MonitoringPanel monitoringPanel;
	private PlanTestTree planTestTree;
	private TestPanel testPanel;

	public Frame() {
		super();
		initialize();
		this.setVisible(true);
	}

	private void initialize() {
		this.setTitle(Constants.TITLE);
		this.setSize(Constants.FRAME_SIZE_X, Constants.FRAME_SIZE_Y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.initMenu();
		this.initPanels();
	}

	private void initMenu() {
		JMenuBar bar = new JMenuBar();
		this.setJMenuBar(bar);

		JMenu fileMenu = new JMenu(Constants.MENU_FILE);

		JMenu newMenu = new JMenu(Constants.MENU_FILE_NEW);

		JMenuItem newScalabilityItem = new JMenuItem(Constants.MENU_FILE_NEW_SCALABILITY);
		JMenuItem newWorkloadItem = new JMenuItem(Constants.MENU_FILE_NEW_WORKLOAD);
		JMenuItem openItem = new JMenuItem(Constants.MENU_FILE_OPEN);
		JMenuItem saveItem = new JMenuItem(Constants.MENU_FILE_SAVE);

		JMenuItem quitItem = new JMenuItem(Constants.MENU_FILE_QUIT);
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
		
		this.slaveButton = new JButton(Constants.FRAME_SLAVES);
		this.slaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showSlavesPanel();
			}
		});
		
		this.monitoringButton = new JButton(Constants.FRAME_MONITORING);
		this.monitoringButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showMonitoringPanel();
			}
		});
		
		grid.add(this.slaveButton);
		grid.add(this.monitoringButton);
		container.add(grid, BorderLayout.NORTH);
		
		testPanel = new TestPanel();
		this.planTestTree = new PlanTestTree(this.testPanel);
		container.add(this.planTestTree, BorderLayout.CENTER);
		this.planTestTree.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent arg0) {
			}
			
			public void focusGained(FocusEvent arg0) {
				showTestPanel();
			}
		});

	    this.add(container, BorderLayout.WEST);
	    this.slavePanel = new SlavesPanel();
	    this.slavePanel.setVisible(false);
	    
	    this.monitoringPanel = new MonitoringPanel();
	    this.monitoringPanel.setVisible(false);
	    
	    JPanel center = new JPanel();
	    center.add(this.slavePanel);
	    center.add(this.monitoringPanel);
	    center.add(this.testPanel);
	    this.add(center, BorderLayout.CENTER);
	}
	
	private void showSlavesPanel() {
		this.slavePanel.setVisible(true);
		this.monitoringPanel.setVisible(false);
		this.testPanel.setVisible(false);
	}
	
	private void showMonitoringPanel() {
		this.monitoringPanel.setVisible(true);
		this.slavePanel.setVisible(false);
		this.testPanel.setVisible(false);
	}
	
	private void showTestPanel() {
		this.monitoringPanel.setVisible(false);
		this.slavePanel.setVisible(false);
		this.testPanel.setVisible(true);
	}

}
