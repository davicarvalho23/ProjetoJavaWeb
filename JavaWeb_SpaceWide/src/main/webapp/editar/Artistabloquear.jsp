<%@ page import="dao.Dao, dao.ArtistaDao"%>
<jsp:useBean id="u" class="classes.Artista"></jsp:useBean>
<jsp:setProperty property="*" name="u" />

<%@include file="../acesso.jsp"%>

<%
    int i = ArtistaDao.bloquearArtista(u);
    
    if(i>0){
        response.sendRedirect("../artistacontrolar.jsp?pag=1");
        request.setAttribute("msg", "Artista Alterado com sucesso!");
    }else{
        response.sendRedirect("artistabloquear-erro.jsp");        
    }
%>