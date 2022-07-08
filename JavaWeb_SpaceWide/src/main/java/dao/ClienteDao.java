package dao;

import classes.Cliente;
import static dao.Dao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
	            cliente.setEmail(rs.getString("email"));         
	            cliente.setSenha(rs.getString("senha"));   
	            cliente.setEstado(rs.getString("estado"));
                 //   cliente.setData_de_criacao(current_timestamp());
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
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE cliente SET nome=?, email=?  WHERE id_cliente=?");
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

            
            
            	    
          public static Cliente logar(String email, String senha){ 
                Cliente ar = new Cliente();    
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from cliente where email=?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        //Verifica se a consulta retornou resultado
        if (rs.next()) {       
                if(rs.getString("estado").equals("ativo")){
                    if(rs.getString("senha").equals(senha)){
                        ar.setId(rs.getInt("id"));
                       ar.setNome(rs.getString("nome"));
                        ar.setEmail(rs.getString("email"));         
                        ar.setSenha(rs.getString("senha"));   
                       ar.setAcesso(rs.getString("acesso"));     
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
       JOptionPane.showMessageDialog(null, "Deu Erro, tente novamente.");
    }      
        return ar;
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
	            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS admin FROM cliente where Acesso = 'admin'");
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()){
	                valores[0] = rs.getInt("admin");
	            }   
	 
	            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS comum FROM cliente where Acesso = 'comum'");
	            rs = ps.executeQuery();
	            while(rs.next()){
	                valores[1] = rs.getInt("comum");
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
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO CLIENTE(NOME,EMAI, SENHA, ESTADO) VALUES(?,?,?,?)");
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

		
		

