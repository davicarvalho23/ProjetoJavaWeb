<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.Dao, dao.ArtistaDao, classes.Artista, java.util.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/tabela.css">
        <link href="css/grafico.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="css/padrao.css" rel="stylesheet" type="text/css"/>
        <title>Lista de Usu�rios</title>
    </head>
    <body>      
            <div class="topnav">
                <%@include file="menu.jsp"%>
            </div>
            <div class="content">        
            <%
                String pag = request.getParameter("pag");
                int id = Integer.parseInt(pag);
                
                //Quantidade de Registros da P�gina
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
        
            <h1>Lista de Usu�rios</h1>
            <table>
            <tr><th>Id</th><th>Nome</th><th>Nome_artistico</th><th>Email</th><th>Senha</th><th>Acesso</th><th>Status</th><th colspan="3">A��es</td></tr>
                <c:forEach items="${list}" var="artista">
                <tr>
                    <td>${artista.getId()}</td>
                    <td>${artista.getNome()}</td>
                    <td>${artista.getNome_artistico()}</td>
                    <td>${artista.getEmail()}</td>            
                    <td>${artista.getSenha()}</td>    
                    <td>${artista.getAcesso()}</td> 
                    <td>${artista.getEstado()}</td>
                    <td><a href="Artistaeditarform.jsp?id=${artista.getId()}"><img src="/imagens/editar.png" alt="Editar Usu�rio"></a></td>
                    <td><a href="Artistabloquear.jsp?id=${artista.getId()}&status=${artista.getEstado()}"><img src="/imagens/bloquear.png" alt="Bloquear Usu�rio"></a></td>
                    <td><a href="Artistaexcluir.jsp?id=${artista.getId()}"><img src="/imagens/excluir.png" alt="Excluir Usu�rio"></a></td>            
                </tr>
                </c:forEach>
            </table>
                <div class="pagination">
                    <% for(i=1; i <= contagem; i++) {%>
                            <a href="artistacontrolar.jsp?pag=<%=i%>"><%=i%></a>
                    <% } %>   
                </div>   
            <a href="artistacadastrarform.html"><img src="/imagens/incluir.png" alt="Incluir Usu�rio"></a>
          
    </div>

    <div class="footer">
        <%@include file="rodape.jsp"%>
    </div>
    </body>
</html>
