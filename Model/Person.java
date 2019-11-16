package Model;

abstract class Person 
{
	private Name fullName;
	private Date birthday;
	private String gender;
	private Address home;
	
	/*** Constructor ***/
	public Person(Name fullName, Date birthday, String gender, Address home)
	{
		this.fullName = fullName;
		this.birthday = birthday;
		this.gender = gender;
		this.home = home;
	}
	
	
	/*** Getters ***/
	public Name getName()
	{
		return fullName;
	}
	
	public Date getBirthdate()
	{
		return birthday;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public Address getHome()
	{
		return home;
	}
}
