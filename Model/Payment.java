package Model;

class Payment 
{
	private double amount;
	private Landlord landlord;
	private MyDate MyDateOfPayment;
	
	/*** Constructors ***/
	public Payment(double amount, Landlord landlord, MyDate d)
	{
		this.amount = amount;
		this.landlord = landlord;
		this.MyDateOfPayment = d;
	}
	
	/*** Methods ***/
	public String toString()
	{
		return ("Payment Amount: $" + amount + ". MyDate: " + MyDateOfPayment);
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
	
	public MyDate getMyDate()
	{
		return MyDateOfPayment;
	}
	
}
