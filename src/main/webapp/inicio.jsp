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
		<nav class="navbar navbar-expand-lg bg-info">
			<div>
				<a class="navbar-brand font-weight-bold text-light"><img src="https://i.imgur.com/IHuEebH.png" style="  display: inline-block;
  vertical-align: middle;
  width: 70px;"/> C.C.C ADMINISTRACIÓN </a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>"
					class="nav-link disabled">FACTURACIÓN</a></li>
				<li><a href="<%=request.getContextPath()%>/listCliente"
					class="nav-link text-light">CLIENTES</a></li>
				<li><a href="<%=request.getContextPath()%>/new"
					class="nav-link disabled">TRABAJADORES</a></li>
				<li><a href="<%=request.getContextPath()%>/logOut" class="btn btn-dark text-light float-right">CERRAR SESIÓN</a></li>
			</ul>
		</nav>
	</header>
			<br>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
		<div class="container">

			<h3 class="text-center">¡MENÚ DE INICIO!</h3>
			<hr>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr class="list-group-item-info text-dark text-center">
						<th>¿QUE DESEA REALIZAR?</th>
					</tr>
				</thead>
				<tbody>
					<tr class="text-center">
						<td class="disabled"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-card-checklist" viewBox="0 0 16 16">
  <path d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h13zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>
  <path d="M7 5.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm-1.496-.854a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0l-.5-.5a.5.5 0 1 1 .708-.708l.146.147 1.146-1.147a.5.5 0 0 1 .708 0zM7 9.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm-1.496-.854a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0l-.5-.5a.5.5 0 0 1 .708-.708l.146.147 1.146-1.147a.5.5 0 0 1 .708 0z"/>
</svg>MÓDULO DE FACTURACIÓN</th>
					</tr>
					<tr class="text-center">
						<td><a href="<%=request.getContextPath()%>/listCliente"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-people-fill" viewBox="0 0 16 16">
  <path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
  <path fill-rule="evenodd" d="M5.216 14A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216z"/>
  <path d="M4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5z"/>
</svg>MÓDULO DE CLIENTES</a></th>
		</tr>
		<tr class="text-center">
		<td class="disabled"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-server" viewBox="0 0 16 16">
  <path d="M1.333 2.667C1.333 1.194 4.318 0 8 0s6.667 1.194 6.667 2.667V4c0 1.473-2.985 2.667-6.667 2.667S1.333 5.473 1.333 4V2.667z"/>
  <path d="M1.333 6.334v3C1.333 10.805 4.318 12 8 12s6.667-1.194 6.667-2.667V6.334a6.51 6.51 0 0 1-1.458.79C11.81 7.684 9.967 8 8 8c-1.966 0-3.809-.317-5.208-.876a6.508 6.508 0 0 1-1.458-.79z"/>
  <path d="M14.667 11.668a6.51 6.51 0 0 1-1.458.789c-1.4.56-3.242.876-5.21.876-1.966 0-3.809-.316-5.208-.876a6.51 6.51 0 0 1-1.458-.79v1.666C1.333 14.806 4.318 16 8 16s6.667-1.194 6.667-2.667v-1.665z"/>
</svg>MÓDULO DE TRABAJADORES</th>
		</tr>

				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
