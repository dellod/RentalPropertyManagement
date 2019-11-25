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

public class TESTING_REMOVELATER {

	private JFrame frame;

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
		frame = new JFrame();
		frame.setTitle("Send Email");
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
	}
}
