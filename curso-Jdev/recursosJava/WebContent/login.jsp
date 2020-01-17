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



<title>Filter Autenticação</title>

</head>
<body>
	<div class="container">

		<div class="card text-white ">

			<div class="card-header bg-primary">

				<div class="row">
					<div class="col-md-11 text-center">
						<h5>Acesso</h5>
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
				
				<form action="ServletAutenticacao" method="POST">
				<input id="url" type="hidden" name="url" value="<%=request.getParameter("url") %>">
					<div class="form-group  mx-sm-3 mb-2">
						<label for="teste" class="card-text">Login:</label>		 
						<input type="text" class="form-control" id="login" name="login" placeholder="">
					</div>
					
					<div class="form-group mx-sm-3 mb-2">
						<label for="senha" class="card-text">Senha:</label> <input type="password"
							class="form-control" id="senha" name="senha"placeholder="">

					</div>

					<button type="submit" class="btn btn-primary mb-2">Logar</button>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../resources/js/main.js"></script>
</body>
</html>