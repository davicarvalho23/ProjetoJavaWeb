<%@ page import="dao.Dao, dao.ArtistaDao, classes.Artista, java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/editar.css" rel="stylesheet" type="text/css"/>
        <title>Editar Artista</title>
    </head>
    <body>
    
    	<%@include file="../acesso.jsp"%>
    
        <%
        String id = request.getParameter("id");
       Artista ar = ArtistaDao.getArtistaById(Integer.parseInt(id));
        
        %>
<div class='form-container'>
    <div class='form-header'>
        <p class='form-title'>Cadastro de artista</p>
        <p class='form-subtitle'><%=ar.getNome()%>, preencha o formulario para .</p>
    </div>

    <div class='profiler-form'>
        <form class='form' action='artistaeditar.jsp' method='post' enctype='multipart/form-data'>

            <div class='input-group'>

	         
                <div class='input-field'>
                    <label><i class='fas fa-user'></i></label>
                        <input type="hidden" name="id" value="<%=ar.getId()%>">
                    <input type='text' name='nome' value="<%=ar.getNome()%>">
                </div>
		  <div class='input-field'>
                    <label><i class='fas fa-user'></i></label>
                    <input type='text' name='nome_artistico' value="<%=ar.getNome_artistico()%>">
                </div>
				
				<div class='input-field'>
                    <label><i class='fas fa-user'></i></label>
                    <input type='text' name='nome_artistico' value="<%=ar.getEmail()%>">
                </div>
				
                <button type='submit' class='submit-btn' name='submit'>Editar</button>
            </div>

        </form>
    </div>
</div>
    </body>
</html>