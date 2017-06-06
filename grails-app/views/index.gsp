<html>

<head>
	<link rel="icon" href="images/icon.png">
	<title>Farmacie Regionali</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
	<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
		  rel="stylesheet" type="text/css">
	<link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
		  rel="stylesheet" type="text/css">
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
		<g:if test="${session.user}">
		<div class="collapse navbar-collapse" id="navbar-ex-collapse">
			<ul class="nav navbar-nav navbar-right">
				<li >
					<a href="#">Bentornato, ${session.user}</a>
				</li>
				<li class="active">
					<a href="login/logout.gsp">Logout</a>
				</li>
			</ul>
		</div>
		</g:if>
		<g:else>
			<div class="collapse navbar-collapse" id="navbar-ex-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="active">
						<a href="login/login.gsp">Accedi</a>
					</li>
				</ul>
			</div>
		</g:else>
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
					<p>La Regione (REG) ha osservato che negli ultimi tempi ciascuna farmacia
					si e’ dotata di un proprio sistema di contabilita’/gestione di magazzino,
					e molti di tali sistemi sono ormai divenuti obsoleti. Inoltre la frammentazione
					delle soluzioni rende difficoltosa l’integrazione dei dati per fini analitici.
					REG ha dunque deciso di realizzare una applicazione accessibile via Web,
					che dovra’ essere utilizzata da tutte le farmacie al duplice scopo di abbattere
					i costi di produzione/manutenzione del sistema, e di standardizzare ed
					agevolare la condivisione delle informazioni con REG stessa.La Regione
					(REG) ha osservato che negli ultimi tempi ciascuna farmacia si e’ dotata
					di un proprio sistema di contabilita’/gestione di magazzino, e molti di
					tali sistemi sono ormai divenuti obsoleti. Inoltre la frammentazione delle
					soluzioni rende difficoltosa l’integrazione dei dati per fini analitici.
					REG ha dunque deciso di realizzare una applicazione accessibile via Web,
					che dovra’ essere utilizzata da tutte le farmacie al duplice scopo di abbattere
					i costi di produzione/manutenzione del sistema, e di standardizzare ed
					agevolare la condivisione delle informazioni con REG stessa.</p>
				</div>
		</div>
	</div>
</div>
</body>

</html>