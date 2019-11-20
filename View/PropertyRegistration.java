package View;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ClientController.ApplicationController;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class PropertyRegistration extends LandlordGUI
{

	private JFrame frame;
	private JTextField txtLandlordFirst;
	private JTextField txtLandlordLast;
	private JTextField txtEmail;
	private JTextField txtLandlordAddress;
	private JTextField txtLandlordCity;
	private JTextField txtLandlordProv;
	private JTextField txtLandlordCountry;
	private JTextField txtyear;
	private JTextField txtday;
	private JTextField txtHouseType;
	private JTextField txtNumBathrooms;
	private JTextField txtNumBeds;
	private JTextField txtPropertyStreet;
	private JTextField txtPropertyCity;
	private JTextField txtPropertyProvince;
	private JTextField txtPropertyCountry;

	/**
	 * Launch the application.
	 */
	public static void PropertyRegistrationScreen(ApplicationController c) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PropertyRegistration window = new PropertyRegistration(c);
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
	public PropertyRegistration(ApplicationController c) 
	{
		super(c);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 435);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegisterProperty = new JLabel("Register Property");
		lblRegisterProperty.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblRegisterProperty.setBounds(10, 10, 206, 39);
		frame.getContentPane().add(lblRegisterProperty);
		
		JLabel lblNewLabel = new JLabel("Personal Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(10, 59, 206, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("First Name");
		lblName.setBounds(10, 82, 66, 13);
		frame.getContentPane().add(lblName);
		
		txtLandlordFirst = new JTextField();
		txtLandlordFirst.setBounds(75, 79, 96, 19);
		frame.getContentPane().add(txtLandlordFirst);
		txtLandlordFirst.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(176, 82, 66, 13);
		frame.getContentPane().add(lblLastName);
		
		txtLandlordLast = new JTextField();
		txtLandlordLast.setColumns(10);
		txtLandlordLast.setBounds(253, 79, 96, 19);
		frame.getContentPane().add(txtLandlordLast);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(75, 111, 46, 13);
		frame.getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(131, 108, 178, 19);
		frame.getContentPane().add(txtEmail);
		
		JLabel lblNewLabel_1 = new JLabel("Gender(M/F)");
		lblNewLabel_1.setBounds(359, 82, 74, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 134, 66, 13);
		frame.getContentPane().add(lblAddress);
		
		txtLandlordAddress = new JTextField();
		txtLandlordAddress.setBounds(72, 134, 183, 19);
		frame.getContentPane().add(txtLandlordAddress);
		txtLandlordAddress.setColumns(10);
		
		JLabel lblQuadrant = new JLabel("Quadrant");
		lblQuadrant.setBounds(278, 134, 71, 13);
		frame.getContentPane().add(lblQuadrant);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(10, 170, 46, 13);
		frame.getContentPane().add(lblCity);
		
		txtLandlordCity = new JTextField();
		txtLandlordCity.setText("Calgary");
		txtLandlordCity.setBounds(51, 167, 96, 19);
		frame.getContentPane().add(txtLandlordCity);
		txtLandlordCity.setColumns(10);
		
		JLabel lblProvince = new JLabel("Province");
		lblProvince.setBounds(157, 170, 66, 13);
		frame.getContentPane().add(lblProvince);
		
		txtLandlordProv = new JTextField();
		txtLandlordProv.setText("Alberta");
		txtLandlordProv.setBounds(213, 167, 96, 19);
		frame.getContentPane().add(txtLandlordProv);
		txtLandlordProv.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(332, 170, 62, 13);
		frame.getContentPane().add(lblCountry);
		
		txtLandlordCountry = new JTextField();
		txtLandlordCountry.setText("Canada");
		txtLandlordCountry.setBounds(390, 167, 86, 19);
		frame.getContentPane().add(txtLandlordCountry);
		txtLandlordCountry.setColumns(10);
		
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
		comboBoxQuadrant.setBounds(350, 130, 53, 21);
		frame.getContentPane().add(comboBoxQuadrant);
		
		String[] genders = {"M", "F"};
		String regGender = "";
		JComboBox comboBoxGender = new JComboBox(genders);
		comboBoxGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource() == comboBoxGender)
				{
					JComboBox genderCB = (JComboBox)e.getSource();
					String regGender = (String)genderCB.getSelectedItem();
					//System.out.println(regGender);
				}
			}
		});
		comboBoxGender.setSelectedIndex(-1);
		comboBoxGender.setBounds(432, 78, 44, 21);
		frame.getContentPane().add(comboBoxGender);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(10, 200, 96, 13);
		frame.getContentPane().add(lblDateOfBirth);
		
		String[] months = {"Jan", "Feb", "Mar", "Apr", "Ma", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		String regMonth = "";
		JComboBox comboBoxMonth = new JComboBox(months);
		comboBoxMonth.setSelectedIndex(-1);
		comboBoxMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource() == comboBoxMonth)
				{
					JComboBox monthCB = (JComboBox)e.getSource();
					String regMonth = (String)monthCB.getSelectedItem();
					//System.out.println(regMonth);
				}
			}
		});
		comboBoxMonth.setBounds(129, 196, 74, 21);
		frame.getContentPane().add(comboBoxMonth);
		
		txtyear = new JTextField();
		txtyear.setText("(Year)");
		txtyear.setBounds(298, 197, 96, 19);
		frame.getContentPane().add(txtyear);
		txtyear.setColumns(10);
		
		txtday = new JTextField();
		txtday.setText("(Day)");
		txtday.setBounds(213, 197, 75, 19);
		frame.getContentPane().add(txtday);
		txtday.setColumns(10);
		
		JLabel lblPropertyInformation = new JLabel("Property Information");
		lblPropertyInformation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblPropertyInformation.setBounds(10, 228, 206, 13);
		frame.getContentPane().add(lblPropertyInformation);
		
		JCheckBox chckbxFilledOutBefore = new JCheckBox("Filled out before? Just enter email and check box.");
		//TO USE CHECK BOX use chckbxFilledOutBefore.isSelected();, then only need to extract email.
		chckbxFilledOutBefore.setBounds(147, 55, 329, 21);
		frame.getContentPane().add(chckbxFilledOutBefore);
		
		JLabel lblHouseTypeie = new JLabel("House Type (ie. Apartment, Home, etc.)");
		lblHouseTypeie.setBounds(10, 251, 232, 13);
		frame.getContentPane().add(lblHouseTypeie);
		
		txtHouseType = new JTextField();
		txtHouseType.setBounds(235, 248, 96, 19);
		frame.getContentPane().add(txtHouseType);
		txtHouseType.setColumns(10);
		
		JLabel lblNumberOfBathrooms = new JLabel("Number of Bathrooms");
		lblNumberOfBathrooms.setBounds(10, 274, 125, 13);
		frame.getContentPane().add(lblNumberOfBathrooms);
		
		JLabel lblNumberOfBedrooms = new JLabel("Number of Bedrooms");
		lblNumberOfBedrooms.setBounds(253, 274, 125, 13);
		frame.getContentPane().add(lblNumberOfBedrooms);
		
		txtNumBathrooms = new JTextField();
		txtNumBathrooms.setBounds(147, 271, 96, 19);
		frame.getContentPane().add(txtNumBathrooms);
		txtNumBathrooms.setColumns(10);
		
		txtNumBeds = new JTextField();
		txtNumBeds.setBounds(380, 271, 96, 19);
		frame.getContentPane().add(txtNumBeds);
		txtNumBeds.setColumns(10);
		
		JCheckBox chckbxFurnished = new JCheckBox("Furnished");
		chckbxFurnished.setBounds(381, 247, 95, 21);
		frame.getContentPane().add(chckbxFurnished);
		
		JLabel label = new JLabel("Address");
		label.setBounds(10, 310, 66, 13);
		frame.getContentPane().add(label);
		
		txtPropertyStreet = new JTextField();
		txtPropertyStreet.setColumns(10);
		txtPropertyStreet.setBounds(75, 307, 183, 19);
		frame.getContentPane().add(txtPropertyStreet);
		
		JLabel label_1 = new JLabel("Quadrant");
		label_1.setBounds(278, 310, 71, 13);
		frame.getContentPane().add(label_1);
		
		String regPropertyQuad = "";
		JComboBox comboBoxPropertyQuad = new JComboBox(quadrants);
		comboBoxPropertyQuad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource() == comboBoxPropertyQuad)
				{
					JComboBox quadPropertyCB = (JComboBox)e.getSource();
					String regPropertyQuad = (String)quadPropertyCB.getSelectedItem();
				}
			}
		});
		comboBoxPropertyQuad.setSelectedIndex(-1);
		comboBoxPropertyQuad.setBounds(350, 306, 53, 21);
		frame.getContentPane().add(comboBoxPropertyQuad);
		
		JLabel label_2 = new JLabel("City");
		label_2.setBounds(10, 333, 46, 13);
		frame.getContentPane().add(label_2);
		
		txtPropertyCity = new JTextField();
		txtPropertyCity.setText("Calgary");
		txtPropertyCity.setColumns(10);
		txtPropertyCity.setBounds(51, 330, 96, 19);
		frame.getContentPane().add(txtPropertyCity);
		
		JLabel label_3 = new JLabel("Province");
		label_3.setBounds(157, 333, 66, 13);
		frame.getContentPane().add(label_3);
		
		txtPropertyProvince = new JTextField();
		txtPropertyProvince.setText("Alberta");
		txtPropertyProvince.setColumns(10);
		txtPropertyProvince.setBounds(213, 330, 96, 19);
		frame.getContentPane().add(txtPropertyProvince);
		
		JLabel propertyCountry = new JLabel("Country");
		propertyCountry.setBounds(332, 333, 62, 13);
		frame.getContentPane().add(propertyCountry);
		
		txtPropertyCountry = new JTextField();
		txtPropertyCountry.setText("Canada");
		txtPropertyCountry.setColumns(10);
		txtPropertyCountry.setBounds(390, 330, 86, 19);
		frame.getContentPane().add(txtPropertyCountry);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				theClient.msgFromGUI[2] = "REGISTER_PROPERTY";
				if(chckbxFilledOutBefore.isSelected())
				{
					theClient.msgFromGUI[3] = "REGISTERED";
					/* Landlord Info */
					theClient.msgFromGUI[4] = txtEmail.getText();
					
					/*Property Info */
					theClient.msgFromGUI[5] = txtHouseType.getText();
					if(chckbxFurnished.isSelected())
					{
						theClient.msgFromGUI[6] = "FURNISHED";
					}
					else
					{
						theClient.msgFromGUI[6] = "UNFURNISHED";
					}
					theClient.msgFromGUI[7] = txtNumBathrooms.getText();
					theClient.msgFromGUI[8] = txtNumBeds.getText();
					theClient.msgFromGUI[9] = txtPropertyStreet.getText();
					theClient.msgFromGUI[10] = quadrants[comboBoxPropertyQuad.getSelectedIndex()];
					theClient.msgFromGUI[11] = txtPropertyCity.getText();
					theClient.msgFromGUI[12] = txtPropertyProvince.getText();
					theClient.msgFromGUI[13] = txtPropertyCountry.getText();
				}
				else
				{
					theClient.msgFromGUI[3] = "NOT_REGISTERED";
					/* Landlord Info */
					theClient.msgFromGUI[4] = txtLandlordFirst.getText();
					theClient.msgFromGUI[5] = txtLandlordLast.getText();
					theClient.msgFromGUI[6] = genders[comboBoxGender.getSelectedIndex()];
					theClient.msgFromGUI[7] = txtEmail.getText();
					theClient.msgFromGUI[8] = txtLandlordAddress.getText();
					theClient.msgFromGUI[9] = quadrants[comboBoxQuadrant.getSelectedIndex()];
					theClient.msgFromGUI[10] = txtLandlordCity.getText();
					theClient.msgFromGUI[11] = txtLandlordProv.getText();
					theClient.msgFromGUI[12] = txtLandlordCountry.getText();
					theClient.msgFromGUI[13] = months[comboBoxMonth.getSelectedIndex()];
					theClient.msgFromGUI[14] = txtday.getText();
					theClient.msgFromGUI[15] = txtyear.getText();
					
					/*Property Info */
					theClient.msgFromGUI[16] = txtHouseType.getText();
					if(chckbxFurnished.isSelected())
					{
						theClient.msgFromGUI[17] = "FURNISHED";
					}
					else
					{
						theClient.msgFromGUI[17] = "UNFURNISHED";
					}
					theClient.msgFromGUI[18] = txtNumBathrooms.getText();
					theClient.msgFromGUI[19] = txtNumBeds.getText();
					theClient.msgFromGUI[20] = txtPropertyStreet.getText();
					theClient.msgFromGUI[21] = quadrants[comboBoxPropertyQuad.getSelectedIndex()];
					theClient.msgFromGUI[22] = txtPropertyCity.getText();
					theClient.msgFromGUI[23] = txtPropertyProvince.getText();
					theClient.msgFromGUI[24] = txtPropertyCountry.getText();
				}
				frame.dispose();
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegister.setBounds(131, 368, 85, 21);
		frame.getContentPane().add(btnRegister);
		
		JButton btnPostOnline = new JButton("Register and Post Online");
		btnPostOnline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				theClient.msgFromGUI[2] = "POST";
			}
		});
		
		btnPostOnline.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPostOnline.setBounds(226, 368, 177, 21);
		frame.getContentPane().add(btnPostOnline);
	}
}
