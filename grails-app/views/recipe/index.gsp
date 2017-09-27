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
    <title>Registrazione Ricetta</title>
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
<g:menuMain/>

<g:if test="${flash.message}">
    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="alert alert-dismissable alert-warning">
                        ${flash.message}</div>
                </div>
            </div>
        </div>
    </div>
</g:if>

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <form class="form-horizontal" role="form" action="addRecipe" controller="RecipeController.groovy">
                    <g:if test="${session.customer==null}">
                    <div class="section">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12">
                                    <h3>Dati del Paziente</h3>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="name" class="control-label">Nome</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" placeholder="Nome" name="nome">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="surname" class="control-label">Cognome</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="surname" placeholder="Cognome" name="cognome">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="date" class="control-label">Data di nascita</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="date" class="form-control" id="date" placeholder="Data di nascita" name="data">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="cf" class="control-label">Codice Fiscale</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cf" placeholder="Codice Fiscale" name="codfisc">
                        </div>
                    </div>
                </g:if>
                    <div class="section">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12">
                                    <h3>Dati della Ricetta</h3>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="dateR" class="control-label">Data</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="date" class="form-control" id="dateR" placeholder="Data" name="dataR">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="numReg" class="control-label">ID della ricetta</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="numReg" placeholder="Id ricetta" name="numRec">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="creg" class="control-label">CR del Medico</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="creg" placeholder="Codice Regionale" name="codiceReg">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <input type="hidden" name="idRecipeProd" value="${params.idRecipeProd}">
                            <button type="submit" class="btn btn-default">Registra la ricetta
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