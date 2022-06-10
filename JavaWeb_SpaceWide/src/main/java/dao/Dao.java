package dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class Dao {
	 public static Connection getConnection(){
		Connection con = null;
		    try{
		        Class.forName("com.mysql.jdbc.Driver");       
		        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/site2022","root","");
		    }catch(Exception erro){
		        System.out.println(erro);
		    }
		        return con;
		    
		    }
		    
		  }
