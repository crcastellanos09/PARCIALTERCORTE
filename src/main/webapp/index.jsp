
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>¡Bienvenido!</title>
</head>
<%
String rspta = "";
if (request.getParameter("rspta") != null) {
	int r = Integer.parseInt(request.getParameter("rspta"));
	if (r == 0) {
		rspta = "Error: datos incorrectos";
	}
}
%>


<body class="bg-image" style="background-image: url('https://img.freepik.com/free-vector/white-background-with-blue-tech-hexagon_1017-19366.jpg?w=2000'); height: 400px;">
	<header>
		<nav class="navbar navbar-expand-lg bg-primary">
			<div>
				<a class="navbar-brand font-weight-bold text-light"><img src="https://i.imgur.com/IHuEebH.png" style="display: inline-block; vertical-align: middle; width: 70px;" />
					C.C.C ADMINISTRACIÓN </a>
			</div>
			</ul>
		</nav>
	</header>
	<center>
		<div class="container" style="margin-top: 80px;">
			<form method="post" action="/CRUDJAVA/LoginController">
				<div class="card" style="width: 30rem;">
					<div class="card-body">
					<img src="https://i.imgur.com/IHuEebH.png" style="display: inline-block; vertical-align: middle; width: 300px;" />
						<h4>INICIO DE SESIÓN</h4>
						<br> 
						<input type="text" name="txtusuario" class="form-control mt-2" placeholder="INGRESE SU USUARIO" required> 
						<input type="password" name="txtclave" class="form-control mt-2" placeholder="INGRESE SU CLAVE" required>
						<br>
						<input type="submit" class="btn btn-primary btn-block mt-2" name="btn-login" value="INGRESAR">
						<p style="color: red;"><%=rspta%></p>
					</div>
				</div>
			</form>
		</div>
	</center>
</body>
</html>
