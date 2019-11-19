package ClientController;

import View.*;

import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

// AKA Client
public class ApplicationController 
{
	Application app;
	private Socket theSocket;
	private ObjectInputStream objectIn;
	private PrintWriter writeServer;
	
	private String userType; // User type: Manager, Landlord, or Renter
	public String[] msgFromGUI;
	
	/*** Constructors ***/
	public ApplicationController(String serverName, int port)
	{
		app = new Application(this);
		userType = "GARBAGE";
		msgFromGUI = new String[100]; //Buffer for Application GUI
		// Add server connections here
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
