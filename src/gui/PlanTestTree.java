package gui;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


public class PlanTestTree extends JTree {

	private static final long serialVersionUID = 1L;
	
	public PlanTestTree() {
		super();
		//this.setPreferredSize(new Dimension(150, 300));
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
		DefaultTreeModel model = new DefaultTreeModel(root);
		root.add(new DefaultMutableTreeNode("fils !"));
		this.setModel(model);
	}

}
