package View;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ClientController.ApplicationController;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class PropertyRegistration extends LandlordGUI
{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void PropertyRegistrationScreen(ApplicationController c) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PropertyRegistration window = new PropertyRegistration(c);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PropertyRegistration(ApplicationController c) 
	{
		super(c);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegister.setBounds(10, 432, 85, 21);
		frame.getContentPane().add(btnRegister);
		
		JButton btnPostOnline = new JButton("Post Online");
		btnPostOnline.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPostOnline.setBounds(114, 432, 102, 21);
		frame.getContentPane().add(btnPostOnline);
		
		JLabel lblRegisterProperty = new JLabel("Register Property");
		lblRegisterProperty.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblRegisterProperty.setBounds(10, 10, 206, 39);
		frame.getContentPane().add(lblRegisterProperty);
		
		JLabel lblNewLabel = new JLabel("Personal Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 59, 206, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("First Name");
		lblName.setBounds(10, 82, 66, 13);
		frame.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBounds(75, 79, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(176, 82, 66, 13);
		frame.getContentPane().add(lblLastName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(253, 79, 96, 19);
		frame.getContentPane().add(textField_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 111, 46, 13);
		frame.getContentPane().add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(49, 108, 178, 19);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("Gender(M/F)");
		lblNewLabel_1.setBounds(359, 82, 74, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(237, 108, 46, 13);
		frame.getContentPane().add(lblAddress);
		
		textField_3 = new JTextField();
		textField_3.setBounds(293, 108, 183, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(436, 79, 40, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
	}
}
