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
    <title>Pagina di Aggiunta</title>
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
                <h3>Registrazione di un Medico</h3>
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
                <form class="form-horizontal" role="form" action="subMed" controller="SubscriberMasterController.groovy">
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
                            <input type="text" class="form-control" id="surname" placeholder="Cognome"
                                   name="cognome">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="code" class="control-label">Codice Regionale</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="code" placeholder="Codice Regionale"
                                   name="codereg">
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
        <div class="row">
            <div class="col-md-12"></div>
        </div>
    </div>
</div>
</body>
</html>