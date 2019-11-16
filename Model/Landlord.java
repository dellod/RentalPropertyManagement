package Model;

import java.util.*;

class Landlord extends Person
{
	private String email;
	private ArrayList<Property> propertysOwned;
	
	/*** Constructors ***/
	public Landlord(Name fullName, Date birthday, String gender, Address home, String email, ArrayList<Property> propertysOwned) 
	{
		super(fullName, birthday, gender, home);
		this.email = email;
		this.propertysOwned = propertysOwned;
	}
	
	/*** Methods ***/
	@Override
	public String toString()
	{
		return ("Landlord: " + getName().toString() 
				+ "\tEmail: " + email + "\n");
	}
	
	/*** Getters ***/
	public String getEmail()
	{
		return email;
	}
	
	public ArrayList<Property> getPropertysOwned()
	{
		return propertysOwned;
	}
	
}
