package Model;

class Manager extends Person
{
	private Account profile;
	
	/*** Constructors ***/
	public Manager(Name fullName, MyDate birthday, String gender, Address home, Account profile) 
	{
		super(fullName, birthday, gender, home);
		this.profile = profile;
	}
	
	/*** Methods ***/
	// TODO Need to add more methods
	
	/*** Getters ***/
	public Account getProfile()
	{
		return profile;
	}
}
