package View;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ManagerGUI {

	private JFrame frmRentalPropertymanager;

	/**
	 * Launch the application.
	 */
	public static void ManagerScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerGUI window = new ManagerGUI();
					window.frmRentalPropertymanager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManagerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRentalPropertymanager = new JFrame();
		frmRentalPropertymanager.setTitle("Rental Property (Manager)");
		frmRentalPropertymanager.setBounds(100, 100, 450, 300);
		frmRentalPropertymanager.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
