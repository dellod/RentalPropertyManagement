package Model;

public class Name
{
	private String firstName;
	private String lastName;

	/*** Constructors ***/
	public Name(String first, String last)
	{
		this.firstName = first;
		this.lastName = last;
	}
	
	/*** Methods ***/
	@Override
	public String toString()
	{
		return (firstName + " " + lastName + "\n");
	}
	
	/*** Getters ***/
	public String getFirst()
	{
		return firstName;
	}
	
	public String getLast()
	{
		return lastName;
	}
}