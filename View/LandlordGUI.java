package View;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ClientController.ApplicationController;

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
	}

}
