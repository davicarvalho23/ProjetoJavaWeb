<%@page import="dao.AdministradorDao"%>
<%@page import="classes.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/editar.css">
    </head>
    <%@include file="../acesso.jsp"%>
 
    <%
		    String id = request.getParameter("id");
		  Administrador adm = AdministradorDao.getAdministradorById(Integer.parseInt(id));
    %>
    <body>
<div class='form-container'>
    <div class='form-header'>
        <p class='form-title'>Editar Administrador</p>
        <p class='form-subtitle'><% request.getSession().getAttribute("nome");%>, preencha o formulario para .</p>
    </div>

    <div class='profiler-form'>
        <form class='form' action='admeditar.jsp' method='post' enctype='multipart/form-data'>
                <h3>Editar Administrador, Id: <%=adm.getId()%></h3>
            <div class='input-group'>

                <div class='input-field'>
                    <input type="text" name="nome" value="<%=adm.getNome()%>" placeholder="Nome" required>		
                </div>

                <div class='input-field'>
                        <input type="text" name="nome" value="<%=adm.getEmail()%>" placeholder="Email" required>		
                </div>

                <div class='input-field'>
                          <input type="text" name="nome" value="<%=adm.getSenha()%>" placeholder="Senha" required>		
                </div>  

               
            </div>

        </form>
    </div>
</div>

</body>
</html>
