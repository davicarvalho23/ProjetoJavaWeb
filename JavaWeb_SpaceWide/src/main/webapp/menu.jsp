<head>  
<meta charset="utf-8">
</head>
<body>
<ul>
            <%
      String adm = (String) request.getSession().getAttribute("acesso");
 
       if (adm.equals("admin")) {
          %>
<li class='dropdown'><a href='javascript:void(0)' class='dropbtn'>Usu�rios</a>
<div class='dropdown-content'><a href='#'>Relat�rio de Usu�rios</a><a href='#?pag=1'>Controlar Usu�rios</a><a href='usuariocadastrarform.jsp'>Cadastrar Usu�rio</a></div></li>
       
  <%
          
        }
   %>  
  
              

 <li class="dropdown" style="float:right">

     <a href="javascript:void(0)" class="dropbtn"><%=request.getSession().getAttribute("cliente")%></a>
    <div class="dropdown-content">
      <a href="#">Alterar Dados</a>
      <a href="#">Alterar Senha</a>
      <a href="deslogar.jsp">Deslogar</a>
    </div>
  </li>

</ul>

</body>
