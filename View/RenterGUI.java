package View;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ClientController.ApplicationController;

public class RenterGUI extends Application
{

	private JFrame frmRentalPropertyrenter;

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
		frmRentalPropertyrenter.setBounds(100, 100, 450, 300);
		frmRentalPropertyrenter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
