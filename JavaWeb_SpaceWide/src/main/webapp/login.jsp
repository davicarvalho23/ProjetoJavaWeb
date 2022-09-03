<%@page import="classes.Artista, classes.Cliente"%>
<%@page import="dao.Dao, dao.ClienteDao, dao.ArtistaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="u" class="classes.Artista"></jsp:useBean>
<jsp:useBean id="j" class="classes.Cliente"></jsp:useBean>
<jsp:setProperty property="*" name="u" />

<%
   
    String email = request.getParameter("email");
    String senha = request.getParameter("senha");
  
    //Envia os valores para o Dao e recebe o resultado da consulta
    
    Cliente cl = ClienteDao.logar(email, senha);
    Artista ar = ArtistaDao.logar(email, senha);
 
  
    //Verifica se algum usuário foi encontrado
    if(ar != null || cl != null){
    	if(ar != null){

    	 request.getSession().setAttribute("nome", ar.getNome());
      	 response.sendRedirect("./principal/principal.jsp");
    	}else{
    		 request.getSession().setAttribute("nome", cl.getNome());
          	 response.sendRedirect("./principal/principal.jsp");
    	}
    }else{
    	response.sendRedirect("index.jsp");  
    	request.setAttribute("msg","Informe o login e senha.");
    	}
 	
    
    
%>