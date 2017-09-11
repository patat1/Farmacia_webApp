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
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/Farmacia_WebApp/"><span>Farmacie Regionali</span></a>
		</div>
			<g:if test="${!session.user}">
				<div class="collapse navbar-collapse" id="navbar-ex-collapse">
					<ul class="nav navbar-nav navbar-right">
					<li class="">
						<a href="subscriberMaster/subscribeREG.gsp">Registra una nuova Regione</a>
					</li>
						<li class="active">
							<a href="login/login.gsp">Accesso</a>
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
												<a class="btn btn-block btn-lg btn-primary" href="homepage_regione/index.gsp">Vai alla Home della Regione</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</g:if>
					<g:if test="${session.usertype=="TF"}">
						<h4>Effettuato accesso come Titolare di Farmacia</h4>
						<div class="row">
							<div class="col-md-12">
								<div class="section">
									<div class="container-md-6">
										<div class="row">
											<div class="col-md-12">
												<a class="btn btn-block btn-lg btn-primary" href="homepage_TF/index.gsp">Vai alla Home del Titolare</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</g:if>
				</div>
		</div>
	</div>
</div>
</body>

</html>