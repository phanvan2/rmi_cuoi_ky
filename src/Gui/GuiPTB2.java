package Gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;

import Class.Constant;
import interf.Calculate_IF;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.rmi.Naming;
import java.util.Vector;

public class GuiPTB2 extends JPanel implements ActionListener, FocusListener{
	private JTextField txt_c;
	private JTextField txt_b;
	private JTextField txt_a;

	
	JButton btn_number1, btn_number2, btn_number3, btn_number4,
	btn_number5, btn_number6, btn_number7, btn_number8,
	btn_number9, btn_number0, btn_ac, btn_equal, 
	btn_minus, btn_plus, btn_multiply, btn_division; 
	
	private Constant constant = new Constant() ;

	
	private JLabel lblView ; 
	public Vector<String> vt_history ; 
	public JList list ; 

	/**
	 * Create the panel.
	 */
	public GuiPTB2(JLabel lblView,Vector<String> vt_history, JList list) {
		this.lblView = lblView ; 
		this.vt_history = vt_history; 
		this.list = list ; 
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_view = new JPanel();
		add(panel_view, BorderLayout.NORTH);
		
		txt_a = new JTextField("a");
		txt_a.setHorizontalAlignment(JTextField.CENTER);
		txt_a.setForeground(Color.gray);
		txt_a.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txt_a.addFocusListener(this);
		panel_view.add(txt_a);
		txt_a.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("<html>x<sup>2<sup</html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_view.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("+");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_view.add(lblNewLabel_1);
		
		txt_b = new JTextField("b");
		txt_b.setHorizontalAlignment(JTextField.CENTER);
		txt_b.setForeground(Color.gray);
		txt_b.addFocusListener(this); 
		panel_view.add(txt_b);
		txt_b.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("x");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_view.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("+");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_view.add(lblNewLabel_3);
		
		txt_c = new JTextField("c");
		txt_c.setHorizontalAlignment(JTextField.CENTER);
		txt_c.setForeground(Color.gray);
		txt_c.addFocusListener(this); 
		panel_view.add(txt_c);
		txt_c.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("=");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_view.add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4,4));
		btn_number7 = new JButton("");
		constant.addIconButton(constant.LINK_PATH_IMAGE + "number7.png", btn_number7, 70, 50);
		btn_number7.addActionListener(this);
		panel.add(btn_number7);
		
		 btn_number8 = new JButton("");
			constant.addIconButton(constant.LINK_PATH_IMAGE + "number8.png", btn_number8, 70, 50);
		panel.add(btn_number8);
		btn_number8.addActionListener(this);
		
		 btn_number9 = new JButton("");
		constant.addIconButton(constant.LINK_PATH_IMAGE + "number9.png", btn_number9, 70, 50);
		panel.add(btn_number9);
		btn_number9.addActionListener(this);
		
		 btn_ac = new JButton("");
		constant.addIconButton(constant.LINK_PATH_IMAGE + "AC.jpg", btn_ac, 70, 50);
		panel.add(btn_ac);
		btn_ac.addActionListener(this);
		
		 btn_number4 = new JButton("");
			constant.addIconButton(constant.LINK_PATH_IMAGE + "number4.png", btn_number4, 70, 50);
		panel.add(btn_number4);
		btn_number4.addActionListener(this);
		
		 btn_number5 = new JButton("");
			constant.addIconButton(constant.LINK_PATH_IMAGE + "number5.png", btn_number5, 70, 50);
		panel.add(btn_number5);
		btn_number5.addActionListener(this);
		
		 btn_number6 = new JButton("");
			constant.addIconButton(constant.LINK_PATH_IMAGE + "number6.png", btn_number6, 70, 50);
		panel.add(btn_number6);
		btn_number6.addActionListener(this);
		
		 btn_multiply = new JButton("");
		 constant.addIconButton(constant.LINK_PATH_IMAGE + "nhan.jpg", btn_multiply, 50, 50);
		panel.add(btn_multiply);
		btn_multiply.addActionListener(this);
		
		 btn_number1 = new JButton("");
			constant.addIconButton(constant.LINK_PATH_IMAGE + "number1.png", btn_number1, 70, 50);
		panel.add(btn_number1);
		btn_number1.addActionListener(this);
		
		 btn_number2 = new JButton("");
			constant.addIconButton(constant.LINK_PATH_IMAGE + "number2.png", btn_number2, 70, 50);
		panel.add(btn_number2);
		btn_number2.addActionListener(this);
		
		 btn_number3 = new JButton("");
			constant.addIconButton(constant.LINK_PATH_IMAGE + "number3.png", btn_number3, 70, 50);
		panel.add(btn_number3);
		btn_number3.addActionListener(this);
		
