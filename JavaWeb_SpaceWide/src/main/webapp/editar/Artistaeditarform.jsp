<%@ page import="dao.Dao, dao.ArtistaDao, classes.Artista, java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://thymeleaf.org"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="../materialize/css/materialize.min.css" media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Editar Artista</title>
</head>
<body>

	<%
	//Lê dados da sessão
	String acesso = (String) request.getSession().getAttribute("acesso");

	//Se não há sessão, usuário não logou, retorna pcla o login
	if (acesso == null) {
		response.sendRedirect("../index.jsp");
	}
	%>


	<%
	String id = request.getParameter("id");
	Artista ar = ArtistaDao.getArtistaById(Integer.parseInt(id));
	%>

	<div class="row">
		<form class="col s12">
			<div class="row">
				<div class="input-field col s6">
					<input id="" type="text" value="<%=ar.getNome()%>"
						class="validate">
				</div>
				<div class="input-field col s6">
					<input id="last_name" type="text" class="validate" value="<%=ar.getNome_artistico()%>"> 
				</div>
			</div>
			
			<div class="row">
				<div class="input-field col s12">
					<input id="email" type="email" class="validate"  value="<%=ar.getEmail()%>"> 
				</div>
			</div>
		
			</div>
			<div class="row">
				<div class="input-field col s12">
					<input id="password" type="password" class="validate"  value="<%=ar.getSenha()%>">
				</div>
			</div>
		</form>
	</div>
</body>
</html>