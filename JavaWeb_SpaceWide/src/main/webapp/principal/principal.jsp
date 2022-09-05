<!DOCTYPE html>
<html lang="pt-br">
	
  <link rel="stylesheet" href="../css/main.css"/>
    <title>Space Wide</title>
  </head>
  <body>
  
   <%
	//L� dados da sess�o
	String acesso = (String) request.getSession().getAttribute("acesso");

	//Se n�o h� sess�o, usu�rio n�o logou, retorna pcla o login
	if (acesso == null) {
		response.sendRedirect("../index.jsp");
	}
	%>
	
 	<div class="menu-bar">
 
      <h1 class="logo">Space<span>Wide</span></h1>
      <ul>
        <li><a href="#">Obra_art�stica<i class="fas fa-caret-down"></i></a>

            <div class="dropdown-menu">
                <ul>
                  <li><a href="../obrartisticacontrolar.jsp?pag=1">Gerenciar Obras</a></li>
                  <li><a href="#">Relat�rio das Obras</a></li>
                </ul>
              </div>
         <li><a href="#">Cliente<i class="fas fa-caret-down"></i></a>

            <div class="dropdown-menu">
                <ul>
                  <li><a href="../clientescontrolar.jsp?pag=1">Gerenciar Clientes</a></li>
                  <li><a href="../clienterelatorio.jsp">Relat�rio de Clientes</a></li>
                </ul>
              </div>
              <li><a href="#">Artista<i class="fas fa-caret-down"></i></a>

            <div class="dropdown-menu">
                <ul>
                  <li><a href="../artistacontrolar.jsp?pag=1">Gerenciar Artistas</a></li>
                  <li><a href="#">Relat�rio de Artistas</a></li>
                </ul>
              </div>
           <li><a><%=request.getSession().getAttribute("nome")%> <i class="fas fa-caret-down"></i></a>

            <div class="dropdown-menu">
                <ul>
                	
                    <li><a href="../deslogar.jsp">Sair</a></li>
            
                </ul>
              </div>
      </ul>
    </div>
  </body>

</html>
