<head>
<meta charset="utf-8">
</head>
<body>
<ul>
		
  <li><a href="principal.jsp">Principal</a></li>
  <li><a href="#">Artistas</a></li>
            
<li class='dropdown'><a href='javascript:void(0)' class='dropbtn'>Usuários</a>
<div class='dropdown-content'><a href='usuariosrelatorio.jsp'>Relatório de Usuários</a><a href='usuarioscontrolar.jsp?pag=1'>Controlar Usuários</a><a href='usuariocadastrarform.jsp'>Cadastrar Usuário</a></div></li>
            
   
  

 <li class="dropdown" style="float:right">
     <a href="javascript:void(0)" class="dropbtn">Usuário: <%=request.getSession().getAttribute("nome")%></a>
    <div class="dropdown-content">
      <a href="#">Alterar Dados</a>
      <a href="#">Alterar Senha</a>
      <a href="deslogar.jsp">Deslogar</a>
    </div>
  </li>

</ul>

</body>