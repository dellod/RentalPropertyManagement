package View;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class LandlordGUI extends Application
{

	private JFrame frmRentalPropertylandlord;

	/**
	 * Launch the application.
	 */
	public static void LandlordScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LandlordGUI window = new LandlordGUI();
					window.frmRentalPropertylandlord.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LandlordGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRentalPropertylandlord = new JFrame();
		frmRentalPropertylandlord.setTitle("Rental Property (Landlord)");
		frmRentalPropertylandlord.setBounds(100, 100, 450, 300);
		frmRentalPropertylandlord.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
