package Model;

class Account 
{
	private String username;
	private String password;
	
	/*** Constructors ***/
	public Account(String user, String pass)
	{
		this.username = user;
		this.password = pass;
	}
	
	/*** Methods ***/
	boolean checkUser(String user, String pass)
	{
		return false; // TODO implement the rest.
	}
	
	/*** Getters ***/
	// Might not need getters.
}
