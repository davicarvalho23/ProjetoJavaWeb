<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.Dao, dao.ClienteDao, classes.Cliente, java.util.*"%>

<!DOCTYPE html>
<html xmlns:th="http://thymeleaf.org"
	  xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
	    <head>
	        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	       <!--  <link rel="stylesheet" href="/css/tabela.css"> -->
	        <link href="css/grafico.css" rel="stylesheet" type="text/css"/>
	        <link href="css/main.css" rel="stylesheet" type="text/css"/>
	        <link href="css/padrao.css" rel="stylesheet" type="text/css"/>
		    <meta charset="UTF-8"/>
		    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
		  	<!--Import Google Icon Font-->
		      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		      <!--Import materialize.css-->
		      <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>
		  	
	  
	        <title>Lista de Clientes</title>
    </head>
    <body>    
    <%@include file="acesso.jsp"%> 
    <%@include file="menu.jsp"%>
 
            <div class="container">        
            <%
                String pag = request.getParameter("pag");
                int id = Integer.parseInt(pag);
                
                //Quantidade de Registros da Página
                int total = 3;
                
                if(id!=1){
                    id = id -1;
                    id = id * total + 1;
                }
                
                List<Cliente> list = ClienteDao.getClientes(id,total);
                request.setAttribute("list", list);
                
                int contagem = ClienteDao.getContagem();
                int i;
                request.setAttribute("contagem", contagem);
                if(contagem%total==0){
                    contagem=contagem/total;
                }else{
                    contagem=contagem/total + 1;    
                }

            %>
        
            <h4>Lista de Clientes</h4>
            <table style="margin-bottom:10px;">
            <tr><th>Id</th><th>Nome</th><th>Email</th><th>Senha</th><th colspan="">Estado</th><th colspan="">Data de Criaçao</th><th colspan="">Data de última modificação</th>
            <th colspan="2">Ações</th></tr>
                <c:forEach items="${list}" var="cliente">
                <tr>
                    <td>${cliente.getId()}</td>
                    <td>${cliente.getNome()}</td>
                    <td>${cliente.getEmail()}</td>            
                    <td>${cliente.getSenha()}</td>    
                    <td>${cliente.getEstado()}</td>
                    <td style="marggin-right: 2rem;">${cliente.getData_de_criacao()}</td>
                    <td>${cliente.getData_da_ultima_modificacao()}</td>
                    <td><a href="editar/Clientebloquear.jsp?id=${cliente.getId()}&estado=${cliente.getEstado()}"> <i class="material-icons right">lock</i></a></td>
                    <td><a href="editar/Clientexcluir.jsp?id=${cliente.getId()}" ><i class=" material-icons right" onclick="confirmarExcluir()">delete</i></a></td>
                </tr>	
                </c:forEach>
            </table>
                 
                     <ul class="pagination">
                    <% for(i=1; i <= contagem; i++) {%>
                    
                    
                      
                        <li class="active" style="background-color:#008ddd;"><a href="clientescontrolar.jsp?pag=<%=i%>"><%=i%></a></li>
   					
    				
                    <% } %>  
                     </ul> 
                 
                </div>   
            
          
          
    <div class="container footer">
    
        <%@include file="rodape.jsp"%>
    </div>
	  
	    
    </body>
     <script>
			function confirmarExcluir() {
	 		confirm("Deseja apagar?");
				}
			</script>
   
</html>
