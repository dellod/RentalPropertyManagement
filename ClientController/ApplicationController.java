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

		System.out.println("running landlord");
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
