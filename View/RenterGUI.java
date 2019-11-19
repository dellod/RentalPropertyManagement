package View;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ClientController.ApplicationController;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RenterGUI extends Application
{

	private JFrame frmRentalPropertyrenter;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void RenterScreen(ApplicationController c) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RenterGUI window = new RenterGUI(c);
					window.frmRentalPropertyrenter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RenterGUI(ApplicationController c) 
	{
		this.theClient = c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRentalPropertyrenter = new JFrame();
		frmRentalPropertyrenter.setTitle("Rental Property (Renter)");
		frmRentalPropertyrenter.setBounds(100, 100, 650, 450);
		frmRentalPropertyrenter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRentalPropertyrenter.getContentPane().setLayout(null);
		
		JLabel lblWelcomeRenter = new JLabel("Welcome Renter!");
		lblWelcomeRenter.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 20));
		lblWelcomeRenter.setBounds(221, 81, 195, 39);
		frmRentalPropertyrenter.getContentPane().add(lblWelcomeRenter);
		
		JLabel lblPleaseEnterUsername = new JLabel("Please enter username and password (Don't have account? Continue for Regular Renter).");
		lblPleaseEnterUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPleaseEnterUsername.setBounds(77, 149, 491, 13);
		frmRentalPropertyrenter.getContentPane().add(lblPleaseEnterUsername);
		
		JLabel label_1 = new JLabel("Username");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(172, 172, 66, 13);
		frmRentalPropertyrenter.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(172, 208, 66, 13);
		frmRentalPropertyrenter.getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(248, 170, 96, 19);
		frmRentalPropertyrenter.getContentPane().add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(248, 206, 96, 19);
		frmRentalPropertyrenter.getContentPane().add(passwordField);
		
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				theClient.msgFromGUI[1] = "REGISTERED";
				theClient.msgFromGUI[2] = textField.getText();
				theClient.msgFromGUI[3] = new String(passwordField.getPassword());
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setBounds(182, 235, 96, 21);
		frmRentalPropertyrenter.getContentPane().add(button);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				theClient.msgFromGUI[1] = "REGULAR";
			}
		});
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnContinue.setBounds(287, 235, 96, 21);
		frmRentalPropertyrenter.getContentPane().add(btnContinue);
	}
}
