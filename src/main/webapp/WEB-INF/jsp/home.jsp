<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>AppVenda</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active" href="/">AppVenda</a></li>
				<li class="nav-item"><a class="nav-link" href="/vendedor/listagem">Vendedores</a></li>
				<li class="nav-item"><a class="nav-link" href="/animal/listagem">Animais</a></li>
				<li class="nav-item"><a class="nav-link" href="/gato/listagem">Gato</a></li>
				<li class="nav-item"><a class="nav-link" href="/cachorro/listagem">Cachorro</a></li>
				<li class="nav-item"><a class="nav-link" href="/endereco/listagem">Endereços</a></li>
				<li class="nav-item"><a class="nav-link" href="/estado/listagem">Estados</a></li>
			</ul>

			<form class="d-flex" action="/municipio/listagem" method="get">

				<select class="form-control me-2" name="uf">

				  <c:forEach var="estado" items="${estados}">
				  	<option value="${estado.id}">${estado.nome} - ${estado.sigla}</option>
				  </c:forEach>
				</select>

				<button class="btn btn-primary" type="submit">Municípios</button>
			</form>

		</div>
	</nav>

	<div class="container mt-3">

		<span class="badge rounded-pill bg-primary">Vendedor:${qtdeVendedor}</span>
		<span class="badge rounded-pill bg-secondary">Animal:${qtdeAnimal}</span>
		<span class="badge rounded-pill bg-success">Gato:${qtdeGato}</span>
		<span class="badge rounded-pill bg-danger">Cachorro:${qtdeCachorro}</span>
		<span class="badge rounded-pill bg-warning">Endereço:${qtdeEndereco}</span>

		<c:if test="${not empty listagem}">
			<h2>AppPetshop</h2>
			<p>Gestão de vendas de Animais:</p>
			<table class="table">
				<thead class="table-dark">
					<tr>
						<th>${titulo}</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${listagem}">
						<tr>
							<td>${item}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>


	</div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.min.js"></script>
</body>
</html>