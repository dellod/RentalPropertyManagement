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
	
	public boolean validateUser(String username, String password) {
		
		dataBase
		
	}
	
	public boolean validateManager(String username, String password) {
		
		
	}
	
	public void insertProperty(Property p) {
		
	}
	
	public ArrayList<Property> search(){
		
	}
	
	public String createNotification(ArrayList<Property> propertyCart) {
		
	}
	
	public boolean areThereNewNotification() {
		
	}
}
