    <%
       //L� dados da sess�o
       String acesso = (String) request.getSession().getAttribute("acesso");
 
       //Se n�o h� sess�o, usu�rio n�o logou, retorna para o login
        if (acesso.equalsIgnoreCase("admin")) {
            response.sendRedirect("index.jsp");
        }
    %>