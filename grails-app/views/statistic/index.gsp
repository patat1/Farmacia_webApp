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
<g:header/>
<g:menuMain/>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-5">
                <h1>Statistiche sulle vendite</h1>
                <g:if test="${params.start=="1900-01-01" && params.end=="3000-01-01"}">
                    <h4>Dati su ogni vendita:</h4>
                </g:if>
                <g:elseif test="${params.start==null || params.end==null || params.start=="" || params.end==""}">
                    <h4>Indicare le date di inizio e fine del periodo di cui si vogliono le statistiche</h4>
                </g:elseif>
                <g:else>
                    <h4>Dati sulle vendite dal ${params.start} al ${params.end}:</h4>
                </g:else>
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
            <form action="index" controller="StatisticController.groovy">
                <input type="hidden" name="start" value="1900-01-01">
                <input type="hidden" name="end" value="3000-01-01">
                <button type="submit" class="btn btn-default">Controlla su tutto il database</button>
            </form>
        </div>
    </div>
</g:if>
<g:if test="${params.start!=null && params.end!=null && params.start!="" && params.end!=""}">
    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
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