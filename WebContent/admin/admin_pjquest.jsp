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
<jsp:useBean id="pjquestBean" class="gallinator.bean.PJQuestBean"
	scope="session" />
<jsp:useBean id="listaPJQuest" class="gallinator.listabean.ListaPJQuest"
	scope="session" />
<jsp:setProperty name="listaPJQuest" property="clausulaWhere" value="" />
<head>
<script type="text/javascript" src="../js/jquery-2.0.2.js">
<!--text-->
	
</script>
<script type="text/javascript" src="../js/functions_admin.js">
<!--text-->
	
</script>

<jsp:include page="../includes/js_admin.jsp" />
<link rel="stylesheet" type="text/css" href="../style/admin.css"
	media="screen" />
<title>Administración - Oasis</title>
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
			<li class="active"><a href="admin_pjquest.jsp">PJ_Quests</a></li>
			<li><a href="admin_quest.jsp">Quests</a></li>
			<li><a id="closesession" href="#" onclick="closeSession()">Cerrar
					Sesion</a></li>
		</ul>
		<div class="clr"></div>
		<section class="block">
			<table id="list_pjq">
				<tr>
					<th>Quest</th>
					<th>Personaje</th>
					<th>Iniciada</th>
					<th>Acabada</th>
					<th>Borrar</th>
				</tr>
				<c:forEach var="pj" items="${listaPJQuest.PJQuest}">
					<tr>
						<td>${pj.quest}</td>
						<td>${pj.personaje}</td>
						<td>${pj.init}</td>
						<td>${pj.done}</td>
						<td><input type="checkbox" name="seleccion[]"
							value="${pj.idquest_personaje}" /></td>

					</tr>
				</c:forEach>
			</table>
			<ul class="tabs">
				<li><button onclick="deletePJQ()">Borrar Seleccion</button></li>
			</ul>
			<div id="modpjquest">
				<h1>Modificar Quest del PJ</h1>
				<table>
					<tr>
						<th>Quest</th>
						<th>Personaje</th>
						<th>Iniciada</th>
						<th>Acabada</th>
						<th>Modificar</th>
					</tr>
					<tr>
					</tr>
				</table>
			</div>
		</section>
	</section>
</body>
	</html>
</jsp:root>