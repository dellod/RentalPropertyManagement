package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

// TESTING GITHUB on visual studio
public class TESTING_REMOVELATER {

	private JFrame reportWindow;
	private JTextField txtStartDay;
	private JTextField txtStartMonth;
	private JTextField txtStartYear;
	private JTextField txtEndDay;
	private JTextField txtEndMonth;
	private JTextField txtEndYear;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TESTING_REMOVELATER window = new TESTING_REMOVELATER();
					window.searchWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the application.
	 */
	public TESTING_REMOVELATER() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		reportWindow = new JFrame();
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
		
		txtStartDay = new JTextField();
		txtStartDay.setBounds(54, 109, 58, 19);
		reportWindow.getContentPane().add(txtStartDay);
		txtStartDay.setColumns(10);
		
		txtStartMonth = new JTextField();
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
		
		txtStartYear = new JTextField();
		txtStartYear.setBounds(333, 109, 69, 19);
		reportWindow.getContentPane().add(txtStartYear);
		txtStartYear.setColumns(10);
		
		JLabel label = new JLabel("Day");
		label.setBounds(20, 180, 46, 13);
		reportWindow.getContentPane().add(label);
		
		txtEndDay = new JTextField();
		txtEndDay.setColumns(10);
		txtEndDay.setBounds(54, 177, 58, 19);
		reportWindow.getContentPane().add(txtEndDay);
		
		JLabel label_1 = new JLabel("Month");
		label_1.setBounds(142, 180, 75, 13);
		reportWindow.getContentPane().add(label_1);
		
		txtEndMonth = new JTextField();
		txtEndMonth.setColumns(10);
		txtEndMonth.setBounds(189, 177, 75, 19);
		reportWindow.getContentPane().add(txtEndMonth);
		
		JLabel label_2 = new JLabel("Year");
		label_2.setBounds(291, 180, 123, 13);
		reportWindow.getContentPane().add(label_2);
		
		txtEndYear = new JTextField();
		txtEndYear.setColumns(10);
		txtEndYear.setBounds(333, 177, 69, 19);
		reportWindow.getContentPane().add(txtEndYear);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGenerate.setBounds(189, 217, 85, 21);
		reportWindow.getContentPane().add(btnGenerate);
		
		
	}
}
