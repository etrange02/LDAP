package main;

import javax.swing.UIManager;

import gui.Frame;

public class Main {
	
	public static void main(String [] arg) {
		/*try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		new Frame();
	}

}
