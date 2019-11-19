package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import ClientController.ApplicationController;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerGUI extends Application
{

	private JFrame frmRentalPropertymanager;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void ManagerScreen(ApplicationController c) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerGUI window = new ManagerGUI(c);
					window.frmRentalPropertymanager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create and launch the application.
	 */
	public ManagerGUI(ApplicationController c) 
	{
		this.theClient = c;
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRentalPropertymanager = new JFrame();
		frmRentalPropertymanager.setTitle("Rental Property (Manager)");
		frmRentalPropertymanager.setBounds(100, 100, 650, 450);
		frmRentalPropertymanager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRentalPropertymanager.getContentPane().setLayout(null);
		
		JLabel lblWelcomeManager = new JLabel("Welcome Manager!");
		lblWelcomeManager.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 20));
		lblWelcomeManager.setBounds(209, 69, 222, 39);
		frmRentalPropertymanager.getContentPane().add(lblWelcomeManager);
		
		JLabel lblPleaseEnterUsername = new JLabel("Please enter username and password (Don't have account? Register below!)");
		lblPleaseEnterUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPleaseEnterUsername.setBounds(116, 142, 423, 13);
		frmRentalPropertymanager.getContentPane().add(lblPleaseEnterUsername);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(209, 165, 66, 13);
		frmRentalPropertymanager.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(209, 200, 66, 13);
		frmRentalPropertymanager.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(285, 163, 96, 19);
		frmRentalPropertymanager.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(285, 198, 96, 19);
		frmRentalPropertymanager.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println(textField.getText());
				System.out.println(passwordField.getPassword());
				theClient.msgFromGUI[1] = textField.getText();
				theClient.msgFromGUI[2] = new String(passwordField.getPassword());
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setBounds(209, 243, 85, 21);
		frmRentalPropertymanager.getContentPane().add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegister.setBounds(314, 243, 85, 21);
		frmRentalPropertymanager.getContentPane().add(btnRegister);
	}
}
