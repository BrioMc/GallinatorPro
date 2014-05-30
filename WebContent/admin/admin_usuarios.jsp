<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:sql="http://java.sun.com/jsp/jstl/sql"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions" version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="true" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:useBean id="usuarioBean" class="gallinator.bean.UsuarioBean"
	scope="session" />
<jsp:useBean id="listaUsuario" class="gallinator.listabean.ListaUsuario"
	scope="session" />
<jsp:setProperty name="listaUsuario" property="clausulaWhere"
	value="where id!=1" />
<head>

<jsp:include page="../includes/js_admin.jsp" />
<script type="text/javascript" src="../js/jquery-2.0.2.js">
<!--text-->
	
</script>
<script type="text/javascript" src="../js/functions_admin.js">
<!--text-->
	
</script>
<link rel="stylesheet" type="text/css" href="../style/admin.css"
	media="screen" />
<title>GallinatorPro</title>
<jsp:useBean id="SesionAdmin" class="gallinator.bean.UsuarioBean"
	scope="session" />
</head>
<c:if test="${SesionAdmin.id==0 }">
	<c:redirect url="../index.jsp" />
</c:if>
<body>
	<section class="wrapper">
		<h1>Administración</h1>
		<ul class="tabs">
			<li class="active"><a href="admin_usuarios.jsp">Usuarios</a></li>
			<li><a href="admin_jugadores.jsp">Jugadores</a></li>
			<li><a href="admin_enemigos.jsp">Enemigos</a></li>
			<li><a href="admin_quest.jsp">Quests</a></li>
			<li><a id="closesession" href="#" onclick="closeSession()">Cerrar Sesion</a></li>
		</ul>
		<div class="clr"></div>
		<table>
			<tr>
				<th>Usuario</th>
				<th>Pass</th>
				<th>Email</th>
				<th>Selección</th>
			</tr>
			<c:forEach var="usuario" items="${listaUsuario.usuario}">
				<tr>
					<td>${usuario.user}</td>
					<td>${usuario.pass}</td>
					<td>${usuario.email}</td>
					<td><input type="checkbox" name="seleccion[]"
						value="${usuario.id}" /></td>
				</tr>
			</c:forEach>
		</table>
	</section>
</body>
	</html>
</jsp:root>