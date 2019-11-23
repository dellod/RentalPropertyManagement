package ServerController;

import java.sql.*;
import java.util.ArrayList;

import Model.*;

public class DataBase {
	Connection myConn;
    Statement stm;
    private static DataBase singleton;
    
  	private DataBase() throws SQLException{
    	
    	 
	   myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "ensf480db");
       stm = myConn.createStatement();
       
    }
  	
  	public static DataBase getDataBase() throws SQLException {
  		
  		if(singleton == null) {
  			singleton = new DataBase();
  		}
  		 return singleton;
  		
  	}
   
   public Report generateReport(MyDate a,MyDate b) throws SQLException {

	   
	   String query = "select count(*) from Property where regDate >= '"+ a.getYear()+"-"+a.getMonth()+"-"+a.getDay()+"' and regDate <= '"+ b.getYear()+"-"+b.getMonth()+"-"+b.getDay()+"'";
	   ResultSet rs = stm.executeQuery(query);
	   rs.next();
	   int numList = rs.getInt("count(*)");
	   
	   query = "select count(*) from Property where state = 'rented' and regDate >= '"+ a.getYear()+"-"+a.getMonth()+"-"+a.getDay()+"' and regDate <= '"+ b.getYear()+"-"+b.getMonth()+"-"+b.getDay()+"'";
	   rs = stm.executeQuery(query);
	   rs.next();
	   int numRented = rs.getInt("count(*)");
	   
	   query = "select * from Property where state = 'rented' and regDate >= '"+ a.getYear()+"-"+a.getMonth()+"-"+a.getDay()+"' and regDate <= '"+ b.getYear()+"-"+b.getMonth()+"-"+b.getDay()+"'";
	   rs = stm.executeQuery(query); 
	   ArrayList<Property> rentedProperty = convertToProperty(rs);
	   
	   query = "select count(*) from Property where state = 'active' and regDate >= '"+ a.getYear()+"-"+a.getMonth()+"-"+a.getDay()+"' and regDate <= '"+ b.getYear()+"-"+b.getMonth()+"-"+b.getDay()+"'";
	   rs = stm.executeQuery(query);
	   rs.next();
	   int numActive = rs.getInt("count(*)");
	   
	   Report r = new Report(numList,numRented,numActive,rentedProperty);
	   
	   return r;
   }
   public boolean loginRenter(String username, String password) throws SQLException {
	   String query = "select username from Account where username = " + username + "and password = " + password + ")";
	   return  stm.execute(query);
   }
   public boolean loginManager(String username, String password) throws SQLException {
	   String query = "select username from Manager where username = " + username + "and password = " + password + ")";
	   return  stm.execute(query);
	   
   }
   public void getAllUserName() {
	   //String query = "select username from Account where username = " + username + "and password = " + password + ")";
	  //return  stm.execute(query);
   }
   public boolean registerAccount(String username, String password) throws SQLException {
	   
	   String query = "select username from Account where username = " + username;
	   
	   //ResultSet rs = stm.executeQuery(query);
	   if(stm.execute(query) == false) {
		   query ="insert into Account (username, password) values (" + username+ ", "+ password + ")";
		   stm.execute(query);
		   return true;
	   }
	   else {
		   return false;
	   }
		   
	  
   }
  
   
   private  ArrayList<Property> convertToProperty(ResultSet rs) throws SQLException {
	   ArrayList<Property> toSend = new ArrayList<>();
	   while (rs.next()) {
		   
		   
		   int ID = rs.getInt("ID");
		   Date d = rs.getDate("regDate");
		   MyDate myDate = new MyDate(d.getDate(),d.getMonth(),d.getYear());
		   
		   String type2 = rs.getString("type");
		   int BathNum = rs.getInt("numBath");
		   int BedNum = rs.getInt("numBed");
		   boolean furnished  = rs.getBoolean("furnished");
		   String state = rs.getString("state");
		   
		   String street = rs.getString("addressStreet");
		   String city = rs.getString("addressCity");
		   String country = rs.getString("addressCountry");
		   String province = rs.getString("addressProvince");
		   String ownderQuadrant = rs.getString("addressQuadrant");
		   
		   Address address = new Address(street,city,country,province,ownderQuadrant);
		   
		   String ownerFname = rs.getString("ownerFname");
		   String ownerLname = rs.getString("ownerLname");
		   String ownerEmail = rs.getString("ownerEmail");
		   Date d2 = rs.getDate("ownerBirthday");
		   MyDate birthday = new MyDate(d2.getDate(),d2.getMonth(),d2.getYear());
		   
		   boolean gender = rs.getBoolean("gender");
		   String gender2;
		   if(gender) {
			   gender2="M";
		   }
		   else {
			   gender2="F";
		   }
		   Name n = new Name(ownerFname,ownerLname);
		   
		   Landlord l = new Landlord(n,birthday,gender2,null,ownerEmail);
		   Property p = new Property(ID,myDate,l,type2,BathNum,BedNum,furnished,state,address);
		   toSend.add(p);
	   }
	   return toSend;
   }
   public  ArrayList<Property> searchByType(String type) throws SQLException {
	   String query = "selct * from Property where type = "+type;
	   ResultSet rs = stm.executeQuery(query);
	   return convertToProperty(rs);
   }
   
   public  ArrayList<Property> searchByBath(int num) throws SQLException {
	   String query = "selct * from Property where numBath = "+ Integer.toString(num);
	   ResultSet rs = stm.executeQuery(query);
	   return convertToProperty(rs);
   }
 
   public  ArrayList<Property> searchByBed(int num) throws SQLException {
	   String query = "selct * from Property where numBed = "+ Integer.toString(num);
	   ResultSet rs = stm.executeQuery(query);
	   return convertToProperty(rs);
   }
   
   public  ArrayList<Property> searchByFurnish(int furnished) throws SQLException {
	   String query = "selct * from Property where furnished = "+ Integer.toString(furnished);
	   ResultSet rs = stm.executeQuery(query);
	   return convertToProperty(rs);
   }
   
   public  ArrayList<Property> searchByQuadrant(String quadrant) throws SQLException {
	   String query = "selct * from Property where quadrant = "+ quadrant;
	   ResultSet rs = stm.executeQuery(query);
	   return convertToProperty(rs);
	   
   }
   
   public ArrayList<Property> searchByID(int ID) throws SQLException {
	   String query = "selct * from Property where ID = "+ Integer.toString(ID);
	   ResultSet rs = stm.executeQuery(query);
	   return convertToProperty(rs);
	   
   }
   

}
