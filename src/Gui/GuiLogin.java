package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import interf.ConnectDB_interface;
import server.User;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.Naming;
import java.security.MessageDigest;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GuiLogin extends JFrame implements ActionListener, FocusListener {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private ImageIcon imageIcon_show, imageIcon_hidden ; 
	private boolean iconPass = true ; // hidden 
	JLabel lblWarningUsername; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiLogin frame = new GuiLogin();
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
	public GuiLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		setTitle("RMI");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		try {// set icon giao dien---------------------------
			Image iconmes = ImageIO.read(new File("Image\\logo_rmi2.jpg"));
			this.setIconImage(iconmes); 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		
		}
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(187, 70, 196, 32);
		txtUsername.setHorizontalAlignment(JTextField.CENTER);
		txtUsername.setText("Type your username");
		txtUsername.setForeground(Color.gray);
		txtUsername.addFocusListener(this);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(187, 144, 196, 32);
		txtPassword.setHorizontalAlignment(JTextField.CENTER);
		txtPassword.setText("Type your password");
		txtPassword.setForeground(Color.gray);
		txtPassword.setEchoChar('\0');
		txtPassword.addFocusListener(this);
		panel.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lbUsername = new JLabel("Username: ");
		lbUsername.setForeground(new Color(0, 128, 0));
		lbUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbUsername.setBounds(65, 67, 112, 32);
		panel.add(lbUsername);
		
		JLabel lbPassword = new JLabel("Password: ");
		lbPassword.setForeground(new Color(0, 128, 0));
		lbPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbPassword.setBounds(65, 141, 114, 32);
		panel.add(lbPassword);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(34, 139, 34));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(110, 10, 196, 47);
		panel.add(lblNewLabel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(0, 128, 0));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setBounds(149, 211, 104, 21);
		btnLogin.addActionListener(this);
		panel.add(btnLogin);
		
		JLabel lbRegister = new JLabel("Register");
		lbRegister.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lbRegister.setBounds(324, 199, 59, 13);
		panel.add(lbRegister);
		
		JLabel lbIconPassword = new JLabel("");
		lbIconPassword.setBounds(385, 156, 45, 13);
		panel.add(lbIconPassword);
		
		try {
			BufferedImage bufferImage = ImageIO.read(new File("Image\\eye-look.png"));
			imageIcon_show = new ImageIcon(bufferImage.getScaledInstance(21, 15, Image.SCALE_SMOOTH));
			
			BufferedImage bufferImage_hidden = ImageIO.read(new File("Image\\hide-private-hidden.png"));
			imageIcon_hidden = new ImageIcon(bufferImage_hidden.getScaledInstance(21, 15, Image.SCALE_SMOOTH));
			lbIconPassword.setIcon(imageIcon_hidden);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		lblWarningUsername = new JLabel("username already in use");
		lblWarningUsername.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblWarningUsername.setForeground(Color.RED);
		lblWarningUsername.setBounds(187, 53, 208, 13);
		lblWarningUsername.setVisible(false);
		panel.add(lblWarningUsername);
		
		lbIconPassword.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(iconPass) {
					lbIconPassword.setIcon(imageIcon_show) ;
					iconPass = !iconPass; 
					txtPassword.setEchoChar('\0'); 
				}else {
					lbIconPassword.setIcon(imageIcon_hidden) ; 
					iconPass = !iconPass; 
					if (txtPassword.getText().equals("Type your password")) {
						txtPassword.setEchoChar('\0'); 
					}else {
						txtPassword.setEchoChar('*'); 
					}
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Login")) {
			ConnectDB_interface obj=null;
			try {
				obj=(ConnectDB_interface)Naming.lookup("rmi://192.168.1.148/login");

				String sql = "SELECT id, username FROM `user` WHERE username LIKE '"+ txtUsername.getText() + "' AND password LIKE '" + scryptWithMD5( txtPassword.getText() ) + "'" ; 
				User user = obj.findOneData(sql); 
				if( user == null) {
					JOptionPane.showMessageDialog(null, "Login Failed"); 
				}else {
					System.out.println("user: "+ user.getId() + ": " + user.getName());
					JOptionPane.showMessageDialog(null, "Login success"); 
					new GuiClient(user.getName()).setVisible(true); 
					setVisible(false);
				}
			}catch(Exception ee ) {
				System.out.println(ee.getMessage());
			}
		}
	}
	
	public String scryptWithMD5(String pass) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
	        byte[] passBytes = pass.getBytes();
	        md.reset();
	        byte[] digested = md.digest(passBytes);
	        StringBuffer sb = new StringBuffer();
	        for(int i=0;i<digested.length;i++){
	            sb.append(Integer.toHexString(0xff & digested[i]));
	        }
	        return sb.toString();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return null; 
	}

	

	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(txtUsername)) {
			if(txtUsername.getText().equals("Type your username")) {
				txtUsername.setText("");
				txtUsername.setForeground(Color.black);
			}
		}
		if(e.getSource().equals(txtPassword)) {
			if(txtPassword.getText().equals("Type your password")) {
				txtPassword.setText("");
				txtPassword.setForeground(Color.black);
				txtPassword.setEchoChar('*');
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(txtUsername)) {
			if( txtUsername.getText().equals("")) {
				txtUsername.setText("Type your username");
				txtUsername.setForeground(Color.gray);
			}
			

			
		}
		if(e.getSource().equals(txtPassword)) {
			if( txtPassword.getText().equals("")) {
				txtPassword.setText("Type your password");
				txtPassword.setForeground(Color.gray);
				txtPassword.setEchoChar('\0');
			}
		}
	}
	
}
