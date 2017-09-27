<%--
  Created by IntelliJ IDEA.
  User: roberto
  Date: 08/06/17
  Time: 13.39
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="icon" href="../images/icon.png">
    <title>Farmacie Regionali</title>
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
            <div class="col-md-6">
                <img class="img-responsive" src="../images/farmacia2.jpg">
            </div>
            <div class="col-md-6">
                <div class="row">
                    <div class="col-md-12">
                        <h1>Operazioni disponibili per un Dottore di Farmacia:</h1>
                        <div class="row">
                            <div class="col-md-12">
                                    <a class="btn btn-block btn-lg btn-primary" href="../productEditor/buyProducts.gsp">Aggiungi prodotti al Carrello</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>