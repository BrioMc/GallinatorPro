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
<jsp:useBean id="enemigoBean" class="gallinator.bean.EnemigoBean"
	scope="session" />
<jsp:useBean id="listaEnemigo" class="gallinator.listabean.ListaEnemigo"
	scope="session" />
<jsp:setProperty name="listaEnemigo" property="clausulaWhere" value="" />
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
			<li class="active"><a href="admin_enemigos.jsp">Enemigos</a></li>
			<li><a href="admin_quest.jsp">Quests</a></li>
			<li><a id="closesession" href="#" onclick="closeSession()">Cerrar
					Sesion</a></li>
		</ul>
		<div class="clr"></div>
		<section class="block">
			<table id="list_enemy">
				<tr>
					<th>Nombre</th>
					<th>Imagen</th>
					<th>Daño</th>
					<th>Sangre</th>
					<th>Exp</th>
					<th>Puntos</th>
					<th>Borrar</th>
					<th>Modificar</th>
				</tr>
				<c:forEach var="enemigo" items="${listaEnemigo.enemigo}">
					<tr>
						<td>${enemigo.nombre}</td>
						<td><img class="enemyimg " src="../${enemigo.imagen}"></img></td>
						<td>${enemigo.dmg}</td>
						<td>${enemigo.sangre}</td>
						<td>${enemigo.exp}</td>
						<td>${enemigo.points}</td>
						<td><input type="checkbox" name="seleccion[]"
							value="${enemigo.id}" /></td>
						<td><button onclick="modEnemy(${enemigo.id})">Modificar</button></td>
					</tr>
				</c:forEach>
			</table>
			<ul class="tabs">
				<li><button onclick="showFormEnemy()">Añadir</button></li>
				<li><button onclick="deleteEnemy()">Borrar Seleccion</button></li>
			</ul>
			<div id="addenemy">
				<h1>Añadir/Modificar Enemigo</h1>
				<table>
					<tr>
						<th>Nombre</th>
						<th>Imagen</th>
						<th>Daño</th>
						<th>HP(Health Points)</th>
						<th>Experiencia</th>
						<th>Puntos</th>
					</tr>
					<tr>
						<form action="../ControladorEnemigo" method="post"
							enctype="multipart/form-data">
							<input type="hidden" name="idEnemy" value="null" />
							<td><input type="text" name="nombre" size="20" /></td>
							<td><div id="cajaimagen">
									<!-- text -->
								</div> <input type="file" id="files" name="files[]" accept="image/*" /></td>
							<td><input type="text" name="dmg" class="inputnumber" /></td>
							<td><input type="text" name="sangre" class="inputnumber" /></td>
							<td><input type="text" name="exp" class="inputnumber" /></td>
							<td><input type="text" name="points" class="inputnumber" /></td>
							<td><input type="submit" value="Añadir/Modificar"
								class="inputnumber" /></td>
						</form>
					</tr>
				</table>
			</div>
			<script type="text/javascript">
				function archivo(evt) {
					var files = evt.target.files; // FileList object
					//Obtenemos la imagen del campo "file". 
					for (var i = 0, f; f = files[i]; i++) {
						//Solo admitimos imágenes.
						if (!f.type.match('image.*')) {
							continue;
						}
						var reader = new FileReader();
						reader.onload = (function(theFile) {
							return function(e) {
								// Creamos la imagen.
								document.getElementById("cajaimagen").innerHTML = [
										'<div id="imagen"><img class="enemyimg" src="',
										e.target.result, '"	title="',
										escape(theFile.name), '" /></div>' ]
										.join('');
							};
						})(f);
						reader.readAsDataURL(f);
					}
				}
				document.getElementById('files').addEventListener('change',
						archivo, false);
			</script>
		</section>
	</section>
</body>
	</html>
</jsp:root>