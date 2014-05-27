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

<jsp:useBean id="questBean" class="gallinator.bean.QuestBean"
	scope="session" />
<jsp:useBean id="listaQuest" class="gallinator.listabean.ListaQuest"
	scope="session" />
<jsp:setProperty name="listaQuest" property="clausulaWhere" value="" />

<head>
<script type="text/javascript" src="../js/jquery-2.0.2.js">
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
			<li><a href="admin_jugadores.jsp">Jugadores</a></li>
			<li><a href="admin_enemigos.jsp">Enemigos</a></li>
			<li class="active"><a href="admin_quest.jsp">Quests</a></li>
		</ul>
		<div class="clr"></div>
		<section class="block">
			<table>
				<tr>
					<th>Definicion</th>
					<th>Inicio X</th>
					<th>Inicio Y</th>
					<th>Recompensa</th>
					<th>Final X</th>
					<th>Final Y</th>
					<th>Puntos</th>
					<th>Seleccion</th>
				</tr>
				<c:forEach var="quest" items="${listaQuest.quest}">
					<tr>
						<td>${quest.definicion}</td>
						<td>${quest.posX_init}</td>
						<td>${quest.posY_init}</td>
						<td>${quest.respuesta}</td>
						<td>${quest.posX_finish}</td>
						<td>${quest.posY_finish}</td>
						<td>${quest.points}</td>
						<td><input type="checkbox" name="seleccion[]"
							value="${quest.id}" /></td>
					</tr>
				</c:forEach>
			</table>

			<div id="addquest">
				<form action="ControladorQuest" method="post">
					<table>
						<tr>
							<td colspan="2">Definición :</td>
							<td colspan="2"><textarea name="definicion" rows="" cols=""><!-- text --></textarea></td>
						</tr>
						<tr>
							<td>Inicio X :</td>
							<td><input type="number" name="posX_init" /></td>
							<td>Inicio Y :</td>
							<td><input type="number" name="posY_init" /></td>
						</tr>
						<tr>
							<td colspan="2">Resultado :</td>
							<td colspan="2"><textarea name="resultado" rows="" cols=""><!-- text --></textarea></td>
						</tr>
						<tr>
							<td>Final X :</td>
							<td><input type="number" name="posX_finish" /></td>
							<td>Final Y :</td>
							<td><input type="number" name="posY_finish" /></td>
						</tr>
						<tr>
							<td>Puntos :</td>
							<td><input type="number" name="points" rows="" cols="" /></td>
						</tr>
						<tr>
							<td><input type="hidden" name="id" value="null"/></td>
							<td><input type="submit" name="Añadir" value="añadir" /></td>
						</tr>
					</table>
				</form>
			</div>
		</section>
	</section>
</body>
	</html>
</jsp:root>