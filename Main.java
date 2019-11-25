import java.io.IOException;
import java.sql.SQLException;

import ClientController.*;
import ServerController.*;
import View.*;

public class Main 
{
	public static String[] OPTIONS = {"CLIENT", "SERVER"};
	public static String CHOICE = OPTIONS[1];
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException
	{
		switch(CHOICE)
		{
			case "CLIENT":
				ApplicationController.mainClient();
				break;
			case "SERVER":
				Server.mainServer();
				break;
			default:
				System.out.println("Error in Main.java");
		}
	}
}
