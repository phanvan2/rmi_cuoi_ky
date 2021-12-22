package Class;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class ContentCell implements ListCellRenderer {

	@Override
	public JPanel getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,boolean cellHasFocus) {
		// TODO Auto-generated method stub
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JLabel text = new JLabel(value.toString()); 
		panel.add(text, BorderLayout.CENTER);
//		if( value.toString().contains("Me")) {
//			panel.setBackground(Color.cyan);
//		}
		return panel;
	}
	

}
