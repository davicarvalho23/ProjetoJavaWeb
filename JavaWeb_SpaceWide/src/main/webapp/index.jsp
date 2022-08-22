
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
   
    <title>Login</title>
    <link rel="shortcut icon" type="image/x-icon" href="favicon.svg"/>   
    <link rel="stylesheet" href="./css/login.css">
</head>
<body>
    <div class="main">
        <div class="navbar">
            <div class="icon">
            </div>
            <div class="menu">
            </div>
        </div> 
        <div class="content">
            <h1><br><span>Artes digitais & Fotografias</span><br>Com alta qualidade</h1>
            <p class="par">O SpaceWide é uma plataforma de compartilhamento e venda de Imagens digitais<br>
            com alta qualidade , já contamos na nossa comunidade<br>
            uma grande quantidade de artistas com diversos tipos de artes digitais </p>


             <div class="form">
             
                 <form action="login.jsp" method="post"> 
                    <h2>Space<span>Wide</span></h2>
                    <input type="email" name="email" placeholder="Email...">
                    <input type="password" name="senha" placeholder="Senha...">
                    <input type="submit" value="Entrar" >
                  	<p>${msg}</p>
                    </form>
                 
              
                    <p class="link">Acesso para administrador.</p>  
             </div>
        </div>
    </div>
</body>
</html>
