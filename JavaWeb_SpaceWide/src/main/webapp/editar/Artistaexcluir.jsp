<%@ page import="dao.Dao, dao.ArtistaDao"%>
<jsp:useBean id="u" class="classes.Artista"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%@include file="../acesso.jsp" %>
	<%	
		int i = ArtistaDao.excluirArtista(u);
		
		if(i > 0) {
			response.sendRedirect("../artistacontrolar.jsp?pag=1");
			
		}else{
			response.sendRedirect("../usuariobloquear-erro.jsp");
		}
	%>