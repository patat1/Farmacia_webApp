<html>

<head>
    <link rel="icon" href="../images/icon.png">
    <title>Login</title>
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
            <a class="navbar-brand" href="/Farmacia_WebApp/"><span>Farmacie Regionali</span></a>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>Farmacie Regionali</h1>
            </div>
        </div>
        <g:if test="${flash.message}">
            <div class="alert alert-dismissable alert-warning">
                ${flash.message}</div>
        </g:if>
        <div class="row">
            <div class="col-md-6">
                <form action="log_in" controller="LoginController.groovy">
                    <div class="form-group">
                        <label class="control-label" for="exampleInputEmail1">Nome utente</label>
                        <input class="form-control" id="exampleInputEmail1"
                               placeholder="Username" type="text" name="username">
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="exampleInputPassword1">Password</label>
                        <input class="form-control" id="exampleInputPassword1"
                               placeholder="Password" type="password" name="password">
                    </div>
                    <button type="submit" class="btn btn-primary">Accedi</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

</html>