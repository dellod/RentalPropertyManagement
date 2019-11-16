package Model;

class Date 
{
	private String day;
	private String month;
	private String year;
	
	/*** Constructors ***/
	public Date(String day, String month, String year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	/*** Getters ***/
	public String getDay()
	{
		return day;
	}
	
	public String getMonth()
	{
		return month;
	}
	
	public String getYear()
	{
		return year;
	}
}
