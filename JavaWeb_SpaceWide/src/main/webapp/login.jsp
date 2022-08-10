<%@page import="classes.Artista, classes.Cliente"%>
<%@ page import="dao.Dao, dao.ArtistaDao, dao.ClienteDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="c" class="classes.Artista"></jsp:useBean>
<jsp:setProperty property="*" name="c" />
    
<%
    //Lê valores do formulário
    String email = request.getParameter("email");
    String senha = request.getParameter("senha");
    
    //Envia os valores para o Dao e recebe o resultado da consulta
    
  
    Artista ar = ArtistaDao.logar(email, senha);
    Cliente cl = ClienteDao.logar(email, senha);
 
    
    //Verifica se algum usuário foi encontrado
    if(cl != null || ar !=null){
        //Cria sessão e redireciona para a tela principal
        request.getSession().setAttribute("nome", ar.getNome());
        request.getSession().setAttribute("acesso", ar.getAcesso());    
        response.sendRedirect("index.jsp");
        
        //Redireciona erros para a tela de login
    }else{
        response.sendRedirect("login.jsp");
    }
%>