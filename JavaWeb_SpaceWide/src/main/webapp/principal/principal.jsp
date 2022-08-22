<!DOCTYPE html>
<html lang="pt-br">
	
  <link rel="stylesheet" href="../css/main.css"/>
    <title>Space Wide</title>
  </head>
  <body>
  
      <%@include file="../acesso.jsp" %>
 	   
 	<div class="menu-bar">
 
      <h1 class="logo">Space<span>Wide</span></h1>
      <ul>
        <li><a href="#">Obra_art�stica<i class="fas fa-caret-down"></i></a>

            <div class="dropdown-menu">
                <ul>
                  <li><a href="#">Gerenciar Obras</a></li>
                  <li><a href="#">Relat�rio das Obras</a></li>
                </ul>
              </div>
         <li><a href="#">Cliente<i class="fas fa-caret-down"></i></a>

            <div class="dropdown-menu">
                <ul>
                  <li><a href="#">Gerenciar Clientes</a></li>
                  <li><a href="#">Relat�rio de Clientes</a></li>
                </ul>
              </div>
              <li><a href="#">Artista<i class="fas fa-caret-down"></i></a>

            <div class="dropdown-menu">
                <ul>
                  <li><a href="../artistacontrolar.jsp?pag=1">Gerenciar Artistas</a></li>
                  <li><a href="#">Relat�rio de Artistas</a></li>
                </ul>
              </div>
           <li><a href="#"><%=request.getSession().getAttribute("nome")%> <i class="fas fa-caret-down"></i></a>

            <div class="dropdown-menu">
                <ul>
                    <li><a href="../deslogar.jsp">Sair</a></li>
            
                </ul>
              </div>
      </ul>
    </div>
  </body>

</html>