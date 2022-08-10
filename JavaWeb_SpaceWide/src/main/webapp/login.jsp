<%@page import="classes.Artista"%>
<%@ page import="dao.Dao, dao.ArtistaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="c" class="classes.Artista"></jsp:useBean>
<jsp:setProperty property="*" name="c" />
    
<%
    //Lê valores do formulário
    String email = request.getParameter("email");
    String senha = request.getParameter("senha");
    
    //Envia os valores para o Dao e recebe o resultado da consulta
    Artista ar = ArtistaDao.logar(email, senha);
    
    //Verifica se algum usuário foi encontrado
    if(ar !=null){
        //Cria sessão e redireciona para a tela principal
        request.getSession().setAttribute("usuario", ar.getNome());
        request.getSession().setAttribute("acesso", ar.getAcesso());    
        response.sendRedirect("index.jsp");
        
        //Redireciona erros para a tela de login
    }else{
        response.sendRedirect("login.jsp");
    }
%>