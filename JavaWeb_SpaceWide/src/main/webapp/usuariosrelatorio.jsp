<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.Dao, dao.usuariosDao, classes.Usuario, java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/tabela.css">
        <link href="css/grafico.css" rel="stylesheet" type="text/css"/>

        <title>Relatório de Usuários</title>
    </head>
    <body>
            <div class="topnav">
                <%@include file="menu.jsp"%>
            </div>
            <div class="content">        
            <%
                
                List<Usuario> list = usuariosDao.getRelatorio();
                request.setAttribute("list", list);
               
                int[] valores = usuariosDao.getRelatorioUsuarios();
                request.setAttribute("valores", valores);
                

            %>
        
            <h1>Relatório de Usuários</h1>
            <table>
            <tr><th>Id</th><th>Nome</th><th>Email</th><th>Acesso</th></tr>
                <c:forEach items="${list}" var="usuarios">
                <tr>
                    <td>${usuarios.getId()}</td>
                    <td>${usuarios.getNome()}</td>
                    <td>${usuarios.getEmail()}</td>               
                    <td>${usuarios.getAcesso()}</td> 
          
                </tr>
                </c:forEach>
            </table>
 
            <div class="grafico">
                <canvas id="myChart"></canvas>
                <p>Distribuição de Usuários:</p>
                <p>Administrador: <%=valores[0]%></p>
                <p>Cliente: <%=valores[1]%></p>
            </div>

            <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js
            "></script>

    <script type="text/javascript">
        var ctx = document.getElementById("myChart");
        var valores = [<%=valores[0]%>, <%=valores[1]%>];
        var tipos = ["ADM", "Cliente"];

        var myChart = new Chart(ctx, {
          type: "pie",
          data: {
            labels: tipos,
            datasets: [
              {
                label: "Usuarios",
                data: valores,
                backgroundColor: [
                  "rgba(255, 99, 132, 0.2)",
                  "rgba(54, 162, 235, 0.2)",
                  "rgba(255, 206, 86, 0.2)",
                  "rgba(75, 192, 192, 0.2)",
                  "rgba(153, 102, 255, 0.2)",
                ]
              }
            ]
          }
        }); 
    </script>           
    </div>

    <div class="footer">
        <%@include file="rodape.jsp"%>
    </div>
    </body>
</html>

