/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import classes.Obra_artistica; 

import static dao.Dao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Obra_ArtisticaDao {
  
	
	  public static Obra_artistica getObra_artisticaById(int id){
	       Obra_artistica obra = null;      
	    try{
	        Connection con = getConnection();
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from obra_artistica where id=?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	            obra = new Obra_artistica();
	            obra.setId(rs.getInt("id_obra_artistica"));
	            obra.setId_artista(rs.getInt("id_artista"));
	            obra.setTitulo(rs.getString("titulo"));
	            obra.setDescricao(rs.getString("descricao"));   
	            obra.setLocalizacao_da_imagem(rs.getString("localizacao_da_imagem"));   
	            
	        }
	    }catch(Exception erro){
	        System.out.println(erro);
	    }      
	        return obra;
	    }
	    
	    
	   public static int editarObra_artistica(Obra_artistica obra_artistica){
	       int status = 0;  
	   try{
	        Connection con = getConnection();
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE obra_artistica SET titulo=?, descricao=?, localizacao_da_imagem  WHERE id=?");
	        ps.setString(1, obra_artistica.getTitulo());
	        ps.setString(2, obra_artistica.getDescricao());
            ps.setString(3, obra_artistica.getLocalizacao_da_imagem());
            ps.setInt(4, obra_artistica.getId());
	        status = ps.executeUpdate();
	    }catch(Exception erro){
	        System.out.println(erro);
	    }      
	       return status;
	   }
	    
	    public static List<Obra_artistica> getObra_artistica(int inicio, int total) {
	    List<Obra_artistica> list = new ArrayList<>();
	    try{
	        Connection con = getConnection();
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM obra_artistica ORDER BY id LIMIT " + (inicio - 1) + " ," + total);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	            Obra_artistica obra = new Obra_artistica();
	            obra.setId(rs.getInt("id"));
	            obra.setTitulo(rs.getString("nome"));
	            obra.setDescricao(rs.getString("descricao"));   
	         
	            list.add(obra);
	        }       
	    }catch(Exception erro){
	        System.out.println(erro);
	    }
	    return list;
	    }

	    public static List<Obra_artistica> getRelatorio() {
	    List<Obra_artistica> list = new ArrayList<Obra_artistica>();
	    try{
	        Connection con = getConnection();
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM obra_artistica");
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	           Obra_artistica obra = new Obra_artistica();
	            obra.setId(rs.getInt("id_cliente"));
	            obra.setTitulo(rs.getString("titulo"));
	            list.add(obra);
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
	            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS contagem FROM obra_artistica");
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()){
	                contagem = rs.getInt("contagem");
	            }   
	        }catch(Exception erro){
	            System.out.println(erro);
	        }
	        return contagem;
	    }
	    
	    
	        public static int[] getRelatorioObra() {

	int[] valores = {10, 20, 30, 40};
	        
	        try{
	            Connection con = getConnection();
	            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) FROM cliente ");
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()){
	                valores[0] = rs.getInt("ADM");
	            }   
	 
	            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) FROM cliente where");
	            rs = ps.executeQuery();
	            while(rs.next()){
	                valores[1] = rs.getInt("Comum");
	            }            
	            
	        }catch(Exception erro){
	            System.out.println(erro);
	        }
	        return valores;
	    }
	        

	        
	    
	    public static int excluirCliente(Obra_artistica obra){
	       int status = 0;  
	        try{
	             Connection con = getConnection();
	             PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM obra_artistica WHERE id_obra_artistica=?");
	             ps.setInt(1, obra.getId());         
	             status = ps.executeUpdate();
	         }catch(Exception erro){
	             System.out.println(erro);
	         }      
	            return status;
	   }
	    
}
