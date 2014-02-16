package gui;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;

public class TestPanel extends JPanel {

	private static final long serialVersionUID = 3793285879398231346L;
	private JPanel associatedVisiblePanel;
	private Map<DefaultMutableTreeNode, AbstractTestPanel> mapNodePanel;
	
	public TestPanel() {
		super();
		this.mapNodePanel = new HashMap<>();
	}
	
	public void hideVisibleAssociatedPanel() {
		if (this.associatedVisiblePanel == null)
			return;
		this.associatedVisiblePanel.setVisible(false);
		this.associatedVisiblePanel = null;
	}
	
	public void addNode(DefaultMutableTreeNode node) {
		this.addNode(node, null);
	}
	
	public void addNode(DefaultMutableTreeNode node, AbstractTestPanel panel) {
		if (panel != null) {
			this.add(panel);
			panel.setVisible(false);
		}
		this.mapNodePanel.put(node, panel);
	}
	
	public void showAssociatedPanel(DefaultMutableTreeNode node) {
		hideVisibleAssociatedPanel();
		if (this.mapNodePanel.containsKey(node)) {
			this.associatedVisiblePanel = this.mapNodePanel.get(node);
			if (this.associatedVisiblePanel != null)
				this.associatedVisiblePanel.setVisible(true);
		}		
	}
}
