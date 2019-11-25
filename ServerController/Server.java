package ServerController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.naming.NamingException;

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
	public void communicate() throws SQLException, NamingException 
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
		switch (input) {
		
		case "REGULAR":
			//System.out.println("TEST");
			break;
		case "REGISTERED":
			//System.out.println("TES2222222222222222T");
			String username = socketIn.readLine();
			String password = socketIn.readLine();
			System.out.println("TEST");
			if(modelController.getDataBase().loginRenter(username, password)){
			printWriter.println("true");
			printWriter.flush();
			System.out.print("true");
			
			}
			else{
			printWriter.println("false");
			System.out.print("false");
			printWriter.flush();
			}
		}
	}
	public void registeredRenter() {
		
	}
	public static void mainServer() throws SQLException
	{
		Server s = new Server(4000);
		s.communicate();
	}
}
