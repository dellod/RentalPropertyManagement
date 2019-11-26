package ClientController;

import View.*;
import View.RegisteredRenter;

import java.io.*;
import Model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;


// AKA Client
/**
 * ApplicationController is the main client being to control the GUI side of the application and communicate those results to the server.
 *
 */
public class ApplicationController 
{
	/**
	 * Main GUI.
	 */
	Application app; // GUI
	
	/**
	 * Socket that communicates to the server.
	 */
	private Socket theSocket;
	
	/**
	 * Stream that receives objects from the server.
	 */
	private ObjectInputStream objectIn;
	
	/**
	 * Writer that writes to data to the server.
	 */
	private PrintWriter writeServer;
	
	/**
	 * Buffered reader that reads strings from the server.
	 */
	private BufferedReader bfReader;
	
	/**
	 * String that indicates the type of user selected at the GUI.
	 */
	private String userType; // User type: Manager, Landlord, or Renter
	
	/**
	 * Global variable that acts like a buffer to receive information from the GUI.
	 */
	public static volatile String[] msgFromGUI; // Buffer from GUI
	
	/*** Constructors ***/
	/**
	 * Constructs ApplicationController with a server name type and port.
	 * @param serverName is the name of server that controls if it is localhost or run over wifi.
	 * @param port is the port that the client communicates through to the server.
	 */
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
		try
		{
			theSocket = new Socket(serverName, port);
			System.out.println("\tCreated socket!");

			objectIn = new ObjectInputStream(theSocket.getInputStream());
			System.out.println("\tCreated object input stream!");
			writeServer = new PrintWriter(theSocket.getOutputStream());
			
			bfReader = new BufferedReader(new InputStreamReader(theSocket.getInputStream()));
		}
		catch(IOException e)
		{
			System.out.println("Could not connect with server.");
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("Client connected with server!\n");
	}
	
