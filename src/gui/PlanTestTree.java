package gui;

import java.awt.Dimension;

import javax.swing.JTree;

public class PlanTestTree extends JTree {

	private static final long serialVersionUID = 1L;
	
	public PlanTestTree() {
		super();
		this.setPreferredSize(new Dimension(150, 300));
		
		this.removeAll();
		
	}

}
