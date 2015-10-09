package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TodoLoginAction {

 public boolean isUserLoggedin(String userId){
  return true;
 }
 
 public boolean validateUser(String _userId, String _password)
 {
  boolean status=false;
 
  try{
	  Class.forName("oracle.jdbc.driver.OracleDriver");  
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
    PreparedStatement ps=con.prepareStatement( "select * from USERS where USERID=? and PASSWORD=?");  
    ps.setString(1,_userId);  
    ps.setString(2,_password);  
    
    ResultSet rs=ps.executeQuery();  
   
    status=rs.next();
   }
  catch(Exception e)
  {
   e.printStackTrace();
  }
  return status;
 }

 public boolean isUserAutorized(String userId, String action){
  return true;
 }

}
