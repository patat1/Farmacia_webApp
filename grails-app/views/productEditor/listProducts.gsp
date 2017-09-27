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
    <title>Registrazione Prodotto</title>
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
            <div class="col-md-12">
                <h1>Catalogo dei prodotti</h1>
                <g:if test="${flash.message}">
                    <div class="alert alert-dismissable alert-info">${flash.message}</div>
                </g:if>
            </div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <table class="table">
            <thead>
            <tr>
                <th>Prodotto</th>
                <th>Codice</th>
                <th>Quantità in magazzino</th>
                <th>Ordina</th>
            </tr>
            <g:prodtable/>
            </thead>

        </table>
    </div>
</div>
</body>

</html>