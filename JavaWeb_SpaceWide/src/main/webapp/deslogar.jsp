<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="servlet.Login, dao.Dao, dao.AdministradorDao, java.util.*"%>


<%
          request.getSession().invalidate();
        response.sendRedirect("./index.jsp");
%>