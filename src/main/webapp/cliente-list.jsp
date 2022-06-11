<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Administración de Clientes</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<body class="bg-image" style="background-image: url('https://img.freepik.com/free-vector/white-background-with-blue-tech-hexagon_1017-19366.jpg?w=2000'); height: 400px;">
	<header>
		<nav class="navbar navbar-expand-lg bg-danger">
			<div>
				<a class="navbar-brand font-weight-bold text-light"><img src="https://i.imgur.com/IHuEebH.png" style="  display: inline-block;
  vertical-align: middle;
  width: 70px;"/> C.C.C ADMINISTRACIÓN </a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/mainPage"
					class="nav-link text-light">INICIO</a></li>
				<li><a href="<%=request.getContextPath()%>/listCliente"
					class="nav-link text-light">VER CLIENTES</a></li>
				<li><a href="<%=request.getContextPath()%>/new"
					class="nav-link text-light">INSERTAR CLIENTES</a></li>
				<li><a href="<%=request.getContextPath()%>/logOut" class="btn btn-dark text-light float-right">CERRAR SESIÓN</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
		<div class="container">
			<h3 class="text-center">LISTA DE CLIENTES</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-danger text-light">INSERTAR
					NUEVO CLIENTE</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr class="list-group-item-danger text-dark text-center">
						<th>ID</th>
						<th>NOMBRE</th>
						<th>GENERO</th>
						<th>DIRECCION</th>
						<th>CIUDAD</th>
						<th>CORREO</th>
						<th>ACCIONES</th>
					</tr>
				</thead>
				<tbody>
					<!-- for (Todo todo: todos) { -->
					<c:forEach var="cliente" items="${listCliente}">
						<tr class="bg-light">
							<td><c:out value="${cliente.id_cliente}" /></td>
							<td><c:out value="${cliente.nombre_cliente}" /></td>
							<td><c:out value="${cliente.genero_cliente}" /></td>
							<td><c:out value="${cliente.direccion_cliente}" /></td>
							<td><c:out value="${cliente.ciudad_cliente}" /></td>
							<td><c:out value="${cliente.correo_cliente}" /></td>
							<td><a href="edit?id_cliente=<c:out value='${cliente.id_cliente}' />"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="#4bd61c" class="bi bi-pencil" viewBox="0 0 16 16">
  <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
</svg></a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id_cliente=<c:out value='${cliente.id_cliente}' />"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="#d61c1c" class="bi bi-trash" viewBox="0 0 16 16">
  <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
  <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
</svg></a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>