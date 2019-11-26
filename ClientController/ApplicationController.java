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
				sendString(userType);
				communicateManager();
			}
			else if(userType == "Landlord")
			{
				sendString(userType);
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
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	private void communicateManager() throws IOException, ClassNotFoundException
	{
		//System.out.println("running manager");
		waitForMsg(1);
		if(msgFromGUI[1] == "LOGIN")
		{
			//System.out.println(msgFromGUI[2]);
			//System.out.println(msgFromGUI[3]);
			waitForMsg(2);
			String renterUsername = msgFromGUI[2];
			sendString(renterUsername);
			
			waitForMsg(3);
			String renterPass = msgFromGUI[3];
			sendString(renterPass);
			System.out.println("test");
			boolean managerResult = objectIn.readBoolean();
			System.out.println(managerResult);
			if(managerResult)
			{
				app.msgFromClient[0] = "VALID";
			}
			else
			{
				app.msgFromClient[0] = "NOT_VALID";
			}
			flushOutGUIBuffer(2, 3);
			
			waitForMsg(4);
			String manOption = msgFromGUI[4];
			switch(manOption)
			{
				case "REPORT":
					waitForMsg(5); // REPORT
					sendString(msgFromGUI[5]);
					
					//START
					waitForMsg(6);
					sendString(msgFromGUI[6]);

					waitForMsg(7);
					sendString(msgFromGUI[6]);

					waitForMsg(8);
					sendString(msgFromGUI[6]);
					
					//END
					waitForMsg(9);
					sendString(msgFromGUI[6]);

					waitForMsg(10);
					sendString(msgFromGUI[6]);

					waitForMsg(11);
					sendString(msgFromGUI[6]);
					
					Report theReport = (Report)objectIn.readObject();
			
					System.out.println(theReport);
					
					flushOutGUIBuffer(4, 11);
					break;
				case "":
					break;
			}
		}
	}
	
	/**
	 * Communicates to the server as the landlord.
	 */
	private void communicateLandlord()
	{
		//System.out.println("running landlord");
		waitForMsg(1);
		String landlordOption = msgFromGUI[1];
		switch(landlordOption)
		{
			case "REGISTER":
				waitForMsg(2);
				if(msgFromGUI[2] == "REGISTER_PROPERTY") // Selected Register Property on GUI
				{
					sendString("ADDING_PROP");
					waitForMsg(3);
					if(msgFromGUI[3] == "REGISTERED") // Landlord that already exists in database.
					{
						sendString("REGISTERED");
						System.out.println("Registered Landlord");
						
						/* Landlord Info */
						waitForMsg(4);
						String regEmail = msgFromGUI[4];
						sendString(regEmail); // Search database with this email
						
						/* Property Info */
						waitForMsg(5);
						String regHouseType = msgFromGUI[5];
						sendString(regHouseType);
						
						String regIsFurnished;
						waitForMsg(6);
						if(msgFromGUI[6] == "FURNISHED")
						{
							regIsFurnished = "1";
						}
						else
						{
							regIsFurnished = "0";
						}
						sendString(regIsFurnished);
						
						waitForMsg(7);
						int regNumBaths = Integer.parseInt(msgFromGUI[7]);
						sendString(Integer.toString(regNumBaths));
						
						waitForMsg(8);
						int regNumBeds = Integer.parseInt(msgFromGUI[8]);
						sendString(Integer.toString(regNumBeds));
						
						waitForMsg(9);
						String regPropertyStreet = msgFromGUI[9];
						sendString(regPropertyStreet);
						
						waitForMsg(10);
						String regQuad = msgFromGUI[10];
						sendString(regQuad);
						
						waitForMsg(11);
						String regCity = msgFromGUI[11];
						sendString(regCity);
						
						waitForMsg(12);
						String regProv = msgFromGUI[12];
						sendString(regProv);
						
						waitForMsg(13);
						String regCountry = msgFromGUI[13];
						sendString(regCountry);
						
						waitForMsg(14);
						String postStatus = msgFromGUI[14]; // Online or offline.
						//System.out.println(postStatus);
						sendString(postStatus);
						
						waitForMsg(15);
						String buttonPress = msgFromGUI[15];
						while(buttonPress  == "") {}
						
						/* Cleanup */
						flushOutGUIBuffer(3, 15);
					}
					else if(msgFromGUI[3] == "NOT_REGISTERED") // Landlord that does not exist in database yet.
					{
						sendString("NOT_REGISTERED");
						System.out.println("Not registered Landlord");
						
						/* Landlord Info */
						waitForMsg(4);
						String regFirstName = msgFromGUI[4];
						sendString(regFirstName);
						
						waitForMsg(5);
						String regLastName = msgFromGUI[5];
						sendString(regLastName);
						
						waitForMsg(6);
						String regGender = msgFromGUI[6];
						if(regGender == "M")
						{
							System.out.println("Male");
							sendString("1");
						}
						else
						{
							System.out.println("female");
							sendString("0");
						}
						//sendString(regGender);
						
						waitForMsg(7);
						String regEmail = msgFromGUI[7];
						sendString(regEmail);
						
						waitForMsg(8);
						String regLandlordAddress = msgFromGUI[8];
						sendString(regLandlordAddress);
						
						waitForMsg(9);
						String regLandlordQuad = msgFromGUI[9];
						sendString(regLandlordQuad);
						
						waitForMsg(10);
						String regLandlordCity = msgFromGUI[10];
						sendString(regLandlordCity);
						
						waitForMsg(11);
						String regLandlordProv = msgFromGUI[11];
						sendString(regLandlordProv);
						
						waitForMsg(12);
						String regLandlordCountry = msgFromGUI[12];
						sendString(regLandlordCountry);
						
						waitForMsg(13);
						String regBirthMonth = msgFromGUI[13];
						sendString(regBirthMonth);

						waitForMsg(14);
						String regBirthDay = msgFromGUI[14];
						sendString(regBirthDay);

						waitForMsg(15);
						String regBirthYear = msgFromGUI[15];
						sendString(regBirthYear);
						
						/* Property Info */
						waitForMsg(16);
						String regHouseType = msgFromGUI[16];
						sendString(regHouseType);

						String regIsFurnished;
						if(msgFromGUI[17] == "FURNISHED")
						{
							regIsFurnished = "1";
						}
						else
						{
							regIsFurnished = "0";
						}
						sendString(regIsFurnished);

						waitForMsg(18);
						int regNumBaths = Integer.parseInt(msgFromGUI[18]);
						sendString(Integer.toString(regNumBaths));

						waitForMsg(19);
						int regNumBeds = Integer.parseInt(msgFromGUI[19]);
						sendString(Integer.toString(regNumBeds));

						waitForMsg(20);
						String regPropertyStreet = msgFromGUI[20];
						sendString(regPropertyStreet);

						waitForMsg(21);
						String regQuad = msgFromGUI[21];
						sendString(regQuad);

						waitForMsg(22);
						String regCity = msgFromGUI[22];
						sendString(regCity);

						waitForMsg(23);
						String regProv = msgFromGUI[23];
						sendString(regProv);

						waitForMsg(24);
						String regCountry = msgFromGUI[24];
						sendString(regCountry);

						waitForMsg(25);
						String postStatus = msgFromGUI[25]; // Online or offline.
						//System.out.println(postStatus);
						sendString(postStatus);
						
						waitForMsg(26);
						String buttonPress = msgFromGUI[26];
						while(buttonPress  == "") {}
						
						/* Cleanup */
						flushOutGUIBuffer(3, 26);
						
						app.msgFromClient[0] = "Property registered"; // NEEDS TO CHANGE IF NOT SUCCESSFUL
					}
					waitByMili(100);
					//Have to let GUI know if registration was successful or not.
				}
				break;
			case "STATE":
				sendString("CHANGESTATE");
				waitForMsg(2);
				if(msgFromGUI[2] == "CHANGE")
				{
					waitForMsg(3);
					int propertyIdToSearch = Integer.parseInt(msgFromGUI[3]);
					sendString(Integer.toString(propertyIdToSearch));
					
					waitForMsg(4);
					String newState = msgFromGUI[4];
					sendString(newState);
					
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
					waitForMsg(5);
					if(msgFromGUI[5] == "EMAIL_BUTTON")
					{
						System.out.println("Email button pressed.");
						sendString("EMAIL");
						waitForMsg(6);
						String emailToSend = msgFromGUI[6];
						sendString(emailToSend);
						waitForMsg(7);
						String propertyString = msgFromGUI[7];
						sendString(propertyString);
						flushOutGUIBuffer(5, 7);
					}
					break;
			}
		}
		else if(renterType == "REGULAR")
		{
			sendString(renterType);
			
			ArrayList<Property> properties = (ArrayList<Property>) objectIn.readObject();
			while(properties.isEmpty())
			{
				System.out.println("test");
				properties = (ArrayList<Property>) objectIn.readObject();
			}
			Application.properties = properties;
			
			waitForMsg(4);
			String regularRenterOption = msgFromGUI[4];
			switch(regularRenterOption)
			{
				case("SEARCH"):
					System.out.println("Searching!");
					waitForMsg(5);
					if(msgFromGUI[5] == "SEARCH")
					{
						System.out.println("Search button has been pressed.");
						waitForMsg(6);
						if(msgFromGUI[6] == "SEARCH_ID")
						{
							sendString("BY_ID");
							waitForMsg(7);
							sendString(msgFromGUI[7]);
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
						else
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
		/*
		for(int i = 0; i < msgFromGUI.length; i++)
		{
			System.out.println(msgFromGUI[i]);
		}*/
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
		ApplicationController client = new ApplicationController("10.13.93.210", 4000);
		client.getApp().mainGUI(client); // Launches GUI.
		client.initalizeThenRun();
	}
}
