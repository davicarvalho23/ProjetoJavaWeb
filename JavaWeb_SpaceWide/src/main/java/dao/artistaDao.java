package dao;

import static dao.Dao.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Artista;


public class artistaDao {

	  public static Artista getArtistaById(int id){
	        Artista artista = null;      
	    try{
	        Connection con = getConnection();
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from artista where Id=?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	            artista = new Artista();
	            artista.setId(rs.getInt("id"));
	            artista.setNome(rs.getString("nome"));
	            artista.setNome(rs.getString("nome_artistico"));
	            artista.setEmail(rs.getString("email"));         
	            artista.setSenha(rs.getString("senha"));   
	            artista.setNome(rs.getString("genero"));
	            
	        }
	    }catch(Exception erro){
	        System.out.println(erro);
	    }      
	        return artista;
	    }
	    
	    
	   public static int editarArtista(Artista artista){
	       int status = 0;  
	   try{
	        Connection con = getConnection();
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE artista SET Nome=?, Email=?, Nome_artistico=? WHERE Id=?");
	        ps.setString(1, artista.getNome());
	        ps.setString(2, artista.getEmail());
	        ps.setInt(4, artista.getId());         
	        status = ps.executeUpdate();
	    }catch(Exception erro){
	        System.out.println(erro);
	    }      
	       return status;
	   }
	    
	    public static List<Artista> getArtista(int inicio, int total) {
	    List<Artista> list = new ArrayList<Artista>();
	    try{
	        Connection con = getConnection();
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM artista ORDER BY Id LIMIT " + (inicio - 1) + " ," + total);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	            Artista artista = new Artista();
	            artista.setId(rs.getInt("id"));
	            artista.setNome(rs.getString("nome"));
	            artista.setNome(rs.getString("nome_artistico"));
	            artista.setEmail(rs.getString("email"));         
	            artista.setSenha(rs.getString("senha"));   
	            artista.setNome(rs.getString("genero"));
	            
	            list.add(artista);
	        }       
	    }catch(Exception erro){
	        System.out.println(erro);
	    }
	    return list;
	    }

	    public static List<Artista> getRelatorio() {
	    List<Artista> list = new ArrayList<Artista>();
	    try{
	        Connection con = getConnection();
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM artista");
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	            Artista artista = new Artista();
	            artista.setId(rs.getInt("id"));
	            artista.setNome(rs.getString("nome"));
	            artista.setNome(rs.getString("nome_artistico"));
	            artista.setEmail(rs.getString("email"));
	            artista.setEmail(rs.getString("genero"));
	            
	            list.add(artista);
	        }       
	    }catch(Exception erro){
	        System.out.println(erro);
	    }
	    return list;
	    }
	    
	    public static int getContagem() {
	        int contagem = 0;
	        try{
	            Connection con = getConnection();
	            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS contagem FROM artista");
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()){
	                contagem = rs.getInt("contagem");
	            }   
	        }catch(Exception erro){
	            System.out.println(erro);
	        }
	        return contagem;
	    }
	    
	    
	        public static int[] getRelatorioArtista() {

	int[] valores = {10, 20, 30, 40};
	        
	        try{
	            Connection con = getConnection();
	            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS ADM FROM artista where Acesso = 'Admin'");
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()){
	                valores[0] = rs.getInt("ADM");
	            }   
	 
	            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Comum FROM artista where Acesso = 'Comum'");
	            rs = ps.executeQuery();
	            while(rs.next()){
	                valores[1] = rs.getInt("Comum");
	            }            
	            
	        }catch(Exception erro){
	            System.out.println(erro);
	        }
	        return valores;
	    }
	        

	        
	    
	    public static int excluirArtista(Artista artista){
	       int status = 0;  
	        try{
	             Connection con = getConnection();
	             PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM artista WHERE id=?");
	             ps.setInt(1, artista.getId());         
	             status = ps.executeUpdate();
	         }catch(Exception erro){
	             System.out.println(erro);
	         }      
	            return status;
	   }
	    
	    
	   public static int cadastrarArtista(Artista artista){
	       int status = 0;  
	   try{
	        Connection con = getConnection();
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO artista(NOME, NOME_ARTISTICO, EMAIL, SENHA, GENERO) VALUES(?,?,?,?,?)");
	        ps.setString(1, artista.getNome());
	        ps.setString(2, artista.getNome_artistico());
	        ps.setString(3, artista.getEmail());
	        ps.setString(4, artista.getSenha());   
	        ps.setString(5, artista.getGenero());
	        status = ps.executeUpdate();
	    }catch(Exception erro){
	        System.out.println(erro);
	    }      
	       return status;
	   }
	    
	}

		
		
