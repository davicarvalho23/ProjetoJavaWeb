<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="servlet.Login, dao.Dao, dao.ArtistaDao, classes.Artista, java.util.*"%>
<%@ page import="servlet.Login, dao.Dao, dao.ClienteDao, classes.Cliente, java.util.*"%>
<%
          request.getSession().invalidate();
        response.sendRedirect("index.jsp");
%>