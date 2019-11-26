package ServerController;

import java.sql.SQLException;
import java.util.ArrayList;


import Model.*;
public class ModelController {

	private DataBase dataBase;
	public DataBase getDataBase() {
		return dataBase;
	}
	public ModelController() throws SQLException{
		
		dataBase = DataBase.getDataBase();
	}
	public ArrayList<Property> getAllProperty() throws SQLException{
		return dataBase.getAllProperty();
	}
	public Report generateReport(MyDate start,MyDate end) throws SQLException {
		String start1 = Integer.toString(start.getYear())+"-"+Integer.toString(start.getMonth())+"-"+Integer.toString(start.getDay());
		String end1 = Integer.toString(end.getYear())+"-"+Integer.toString(end.getMonth())+"-"+Integer.toString(end.getDay());
		return dataBase.generateReport(start, end);
		
	}
	
	public boolean validateUser(String username, String password) throws SQLException {
		
		return dataBase.loginRenter(username, password);
		
	}
	
	public boolean validateManager(String username, String password) throws SQLException {
		
		return dataBase.loginManager(username, password);
		
	}
	
	public void insertPropertyWithoutPosting(String type, int numBath, int numBed, int furnished, String state, String street, String city, String country, String province, String quadrant, String Fname, String Lname, String email, int year, int month, int day, int gender) throws SQLException {
		String date = Integer.toString(year)+"-"+Integer.toString(month)+"-"+Integer.toString(day);
		dataBase.registerPropertyWithoutPosting(type, numBath, numBed, furnished, state, street, city, country, province, quadrant, Fname, Lname, email, date, gender);
		
	}
	
	public void insertPropertyWithPosting(String type, int numBath, int numBed, int furnished, String state, String street, String city, String country, String province, String quadrant, String Fname, String Lname, String email, int year, int month, int day, int gender,int fee,int period) throws SQLException {
		String date = Integer.toString(year)+"-"+Integer.toString(month)+"-"+Integer.toString(day);
		dataBase.registerPropertyWithPosting(type, numBath, numBed, furnished, state, street, city, country, province, quadrant, Fname, Lname, email, date, gender,fee ,period);
		
	}
	public ArrayList<Property> searchByType(String type) throws SQLException{
		return dataBase.searchByType(type);
	}
	
	public ArrayList<Property> searchByBath(int numBath) throws SQLException{
		return dataBase.searchByBath(numBath);
	}
	
	public ArrayList<Property> searchByBed(int numBed) throws SQLException{
		return dataBase.searchByBath(numBed);
	}
	
	public ArrayList<Property> searchByFurnish(int furnished) throws SQLException{
		return dataBase.searchByFurnish(furnished);
	}
	
	public ArrayList<Property> searchByQuadrant(String quadrant) throws SQLException{
		return dataBase.searchByQuadrant(quadrant);
	}
	
	public ArrayList<Property> searchByID(int ID) throws SQLException{
		return dataBase.searchByID(ID);
	}
	
	public ArrayList<String> searchByEmail(String email) throws SQLException{
		ArrayList<String> emailInData =  dataBase.searchOwnerByEmail(email);
		return emailInData;
	}
	
	public String getOwnerEmail(int ID) throws SQLException {
		return dataBase.searchOwnerEmailByID(ID);
	}
	
	public boolean settingState(int ID,String state) throws SQLException {
		return dataBase.settingState(ID, state);
	}
	public ArrayList<Property> search(String type, int numBath, int numBed, int furnished, String quadrant) throws SQLException{
		/*ArrayList<Property> result = new ArrayList<Property>();
		result.addAll(dataBase.searchByType(type));
		result.addAll(dataBase.searchByBath(numBath));
		result.addAll(dataBase.searchByBed(numBed));
		result.addAll(dataBase.searchByFurnish(furnished));
		result.addAll(dataBase.searchByQuadrant(quadrant));
		return result;*/
		return dataBase.search(type, numBath, numBed, furnished, quadrant);
	}
	
	public boolean areThereNewNotification(RegisteredRenter r) throws SQLException {
		
		ArrayList<Property> before = r.getCart();
		dataBase.getNotification(r);
		ArrayList<Property> after = r.getCart();
		
		if(before.equals(after)) {
			return false;
		}
		else {
			return true;
		}
		
	}
}
