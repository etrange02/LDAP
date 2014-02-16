package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import tools.Constants;

public abstract class AbstractTestPanel extends JPanel {

	private static final long serialVersionUID = 2233649581928260954L;
	private JButton deployRunButton;
	private JButton stopButton;
	
	protected void initPanel() {
		JPanel grid = new JPanel(new GridLayout(1, 2));
		
		deployRunButton = new JButton(Constants.TEST_DEPLOY_ACTION);
		stopButton = new JButton(Constants.TEST_STOP_ACTION);
		
		deployRunButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deployRunButtonAction(e);
			}
		});
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopButtonAction(e);
			}
		});
		
		grid.add(deployRunButton);
		grid.add(stopButton);
		
		this.add(grid);
	}
	
	protected abstract void deployRunButtonAction(ActionEvent e);
	protected abstract void stopButtonAction(ActionEvent e);

}
