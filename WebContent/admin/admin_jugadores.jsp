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
<jsp:useBean id="personajeBean" class="gallinator.bean.SesionPlayer"
	scope="session" />
<jsp:useBean id="listaPersonaje"
	class="gallinator.listabean.ListaPersonaje" scope="session" />
<jsp:setProperty name="listaPersonaje" property="clausulaWhere" value="" />
<head>

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
			<li><a href="admin_usuarios.jsp">Usuarios</a></li>
			<li class="active"><a href="admin_jugadores.jsp">Jugadores</a></li>
			<li><a href="admin_enemigos.jsp">Enemigos</a></li>
			<li><a href="admin_quest.jsp">Quests</a></li>
		</ul>
		<div class="clr"></div>
		<section class="block">

			<table>
				<tr>
					<th>Usuario</th>
					<th>Alias</th>
					<th>Clase</th>
					<th>Sangre</th>
					<th>Mana</th>
					<th>Daño Físico</th>
					<th>Daño Habilidad</th>
					<th>Experiencia</th>
					<th>Level</th>
					<th>Pos X</th>
					<th>Pos Y</th>
					<th>Score</th>
					<th>Seleccion</th>
				</tr>
				<c:forEach var="personaje" items="${listaPersonaje.personaje}">
					<tr>
						<td>${personaje.usuario}</td>
						<td>${personaje.alias}</td>
						<td>${personaje.clase}</td>
						<td>${personaje.sangre}/${personaje.maxSangre}</td>
						<td>${personaje.mana}/${personaje.maxMana}</td>
						<td>${personaje.dmgF}</td>
						<td>${personaje.dmgH}</td>
						<td>${personaje.exp}</td>
						<td>${personaje.lv}</td>
						<td>${personaje.posX}</td>
						<td>${personaje.posY}</td>
						<td>${personaje.score}</td>
						<td><input type="checkbox" name="seleccion[]"
							vale="${personaje.id}" /></td>
					</tr>
				</c:forEach>
			</table>
		</section>
	</section>
</body>
	</html>
</jsp:root>