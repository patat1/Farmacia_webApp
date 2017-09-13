<%--
  Created by IntelliJ IDEA.
  User: roberto
  Date: 07/06/17
  Time: 17.34
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="icon" href="../images/icon.png">
    <title>Pagina di Registrazione</title>
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
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h3>Registrazione di una Regione</h3>
                <h4>Inserire i dati</h4>
                <g:if test="${flash.message}">
                    <div class="alert alert-dismissable alert-warning">${flash.message}</div>
                </g:if>
            </div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <form class="form-horizontal" role="form" action="subREG" controller="SubscriberMasterController.groovy">
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="name" class="control-label">Nome della Regione</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" placeholder="Nome" name="nome">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="password" class="control-label">Password</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="password" placeholder="Password"
                                   name="passworda">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="passwordControl" class="control-label">Reinserisci Password</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="passwordControl" placeholder="Password"
                                   name="passwordb">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Procedi con la registrazione
                                <i class="fa fa-fw fa-angle-right"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>