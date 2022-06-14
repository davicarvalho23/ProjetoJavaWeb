<%@ page import="dao.clienteDao"%>
<jsp:useBean id="u" class="classes.Cliente"></jsp:useBean>
<jsp:setProperty property="*" name="u" />
    
<%
    int i = clienteDao.cadastrarCliente(u);
    
    if(i>0){
        response.sendRedirect("usuarioscontrolar.jsp");
    }else{
        response.sendRedirect("usuariocadastrar-erro.jsp");        
    }
%>