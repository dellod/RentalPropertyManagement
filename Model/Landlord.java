package Model;

import java.io.Serializable;
import java.util.*;

public class Landlord extends Person
{
	private String email;
	private ArrayList<Property> propertysOwned;
	
	/*** Constructors ***/
	public Landlord(Name fullName, MyDate birthday, String gender, Address home, String email) 
	{
		super(fullName, birthday, gender, home);
		this.email = email;
		propertysOwned = new ArrayList<Property>();
	}
	
	/*** Methods ***/
	void registerProperty(Property property)
	{
		propertysOwned.add(property);
		System.out.println("Property has been registered!");
	}
	
	void deleteProperty(Property property) // Delete by object.
	{
		propertysOwned.remove(property);
	}
	
	void deleteProperty(int index) // Delete by index.
	{
		propertysOwned.remove(index);
	}
	
	boolean payFee(Property propertyToPost) // Pay fee to post property online.
	{
		return false; // TODO connect this with the model controller.
	}
	
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
