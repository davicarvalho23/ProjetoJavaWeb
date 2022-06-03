<%@ page import="dao.usuariosDao"%>
<jsp:useBean id="u" class="classes.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u" />
    
<%
    int i = usuariosDao.editarUsuario(u);
    response.sendRedirect("usuarioscontrolar.jsp?pag=1");
%>
