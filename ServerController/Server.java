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

import Model.MyDate;
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
				System.out.println(input);
				
				switch(input) {
				
					
				case "Renter":
					//System.out.println("IN RENTER");
					renter();
					break;
					
				case "Landlord":
					landLoardDecideWhatToDo();
					break;
					
				case "Manager":
					manager();
				}
			}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		
	}
	public void manager() throws IOException, SQLException {
		if(managerLogin()) {
			objectOut.writeBoolean(true);
			objectOut.flush();
			managerDecideWhatToDo();
		}
		else{
			objectOut.writeBoolean(false);
			objectOut.flush();
		}
		
		
		
	}
	public void managerDecideWhatToDo() throws IOException, SQLException {
		String input;
		while(true) {
			input = socketIn.readLine();
			
			switch(input) {
			
			case "GENERATE":
				generarteReport();
				break;
			case "CHANGESTATE":
				
				break;
				
			}
			break;
		}
	}
	public void generarteReport() throws IOException, SQLException {
		String startD = socketIn.readLine();
		int SD = Integer.parseInt(startD);
		String startM = socketIn.readLine();
		int SM = Integer.parseInt(startM);
		String startY = socketIn.readLine();
		int SY = Integer.parseInt(startY);
		String afterD = socketIn.readLine();
		int AD = Integer.parseInt(afterD);
		String afterM = socketIn.readLine();
		int AM = Integer.parseInt(afterM);
		String afterY = socketIn.readLine();
		int AY = Integer.parseInt(afterY);
		
		MyDate start = new MyDate(SD,SM,SY);
		MyDate after = new MyDate(AD,AM,AY);
		
		objectOut.writeObject(modelController.generateReport(start, after));
	}
	public boolean managerLogin() throws IOException, SQLException {
		String username = socketIn.readLine();
		String password = socketIn.readLine();
		return modelController.validateManager(username, password);
	}
	public void landLoardDecideWhatToDo() throws IOException, SQLException {
		String input = socketIn.readLine();
		while(true) {
			input = socketIn.readLine();
			
			switch(input) {
			
			case "ADDING_PROP":
				addProperty();
				break;
			case "CHANGESTATE":
				changeState();
				break;
				
			}
			break;
		}
	}
	public void changeState() throws IOException, SQLException {
		String ID = socketIn.readLine();
		int theID = Integer.parseInt(ID);
		String state = socketIn.readLine();
		modelController.settingState(theID, state);
		
	}
	public void addProperty() throws IOException, SQLException {
		System.out.println("in add property");
		String input;
		while(true) {
			input = socketIn.readLine();
			System.out.println(input);
			switch(input) {
			
			case "REGISTERED":
				String email = socketIn.readLine();
				ArrayList<String> ownerInfo = modelController.getDataBase().searchOwnerByEmail(email);
				String ownerEmail = ownerInfo.get(0);
				String ownerFname = ownerInfo.get(1);
				String ownerLname = ownerInfo.get(2);
				String gender1 = ownerInfo.get(3);
				int gender = Integer.parseInt(gender1);
				String type = socketIn.readLine();
				
				String furnished1 = socketIn.readLine();
				int furnished = Integer.parseInt(furnished1);
				
				String numBath1 = socketIn.readLine();
				int numBath = Integer.parseInt(numBath1);
				String numBed1 = socketIn.readLine();
				int numBed = Integer.parseInt(numBed1);
				String street = socketIn.readLine();
				String quadrant = socketIn.readLine();
				String city = socketIn.readLine();
				String province = socketIn.readLine();
				String country = socketIn.readLine();
				
				MyDate d = new MyDate();
				
				
				String postOnline;
				while(true) {
					postOnline = socketIn.readLine();
					switch(postOnline) {
					
					case "ONLINE":
						System.out.println("inONLINE");
						modelController.insertPropertyWithPosting(type, numBath, numBed, furnished, "active", street, city, country, province, quadrant, ownerFname, ownerLname, ownerEmail, d.getYear(), d.getMonth(), d.getDay(), gender,10,1);
						break;
					case "OFFLINE":
						modelController.insertPropertyWithoutPosting(type, numBath, numBed, furnished, "active", street, city, country, province, quadrant, ownerFname, ownerLname, ownerEmail, d.getYear(), d.getMonth(), d.getDay(), gender);
						break;
					}
					break;
				//
				}
			
				break;
				
			case "NOT_REGISTERED":
				
				String ownerFname2 = socketIn.readLine();
				String ownerLname2 = socketIn.readLine();
				String gender2 = socketIn.readLine();
				int gender3 = Integer.parseInt(gender2);
				String ownerEmail2 = socketIn.readLine();
				String ownerStreet = socketIn.readLine();
				String ownerQuadrant = socketIn.readLine();
				String ownerCity = socketIn.readLine();
				String ownerProvince = socketIn.readLine();
				String ownerCountry = socketIn.readLine();
				String month = socketIn.readLine();
				String day = socketIn.readLine();
				String year = socketIn.readLine();
				
				String type2 = socketIn.readLine();
				
				String furnished2 = socketIn.readLine();
				int furnished3 = Integer.parseInt(furnished2);
				
				String numBath2 = socketIn.readLine();
				int numBath3 = Integer.parseInt(numBath2);
				String numBed2 = socketIn.readLine();
				int numBed3 = Integer.parseInt(numBed2);
				
				String street2 = socketIn.readLine();
				String quadrant2 = socketIn.readLine();
				String city2 = socketIn.readLine();
				String province2 = socketIn.readLine();
				String country2 = socketIn.readLine();
				
				//String postOnline2 = socketIn.readLine();
				MyDate d2= new MyDate();
				String postOnline2;
				while(true) {
					postOnline2 = socketIn.readLine();
					switch(postOnline2) {
					
					case "ONLINE":
						System.out.println("inONLINE");
						modelController.insertPropertyWithPosting(type2, numBath3, numBed3, furnished3, "active", street2, city2, country2, province2, quadrant2, ownerFname2, ownerLname2, ownerEmail2, d2.getYear(), d2.getMonth(), d2.getDay(), gender3,10,1);
						break;
					case "OFFLINE":
						modelController.insertPropertyWithoutPosting(type2, numBath3, numBed3, furnished3, "active", street2, city2, country2, province2, quadrant2, ownerFname2, ownerLname2, ownerEmail2, d2.getYear(), d2.getMonth(), d2.getDay(), gender3);
						break;
					}
					break;
				//
				}
			
			}
		}
		
	}
	public void renter() throws IOException, SQLException {
		String input = socketIn.readLine(); 
		while(true) {
			 input = socketIn.readLine();
			//System.out.println("INPUT IN RENTER "+input);
		switch (input) {
		
		case "REGULAR":
			//wait("REGULAR");
			listAllProperty();
			decideWhatToDo();
			break;
		case "REGISTERED":
			registeredRenter();
			decideWhatToDo();
			break;
				
		}
		}
	}
	public void listAllProperty() throws IOException, SQLException {
		objectOut.writeObject(modelController.getAllProperty());
		objectOut.flush();
	}
	public void registeredRenter() throws IOException, SQLException {
		wait("REGISTERED");
		
		String username = socketIn.readLine();
		String password = socketIn.readLine();
		if(modelController.getDataBase().loginRenter(username, password)){
		objectOut.writeBoolean(true);
		objectOut.flush();
		System.out.println("true");
		listAllProperty();
		
		}
		else{
		objectOut.writeBoolean(false);
		objectOut.flush();
		System.out.println("false");
		}
		
		
		
		
	}
	
	
	public void decideWhatToDo() throws IOException, NumberFormatException, SQLException {
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
		
		case "EMAIL":
			String content = socketIn.readLine();
			//System.out.println(content);
			String property = socketIn.readLine();
			System.out.println("The following property's owner will get email");
			System.out.println(property);
			System.out.println(content);
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
