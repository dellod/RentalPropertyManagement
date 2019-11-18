package Model;

class Date 
{
	private String day;
	private String month;
	private String year;
	
	/*** Constructors ***/
	public Date()
	{
		setCurrentDate();
	}
	
	public Date(String day, String month, String year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	/*** Methods ***/
	public void setCurrentDate()
	{
		String tempString = java.time.LocalDate.now().toString();
		String delims = "[-]+";
		String[] tokens = tempString.split(delims);
		year = tokens[0];
		month = tokens[1];
		day = tokens[2];
	}
	
	@Override
	public String toString()
	{
		return (month + "/" + day + "/" + year + "\n");
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
