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
                <h1>Attendere prego...</h1>
            </div>
        </div>
    </div>
</div>
</body>

</body>
</html>