		 btn_division = new JButton("");
		panel.add(btn_division);
		constant.addIconButton(constant.LINK_PATH_IMAGE + "divide-docomo.png", btn_division, 50, 50);
		btn_division.addActionListener(this);
		
		 btn_number0 = new JButton("");
			constant.addIconButton(constant.LINK_PATH_IMAGE + "number0.png", btn_number0, 70, 50);
		panel.add(btn_number0);
		btn_number0.addActionListener(this);
		
		 btn_plus = new JButton("");
		constant.addIconButton(constant.LINK_PATH_IMAGE + "plus.jpg", btn_plus, 50, 50);
		panel.add(btn_plus);
		btn_plus.addActionListener(this);
		
		 btn_minus = new JButton("");
		constant.addIconButton(constant.LINK_PATH_IMAGE + "tru2.jpg", btn_minus, 80, 40);
		panel.add(btn_minus);
		btn_minus.addActionListener(this);
		
		 btn_equal = new JButton("");
		constant.addIconButton(constant.LINK_PATH_IMAGE + "daubang.jpg", btn_equal, 80, 40);
		panel.add(btn_equal);
		btn_equal.addActionListener(this);
		
		
		this.add(panel, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JTextField txtSelect ; 
		
		//txt_a.is
		
		if(e.getSource().equals(btn_number0)) {
			//txt_screen.append("0");
		}else if(e.getSource().equals(btn_number1)) {
		//	txt_screen.append("1");
			
		}else if(e.getSource().equals(btn_number2)) {
		//	txt_screen.append("2");
			
		}else if(e.getSource().equals(btn_number3)) {
		//	txt_screen.append("3");
			
		}else if(e.getSource().equals(btn_number4)) {
		//	txt_screen.append("4");
			
		}else if(e.getSource().equals(btn_number5)) {
		//	txt_screen.append("5");

		}else if(e.getSource().equals(btn_number6)) {
		//	txt_screen.append("6");

		}else if(e.getSource().equals(btn_number7)) {
		//	txt_screen.append("7");

		}else if(e.getSource().equals(btn_number8)) {
		//	txt_screen.append("8");

		}else if(e.getSource().equals(btn_number9)) {
		//	txt_screen.append("9");

		}else if(e.getSource().equals(btn_ac)) {
		//	txt_screen.setText("");

		}else if(e.getSource().equals(btn_plus)) {
		//	txt_screen.append("+");
			
		}else if(e.getSource().equals(btn_minus)) {
		//	txt_screen.append("-");

		}else if(e.getSource().equals(btn_division)) {
		//	txt_screen.append("/");

		}else if(e.getSource().equals(btn_equal)) {
			calcualator(); 
		//	txt_screen.setText("");

		}else if(e.getSource().equals(btn_multiply)) {
		//	txt_screen.append("*");
//
		}
	}
	public void calcualator() {
		try {
			String a = txt_a.getText();
			String b = txt_b.getText();
			String c = txt_c.getText();
			
			Calculate_IF obj= (Calculate_IF)Naming.lookup(  "rmi://" + new Constant().HOST + "/calculate");
			String result = obj.giaiPTBac2( Float.parseFloat(a) ,  Float.parseFloat(b),  Float.parseFloat(c)); 
			
			this.lblView.setText(result) ; 
		//	sendMessage() ;
			updateHistory("vừa thực hiện phép tính " + result) ;
		}catch(Exception e) {
			System.out.println(e.getMessage()); 
		}

	}
	public void updateHistory(String s) {
		vt_history.add(s);
		list.updateUI();
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(txt_a)) {
			if(txt_a.getText().equals("a")) {
				txt_a.setText("");
				txt_a.setForeground(Color.black);
			}
		}
		if(e.getSource().equals(txt_b)) {
			if(txt_b.getText().equals("b")) {
				txt_b.setText("");
				txt_b.setForeground(Color.black);
			}
		}
		if(e.getSource().equals(txt_c)) {
			if(txt_c.getText().equals("c")) {
				txt_c.setText("");
				txt_c.setForeground(Color.black);
			}
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(txt_a)) {
			if( txt_a.getText().equals("")) {
				txt_a.setText("a");
				txt_a.setForeground(Color.gray);
			}

		}
		if(e.getSource().equals(txt_b)) {
			if(txt_b.getText().equals("")) {
				txt_b.setText("b");
				txt_b.setForeground(Color.gray);
			}
		}
		if(e.getSource().equals(txt_c)) {
			if(txt_c.getText().equals("")) {
				txt_c.setText("c");
				txt_c.setForeground(Color.gray);
			}
		}
	}

}
