package View;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ClientController.ApplicationController;
import javax.swing.JLabel;
import java.awt.Font;

public class Manager extends ManagerGUI{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void	ManagerMenuScreen(ApplicationController c) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager window = new Manager(c);
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
	public Manager(ApplicationController c) {
		super(c);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Welcome Manager!");
		label.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(10, 10, 222, 39);
		frame.getContentPane().add(label);
	}

}
