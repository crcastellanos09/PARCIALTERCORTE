<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Acceso a Datos</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body class="bg-image" style="background-image: url('https://img.freepik.com/free-vector/white-background-with-blue-tech-hexagon_1017-19366.jpg?w=2000');
    height: 400px;">
		<header>
		<nav class="navbar navbar-expand-lg bg-success">
			<div>
				<a class="navbar-brand font-weight-bold text-light"><img src="https://i.imgur.com/IHuEebH.png" class="fade-in" style="display: inline-block;
  vertical-align: middle;
  width: 70px;"/> C.C.C ADMINISTRACIÓN </a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listCliente"
					class="nav-link" style="color:#ffff;">VER CLIENTES</a></li>
				<li><a href="<%=request.getContextPath()%>/new"
					class="nav-link" style="color:#ffff;">INSERTAR CLIENTES</a></li>
				<li><a href="<%=request.getContextPath()%>/logOut" class="btn btn-dark text-light float-right">CERRAR SESIÓN</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${cliente != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${cliente == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${cliente != null}">
EDITAR CLIENTE
</c:if>
						<c:if test="${cliente == null}">
INSERTAR NUEVO CLIENTE
</c:if>
					</h2>
				</caption>
				<c:if test="${cliente != null}">
					<input type="hidden" name="id_cliente" value="<c:out value='${cliente.id_cliente}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>NOMBRE</label> <input type="text"
						value="<c:out value='${cliente.nombre_cliente}' />" class="form-control"
						name="nombre_cliente" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>GENERO</label> <select type="text"
						value="<c:out value='${cliente.genero_cliente}' />" class="form-control"
						name="genero_cliente">
  						  <option selected value="MASCULINO">MASCULINO</option>
  	                      <option value="FEMENINO">FEMENINO</option>
  	                      <option value="OTRO">OTRO</option>
  	                      </select>
				</fieldset>
				<fieldset class="form-group">
					<label>DIRECCION</label> <input type="text"
						value="<c:out value='${cliente.direccion_cliente}' />" class="form-control"
						name="direccion_cliente" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>CIUDAD</label> <input type="text"
						value="<c:out value='${cliente.ciudad_cliente}' />" class="form-control"
						name="ciudad_cliente" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>CORREO</label> <input type="email"
						value="<c:out value='${cliente.correo_cliente}' />" class="form-control"
						name="correo_cliente" required="required">
				</fieldset>
				
				
				<button type="submit" class="btn btn-success">GUARDAR</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>