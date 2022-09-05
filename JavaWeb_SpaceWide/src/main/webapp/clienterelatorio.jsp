<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="dao.Dao, dao.ClienteDao, classes.Cliente, java.util.*"%>
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
<link type="text/css" rel="stylesheet" href="./css/grafico.css">
<script src="./scripts/filtrar.js"></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>
	<%@include file="menu.jsp"%>
	<%@include file="acesso.jsp"%>

	<div class="content">
		<%
		List<Cliente> list = ClienteDao.getRelatorio();
		request.setAttribute("list", list);

		int[] valores = ClienteDao.getRelatorioClientes();
		request.setAttribute("valores", valores);
		%>

		<h1>Relatório de Usuários</h1>

		<input type="text" id="filtrarnomes"
			onkeyup="filtrar('filtrarnomes', 1)" placeholder="Busca de nomes">
		<input type="text" id="filtraremails"
			onkeyup="filtrar('filtraremails', 2)" placeholder="Busca de emails">

		<table>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Acesso</th>
			</tr>
			<c:forEach items="${list}" var="cliente">
				<tr>
					<td>${cliente.getId()}</td>
					<td>${cliente.getNome()}</td>
					<td>${cliente.getEmail()}</td>
					<td>${cliente.getAcesso()}</td>

				</tr>
			</c:forEach>
		</table>

		<div class="grafico">
			<canvas id="myChart"></canvas>
			<p>Distribuição de Usuários:</p>
			<p>
				Ativo:
				<%=valores[0]%></p>
			<p>
				Inativo:
				<%=valores[1]%></p>
			<p>
				Suspenso:
				<%=valores[2]%></p>
			<p>
				Banido:
				<%=valores[3]%></p>
		</div>

		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js
            "></script>

		<script type="text/javascript">
			var ctx = document.getElementById("myChart");
			var valores = [
		<%=valores[0]%>
			,
		<%=valores[1]%>
			,
		<%=valores[2]%>
			,
		<%=valores[3]%>
			];
			var tipos = [ "ativo", "inativo", "suspenso", "banido" ];
			var myChart = new Chart(ctx, {
				type : "pie",
				data : {
					labels : tipos,
					datasets : [ {
						label : "Clientes",
						data : valores,
						backgroundColor : [ "rgba(45, 102, 180, 0.2)",
								"rgba(188, 46, 31, 0.2)",
								"rgba(255, 206, 86, 0.2)",
								"rgba(75, 192, 192, 0.2)",
								"rgba(153, 102, 255, 0.2)", ]
					} ]
				}
			});
		</script>
	</div>

	<div class="footer">
		<%@include file="rodape.jsp"%>
	</div>
</body>
</html>
