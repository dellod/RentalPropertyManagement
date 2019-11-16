package Model;

class Address 
{
	private String street;
	private String city;
	private String country;
	private String province;
	private String quadrant;
	private int homeNumber;
	
	/*** Constructors ***/
	public Address(String street, String city, String country, String province, String quadrant, int homeNumber)
	{
		this.street = street;
		this.city = city;
		this.country = country;
		this.province = province;
		this.quadrant = quadrant;
		this.homeNumber = homeNumber;
	}
	
	/*** Methods ***/
	@Override
	public String toString()
	{
		return (homeNumber + ", " + street + " " + quadrant + ", " + city + ", " + province + " " + country + "\n");
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
	
	public String getCountry()
	{
		return country;
	}
	
	public String getProvince()
	{
		return province;
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