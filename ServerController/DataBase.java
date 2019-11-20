package ServerController;

import java.sql.*;

public class DataBase {
	Connection myConn;
    Statement stm;
    
   public DataBase() throws SQLException{
    	
    	 
	   myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "ensf480db");
       stm = myConn.createStatement();
       
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
   public void convertToProperty(ResultSet rs) throws SQLException {
	   while (rs.next()) {
		   int ID = rs.getInt("ID");
		   Date d = rs.getDate("regDate");
		   String type2 = rs.getString("type");
		   int BathNum = rs.getInt("numBath");
		   int BedNum = rs.getInt("numBed");
		   boolean furnished  = rs.getBoolean("furnished");
		   String quadrant = rs.getString("quadrant");
		   String state = rs.getString("state");
		   String address = rs.getString("address");
		   String ownerFname = rs.getString("ownerFname");
		   String ownerLname = rs.getString("ownerLname");
		   String ownerEmail = rs.getString("ownerEmail");
	   }
   }
   public void searchByType(String type) throws SQLException {
	   String query = "selct * from Property where type = "+type;
	   ResultSet rs = stm.executeQuery(query);
	   convertToProperty(rs);
   }
   
   public void searchByBath(int num) throws SQLException {
	   String query = "selct * from Property where numBath = "+ Integer.toString(num);
	   ResultSet rs = stm.executeQuery(query);
	   convertToProperty(rs);
   }
 
   public void searchByBed(int num) throws SQLException {
	   String query = "selct * from Property where numBed = "+ Integer.toString(num);
	   ResultSet rs = stm.executeQuery(query);
	   convertToProperty(rs);
   }
   
   public void searchByFurnish(int furnished) throws SQLException {
	   String query = "selct * from Property where furnished = "+ Integer.toString(furnished);
	   ResultSet rs = stm.executeQuery(query);
	   convertToProperty(rs);
   }
   
   public void searchByQuadrant(String quadrant) throws SQLException {
	   String query = "selct * from Property where quadrant = "+ quadrant;
	   ResultSet rs = stm.executeQuery(query);
	   convertToProperty(rs);
	   
   }
   
   public void searchByID(int ID) throws SQLException {
	   String query = "selct * from Property where ID = "+ Integer.toString(ID);
	   ResultSet rs = stm.executeQuery(query);
	   convertToProperty(rs);
	   
   }
   

}