	/*** Methods 
	 * @throws IOException 
	 * @throws ClassNotFoundException ***/
	public void initalizeThenRun() throws ClassNotFoundException, IOException
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
				sendString(userType);
				communicateRenter();
			}
		}
	}
	
	/**
	 * Communicates to the server as the manager.
	 */
	private void communicateManager()
	{
		//System.out.println("running manager");
		if(msgFromGUI[1] == "LOGIN")
		{
			System.out.println(msgFromGUI[2]);
			System.out.println(msgFromGUI[3]);
			// VALIDATE IN HERE
			flushOutGUIBuffer(1, 3);
		}
	}
	
	/**
	 * Communicates to the server as the landlord.
	 */
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
						app.msgFromClient[0] = "Property registered!"; // THIS NEED TO CHAGNE IF NOT SUCCESSFUL
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
						
						app.msgFromClient[0] = "Property registered"; // NEEDS TO CHANGE IF NOT SUCCESSFUL
					}
					//Have to let GUI know if registration was successful or not.
					
				}
				else if(msgFromGUI[2] == "POST") // Selected change state on GUI
				{
					
				}
				break;
			case "STATE":
				if(msgFromGUI[2] == "CHANGE")
				{
					int propertyIdToSearch = Integer.parseInt(msgFromGUI[3]);
					String newState = msgFromGUI[4];
					
					System.out.println("Property ID: " + propertyIdToSearch);
					System.out.println("New State: " + newState);
					flushOutGUIBuffer(2, 4);
				}
				break;
			default:
				break;
		}
		
	}
	
	/**
	 * Communicates to the server as the renter.
	 */
	private void communicateRenter() throws ClassNotFoundException, IOException
	{
		//System.out.println("running renter");
		String renterType = msgFromGUI[1];
		sendString(renterType);
		if(renterType == "REGISTERED")
		{
			sendString(renterType);
			
			waitForMsg(2);
			String renterUsername = msgFromGUI[2];
			waitForMsg(3);
			String renterPass = msgFromGUI[3];
			sendString(renterUsername);
			sendString(renterPass);
			
			boolean userResult = objectIn.readBoolean();
			//System.out.println(userResult);
			if(userResult)
			{
				//write to GUI that it is okay to go to next window.
				app.msgFromClient[0] = "VALID";
			}
			else
			{
				//write to GUI that it is not okay to go to next window.
				app.msgFromClient[0] = "NOT_VALID";
			}
			System.out.println("Login successful");
			ArrayList<Property> properties = (ArrayList<Property>) objectIn.readObject();
			
			Application.properties = properties;
			
			waitForMsg(4); 
			String regRenterOption = msgFromGUI[4];
			System.out.println(regRenterOption);
			switch(regRenterOption)
			{
				case("NOTIFICATIONS"):
					break;
				case("SEARCH_AND_SAVE"):
					System.out.println("Searching!");
					waitForMsg(5);
					if(msgFromGUI[5] == "SEARCH")
					{
						System.out.println("Search button has been pressed.");
						waitForMsg(6);
						if(msgFromGUI[6] == "SEARCH_ID") // Searching by just id.
						{
							sendString("BY_ID");
							waitForMsg(7);
							sendString(msgFromGUI[7]);
							//int propId = Integer.parseInt(msgFromGUI[6]);
							//System.out.println(propId);
							System.out.println("searching...");
				
							ArrayList<Property> newProperties = (ArrayList<Property>) objectIn.readObject();
							RegisteredRenter.msgFromClient[0] = "UPDATE";
							for(int i = 0; i < newProperties.size(); i++)
							{
								System.out.println(newProperties.get(i));
							}
							System.out.println("updating...");
							
							
							Application.properties = newProperties;
							
							flushOutGUIBuffer(4, 7);
						}
						else // Searching by filling out required fields in GUI.
						{
							sendString("BY_ELSE");
							waitForMsg(7);
							String searchHouseType = msgFromGUI[7];
							sendString(searchHouseType);
							waitForMsg(8);
							int searchNumBeds = Integer.parseInt(msgFromGUI[8]);
							sendString(Integer.toString(searchNumBeds));
							waitForMsg(7);
							int searchNumBaths = Integer.parseInt(msgFromGUI[9]);
							sendString(Integer.toString(searchNumBaths));
							waitForMsg(10);
							if(msgFromGUI[10] == "FURNISHED")
							{
								sendString("1");
							}
							else
							{
								sendString("0");
							}
							waitForMsg(11);
							String searchCityQuad = msgFromGUI[11];
							sendString(searchCityQuad);
							
							System.out.println("searching...");
							ArrayList<Property> newProperties = (ArrayList<Property>) objectIn.readObject();
							RegisteredRenter.msgFromClient[0] = "UPDATE";
							System.out.println("SIZE: " + newProperties.size());
							for(int i = 0; i < newProperties.size(); i++)
							{
								System.out.println(newProperties.get(i));
							}
							System.out.println("updating...");
						
							Application.properties = newProperties;
		
							flushOutGUIBuffer(4, 11);
						}
					}
					
					break;
				case("EMAIL"):
					if(msgFromGUI[5] == "EMAIL_BUTTON")
					{
						String emailToSend = msgFromGUI[5];
						System.out.println(emailToSend);
						flushOutGUIBuffer(5, 5);
					}
					break;
			}
		}
		else if(renterType == "REGULAR")
		{
			//System.out.println("no account");
			sendString(renterType);
			waitForMsg(4);
			String regularRenterOption = msgFromGUI[4];
			switch(regularRenterOption)
			{
				case("SEARCH"):
					if(msgFromGUI[5] == "SEARCH")
					{
						System.out.println("Search button has been pressed.");
						if(msgFromGUI[5] == "SEARCH_ID")
						{
							int propId = Integer.parseInt(msgFromGUI[6]);
							System.out.println(propId);
							
							flushOutGUIBuffer(4, 6);
						}
						else
						{
							String searchHouseType = msgFromGUI[6];
							int searchNumBeds = Integer.parseInt(msgFromGUI[7]);
							int searchNumBaths = Integer.parseInt(msgFromGUI[8]);
							boolean isSearchFurnished;
							if(msgFromGUI[9] == "FURNISHED")
							{
								isSearchFurnished = true;
							}
							else
							{
								isSearchFurnished = false;
							}
							String searchCityQuad = msgFromGUI[10];
							
							System.out.println(searchHouseType);
							System.out.println(searchNumBeds);
							System.out.println(searchNumBaths);
							System.out.println(isSearchFurnished);
							System.out.println(searchCityQuad);
							
							waitByMili(500);
							flushOutGUIBuffer(4, 10);
						}
					}
					break;
				case("EMAIL"):
					if(msgFromGUI[5] == "EMAIL_BUTTON")
					{
						String emailToSend = msgFromGUI[5];
						System.out.println(emailToSend);
						
						flushOutGUIBuffer(5, 5);
					}
					break;
			}
		}
	}
	
	/**
	 * Flushes out certain parts of the GUI buffer.
	 * @param start is the exact point you want flushing to occur.
	 * @param end is the exact end you want flushing to end.
	 */
	public void flushOutGUIBuffer(int start, int end)
	{
		for(int i = start; i <= end; i++)
		{
			msgFromGUI[i] = "";
		}
		
		for(int i = 0; i < msgFromGUI.length; i++)
		{
			System.out.println(msgFromGUI[i]);
		}
	}
	
	/**
	 * Sends string towards the server.
	 * @param s String to be sent towards the server.
	 */
	protected void sendString(String s) 
	{
		writeServer.println(s);
		writeServer.flush();
	}
	
	/*** Getters ***/
	/**
	 * Gets user type.
	 * @return user type as String.
	 */
	public String getUserType()
	{
		return userType;
	}
	
	/**
	 * Gets the Application.
	 * @return app of type Application.
	 */
	public Application getApp()
	{
		return app;
	}
	
	/*** Setters ***/
	/**
	 * Waits for message to be received from the GUI, making sure index is not empty.
	 * @param index is the point you want to make sure is not empty.
	 */
	public void waitForMsg(int index)
	{
		while(msgFromGUI[index] == "") {}
	}
	
	/**
	 * Puts main thread to sleep for length of mili in mili.
	 * @param mili type long that indicates how long you want main system to sleep for.
	 */
	public void waitByMili(long mili)
	{
		try {
			Thread.sleep(mili);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Behaves like the main for ApplicationController, controlled by Main.java.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static void mainClient() throws ClassNotFoundException, IOException
	{
		ApplicationController client = new ApplicationController("10.13.128.70", 4000);
		client.getApp().mainGUI(client); // Launches GUI.
		client.initalizeThenRun();
	}
}
