package dao;

import classes.Cliente;
import static dao.Dao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class ClienteDao {
	  public static Cliente getClienteById(int id){
	        Cliente cliente = null;      
	    try{
	        Connection con = getConnection();
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from cliente where Id=?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	            cliente = new Cliente();
	            cliente.setId(rs.getInt("id"));
	            cliente.setNome(rs.getString("nome"));
	            cliente.setApelido(rs.getString("apelido"));
	            cliente.setEstado(rs.getString("estado"));
	            cliente.setEmail(rs.getString("email"));         
	            cliente.setSenha(rs.getString("senha"));   
	            
	        }
	    }catch(Exception erro){
	        System.out.println(erro);
	    }      
	        return cliente;
	    }
	    
	    
	   public static int editarcliente(Cliente cliente){
	       int status = 0;  
	   try{
	        Connection con = getConnection();
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE cliente SET nome=?, apelido=?, estado=?, email=?  WHERE id_cliente=?");
	        ps.setString(1, cliente.getNome());
	        ps.setString(2, cliente.getEmail());
	        ps.setInt(4, cliente.getId());         
	        status = ps.executeUpdate();
	    }catch(Exception erro){
	        System.out.println(erro);
	    }      
	       return status;
	   }
	    
	    public static List<Cliente> getclientes(int inicio, int total) {
	    List<Cliente> list = new ArrayList<Cliente>();
	    try{
	        Connection con = getConnection();
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM cliente ORDER BY id_cliente LIMIT " + (inicio - 1) + " ," + total);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	            Cliente cliente = new Cliente();
	            cliente.setId(rs.getInt("id"));
	            cliente.setNome(rs.getString("nome"));
	            cliente.setEmail(rs.getString("email"));         
	            cliente.setSenha(rs.getString("senha"));   
	         
	            list.add(cliente);
	        }       
	    }catch(Exception erro){
	        System.out.println(erro);
	    }
	    return list;
	    }

	    public static List<Cliente> getRelatorio() {
	    List<Cliente> list = new ArrayList<Cliente>();
	    try{
	        Connection con = getConnection();
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM cliente");
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	            Cliente cliente = new Cliente();
	            cliente.setId(rs.getInt("id"));
	            cliente.setNome(rs.getString("nome"));
	            cliente.setEmail(rs.getString("email"));           
	            list.add(cliente);
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
	            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS contagem FROM cliente");
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()){
	                contagem = rs.getInt("contagem");
	            }   
	        }catch(Exception erro){
	            System.out.println(erro);
	        }
	        return contagem;
	    }
	    
	    
	        public static int[] getRelatorioclientes() {

	int[] valores = {10, 20, 30, 40};
	        
	        try{
	            Connection con = getConnection();
	            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS ADM FROM cliente where Acesso = 'Admin'");
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()){
	                valores[0] = rs.getInt("ADM");
	            }   
	 
	            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Comum FROM cliente where Acesso = 'Comum'");
	            rs = ps.executeQuery();
	            while(rs.next()){
	                valores[1] = rs.getInt("Comum");
	            }            
	            
	        }catch(Exception erro){
	            System.out.println(erro);
	        }
	        return valores;
	    }
	        

	        
	    
	    public static int excluirCliente(Cliente cliente){
	       int status = 0;  
	        try{
	             Connection con = getConnection();
	             PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM cliente WHERE id=?");
	             ps.setInt(1, cliente.getId());         
	             status = ps.executeUpdate();
	         }catch(Exception erro){
	             System.out.println(erro);
	         }      
	            return status;
	   }
	    
	    
	   public static int cadastrarCliente(Cliente cliente){
	       int status = 0;  
	   try{
	        Connection con = getConnection();
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO CLIENTE(NOME,APELIDO,ESTADO,EMAIL,SENHA) VALUES(?,?,?,?)");
	        ps.setString(1, cliente.getNome());
	        ps.setString(2, cliente.getEmail());
	        ps.setString(3, cliente.getSenha());       
	        
	        status = ps.executeUpdate();
	    }catch(Exception erro){
	        System.out.println(erro);
	    }      
	       return status;
	   }
	    
	}

		
		

