<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/justifiedGallery/3.7.0/css/justifiedGallery.min.css" integrity="sha256-ZKOGvp7YVwX26g2d0ooDvbSBQSEiIi4Bd9FuK+12Zk0=" crossorigin="anonymous" />
  <link rel="stylesheet" href="./css/main.css">
  <title>Space Wide </title>
 
</head>
<body>
    
  <header>
      
    <nav class="navbar">
        
      <div class="left">
        <div class="logo">
          <a href="index.jsp">
            <h1 class="logo">Space<span>Wide</span></h1>
          </a>
        </div>
        <div class="nav-search-form">
        </div>
      </div>
      <ul class="nav">
<%@include file="menu.jsp"%>
    </nav>
  </header>

  <section class="hero">
    <div class="hero-container">
      <div class="hero-content">
        <h1>Explore o inexplorado.</h1>
        <p>
          Site em desenvolvimento. <br>
          Provérbios 10:20 Prata escolhida é a língua do justo; o coração dos perversos é de nenhum valor. <br>
          21 Os lábios do justo apascentam a muitos, mas os tolos morrem por falta de entendimento.
        </p>
  
    <div class="hero-overlay"></div>
  </section>     

  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/justifiedGallery/3.7.0/js/jquery.justifiedGallery.min.js" integrity="sha256-bIPvSCQ7+G5GbIXDt2B+9AMpCmFtxTVLU+aWAIPzL8I=" crossorigin="anonymous"></script>
  <script>
    $('#gallery').justifiedGallery({
      rowHeight : 200,
      lastRow : 'nojustify',
      margins : 12
    });
  </script>
</body>
</html>

