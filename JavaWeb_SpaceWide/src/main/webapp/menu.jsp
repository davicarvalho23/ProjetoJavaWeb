<head>
<meta charset="utf-8">
</head>
<body>
 <div class="menu-bar">
 
      <h1 class="logo">Space<span>Wide</span></h1>
      <ul>
        <li><a href="#">Obra_artística<i class="fas fa-caret-down"></i></a>

            <div class="dropdown-menu">
                <ul>
                  <li><a href="obrartisticacontrolar.jsp?pag=1">Gerenciar Obras</a></li>
                  <li><a href="relatoriobra.jsp">Relatório das Obras</a></li>
                </ul>
              </div>
         <li><a href="#">Cliente<i class="fas fa-caret-down"></i></a>

            <div class="dropdown-menu">
                <ul>
                  <li><a href="clientescontrolar.jsp?pag=1">Gerenciar Clientes</a></li>
                  <li><a href="clienterelatorio.jsp">Relatório de Clientes</a></li>
                </ul>
              </div>
              <li><a href="#">Artista<i class="fas fa-caret-down"></i></a>

            <div class="dropdown-menu">
                <ul>
                  <li><a href="artistacontrolar.jsp?pag=1">Gerenciar Artistas</a></li>
                  <li><a href="#">Relatório de Artistas</a></li>
                </ul>
              </div>
           <li><a href="#"><%=request.getSession().getAttribute("nome")%> <i class="fas fa-caret-down"></i></a>

            <div class="dropdown-menu">
                <ul>
                    <li><a href="deslogar.jsp">Sair</a></li>
            
                </ul>
              </div>
      </ul>
    </div>
</body>