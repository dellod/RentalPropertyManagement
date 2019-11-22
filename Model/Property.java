package Model;

class Property 
{
	private MyDate MyDateRegistered;
	private Landlord owner;
	private String houseType;
	private int numBathrooms;
	private int numBedrooms;
	private boolean furnished;
	private String state;
	private Address address;
	
	/*** Constructors ***/
	public Property(MyDate MyDateRegistered, Landlord owner, String houseType, int bathrooms, int bedrooms, boolean furnished, String state, Address address)
	{
		this.MyDateRegistered = MyDateRegistered;
		this.owner = owner;
		this.houseType = houseType;
		this.numBathrooms = bathrooms;
		this.numBedrooms = bedrooms;
		this.furnished = furnished;
		this.state = state;
		this.address = address;
	}
	
	/*** Methods ***/
	public String toString()
	{
		return ("Property: " + address.toString() +
				"\tState: " + state +
				"\n\tOwner: " + owner.toString());
	}
	
	/*** Getters ***/
	public MyDate getMyDate()
	{
		return MyDateRegistered;
	}
	
	public Landlord getOwner()
	{
		return owner;
	}
	
	public String getType()
	{
		return houseType;
	}
	
	public int getNumBathrooms()
	{
		return numBathrooms;
	}
	
	public int getNumBedrooms()
	{
		return numBedrooms;
	}
	
	public boolean getFurnished()
	{
		return furnished;
	}
	
	public String getState()
	{
		return state;
	}
	
	public Address getAddress()
	{
		return address;
	}
}
