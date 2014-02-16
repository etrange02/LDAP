package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import tools.Constants;


public class PlanTestTree extends JTree {

	private static final long serialVersionUID = 1L;
	private DefaultMutableTreeNode root;
	private DefaultTreeModel model;
	private JPopupMenu popupMenuPlan;
	private JPopupMenu popupMenuTest;
	private JPopupMenu popupMenuInstruction;
	private TestPanel testPanel;
	
	public PlanTestTree(TestPanel testplan) {
		super();
		//this.setPreferredSize(new Dimension(150, 300));
		
		
		this.root = new DefaultMutableTreeNode(Constants.TREE_PLAN_TEST);
		this.model = new DefaultTreeModel(root);
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("fils !");
		root.add(node);
		this.setModel(model);
		
		this.testPanel = testplan;
		this.testPanel.addNode(root);
		this.testPanel.addNode(node, new ScalabilityPanel());
		//this.setEditable(true);
		//this.setRootVisible(false);
		
		this.getModel().addTreeModelListener(new TreeModelListener() {
			
			@Override
			public void treeStructureChanged(TreeModelEvent arg0) {
				System.out.println("treeStructureChanged");
			}
			
			@Override
			public void treeNodesRemoved(TreeModelEvent arg0) {
				System.out.println("treeNodesRemoved");
			}
			
			@Override
			public void treeNodesInserted(TreeModelEvent arg0) {
				System.out.println("treeNodesInserted");
			}
			
			@Override
			public void treeNodesChanged(TreeModelEvent evt) {
				System.out.println("treeNodesChanged");
				Object[] listNoeuds = evt.getChildren();
		        int[] listIndices = evt.getChildIndices();
		        for (int i = 0; i < listNoeuds.length; i++) {
		          System.out.println("Index " + listIndices[i] + ", nouvelle valeur :" + listNoeuds[i]);
		        }
			}
		});
		
		this.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				treeValueChanged(e);
			}
		});
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				treeMousePressed(e);
			}
		});
		
		this.popupMenuPlan = new JPopupMenu();
		JMenuItem scalabilityItem = new JMenuItem(Constants.TREE_POPUPMENU_ADD_SCALABILITY);
		JMenuItem workloadItem = new JMenuItem(Constants.TREE_POPUPMENU_ADD_WORKLOAD);
		this.popupMenuPlan.add(scalabilityItem);
		this.popupMenuPlan.add(workloadItem);
		
		this.popupMenuTest = new JPopupMenu();
		JMenuItem addInstruction = new JMenuItem(Constants.TREE_POPUPMENU_ADD_INSTRUCTION);
		JMenuItem renameTest = new JMenuItem(Constants.TREE_POPUPMENU_RENAME_TEST);
		this.popupMenuTest.add(addInstruction);
		this.popupMenuTest.add(renameTest);
		
		this.popupMenuInstruction = new JPopupMenu();
		JMenuItem removeInstruction = new JMenuItem(Constants.TREE_POPUPMENU_REMOVE_INSTRUCTION);
		JMenuItem renameInstruction = new JMenuItem(Constants.TREE_POPUPMENU_RENAME_INSTRUCTION);
		this.popupMenuInstruction.add(removeInstruction);
		this.popupMenuInstruction.add(renameInstruction);
	}
	
	/*private void addTest() {
		System.out.println("addTest");
	}
	
	private void addInstruction() {
		System.out.println("addInstruction");
	}
	
	private void removeTest() {
		System.out.println("removeTest");
	}
	
	private void removeInstruction() {
		System.out.println("removeInstruction");
	}*/
	
	private void treeValueChanged(TreeSelectionEvent e) {
		System.out.println("valueChanged");
		int[] selected = this.getSelectionRows();
		if (selected.length > 0/* && this.root != e.getPath().getLastPathComponent()*/ ) {
			this.testPanel.showAssociatedPanel((DefaultMutableTreeNode) e.getPath().getLastPathComponent());
		}
	}
	
	private void treeMousePressed(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			int row = this.getRowForLocation(e.getX(), e.getY());
			
			TreePath path = this.getPathForLocation(e.getX(), e.getY());			
			
			if (row != -1) {
				this.setSelectionRow(row);
				switch (path.getPathCount()) {
					case 1:
						this.popupMenuPlan.show(this, e.getX(), e.getY());
						break;
					case 2:
						this.popupMenuTest.show(this, e.getX(), e.getY());
						break;
					case 3:
						this.popupMenuInstruction.show(this, e.getX(), e.getY());
						break;
					default:
						break;
				}
			}
		}
	}

}
