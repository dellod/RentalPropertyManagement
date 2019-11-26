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
				if(index != 0)
				{
					String line = (String) listModel.get(index);
					selectedText.setText(line); // Displays selected text to textField at bottom of RegisteredRenter GUI.
				}
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
		btnProperties.setBounds(283, 321, 104, 21);
		frame.getContentPane().add(btnProperties);
		
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
				theClient.msgFromGUI[4] = "REPORT";
				
				JFrame reportWindow = new JFrame();
				reportWindow.setTitle("Generate Report");
				reportWindow.setBounds(100, 100, 425, 292);
				reportWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				reportWindow.getContentPane().setLayout(null);
				
				JLabel lblReport = new JLabel("Report");
				lblReport.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 20));
				lblReport.setBounds(10, 10, 222, 39);
				reportWindow.getContentPane().add(lblReport);
				
				JLabel lblEnterStartDate = new JLabel("Enter start date and end date to get the range of report.");
				lblEnterStartDate.setBounds(20, 59, 459, 13);
				reportWindow.getContentPane().add(lblEnterStartDate);
				
				JLabel lblStart = new JLabel("Start:");
				lblStart.setBounds(10, 86, 46, 13);
				reportWindow.getContentPane().add(lblStart);
				
				JLabel lblEnd = new JLabel("End:");
				lblEnd.setBounds(10, 151, 46, 13);
				reportWindow.getContentPane().add(lblEnd);
				
				JTextField txtStartDay = new JTextField();
				txtStartDay.setBounds(54, 109, 58, 19);
				reportWindow.getContentPane().add(txtStartDay);
				txtStartDay.setColumns(10);
				
				JTextField txtStartMonth = new JTextField();
				txtStartMonth.setBounds(189, 109, 75, 19);
				reportWindow.getContentPane().add(txtStartMonth);
				txtStartMonth.setColumns(10);
				
				JLabel lblDay = new JLabel("Day");
				lblDay.setBounds(20, 112, 46, 13);
				reportWindow.getContentPane().add(lblDay);
				
				JLabel lblMonth = new JLabel("Month");
				lblMonth.setBounds(142, 112, 75, 13);
				reportWindow.getContentPane().add(lblMonth);
				
				JLabel lblYear = new JLabel("Year");
				lblYear.setBounds(291, 112, 123, 13);
				reportWindow.getContentPane().add(lblYear);
				
				JTextField txtStartYear = new JTextField();
				txtStartYear.setBounds(333, 109, 69, 19);
				reportWindow.getContentPane().add(txtStartYear);
				txtStartYear.setColumns(10);
				
				JLabel label = new JLabel("Day");
				label.setBounds(20, 180, 46, 13);
				reportWindow.getContentPane().add(label);
				
				JTextField txtEndDay = new JTextField();
				txtEndDay.setColumns(10);
				txtEndDay.setBounds(54, 177, 58, 19);
				reportWindow.getContentPane().add(txtEndDay);
				
				JLabel label_1 = new JLabel("Month");
				label_1.setBounds(142, 180, 75, 13);
				reportWindow.getContentPane().add(label_1);
				
				JTextField txtEndMonth = new JTextField();
				txtEndMonth.setColumns(10);
				txtEndMonth.setBounds(189, 177, 75, 19);
				reportWindow.getContentPane().add(txtEndMonth);
				
				JLabel label_2 = new JLabel("Year");
				label_2.setBounds(291, 180, 123, 13);
				reportWindow.getContentPane().add(label_2);
				
				JTextField txtEndYear = new JTextField();
				txtEndYear.setColumns(10);
				txtEndYear.setBounds(333, 177, 69, 19);
				reportWindow.getContentPane().add(txtEndYear);
				
				JButton btnGenerate = new JButton("Generate");
				btnGenerate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						theClient.msgFromGUI[5] = "GENERATE";
						
						theClient.msgFromGUI[6] = txtStartDay.getText();
						theClient.msgFromGUI[7] = txtStartMonth.getText();
						theClient.msgFromGUI[8] = txtStartYear.getText();
						
						theClient.msgFromGUI[9] = txtEndDay.getText();
						theClient.msgFromGUI[10] = txtEndMonth.getText();
						theClient.msgFromGUI[11] = txtEndYear.getText();
						
					}
				});
				btnGenerate.setBounds(189, 217, 85, 21);
				reportWindow.getContentPane().add(btnGenerate);
				
				reportWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				reportWindow.setVisible(true);
			}
		});
		btnGenerateReport.setBounds(516, 171, 110, 21);
		frame.getContentPane().add(btnGenerateReport);
	}

}
