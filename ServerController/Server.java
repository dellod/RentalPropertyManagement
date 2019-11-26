package ServerController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.naming.NamingException;

import Model.Property;

public class Server 
{
	private ServerSocket serverSocket;
	private ObjectOutputStream objectOut;
	private BufferedReader socketIn;
	private PrintWriter printWriter; 
	private ModelController modelController;
	/*** Constructors ***/
	public Server(int port)
	{
		try
		{
			serverSocket = new ServerSocket(port);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("Server is online.");
	}
	
	/*** Methods 
	 * @throws SQLException 
	 * @throws NamingException ***/
	public void communicate() throws SQLException
	{
		
			try 
			{
				System.out.println("Waiting to accept...");
				Socket ss = serverSocket.accept();
				socketIn = new BufferedReader(new InputStreamReader(ss.getInputStream()));
				objectOut = new ObjectOutputStream(ss.getOutputStream());
				printWriter = new PrintWriter(ss.getOutputStream());
				System.out.println("Accepted! Client: " + ss.toString());
				
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
				
			}
			
			modelController = new ModelController();
			String input;
			try {
			while(true) {
				
				input = socketIn.readLine();
				//System.out.println(input);
				
				switch(input) {
				
					
				case "Renter":
					//System.out.println("IN RENTER");
					renter();
					break;
				}
			}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		
	}
	public void renter() throws IOException, SQLException {
		String input = socketIn.readLine(); 
		while(true) {
			 input = socketIn.readLine();
			//System.out.println("INPUT IN RENTER "+input);
		switch (input) {
		
		case "REGULAR":
			//System.out.println("TEST");
			break;
		case "REGISTERED":
			registeredRenter();
			
			break;
				
		}
		}
	}
	public void registeredRenter() throws IOException, SQLException {
		wait("REGISTERED");
		
		String username = socketIn.readLine();
		String password = socketIn.readLine();
		if(modelController.getDataBase().loginRenter(username, password)){
		objectOut.writeBoolean(true);
		objectOut.flush();
		System.out.println("true");
		objectOut.writeObject(modelController.getAllProperty());
		objectOut.flush();
		
		}
		else{
		objectOut.writeBoolean(false);
		objectOut.flush();
		System.out.println("false");
		}
		
		
		
		String input;
		while(true) {
			 input = socketIn.readLine();
			 System.out.println(input);
		switch (input) {
		
		case "BY_ID":
			//System.out.println("IN BYID");
			String ID = socketIn.readLine();
			//System.out.println(ID);
			//objectOut.flush();
			//ArrayList<Property> toSend = modelController.searchByID(Integer.parseInt(ID));
			objectOut.writeObject(modelController.searchByID(Integer.parseInt(ID)));
			objectOut.flush();
			for(int i=0;i<modelController.searchByID(Integer.parseInt(ID)).size();i++) {
				System.out.println(modelController.searchByID(Integer.parseInt(ID)).get(i).toString());
			}
			
			break;
		case "BY_ELSE":
			String houseType =  socketIn.readLine();
			String stringNumBed = socketIn.readLine();
			int numBed = Integer.parseInt(stringNumBed);
			String stringNumBath = socketIn.readLine();
			int numBath = Integer.parseInt(stringNumBath);
			String stringFurnished = socketIn.readLine();
			int furnished = Integer.parseInt(stringFurnished);
			
			
			String quadrant = socketIn.readLine();
			System.out.println(houseType);
			System.out.println(stringNumBed);
			System.out.println(stringNumBath);
			System.out.println(stringFurnished);
			System.out.println(quadrant);
			objectOut.writeObject(modelController.search(houseType, numBath, numBed, furnished, quadrant));
			objectOut.flush();
			for(int i=0;i<modelController.search(houseType, numBath, numBed, furnished, quadrant).size();i++) {
				System.out.println(modelController.search(houseType, numBath, numBed, furnished, quadrant));
			}
			break;
				
		}
		
	}
	}
	public void wait(String s) throws IOException {
		while(socketIn.readLine() == s) {}
	}
	public static void mainServer() throws SQLException
	{
		Server s = new Server(4000);
		s.communicate();
	}
}
