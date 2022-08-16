package dao;

import static dao.Dao.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import classes.Administrador;


public class AdministradorDao {
	
	 static Connection con = getConnection();

	 
	  public static Administrador getAdministradorById(int id){
	       
		  Administrador admin = null;     
		try{
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
	  
	  
	  
	    
public static Administrador logar(String email, String senha){ 
      Administrador ar = new Administrador();    
		try{
		Connection con = getConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from administrador where email=?");
		ps.setString(ar.getId(), email);
		ResultSet rs = ps.executeQuery();
		//Verifica se a consulta retornou resultado
		if (rs.next()) {       
		      if(rs.getString("estado").equals("ativo")){
		          if(rs.getString("senha").equals(senha)){
		              ar.setId(rs.getInt("id"));
		             ar.setNome(rs.getString("nome"));
		              ar.setEmail(rs.getString("email"));         
		              ar.setSenha(rs.getString("senha"));   
		       
		          }else{
		              //Senha errada
		              ar = null;
		          }
		      }else{
		         //Usuário Inativo
		         ar = null;     
		      }
		}else{
		  // E-mail não existe
		 ar = null; 
		}
		}catch(Exception erro){
		erro.printStackTrace();
		}      
		return ar;
		}
	  
}	
