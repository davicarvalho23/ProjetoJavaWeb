  <%
       //L� dados da sess�o 
       String acesso = (String) request.getSession().getAttribute("acesso");
       
       //Verifica se o acesso � de administrador
        if (!acesso.equals("admin")) {
            response.sendRedirect("index.jsp");
        }
    %>