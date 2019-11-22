package View;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ClientController.ApplicationController;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
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
