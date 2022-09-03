    <%
       //Lê dados da sessão
       String acesso = (String) request.getSession().getAttribute("acesso");
 
       //Se não há sessão, usuário não logou, retorna para o login
        if (acesso.equalsIgnoreCase("admin")) {
            response.sendRedirect("index.jsp");
        }
    %>