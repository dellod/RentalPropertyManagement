package Model;

import java.util.ArrayList;

public class RegisteredRenter extends Renter
{
	private String email;
	private ArrayList<Property> propertyCart;
	private Account profile; // Not sure if we need this.
	
	/*** Constructors ***/
	public RegisteredRenter(Name fullName, MyDate birthday, String gender, Address home, String email, ArrayList<Property> cart, Account profile) 
	{
		super(fullName, birthday, gender, home);
		this.email = email;
		this.propertyCart = cart;
		this.profile = profile;
	}
	
	
	/*** Methods ***/
	
	/*** Getters ***/
	public String getEmai()
	{
		return email;
	}
	
	public ArrayList<Property> getCart()
	{
		return propertyCart;
	}
	
	public Account getProfile()
	{
		return profile;
	}
	/*** Setter ***/
	public void setCart(ArrayList<Property> p) {
		propertyCart = p;
	}
}
