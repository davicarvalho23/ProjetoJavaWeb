<%@page import="classes.Administrador"%>
<%@ page import="dao.Dao, dao.AdministradorDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="u" class="classes.Administrador"></jsp:useBean>
<jsp:setProperty property="*" name="u" />
    
<%
   
    String email = request.getParameter("email");
    String senha = request.getParameter("senha");
  
    //Envia os valores para o Dao e recebe o resultado da consulta
    
 	
 		
 	
   Administrador adm = AdministradorDao.logar(email, senha);
 
  
    //Verifica se algum usuário foi encontrado
    if(adm != null){
        //Cria sessão e redireciona para a tela principal
  	request.getSession().setAttribute("nome",adm.getNome());
      	 response.sendRedirect("./principal/principal.jsp");
        
    }else{
    	response.sendRedirect("index.jsp");  
    	request.setAttribute("msg","Informe o login e senha.");
    	}
 	
    
    
%>