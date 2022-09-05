<%@ page import="dao.Dao, dao.Obra_ArtisticaDao"%>
<jsp:useBean id="u" class="classes.Obra_artistica"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%@include file="../acesso.jsp" %>
	<%	
		int i =	Obra_ArtisticaDao.excluirObra(u);
		
		if(i > 0) {
			response.sendRedirect("../obrartisticacontrolar.jsp?pag=1");
			
		}else{
			response.sendRedirect("../obrartisticacontrolar-erro.jsp?");
		}
	%>