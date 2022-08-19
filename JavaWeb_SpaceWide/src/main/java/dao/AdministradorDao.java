package dao;

import static dao.Dao.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import classes.Administrador;
import java.sql.SQLException;


public class AdministradorDao {
	
	 static Connection con = getConnection();

	 
	  public static Administrador getAdministradorById(int id){
	       
		  Administrador admin = null;     
		try{
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM administrador WHERE id = ?");
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
	  
	  
	  
	    
public static Administrador logar(String email, String senha) {
      Administrador adm = new Administrador();    
      
		    try {
		Connection con = getConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from administrador where email=?");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		//Verifica se a consulta retornou resultado
		if (rs.next()) {       
         
                 if(rs.getString("estado").equals("ativo")){
                     if(rs.getString("senha").equals(senha)){
                         adm.setId(rs.getInt("id"));
                         adm.setNome(rs.getString("nome"));
                         adm.setEmail(rs.getString("email"));
                         adm.setSenha(rs.getString("senha"));
                         
                     }else{
                         //Senha errada
                         adm = null;
                     }
                 }else{
                     //Usu�rio Inativo
                     adm = null;
                 }
            
		}else{
		  // E-mail n�o existe
		adm = null; 
                        }
                }catch(Exception erro){
       System.out.println(erro); }
          return adm;
    }      
            public static int editarAdm(Administrador administrador){
	       int status = 0;  
	   try{
	        Connection con = getConnection();
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE administrador SET nome=?, email=? WHERE id=?");
	        ps.setString(1, administrador.getNome());
	        ps.setString(2, administrador.getEmail());
                ps.setString(3, administrador.getSenha());
	        ps.setInt(4, administrador.getId());         
	        status = ps.executeUpdate();
	    }catch(Exception erro){
	        System.out.println(erro);
	    }      
	       return status;
	   }
              
		}

	
