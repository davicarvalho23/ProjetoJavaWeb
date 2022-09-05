<%@ page import="dao.Dao, dao.Obra_ArtisticaDao"%>
<jsp:useBean id="u" class="classes.Obra_artistica"></jsp:useBean>
<jsp:setProperty property="*" name="u" />

    <%
       //Lê dados da sessão
      	String acesso = (String) request.getSession().getAttribute("acesso");
 
       //Se não há sessão, usuário não logou, retorna para o login
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