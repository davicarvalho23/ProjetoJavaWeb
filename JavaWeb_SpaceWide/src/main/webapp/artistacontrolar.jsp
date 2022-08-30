<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.Dao, dao.ArtistaDao, classes.Artista, java.util.*"%>

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
		  	
	  
	        <title>Lista de Artistas</title>
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
        
            <h4>Lista de Artistas</h4>
            <table style="margin-bottom:10px;">
            <tr><th>Id</th><th>Nome</th><th>Nome artístico</th><th>Email</th><th>Senha</th><th colspan="">Estado</th><th colspan="">Data de Criação</th><th colspan="">Data de ultima modificação</th>
            <th colspan="2">Ações</th></tr>
                <c:forEach items="${list}" var="artista">
                <tr>
                    <td>${artista.getId()}</td>
                    <td>${artista.getNome()}</td>
                    <td>${artista.getNome_artistico()}</td>
                    <td>${artista.getEmail()}</td>            
                    <td>${artista.getSenha()}</td>    
                    <td>${artista.getEstado()}</td>
                    <td>${artista.getData_de_criacao()}</td>
                    <td>${artista.getData_da_ultima_modificacao()}
                    <td><a href="editar/Artistabloquear.jsp?id=${artista.getId()}&estado=${artista.getEstado()}"> <i class="material-icons middle">lock</i></a></td>
                    <td><a href="editar/Artistaexcluir.jsp?id=${artista.getId()}"><i class="material-icons middle">delete</i></a></td>            
                    
                </tr>	
                </c:forEach>
            </table>
                 
                     <ul class="pagination">
                    <% for(i=1; i <= contagem; i++) {%>
                    
                    
                      
                        <li class="active" style="background-color:#008ddd;"><a href="artistacontrolar.jsp?pag=<%=i%>"><%=i%></a></li>
   					
    				
                    <% } %>  
                     </ul> 
                 
                </div>   
            
          
          
    <div class="container footer">
    
        <%@include file="rodape.jsp"%>
    </div>
    </body>
</html>
