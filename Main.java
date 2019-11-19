import ClientController.*;
import ServerController.*;
import View.*;

public class Main 
{
	public static String[] OPTIONS = {"CLIENT", "SERVER", "GUI"};
	public static String CHOICE = OPTIONS[2];
	
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
		else if(CHOICE == "GUI") // TAKE OUT LATER just here for testing
		{
			Application.mainGUI();
		}
	}
}
