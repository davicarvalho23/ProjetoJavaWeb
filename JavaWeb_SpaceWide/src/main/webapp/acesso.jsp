    <%
       //Lê dados da sessão
       String usuario = (String) request.getSession().getAttribute("nome");
 
       //Se não há sessão, usuário não logou, retorna para o login
        if (usuario == null) {
            response.sendRedirect("index.jsp");
        }
    %>