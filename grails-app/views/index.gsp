<html>

<head>
	<link rel="icon" href="images/icon.png">
	<title>Farmacie Regionali</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
	<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="navbar navbar-default navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="/Farmacia_WebApp/"><span>Farmacie Regionali</span></a>
		</div>
        <g:if test="${!session.user}">
            <div class="collapse navbar-collapse" id="navbar-ex-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li class="active">
                        <a href="login/login.gsp">Login</a>
                    </li>
                </ul>
            </div>
        </g:if>
	</div>
</div>
<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<img class="img-responsive" src="images/farmacista2.jpg">
			</div>
			<div class="col-md-6">
				<h1>Farmacie Regionali</h1>
				<h3>Un servizio comune</h3>
				<g:if test="${session.usertype=="REG"}">
					<h4>Effettuato accesso come Regione</h4>
					<div class="row">
						<div class="col-md-12">
							<div class="section">
								<div class="container-md-6">
									<div class="row">
										<div class="col-md-12">
											<a class="btn btn-block btn-lg btn-primary" href="homepage/home_REG.gsp">Vai alla Home della Regione</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</g:if>
				<g:elseif test="${session.usertype=="TF"}">
					<h4>Effettuato accesso come Titolare di Farmacia</h4>
					<div class="row">
						<div class="col-md-12">
							<div class="section">
								<div class="container-md-6">
									<div class="row">
										<div class="col-md-12">
											<a class="btn btn-block btn-lg btn-primary" href="homepage/home_TF.gsp">Vai alla Home del Titolare</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</g:elseif>
				<g:elseif test="${session.usertype=="OB"}">
				<h4>Effettuato accesso come Operatore di Banco</h4>
				<div class="row">
					<div class="col-md-12">
						<div class="section">
							<div class="container-md-6">
								<div class="row">
									<div class="col-md-12">
										<a class="btn btn-block btn-lg btn-primary" href="homepage/home_OB.gsp">Vai alla Home del'Operatore di Banco</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				</g:elseif>
				<g:elseif test="${session.usertype=="DF"}">
					<h4>Effettuato accesso come Dottore di Farmacia</h4>
					<div class="row">
						<div class="col-md-12">
							<div class="section">
								<div class="container-md-6">
									<div class="row">
										<div class="col-md-12">
											<a class="btn btn-block btn-lg btn-primary" href="homepage/home_DF.gsp">Vai alla Home del Dottore di Farmacia</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</g:elseif>
				<g:else>
                  <div class="col-md-12">
                    <blockquote>
                      <p>
                        Definirò ciò che ritengo essere la medicina: in prima approssimazione,
                        liberare i malati dalle sofferenze e contenere la violenza della malattia,
                        e non curare chi è ormai sopraffatto dal male.
                      </p>
                      <footer>Ippocrate</footer>
                    </blockquote>
                  </div>
				</g:else>
			</div>
		</div>
	</div>
</div>
</body>

</html>