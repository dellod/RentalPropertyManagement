package ServerController;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.*;
public class ModelController {

	private DataBase dataBase;
	public ModelController() throws SQLException {
		
		dataBase = DataBase.getDataBase();
	}
	public Report generateReport(MyDate start,MyDate end) throws SQLException {
		
		return dataBase.generateReport(start, end);
		
	}
	
	public boolean validateUser(String username, String password) throws SQLException {
		
		return dataBase.loginRenter(username, password);
		
	}
	
	public boolean validateManager(String username, String password) throws SQLException {
		
		return dataBase.loginManager(username, password);
		
	}
	
	public void insertProperty(Property p) {
		
		
		
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
	
	public String createNotification(ArrayList<Property> propertyCart) {
		
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
