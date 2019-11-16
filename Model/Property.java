package Model;

class Property 
{
	private Date dateRegistered;
	private Landlord owner;
	private String houseType;
	private int numBathrooms;
	private int numBedrooms;
	private boolean furnished;
	private String state;
	private Address address;
	
	/*** Constructors ***/
	public Property(Date dateRegistered, Landlord owner, String houseType, int bathrooms, int bedrooms, boolean furnished, String state, Address address)
	{
		this.dateRegistered = dateRegistered;
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
	public Date getDate()
	{
		return dateRegistered;
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
