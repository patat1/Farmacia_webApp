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
                <h1>Nuovo Messaggio</h1>
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
            <div class="col-md-5">
                <form class="form-horizontal" role="form" action="send" controller="MessaggiController.groovy">
                    <div class="form-group">
                        <g:if test="${params.destinatario}">
                            <div class="col-sm-6">
                                <input type="text" class="form-control" value="${params.destinatario}" name="destinatario" placeholder="Destinatario">
                            </div>
                        </g:if>
                        <g:else>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="destinatario" placeholder="Destinatario">
                            </div>
                        </g:else>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <input type="text" class="form-control" cols="40" rows="5" name="messaggio" placeholder="Messaggio">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-10">
                            <button type="submit" class="btn btn-success">Invia</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

</html>