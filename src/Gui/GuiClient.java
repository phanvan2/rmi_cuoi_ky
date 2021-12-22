package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Class.ContentCell;
import Class.PacketUser;
import interf.Calculate_IF;
import interf.ConnectDB_interface;
import server.Calc;
import server.Mess;
import server.User;
import Class.Calculate;
import Class.ChatClient3;
import Class.Constant;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;

public class GuiClient extends JFrame implements ActionListener , MouseListener{

	private JPanel contentPane;
	private JTextField textSend;
	public Vector<String> vt_history = new Vector<String>() ; 
	public JList list ; 
	public Vector<String> list_data_chat = new Vector<String>() ; 
	public JList list_chat ; 
	private ChatClient3 chatClient;
	String username ; 
	JPanel panel_Main, panel_chatpublic; 
	CardLayout card ; 
	JLabel lblBack_calc = new JLabel("back") ; 
	JLabel lblBack_PTB2 = new JLabel("back") ; 
	JLabel lblBack_Chat = new JLabel("back") ; 

	private JButton btn_PTbc2, btn_tinh, btn_chat ; 
	private JTextArea txt_screen;
	private Constant constant ;
	private JLabel lblView ; 


	private String idUser  ;

	GuiMainChat panel_chatt  ; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiClient frame = new GuiClient("pvp", "5");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiClient(String s, String id) {
		super(s); 
		username = s ; 
		//this.idUser = Math.random() + "" + this.username ;
		this.idUser  =  id ; 
		constant = new Constant() ; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 764, 616);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		

		
		JPanel panel_view = new JPanel();
		panel_view.setPreferredSize(new Dimension(400, 100));
		panel_view.setBorder(BorderFactory.createLineBorder(Color.gray));
		contentPane.add(panel_view, BorderLayout.NORTH);
		panel_view.setLayout(new BorderLayout(0, 0));
		
		lblView = new JLabel("Reusult");
		lblView.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_view.add(lblView);
		
		JPanel panel_chat = new JPanel();
		panel_chat.setPreferredSize(new Dimension(200, 100));
		contentPane.add(panel_chat, BorderLayout.EAST);
		panel_chat.setLayout(new BorderLayout(0, 0));
		
	
		
		list = new JList(vt_history) ; 
		list.addMouseListener(this);
		initData(); 
		list.updateUI();
		list.setCellRenderer(new ContentCell());

		
		JScrollPane scroll_history = new JScrollPane(list);
		scroll_history.setPreferredSize(getPreferredSize());
		scroll_history.createVerticalScrollBar();
		scroll_history.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel_chat.add(scroll_history, BorderLayout.CENTER);
		
		panel_Main = new JPanel();
		panel_Main.setBorder(BorderFactory.createLineBorder(Color.gray));
		contentPane.add(panel_Main);
		
		
		card = new CardLayout();
		panel_Main.setLayout(card);
	
		JPanel panelControl = new JPanel();
		btn_tinh = new JButton("calculate");
		btn_tinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_tinh.setBorder(BorderFactory.createCompoundBorder());



		//btn_tinh.setBackground(new Color(0, 128, 0));
		btn_tinh.setBounds(103, 86, 318, 45);
		btn_tinh.addActionListener(this); 
		btn_PTbc2 = new JButton("Calculating quadratic equations"); 
		btn_PTbc2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_PTbc2.setBounds(103, 201, 318, 45);
		btn_PTbc2.addActionListener(this) ; 
		panelControl.setLayout(null);
		panelControl.add(btn_tinh);
		panelControl.add(btn_PTbc2); 
		panel_Main.add("control", panelControl);
		
		btn_chat = new JButton("Chat");
		btn_chat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_chat.setBounds(103, 321, 318, 45);
		panelControl.add(btn_chat);
		btn_chat.addActionListener(this);
		
		JPanel panelTinh = new JPanel();
		panelTinh.setLayout(new BorderLayout());
		panelTinh.add(lblBack_calc, BorderLayout.NORTH);
		lblBack_calc.addMouseListener(this);
		GuiCalculator guitest = new GuiCalculator(this.lblView, vt_history, list, this.idUser);
		panelTinh.add(guitest, BorderLayout.CENTER);
		panel_Main.add("tinh", panelTinh) ;
		
