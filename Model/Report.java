package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Report implements Serializable
{
	private int numHouseListings;
	private int numHousesRented;
	private int numActiveListings;
	private ArrayList<Property> listRented;
	private MyDate reportDate;
	
	/*** Constructors ***/
	public Report(int houseListings, int housesRented, int activeListings, ArrayList<Property> list)
	{
		this.numHouseListings = houseListings;
		this.numHousesRented = housesRented;
		this.numActiveListings = activeListings;
		this.listRented = list;
		reportDate = new MyDate();
		//reportDate.setCurrentDate(); // Needs to have current date.
	}
	
	/*** Methods ***/
	
	/*** Getters ***/
}
