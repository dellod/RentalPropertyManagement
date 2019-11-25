package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class TESTING_REMOVELATER {

	private JFrame emailWindow;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TESTING_REMOVELATER window = new TESTING_REMOVELATER();
					window.searchWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the application.
	 */
	public TESTING_REMOVELATER() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		emailWindow = new JFrame();
		emailWindow.setTitle("Send Email");
		emailWindow.setBounds(100, 100, 450, 300);
		emailWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		emailWindow.getContentPane().setLayout(null);
		
		JLabel lblWriteEmailTo = new JLabel("Write email to landlord below (email of landlord will not be shown).");
		lblWriteEmailTo.setBounds(10, 10, 416, 13);
		emailWindow.getContentPane().add(lblWriteEmailTo);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(10, 33, 416, 194);
		emailWindow.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnSendEmail = new JButton("Send Email");
		btnSendEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSendEmail.setBounds(10, 237, 85, 21);
		emailWindow.getContentPane().add(btnSendEmail);
		
		
	}
}
