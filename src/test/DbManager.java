package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbManager {
	
	public static void main(String[] args){ 
		
        try{ 
        	
            Class.forName("com.mysql.cj.jdbc.Driver"); 
              
            Connection con = DriverManager.getConnection( 
             "jdbc:mysql://localhost:3306/", "root", "juicer"); 
  
            if (con != null)              
                System.out.println("Connected");             
            else            
                System.out.println("Not Connected"); 
              
            con.close(); 
        } 
        catch(Exception e) 
        { 
            System.out.println(e); 
        } 
    } 
}
