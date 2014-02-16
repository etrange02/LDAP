package gui;

import javax.swing.table.AbstractTableModel;

public class SlaveTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = -6144226754812127470L;
	private Object[][] data;
	private String[] title;
	
	public SlaveTableModel(Object[][] data, String[] title) {
		this.data = data;
		this.title = title;
	}
	
	public String getColumnName(int columnIndex) {
		return this.title[columnIndex];
	}

	public int getColumnCount() {
		return this.title.length;
	}

	public int getRowCount() {
		return this.data.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return this.data[rowIndex][columnIndex];
	}
	
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		this.data[rowIndex][columnIndex] = value;
	}
	
	public Class getColumnClass(int columnIndex) {
		if (this.getRowCount() == 0)
			return null;
		return this.data[0][columnIndex].getClass();
	}
	
	public void removeRow(int rowIndex) {
		int rowNb = this.getRowCount() -1;
		int columnNb = this.getColumnCount();
		int index = 0, i = 0;
		
		Object temp[][] = new Object[rowNb][columnNb];
		
		for (Object[] value : this.data) {
			if (rowIndex != index)
			{
				value[0] = "" + (i+1);
				temp[i++] = value;
			}
			++index;
		}
		
		this.data = temp;
		temp = null;
		this.fireTableDataChanged();
	}
	
	public void addRow(Object[] data) {
		int rowNb = this.getRowCount() + 1;
		int columnNb = this.getColumnCount();
		int index = 0;
		
		Object temp[][] = new Object[rowNb][columnNb];
		
		for (Object[] value : this.data)
			temp[index++] = value;
		
		temp[index] = data;
		this.data = temp;
		temp = null;
		this.fireTableDataChanged();
	}

}
