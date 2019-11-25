package Model;

import java.io.Serializable;

abstract class Person implements Serializable
{
	private Name fullName;
	private MyDate birthday;
	private String gender;
	private Address home;
	
	/*** Constructor ***/
	public Person(Name fullName, MyDate birthday, String gender, Address home)
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
	
	public MyDate getBirthdate()
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
