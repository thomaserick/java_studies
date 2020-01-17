<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"
	type="text/javascript"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<script defer
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
  <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<title>Capturando Exceções</title>


<style type="text/css">
#myProgress {
	width: 100%;
	background-color: #ddd;
}

#myBar {
	width: 1%;
	height: 20px;
	background-color: #4CAF50;
}


.ui-progressbar{
	position: relative;
}

.progress-label{
	position: relative;
	left: 50%;
	top: 4px;
	font-weight: bold;
	text-shadow: 1px 1px 0 #fff;
}


</style>




</head>
<body>
	<div class="container">

		<div class="card text-white ">

			<div class="card-header bg-primary">

				<div class="row">
					<div class="col-md-11 text-center">
						<h5>Barra de Progresso</h5>
					</div>

					<div class="col-md-1">
						<ul class="nav nav-pills card-header-pills justify-content-end">
							<li class="nav-item"><a class="nav-link" href="../index.jsp"
								title="Home"><i class="fas fa-home"
									style="color: white; font-size: 20px;"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="card-body text-dark">
			<h3>Progresso com JavaScript</h3>
				<div id="myProgress">
					<div id="myBar"></div>
				</div>
				<br/>
				<button onclick="progressbar();" class="btn btn-success">Iniciar Progresso</button>
				<br/><br/>
				<h3>Progresso com JQuery</h3>
				<div id="progressbar">
				<div class="progress-label"> Carregando....</div>
				</div>
				

			</div>
		</div>
	</div>
	<script type="text/javascript" src="../resources/js/main.js"></script>
</body>
</html>