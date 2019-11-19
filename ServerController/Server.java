package ServerController;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server 
{
	private ServerSocket serverSocket;
	
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
		while(true)
		{
			// Need to run here
		}
	}
	
	public static void mainServer()
	{
		Server s = new Server(8099);
		//s.communicate();
	}
}
