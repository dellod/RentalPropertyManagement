package View;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import ClientController.ApplicationController;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		JLabel lblSelected = new JLabel("Selected:");
		lblSelected.setBounds(10, 387, 148, 13);
		frame.getContentPane().add(lblSelected);
		JTextField selectedText = new JTextField();
		selectedText.setText("Please select object to examine above.");
		selectedText.setEditable(false);
		selectedText.setBounds(131, 384, 351, 19);
		frame.getContentPane().add(selectedText);
		selectedText.setColumns(10);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		JList<String> list = new JList<String>(listModel);
		listModel.addElement("Examine Properties Below");
		list.setBounds(10, 63, 472, 248);
		list.setVisibleRowCount(20);
		
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int index = list.getSelectedIndex();
				String line = (String) listModel.get(index);
				selectedText.setText(line); // Displays selected text to textField at bottom of RegisteredRenter GUI.
			}
		});
		
		frame.getContentPane().add(list);
		
		JButton btnLogout = new JButton("Logout"); 
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // Terminates program
			}
		});
		btnLogout.setBounds(516, 24, 110, 21);
		frame.getContentPane().add(btnLogout);
		
		JButton btnProperties = new JButton("Properties");
		btnProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProperties.setBounds(175, 321, 104, 21);
		frame.getContentPane().add(btnProperties);
		
		JButton btnLandlords = new JButton("Landlords");
		btnLandlords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLandlords.setBounds(289, 321, 98, 21);
		frame.getContentPane().add(btnLandlords);
		
		JButton btnRenters = new JButton("Renters");
		btnRenters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRenters.setBounds(397, 321, 85, 21);
		frame.getContentPane().add(btnRenters);
		
		JLabel lblSelectWhichDatabase = new JLabel("Select which to be displayed.");
		lblSelectWhichDatabase.setBounds(10, 325, 322, 13);
		frame.getContentPane().add(lblSelectWhichDatabase);
		
		JButton btnGenerateReport = new JButton("Report");
		btnGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGenerateReport.setBounds(516, 171, 110, 21);
		frame.getContentPane().add(btnGenerateReport);
	}

}
