package Gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Class.Constant;
import interf.Calculate_IF;
import interf.ConnectDB_interface;

import java.awt.BorderLayout;
import java.awt.Dimension;

public class GuiCalculator extends JPanel implements ActionListener {
	JButton btn_number1, btn_number2, btn_number3, btn_number4,
		btn_number5, btn_number6, btn_number7, btn_number8,
		btn_number9, btn_number0, btn_ac, btn_equal, 
		btn_minus, btn_plus, btn_multiply, btn_division; 
	private JTextArea txt_screen;
	
	private Constant constant = new Constant() ;
	
	private JLabel lblView ; 
	public Vector<String> vt_history ; 
	public JList list ; 
	private String idUser ; 

	/**
	 * Create the panel.
	 */
	public GuiCalculator(JLabel lblView,Vector<String> vt_history, JList list, String idUser) {
		this.lblView = lblView ; 
		this.vt_history = vt_history; 
		this.list = list ; 
		this.idUser = idUser ; 
		JPanel panelTinh = new JPanel();
		this.setLayout(new BorderLayout(0, 0));
		
		txt_screen = new JTextArea() ; 	
		txt_screen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.add(txt_screen, BorderLayout.NORTH);
		txt_screen.setColumns(100);
		txt_screen.setPreferredSize(new Dimension(100,100));
		JPanel panel = new JPanel();
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4,4, 5, 5));
		
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
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btn_number0)) {
			txt_screen.append("0");
		}else if(e.getSource().equals(btn_number1)) {
			txt_screen.append("1");
			
		}else if(e.getSource().equals(btn_number2)) {
			txt_screen.append("2");
			
		}else if(e.getSource().equals(btn_number3)) {
			txt_screen.append("3");
			
		}else if(e.getSource().equals(btn_number4)) {
			txt_screen.append("4");
			
		}else if(e.getSource().equals(btn_number5)) {
			txt_screen.append("5");

		}else if(e.getSource().equals(btn_number6)) {
			txt_screen.append("6");

		}else if(e.getSource().equals(btn_number7)) {
			txt_screen.append("7");

		}else if(e.getSource().equals(btn_number8)) {
			txt_screen.append("8");

		}else if(e.getSource().equals(btn_number9)) {
			txt_screen.append("9");

		}else if(e.getSource().equals(btn_ac)) {
			txt_screen.setText("");

		}else if(e.getSource().equals(btn_plus)) {
			txt_screen.append("+");
			
		}else if(e.getSource().equals(btn_minus)) {
			txt_screen.append("-");

		}else if(e.getSource().equals(btn_division)) {	
			txt_screen.append("/");

		}else if(e.getSource().equals(btn_equal)) {
			calcualator(); 
			txt_screen.setText("");

		}else if(e.getSource().equals(btn_multiply)) {
			txt_screen.append("*");

		}
		
		
	}
	public void calcualator() {
		try {
			Calculate_IF obj= (Calculate_IF)Naming.lookup(  "rmi://" + constant.HOST + "/calculate");
			Float result = obj.getResult(txt_screen.getText()) ; 
			
			this.lblView.setText(txt_screen.getText()+ " = " + result) ; 
		//	sendMessage() ;
			updateHistory(txt_screen.getText()+ " = " + result) ; 
			insertDB(txt_screen.getText()+ " = " + result) ; 
		}catch(Exception e) {
			System.out.println(e.getMessage()); 
		}

	}
	public void updateHistory(String s) {
		vt_history.add(s);
		list.updateUI();
	}
	
	public void insertDB(String s) {
		ConnectDB_interface obj=null;
		try {
			obj=(ConnectDB_interface)Naming.lookup("rmi://" +  constant.HOST + "/db");
	
		
		
			String sql =  "INSERT INTO `calculator`(`idUser`, `history`) VALUES ("+this.idUser+",'"+ s + "')"; 
			
		
			if( obj.changeData(sql) == 1 ) {
				System.out.println("thanh cong");
			}else {
				System.out.println("That bai");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
