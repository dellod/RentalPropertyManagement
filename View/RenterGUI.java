package View;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class RenterGUI {

	private JFrame frmRentalPropertyrenter;

	/**
	 * Launch the application.
	 */
	public static void RenterScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RenterGUI window = new RenterGUI();
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
	public RenterGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRentalPropertyrenter = new JFrame();
		frmRentalPropertyrenter.setTitle("Rental Property (Renter)");
		frmRentalPropertyrenter.setBounds(100, 100, 450, 300);
		frmRentalPropertyrenter.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
