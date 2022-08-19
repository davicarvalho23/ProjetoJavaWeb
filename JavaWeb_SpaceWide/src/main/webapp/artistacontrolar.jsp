<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.Dao, dao.ArtistaDao, classes.Artista, java.util.*"%>

<!DOCTYPE html>
<html      xmlns:th="http://thymeleaf.org"
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
		  	
	  
	        <title>Lista de Usuários</title>
    </head>
    <body>    
    <%@include file="acesso.jsp"%> 
    <%@include file="menu.jsp"%>
 
            <div class="container">        
            <%
                String pag = request.getParameter("pag");
                int id = Integer.parseInt(pag);
                
                //Quantidade de Registros da Página
                int total = 5;
                
                if(id!=1){
                    id = id -1;
                    id = id * total + 1;
                }
                
                List<Artista> list = ArtistaDao.getArtista(id,total);
                request.setAttribute("list", list);
                
                int contagem = ArtistaDao.getContagem();
                int i;
                request.setAttribute("contagem", contagem);
                if(contagem%total==0){
                    contagem=contagem/total;
                }else{
                    contagem=contagem/total + 1;    
                }

            %>
        
            <h3>Lista de Usuários</h3>
            <table>
            <tr><th>Id</th><th>Nome</th><th>Nome artístico</th><th>Email</th><th>Senha</th><th colspan="2">Estado</th><th colspan="3">Ações</th></tr>
                <c:forEach items="${list}" var="artista">
                <tr>
                    <td>${artista.getId()}</td>
                    <td>${artista.getNome()}</td>
                    <td>${artista.getNome_artistico()}</td>
                    <td>${artista.getEmail()}</td>            
                    <td>${artista.getSenha()}</td>    
                    <td>${artista.getEstado()}</td>
                    
                    
                    
                    
                    <td><a href="Artistabloquear.jsp?id=${artista.getId()}&status=${artista.getEstado()}"> <i class="material-icons right">lock</i></a></td>
                    <td><a href="Artistaexcluir.jsp?id=${artista.getId()}"> <i class=" material-icons left">delete</i></a></td>            
                    <td><a href="Artistaeditarform.jsp?id=${artista.getId()}"><i class="material-icons left">model_edit</i></a></td>
                </tr>	
                </c:forEach>
            </table>
                <div class="pagination">
                    <% for(i=1; i <= contagem; i++) {%>
                      <ul class="pagination">
                      
                        <li class="disabled"><a href="artistacontrolar.jsp?pag=<%=i%>"><i class="material-icons">chevron_left</i></a></li>
                        <li class="active" style="background-color:#008ddd;"><a href="artistacontrolar.jsp?pag=<%=i%>"><%=i%></a></li>
   					 </ul>
    				<!-- <a href="artistacontrolar.jsp?pag=<%=i%>"><%=i%></a> -->
                    <% } %>   
                </div>   
            <a href="artistacadastrarform.jsp"><i class="material-icons">add_box</i></a>
          
    </div>

    <div class="container footer">
        <%@include file="rodape.jsp"%>
    </div>
    </body>
</html>
