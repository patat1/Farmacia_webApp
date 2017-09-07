<%--
  Created by IntelliJ IDEA.
  User: roberto
  Date: 08/06/17
  Time: 13.39
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="icon" href="../images/icon.png">
    <title>Farmacie Regionali</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="../css/bootstrap.css" rel="stylesheet" type="text/css">

</head>

<body>
<div class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/Farmacia_WebApp/"><span>Farmacie Regionali</span></a>
        </div>
        <g:if test="${session.user}">
            <div class="collapse navbar-collapse" id="navbar-ex-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#">Accesso come ${session.userinfo}</a>
                    </li>
                    <li class="active">
                        <a controller="login" href="../login/logout.gsp">Logout</a>
                    </li>
                </ul>
            </div>
        </g:if>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <img class="img-responsive" src="../images/farmacia1.jpg">
            </div>
            <div class="col-md-6">
                <div class="row">
                    <div class="col-md-12">
                        <h1>Operazioni disponibili per un Titolare:</h1>
                        <div class="row">
                            <div class="col-md-12">
                                <a class="btn btn-block btn-lg btn-primary" href="../subscriberMaster/subscribeDF.gsp">Registra un Dottore di Farmacia</a>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <a class="btn btn-block btn-lg btn-primary" href="../subscriberMaster/subscribeOB.gsp">Registra un Operatore di Banco</a>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <a class="btn btn-block btn-lg btn-primary" href="../productEditor/adder.gsp">Registra un Prodotto</a>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <a class="btn btn-block btn-lg btn-primary" href="../productEditor/listProducts.gsp">Ordina un Prodotto già registrato</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>