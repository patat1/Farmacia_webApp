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
    <title>Messaggi</title>
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
                <h1>Messaggi Inviati</h1>
                <g:if test="${flash.message}">
                    <div class="alert alert-dismissable alert-info">${flash.message}</div>
                </g:if>
            </div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="btn-group">
                    <a href="../messaggi/inbox.gsp" class="btn btn-default">Ricevuti</a>
                    <a href="../messaggi/sent.gsp" class="btn btn-default">Inviati</a>
                    <a href="../messaggi/write.gsp" class="btn btn-primary">Scrivi Messaggio</a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <table class="table">
            <thead>
            <tr>
                <th>Destinatario</th>
                <th>Data</th>
                <th>Messaggio</th>
            </tr>
            <g:sentTable/>
            </thead>
        </table>
    </div>
</div>
</body>

</html>