package Gui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GuiControl extends JPanel {

	/**
	 * Create the panel.
	 */
	public GuiControl() {
		setLayout(new GridLayout(0, 1, 20, 20));
		
		JLabel lblNewLabel = new JLabel("");
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		add(lblNewLabel_1);

	}

}
