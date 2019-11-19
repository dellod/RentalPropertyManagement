import ClientController.*;
import ServerController.*;
import View.*;

public class Main 
{
	public static String[] OPTIONS = {"CLIENT", "SERVER"};
	public static String CHOICE = OPTIONS[0];
	
	public static void main(String[] args)
	{
		if(CHOICE == "CLIENT")
		{
			ApplicationController.mainClient();
		}
		else if(CHOICE == "SERVER")
		{
			//return ModelController.mainServer();
		}
	}
}
