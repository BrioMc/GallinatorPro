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
<jsp:useBean id="listaEnemy" class="gallinator.listabean.ListaEnemigo"
	scope="session" />
<jsp:setProperty name="listaEnemy" property="clausulaWhere" value="" />

<head>
<script type="text/javascript" src="../js/jquery-2.0.2.js">
<!--text-->
	
</script>
<jsp:include page="../includes/js_admin.jsp" />
<script type="text/javascript" src="../js/functions_admin.js">
<!--text-->
	
</script>
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
			<li><a href="admin_pjquest.jsp">PJ_Quests</a></li>
			<li class="active"><a href="admin_quest.jsp">Quests</a></li>
			<li><a id="closesession" href="#" onclick="closeSession()">Cerrar
					Sesion</a></li>

		</ul>
		<div class="clr"></div>
		<section class="block">
			<table id="lista_quest">
				<tr>
					<th>Definicion</th>
					<th>Inicio X</th>
					<th>Inicio Y</th>
					<th>Recompensa</th>
					<th>Final X</th>
					<th>Final Y</th>
					<th>Battle</th>
					<th>Enemigo</th>
					<th>Mejora</th>
					<th>Sentencia</th>
					<th>Puntos</th>
					<th>Borrar</th>
					<th>Modificar</th>
				</tr>
				<c:forEach var="quest" items="${listaQuest.quest}">
					<tr>
						<td>${quest.definicion}</td>
						<td>${quest.posX_init}</td>
						<td>${quest.posY_init}</td>
						<td>${quest.respuesta}</td>
						<td>${quest.posX_finish}</td>
						<td>${quest.posY_finish}</td>
						<td>${quest.battle}</td>
						<jsp:setProperty name="listaEnemy" property="clausulaWhere"
							value=" where idEnemigo=${quest.enemy}" />

						<td><c:forEach var="enemy" items="${listaEnemy.enemigo}">${enemy.nombre}</c:forEach></td>
						<td>${quest.mejora}</td>
						<td>${quest.sentenciaSQL}</td>
						<td>${quest.points}</td>
						<td><input type="checkbox" name="seleccion[]"
							value="${quest.idQuest}" /></td>
						<td><button onclick="modQuest(${quest.idQuest})">Modificar</button></td>
					</tr>
				</c:forEach>
			</table>

			<ul class="tabs">
				<li><button onclick="showFormQuest()">Añadir</button></li>
				<li><button onclick="deleteQuest()">Borrar Seleccion</button></li>
			</ul>
			<div id="addquest">
				<jsp:setProperty name="listaEnemy" property="clausulaWhere" value="" />
				<h1>Añadir/Modificar Quest</h1>
				<table>
					<tr>
						<th>Definicion</th>
						<th>Inicio X</th>
						<th>Inicio Y</th>
						<th>Recompensa</th>
						<th>Final X</th>
						<th>Final Y</th>
						<th>Battle</th>
						<th>Enemigo</th>
						<th>Mejora</th>
						<th>Sentencia</th>
						<th>Puntos</th>
					</tr>
					<tr>

						<td><textarea name="definicion" rows="" cols=""><!-- text --></textarea></td>
						<td><input class="inputnumber" type="number" name="posX_init" /></td>
						<td><input class="inputnumber" type="number" name="posY_init" /></td>
						<td><textarea name="resultado" rows="" cols=""><!-- text --></textarea></td>
						<td><input class="inputnumber" type="number"
							name="posX_finish" /></td>
						<td><input class="inputnumber" type="number"
							name="posY_finish" /></td>
						<td><select name="battle"><option value='Y'>Si</option>
								<option value='N'>No</option></select></td>

						<td><select name="enemy"><option value="0">--Ninguno--</option><c:forEach var="enemy"
									items="${listaEnemy.enemigo}">
									<option value="${enemy.id}">${enemy.nombre}</option>
								</c:forEach></select></td>
						<td><select name="mejora"><option value='Y'>Si</option>
								<option value='N'>No</option></select></td>
						<td><textarea name="sentencia" rows="" cols=""><!-- text --></textarea></td>
						<td><input class="inputnumber" type="number" name="points"
							rows="" cols="" /></td>
						<td><input type="button" value="Añadir/Modificar"
							onclick="addQuest()" /></td>
						<td><input type="hidden" name="idQuest" id="idQuest" value="" /></td>
					</tr>

				</table>
			</div>
		</section>
	</section>
</body>
	</html>
</jsp:root>