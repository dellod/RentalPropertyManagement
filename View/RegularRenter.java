package View;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

import ClientController.ApplicationController;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegularRenter extends RenterGUI{

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void RegularRenterScreen(ApplicationController c) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegularRenter window = new RegularRenter(c);
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
	public RegularRenter(ApplicationController c) {
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
		
		JLabel lblWelcomeRegularRenter = new JLabel("Welcome Regular Renter!");
		lblWelcomeRegularRenter.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 20));
		lblWelcomeRegularRenter.setBounds(10, 10, 407, 39);
		frame.getContentPane().add(lblWelcomeRegularRenter);
		

		JLabel label = new JLabel("Selected Property:");
		label.setBounds(10, 387, 148, 13);
		frame.getContentPane().add(label);
		textField = new JTextField();
		textField.setText("Please select property to examine above.");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(131, 384, 351, 19);
		frame.getContentPane().add(textField);
		

		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		JList<String> list = new JList<String>(listModel);
		listModel.addElement("Examine Properties Below");
		list.setVisibleRowCount(20);
		list.setBounds(10, 63, 472, 248);
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int index = list.getSelectedIndex();
				String line = (String) listModel.get(index);
				textField.setText(line); // Displays selected text to textField at bottom of RegisteredRenter GUI.
			}
		});
		
		frame.getContentPane().add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(465, 63, 17, 248);
		frame.getContentPane().add(scrollBar);
		
		JButton button = new JButton("Logout");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setBounds(516, 24, 110, 21);
		frame.getContentPane().add(button);
		
		JButton btnSEARCH = new JButton("Search");
		btnSEARCH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				theClient.msgFromGUI[4] = "SEARCH";
				
				JFrame searchWindow = new JFrame("Search (Registered Renter)");
				searchWindow.setPreferredSize(new Dimension(300, 400));
				searchWindow.setLocationRelativeTo(frame);
				searchWindow.getContentPane().setLayout(null); // Absolute layout
				
				JLabel lblSearchProperty = new JLabel("Search Property");
				lblSearchProperty.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
				lblSearchProperty.setBounds(10, 10, 206, 39);
				searchWindow.getContentPane().add(lblSearchProperty);
				
				JLabel lblQueryWillBe = new JLabel("Query will be saved and notfied later if found.");
				lblQueryWillBe.setBounds(10, 49, 266, 13);
				searchWindow.getContentPane().add(lblQueryWillBe);
				
				JCheckBox chckbxSearchByProperty = new JCheckBox("Search by Property ID");
				chckbxSearchByProperty.setBounds(10, 68, 178, 21);
				searchWindow.getContentPane().add(chckbxSearchByProperty);
				
				JLabel lblPropID = new JLabel("Property ID:");
				lblPropID.setBounds(10, 95, 100, 13);
				searchWindow.getContentPane().add(lblPropID);
				
				JTextField txtPropID = new JTextField();
				txtPropID.setBounds(79, 92, 96, 19);
				searchWindow.getContentPane().add(txtPropID);
				txtPropID.setColumns(10);
				
				JLabel lblOtherwiseSearchBy = new JLabel("Otherwise, search by filling all fields below.");
				lblOtherwiseSearchBy.setBounds(10, 118, 266, 13);
				searchWindow.getContentPane().add(lblOtherwiseSearchBy);
				
				JTextField txtHouseType = new JTextField();
				txtHouseType.setBounds(120, 141, 96, 19);
				searchWindow.getContentPane().add(txtHouseType);
				txtHouseType.setColumns(10);
				
				JLabel lblHouseType = new JLabel("House Type:");
				lblHouseType.setBounds(10, 144, 147, 13);
				searchWindow.getContentPane().add(lblHouseType);
				
				JLabel lblNumberOfBedrooms = new JLabel("Bedrooms:");
				lblNumberOfBedrooms.setBounds(10, 167, 165, 13);
				searchWindow.getContentPane().add(lblNumberOfBedrooms);
				
				JTextField txtNumBeds = new JTextField();
				txtNumBeds.setBounds(120, 164, 96, 19);
				searchWindow.getContentPane().add(txtNumBeds);
				txtNumBeds.setColumns(10);
				
				JLabel lblNumberOfBathrooms = new JLabel("Bathrooms: ");
				lblNumberOfBathrooms.setBounds(10, 190, 178, 13);
				searchWindow.getContentPane().add(lblNumberOfBathrooms);
				
				JTextField txtNumbBaths = new JTextField();
				txtNumbBaths.setBounds(120, 187, 96, 19);
				searchWindow.getContentPane().add(txtNumbBaths);
				txtNumbBaths.setColumns(10);
				
				JCheckBox chckbxFurnished = new JCheckBox("Furnished?");
				chckbxFurnished.setBounds(62, 208, 95, 21);
				searchWindow.getContentPane().add(chckbxFurnished);
				
				JLabel lblCityQuadrant = new JLabel("City Quadrant:");
				lblCityQuadrant.setBounds(10, 235, 120, 13);
				searchWindow.getContentPane().add(lblCityQuadrant);
				
				String[] quadrants = {"NW", "NE", "SW", "SE"};
				String regQuad = "";
				JComboBox comboBoxQuadrant = new JComboBox(quadrants);
				comboBoxQuadrant.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						if(e.getSource() == comboBoxQuadrant)
						{
							JComboBox quadrantCB = (JComboBox)e.getSource();
							String regQuad = (String)quadrantCB.getSelectedItem();
							//System.out.println(regQuad);
						}
					}
				});
				comboBoxQuadrant.setSelectedIndex(-1);
				comboBoxQuadrant.setBounds(120, 235, 96, 13);
				searchWindow.getContentPane().add(comboBoxQuadrant);
				
				JButton btnSearch = new JButton("Search");
				btnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						theClient.msgFromGUI[5] = "SEARCH";
						if(chckbxSearchByProperty.isSelected())
						{
							theClient.msgFromGUI[5] = "SEARCH_ID";
							theClient.msgFromGUI[6] = txtPropID.getText();
						}
						else
						{
							theClient.msgFromGUI[5] = "SEARCH_ELSE";
							theClient.msgFromGUI[6] = txtHouseType.getText();
							theClient.msgFromGUI[7] = txtNumBeds.getText();
							theClient.msgFromGUI[8] = txtNumbBaths.getText();
							if(chckbxFurnished.isSelected())
							{
								theClient.msgFromGUI[9] = "FURNISHED";
							}
							else
							{
								theClient.msgFromGUI[9] = "NOT_FURNISHED";
							}
							theClient.msgFromGUI[10] = quadrants[comboBoxQuadrant.getSelectedIndex()];
							System.out.println(theClient.msgFromGUI[10]);
						}
						searchWindow.dispose();
					}
				});
				btnSearch.setBounds(103, 332, 85, 21);
				searchWindow.getContentPane().add(btnSearch);
				
				searchWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				searchWindow.pack();
				searchWindow.setVisible(true);
			}
		});
		btnSEARCH.setBounds(516, 149, 110, 21);
		frame.getContentPane().add(btnSEARCH);
		
		JButton btnEMAIL = new JButton("Send Email");
		btnEMAIL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				theClient.msgFromGUI[4] = "EMAIL";
				JFrame emailWindow = new JFrame();
				
				emailWindow.setTitle("Send Email");
				emailWindow.setBounds(100, 100, 450, 300);
				emailWindow.getContentPane().setLayout(null);
				
				JLabel lblWriteEmailTo = new JLabel("Write email to landlord below (email of landlord will not be shown).");
				lblWriteEmailTo.setBounds(10, 10, 416, 13);
				emailWindow.getContentPane().add(lblWriteEmailTo);
				
				JTextField txtEmail = new JTextField();
				txtEmail.setBounds(10, 33, 416, 194);
				emailWindow.getContentPane().add(txtEmail);
				txtEmail.setColumns(10);
				
				JButton btnSendEmail = new JButton("Send Email");
				btnSendEmail.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						theClient.msgFromGUI[5] = "EMAIL_BUTTON";
						theClient.msgFromGUI[5] = txtEmail.getText();
						emailWindow.dispose();
					}
				});
				btnSendEmail.setBounds(10, 237, 150, 21);
				emailWindow.getContentPane().add(btnSendEmail);
				emailWindow.setLocationRelativeTo(frame);
				emailWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				emailWindow.setVisible(true);
			}
		});
		btnEMAIL.setBounds(516, 180, 110, 21);
		frame.getContentPane().add(btnEMAIL);
	}
}
