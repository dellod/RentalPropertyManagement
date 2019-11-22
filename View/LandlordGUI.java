package View;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

import ClientController.ApplicationController;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LandlordGUI extends Application
{

	private JFrame frmRentalPropertylandlord;

	/**
	 * Launch the application.
	 */
	public static void LandlordScreen(ApplicationController c) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LandlordGUI window = new LandlordGUI(c);
					window.frmRentalPropertylandlord.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create and launch the application.
	 */
	public LandlordGUI(ApplicationController c) 
	{
		this.theClient = c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRentalPropertylandlord = new JFrame();
		frmRentalPropertylandlord.setTitle("Rental Property (Landlord)");
		frmRentalPropertylandlord.setBounds(100, 100, 650, 450);
		frmRentalPropertylandlord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRentalPropertylandlord.getContentPane().setLayout(null);
		
		JButton btnRegister = new JButton("Register Property");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				theClient.msgFromGUI[1] = "REGISTER";
				PropertyRegistration pr = new PropertyRegistration(theClient);
				pr.PropertyRegistrationScreen(theClient);
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegister.setBounds(242, 141, 136, 21);
		frmRentalPropertylandlord.getContentPane().add(btnRegister);
		
		JButton btnState = new JButton("State of Property");
		btnState.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				theClient.msgFromGUI[1] = "STATE";

				JFrame changeState = new JFrame("State of Property");
				changeState.setPreferredSize(new Dimension(300, 150));
				changeState.setLocationRelativeTo(frmRentalPropertylandlord);
				changeState.getContentPane().setLayout(null);
				
				JLabel lblpropId = new JLabel("Property ID: ");
				lblpropId.setBounds(5, 5, 178, 19);
				JTextField txtPropertyID = new JTextField();
				txtPropertyID.setBounds(100, 5, 178, 19);
				JLabel lblState = new JLabel("New State: ");
				lblState.setBounds(5, 35, 178, 19);
				JTextField txtNewState = new JTextField();
				txtNewState.setBounds(100, 35, 178, 19);
				JButton btnChange = new JButton("Change");
				
				btnChange.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						theClient.msgFromGUI[2] = "CHANGE";
						theClient.msgFromGUI[3] = txtPropertyID.getText();
						theClient.msgFromGUI[4] = txtNewState.getText();
					}
				});
				btnChange.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnChange.setBounds(50, 65, 100, 20);
				
				changeState.getContentPane().add(btnChange);
				changeState.getContentPane().add(lblpropId);
				changeState.getContentPane().add(txtPropertyID);
				changeState.getContentPane().add(lblState);
				changeState.getContentPane().add(txtNewState);
				
				changeState.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				changeState.pack();
				changeState.setVisible(true);
			}
		});
		btnState.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnState.setBounds(242, 182, 136, 21);
		frmRentalPropertylandlord.getContentPane().add(btnState);
		
		JLabel lblWelcomeLandlord = new JLabel("Welcome Landlord!");
		lblWelcomeLandlord.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 20));
		lblWelcomeLandlord.setBounds(211, 81, 254, 39);
		frmRentalPropertylandlord.getContentPane().add(lblWelcomeLandlord);
	}
}
