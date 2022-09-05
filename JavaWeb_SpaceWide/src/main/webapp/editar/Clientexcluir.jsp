<%@ page import="dao.Dao, dao.ClienteDao"%>
<jsp:useBean id="u" class="classes.Cliente"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%@include file="../acesso.jsp" %>
	<%	
		int i = ClienteDao.excluirCliente(u);
		
		if(i > 0) {
			response.sendRedirect("../clientescontrolar.jsp?pag=1");
			
		}else{
			response.sendRedirect("../clientescontrolar.jsp?pag=1");
		}
	%>