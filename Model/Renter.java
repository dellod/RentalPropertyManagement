package Model;

abstract class Renter extends Person
{

	public Renter(Name fullName, Date birthday, String gender, Address home) 
	{
		super(fullName, birthday, gender, home);
	}

	boolean search(Property p)
	{
		return false; // TODO implement the rest of this.
	}
}
