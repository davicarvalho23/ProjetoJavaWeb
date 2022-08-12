package dao;

import classes.Administrador;

import static dao.Dao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AdministradorDao {
	
	  public static Administrador getAdministradorById(int id){
	       
		  Administrador admin = null;     
		try{
	        Connection con = getConnection();
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT nome, email, senha, \"administrador\" FROM administrador WHERE id = ?");
	        ResultSet rs = ps.executeQuery();
	    
	        while(rs.next()){
	 	       Calendar cl;
	 	       
	        	admin = new Administrador();
	        	admin.setId(rs.getInt("id"));
	        	admin.setNome(rs.getString("nome"));
	        	admin.setEmail(rs.getString("email"));         
	        	admin.setSenha(rs.getString("senha"));  
	            admin.setEstado(rs.getString("estado"));
               
	
	        }
	   }catch(Exception erro){
	        erro.printStackTrace();
	    }      
	        return admin;
	    }
}	
