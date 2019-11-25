package ServerController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server 
{
	private ServerSocket serverSocket;
	private ObjectOutputStream objectOut;
	private BufferedReader socketIn;
	
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
	
	/*** Methods ***/
	public void communicate() 
	{
		
			try 
			{
				System.out.println("Waiting to accept...");
				Socket ss = serverSocket.accept();
				socketIn = new BufferedReader(new InputStreamReader(ss.getInputStream()));
				objectOut = new ObjectOutputStream(ss.getOutputStream());
				System.out.println("Accepted! Client: " + ss.toString());
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
				
			}
			String input;
			try {
			while(true) {
				input = socketIn.readLine();
				
				switch(input) {
				
					
				case "REGISTERED":
					registered();
				}
			}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		
	}
	public void registered() {
		
	}
	public static void mainServer()
	{
		Server s = new Server(4000);
		s.communicate();
	}
}
