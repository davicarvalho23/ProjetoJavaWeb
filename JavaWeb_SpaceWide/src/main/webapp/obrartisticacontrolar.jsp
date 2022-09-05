<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.Dao, dao.Obra_ArtisticaDao, classes.Obra_artistica, java.util.*"%>

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
		  	
	  
	        <title>Lista de Obras</title>
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
                
                List<Obra_artistica> list = Obra_ArtisticaDao.getObra_artistica(id,total);
                request.setAttribute("list", list);
                
                int contagem = Obra_ArtisticaDao.getContagem();
                int i;
                request.setAttribute("contagem", contagem);
                if(contagem%total==0){
                    contagem=contagem/total;
                }else{
                    contagem=contagem/total + 1;    
                }

            %>
        
            <h4>Lista de Obra Artisticas</h4>
             <div class="divider"></div>
            <div class="section">
            <table class="responsive-table">
            <tr><th>Id</th><th>Título</th><th>Subtitulo</th><th>Localização da Imagem</th><th colspan="">Estado da Obra</th><th colspan="">Data de Criaçao</th><th colspan="">Data de última modificação</th>
            <th colspan="2">Ações</th></tr>
                <c:forEach items="${list}" var="obra">
                <tr>
                    <td>${obra.getId()}</td>
                    <td>${obra.getTitulo()}</td>
                    <td>${obra.getSubtitulo()}</td>            
                    <td>${obra.getLocalizacao_da_imagem()}</td> 
                    <td>${obra.getEstado()}</td>
                    <td style="marggin-right: 2rem;">${obra.getData_de_criacao()}</td>
                    <td>${obra.getData_da_ultima_modificacao()}</td>
                    <td><a href="editar/Obrabloquear.jsp?id=${obra.getId()}&estado=${obra.getEstado()}"> <i class="material-icons right">lock</i></a></td>
                    <td><a href="editar/Obraexcluir.jsp?id=${obra.getId()}" ><i class=" material-icons right" onclick="return confirm('Deseja deletar?');">delete</i></a></td>
                </tr>	
                </c:forEach>
            </table>
                </div> 
                     <ul class="pagination">
                    <% for(i=1; i <= contagem; i++) {%>
                    
                    
                      
                        <li class="active" style="background-color:#008ddd;"><a href="obrartisticacontrolar.jsp?pag=<%=i%>"><%=i%></a></li>
   					
    				
                    <% } %>  
                     </ul> 
                 
                </div>   
            
          
          
    <div class="container footer">
    
        <%@include file="rodape.jsp"%>
    </div>
	  
	    	<script type="text/javascript" src="js/materialize.min.js"></script>
    </body>
</html>
