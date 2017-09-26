<%--
  Created by IntelliJ IDEA.
  User: roberto
  Date: 04/08/17
  Time: 11.16
--%>

<%@ page import="farmacia_webapp.prodotti.ProductEditorController" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="icon" href="../images/icon.png">
    <title>Statistiche</title>
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
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-5">
                <h1>Statistiche sulle vendite</h1>
                <h4>Indicare le date di inizio e fine del periodo di cui si vogliono le statistiche</h4>
                <g:if test="${flash.message}">
                    <div class="alert alert-dismissable alert-info">${flash.message}</div>
                </g:if>
            </div>
        </div>
    </div>
</div>
<g:if test="${params.start==null || params.end==null || params.start=="" || params.end==""}">
    <div class="section">
        <div class="container">
            <form action="index" controller="StatisticController.groovy">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Data inizio</th>
                        <th>Data fine</th>
                    </tr>
                    <tr>
                        <th>
                            <input class="form-control" type="date" name="start">
                        </th>
                        <th>
                            <input class="form-control" type="date" name="end">
                        </th>
                    </tr>
                    </thead>
                </table>
                <button type="submit" class="btn btn-primary">Imposta</button>
            </form>
        </div>
    </div>
</g:if>
<g:if test="${params.start!=null && params.end!=null && params.start!="" && params.end!=""}">
    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h4>Dati dal ${params.start} al ${params.end}:</h4>
                    <a class="btn btn-primary" href="../statistic/index.gsp">Reimposta periodo</a>
                </div>
            </div>
        </div>
    </div>
    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <ul class="media-list">
                        <g:statisticTable/>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</g:if>
</body>

</html>