<%@ page import="dao.Dao, dao.AdministradorDao"%>
<jsp:useBean id="u" class="classes.Administrador"></jsp:useBean>
<jsp:setProperty property="*" name="u" />



<%
    int i = AdministradorDao.editarAdm(u);

    if(i>0){
        response.sendRedirect("admcontrolar.jsp?pag=1");
    }else{
        response.sendRedirect("admexcluir-erro.jsp");        
    }

%>
