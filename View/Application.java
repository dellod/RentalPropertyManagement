package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

class Application extends GUI
{

	private JFrame frmRentalProperty;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frmRentalProperty.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRentalProperty = new JFrame();
		frmRentalProperty.getContentPane().setForeground(Color.BLACK);
		frmRentalProperty.setTitle("Rental Property");
		frmRentalProperty.setBounds(100, 100, 544, 366);
		frmRentalProperty.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRentalProperty.getContentPane().setLayout(null);
		
		JButton btnManager = new JButton("Manager");
		btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//TODO add implementation, open another window gui
				System.out.println("Manager Selected");
				frmRentalProperty.dispose();
				ManagerGUI mg = new ManagerGUI();
				mg.ManagerScreen();
			}
		});
		btnManager.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnManager.setBounds(222, 136, 85, 21);
		frmRentalProperty.getContentPane().add(btnManager);
		
		JButton btnLandlord = new JButton("Landlord");
		btnLandlord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//TODO add implementation, open another window gui
				System.out.println("Landlord Selected");
				frmRentalProperty.dispose();
				LandlordGUI lg = new LandlordGUI();
				lg.LandlordScreen();
			}
		});
		btnLandlord.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnLandlord.setBounds(222, 167, 85, 21);
		frmRentalProperty.getContentPane().add(btnLandlord);
		
		JButton btnRenter = new JButton("Renter");
		btnRenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//TODO add implementation, open another window gui
				System.out.println("Renter Selected");
				frmRentalProperty.dispose();
				RenterGUI rg = new RenterGUI();
				rg.RenterScreen();
			}
		});
		btnRenter.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnRenter.setBounds(222, 198, 85, 21);
		frmRentalProperty.getContentPane().add(btnRenter);
		
		JLabel lblRentalPropertyApplication = new JLabel("\tRental Property Application");
		lblRentalPropertyApplication.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 25));
		lblRentalPropertyApplication.setBounds(98, 10, 360, 75);
		frmRentalProperty.getContentPane().add(lblRentalPropertyApplication);
		
		JLabel lblPleaseChooseThe = new JLabel("Please choose the type of user");
		lblPleaseChooseThe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPleaseChooseThe.setBounds(186, 113, 173, 13);
		frmRentalProperty.getContentPane().add(lblPleaseChooseThe);
		
		JLabel lblEnsfGroup = new JLabel("ENSF 480 Group 15: Daryl Dang, Will Huang, and Perjot Sidhu");
		lblEnsfGroup.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblEnsfGroup.setBounds(124, 306, 351, 13);
		frmRentalProperty.getContentPane().add(lblEnsfGroup);
	}
}
