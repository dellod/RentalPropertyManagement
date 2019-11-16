package Model;

class Name
{
	private String firstName;
	private String lastName;

	/*** Constructors ***/
	public Name(String first, String last)
	{
		this.firstName = first;
		this.lastName = last;
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