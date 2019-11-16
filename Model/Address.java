package Model;

class Address 
{
	private String street;
	private String city;
	private String quadrant;
	private int homeNumber;
	
	/*** Constructors ***/
	public Address(String street, String city, String quadrant, int homeNumber)
	{
		this.street = street;
		this.city = city;
		this.quadrant = quadrant;
		this.homeNumber = homeNumber;
	}
	
	/*** Getters ***/
	public String getStreet()
	{
		return street;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getQuadrant()
	{
		return quadrant;
	}
	
	public int getNumber()
	{
		return homeNumber;
	}
}