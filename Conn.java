package travel_management_system;

import java.sql.*;  

public class Conn{
    Connection c ;
    Statement s;
    public Conn(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem","root","Admin@123"); 
            s=c.createStatement();
            
           
        }catch(Exception e){ 
            e.printStackTrace();
        }  
    } 
    
}  
//package travel_management_system;
//
//import java.sql.*;
//
//public class Conn {
//    Connection con;
//    public Conn() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL Driver
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_management", "root", "Admin@123");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