		JPanel pnPTB2 = new JPanel();
		pnPTB2.setLayout(new BorderLayout());
		pnPTB2.add(lblBack_PTB2, BorderLayout.NORTH); 
		lblBack_PTB2.addMouseListener(this);
		GuiPTB2 guiPTB2 = new GuiPTB2(this.lblView, vt_history, list);
		pnPTB2.add(guiPTB2, BorderLayout.CENTER);
		panel_Main.add("PTB2", pnPTB2);
		//panel_Main.add("tinh", guitest) ;

	

		
	
		
		
		try {
			getConnected(username);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		panel_chatpublic = new JPanel() ;
		panel_chatpublic.setLayout(new BorderLayout());
		panel_chatpublic.add(lblBack_Chat, BorderLayout.NORTH);
		lblBack_Chat.addMouseListener(this);
		panel_chatt = new GuiMainChat("public chat", "111publicChat", chatClient, null); 
		panel_chatpublic.add(panel_chatt, BorderLayout.CENTER); 
		panel_Main.add("chatPublic", panel_chatpublic) ; 

		try {// set icon giao dien---------------------------
			Image iconmes = ImageIO.read(new File(constant.LINK_PATH_IMAGE +  "calculator_icon.png"));
			this.setIconImage(iconmes); 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		
		}
	}
//	private void sendMessage(String chatMessage) throws RemoteException {
//		chatClient.serverIF.updateChat(username, chatMessage);
//	}

	private void getConnected(String userName) throws RemoteException{
		//remove whitespace and non word characters to avoid malformed url
		String cleanedUserName = userName.replaceAll("\\s+","_");
		cleanedUserName = userName.replaceAll("\\W+","_");
		try {		
			chatClient = new ChatClient3(this, cleanedUserName, this.idUser );

		//	chatClient = new ChatClient3(this, cleanedUserName);
			chatClient.startClient();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if( e.getSource().equals(btn_PTbc2)) {
			card.show(panel_Main, "PTB2");

		}else
		
		if(e.getSource().equals(btn_tinh)) {
			System.out.println("hello") ; 
			card.show(panel_Main, "tinh");
		}else
		if(e.getActionCommand().equals("Back")) {
			card.previous(panel_Main);
		}else if(e.getSource().equals(btn_chat)) {
			card.show( panel_Main,"chatPublic" );
		}
	
		
	}
	
	public void initData() {
		ConnectDB_interface obj=null;
		System.out.println("Init data");
		try {
			obj=(ConnectDB_interface)Naming.lookup("rmi://" +  new Constant().HOST + "/db");
			
			String sql_user = "SELECT * FROM `calculator` where idUser = " + this.idUser + ""  ; 
			Vector<Calc> vtdata=obj.getDataCalculator(sql_user); 
			for (Calc calc : vtdata) {
			//	System.out.println(mess.getContent());
				vt_history.add(calc.getHistory()); 
			}
	
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
	
	
//	public void calcualator() {
//		try {
//			Calculate_IF obj= (Calculate_IF)Naming.lookup(  "rmi://" + constant.HOST + "/calculate");
//			Float result = obj.getResult(txt_screen.getText()) ; 
//			
//			lblView.setText(txt_screen.getText()+ " = " + result) ; 
//		//	sendMessage() ;
//			updateHistory("vừa thực hiện phép tính " + result) ;
//		}catch(Exception e) {
//			System.out.println(e.getMessage()); 
//		}
//
//	}
//	
//	public void updateHistory(String s) {
//		vt_history.add(s);
//		list.updateUI();
//	}
	
	public GuiMainChat getGuiChat() {
		return this.panel_chatt ; 
	}
	public JLabel viewlabel() {
		return this.lblView ;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(lblBack_Chat) || e.getSource().equals(lblBack_calc) ||e.getSource().equals(lblBack_PTB2) )
			card.show(panel_Main, "control") ; 
		else if(e.getSource().equals(list)) {
			// TODO Auto-generated method stub
			JList theList = (JList) e.getSource(); 

			int index = theList.locationToIndex(e.getPoint()); 
			String s = (String)theList.getModel().getElementAt(index);
			lblView.setText(s);
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
