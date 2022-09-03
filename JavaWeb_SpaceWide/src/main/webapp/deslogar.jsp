<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="servlet.Login, dao.Dao, dao.ClienteDao, dao.ArtistaDao,  java.util.*"%>


<%
          request.getSession().invalidate();
        response.sendRedirect("./index.jsp");
%>