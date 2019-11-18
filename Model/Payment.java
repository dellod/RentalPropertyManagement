package Model;

class Payment 
{
	private double amount;
	private Landlord landlord;
	private Date dateOfPayment;
	
	/*** Constructors ***/
	public Payment(double amount, Landlord landlord, Date d)
	{
		this.amount = amount;
		this.landlord = landlord;
		this.dateOfPayment = d;
	}
	
	/*** Methods ***/
	public String toString()
	{
		return ("Payment Amount: $" + amount + ". Date: " + dateOfPayment);
	}
	
	/*** Getters ***/
	public double getAmount()
	{
		return amount;
	}
	
	public Landlord getLandlord()
	{
		return landlord;
	}
	
	public Date getDate()
	{
		return dateOfPayment;
	}
	
}
