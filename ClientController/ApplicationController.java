package ClientController;

import View.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

// AKA Client
public class ApplicationController 
{
	Application app; // GUI
	private Socket theSocket;
	private ObjectInputStream objectIn;
	private PrintWriter writeServer;
	
	private String userType; // User type: Manager, Landlord, or Renter
	public String[] msgFromGUI; // Buffer from GUI
	
	/*** Constructors ***/
	public ApplicationController(String serverName, int port)
	{
		app = new Application(this);
		userType = "GARBAGE";
		msgFromGUI = new String[100]; //Buffer for Application GUI
		for(int i = 0; i < msgFromGUI.length; i++)
		{
			msgFromGUI[i] = "";
		}
		System.out.println("Trying to connect to server...");
		
		// Add server connections here
		//try
		{
			//theSocket = new Socket(serverName, port);
			//objectIn = new ObjectInputStream(theSocket.getInputStream());
			//writeServer = new PrintWriter(theSocket.getOutputStream());
		}
		//catch(IOException e)
		{
			//System.out.println("Could not connect with server.");
			//e.printStackTrace();
			//System.exit(1);
		}
		System.out.println("Client connected with server");
	}
	
	/*** Methods ***/
	public void initalizeThenRun()
	{
		while(true) 
		{
			userType = msgFromGUI[0];
			
			if(userType == "Manager")
			{
				communicateManager();
			}
			else if(userType == "Landlord")
			{
				communicateLandlord();
			}
			else if(userType == "Renter")
			{
				communicateRenter();
			}
		}
	}
	
	private void communicateManager()
	{
		
		System.out.println("running manager");
		System.out.println(msgFromGUI[1]);
		System.out.println(msgFromGUI[2]);
	}
	
	private void communicateLandlord()
	{
		//System.out.println("running landlord");
		String landlordOption = msgFromGUI[1];
		switch(landlordOption)
		{
			case "REGISTER":
				if(msgFromGUI[2] == "REGISTER_PROPERTY") // Selected Register Property on GUI
				{
					if(msgFromGUI[3] == "REGISTERED") // Landlord that already exists in database.
					{
						System.out.println("Registered Landlord");
						/* Landlord Info */
						String regEmail = msgFromGUI[4];
						// Search database with this email
						
						/* Property Info */
						String regHouseType = msgFromGUI[5];
						boolean regIsFurnished;
						if(msgFromGUI[6] == "FURNISHED")
						{
							regIsFurnished = true;
						}
						else
						{
							regIsFurnished = false;
						}
						int regNumBaths = Integer.parseInt(msgFromGUI[7]);
						int regNumBeds = Integer.parseInt(msgFromGUI[8]);
						String regPropertyStreet = msgFromGUI[9];
						String regQuad = msgFromGUI[10];
						String regCity = msgFromGUI[11];
						String regProv = msgFromGUI[12];
						String regCountry = msgFromGUI[13];
						
						// Pass elements to create a new property to add to existing landlord
						
						/*
						System.out.println("Email: " + regEmail);
						System.out.println("HouseType: " + regHouseType);
						System.out.println("Furnished: " + regIsFurnished);
						System.out.println("Number of Bathromms: " + regNumBaths);
						System.out.println("Number of Bedrooms: " + regNumBeds);
						System.out.println("Property Street: " + regPropertyStreet);
						System.out.println("Property Quad: " + regQuad);
						System.out.println("City: " + regCity);
						System.out.println("Province: " + regProv);
						System.out.println("Country: " + regCountry);
						*/
						
						/* Cleanup */
						flushOutGUIBuffer(3, 13);
					}
					else if(msgFromGUI[3] == "NOT_REGISTERED") // Landlord that does not exist in database yet.
					{
						System.out.println("Not registered Landlord");
						/* Landlord Info */
						String regFirstName = msgFromGUI[4];
						String regLastName = msgFromGUI[5];
						
						String regGender = msgFromGUI[6];
						
						String regEmail = msgFromGUI[7];
						
						String regLandlordAddress = msgFromGUI[8];
						String regLandlordQuad = msgFromGUI[9];
						String regLandlordCity = msgFromGUI[10];
						String regLandlordProv = msgFromGUI[11];
						String regLandlordCountry = msgFromGUI[12];
						
						String regBirthMonth = msgFromGUI[13];
						String regBirthDay = msgFromGUI[14];
						String regBirthYear = msgFromGUI[15];
						
						/* Property Info */
						String regHouseType = msgFromGUI[16];
						boolean regIsFurnished;
						if(msgFromGUI[17] == "FURNISHED")
						{
							regIsFurnished = true;
						}
						else
						{
							regIsFurnished = false;
						}
						int regNumBaths = Integer.parseInt(msgFromGUI[18]);
						int regNumBeds = Integer.parseInt(msgFromGUI[19]);
						String regPropertyStreet = msgFromGUI[20];
						String regQuad = msgFromGUI[21];
						String regCity = msgFromGUI[22];
						String regProv = msgFromGUI[23];
						String regCountry = msgFromGUI[24];
						
						/* Cleanup */
						flushOutGUIBuffer(3, 24);
					}
				}
				else if(msgFromGUI[2] == "STATE") // Selected change state on GUI
				{
					
				}
				break;
			case "STATE":
				break;
			default:
				break;
		}
		
	}
	
	private void communicateRenter()
	{
		System.out.println("running renter");
		String renterType = msgFromGUI[1];
		if(renterType == "REGISTERED")
		{
			System.out.println("User: " + msgFromGUI[2]);
			System.out.println("Password: " + msgFromGUI[3]);
		}
		else if(renterType == "REGULAR")
		{
			System.out.println("no account");
		}
	}
	
	public void flushOutGUIBuffer(int start, int end)
	{
		for(int i = start; i <= end; i++)
		{
			msgFromGUI[i] = "";
		}
	}
	
	/*** Getters ***/
	public String getUserType()
	{
		return userType;
	}
	
	public Application getApp()
	{
		return app;
	}
	
	/*** Setters ***/
	public void setUserType(String user)
	{
		this.userType = user;
	}
	
	
	public static void mainClient()
	{
		ApplicationController client = new ApplicationController("localhost", 8099);
		client.getApp().mainGUI(client); // Launches GUI.
		client.initalizeThenRun();
	}
}
