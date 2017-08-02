<%--
  Created by IntelliJ IDEA.
  User: roberto
  Date: 01/08/17
  Time: 11.29
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="icon" href="../images/icon.png">
    <title>Registrazione Prodotto</title>
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
                <h3>Registrazione di un nuovo Prodotto</h3>
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
                <form class="form-horizontal" role="form" action="addPROD" controller="SubscriberMasterController.groovy">

                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="name" class="control-label">Nome</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" placeholder="Nome"
                                   name="nome">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="barcode" class="control-label">Codice (a barre)</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="barcode" placeholder="Codice"
                                   name="codice">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="price" class="control-label">Prezzo</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="price" placeholder="Prezzo"
                                   name="prezzo">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="recipe" class="control-label">Ricetta</label>
                        </div>
                        <div class="col-sm-10">
                            <select class="btn btn-primary dropdown-toggle" name="ricetta" id="recipe">
                                <OPTION VALUE=false SELECTED>Non richiede la ricetta
                                <OPTION VALUE=true>Richiede la ricetta
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Procedi con l'aggiunta
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