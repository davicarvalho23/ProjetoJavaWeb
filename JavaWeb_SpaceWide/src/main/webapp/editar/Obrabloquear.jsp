<%@ page import="dao.Dao, dao.Obra_ArtisticaDao"%>
<jsp:useBean id="u" class="classes.Obra_artistica"></jsp:useBean>
<jsp:setProperty property="*" name="u" />

    <%
       //L� dados da sess�o
      	String acesso = (String) request.getSession().getAttribute("acesso");
 
       //Se n�o h� sess�o, usu�rio n�o logou, retorna para o login
        if (acesso == null) {
            response.sendRedirect("../index.jsp");
        }
    %>

<%
    int i = Obra_ArtisticaDao.bloquearObra(u);
    
    if(i>0){
        response.sendRedirect("obrartisticacontrolar.jsp?pag=1");
       
    }else{
        response.sendRedirect("obrabloquear-erro.jsp");        
    }
%>