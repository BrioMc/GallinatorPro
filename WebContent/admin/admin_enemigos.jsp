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
	<jsp:useBean id="enemigoBean" class="gallinator.bean.EnemigoBean"
		scope="session" />
	<jsp:useBean id="listaEnemigo"
		class="gallinator.listabean.ListaEnemigo" scope="session" />
	<jsp:setProperty name="listaEnemigo" property="clausulaWhere" value="" />

	<table>
		<tr>
			<th>Nombre</th>
			<th>Imagen</th>
			<th>Daño</th>
			<th>Sangre</th>
			<th>Exp</th>
			<th>Puntos</th>
			<th>Selección</th>
		</tr>
		<c:forEach var="enemigo" items="${listaEnemigo.enemigo}">
			<tr>
				<td>${enemigo.nombre}</td>
				<td>${enemigo.imagen}</td>
				<td>${enemigo.dmg}</td>
				<td>${enemigo.sangre}</td>
				<td>${enemigo.exp}</td>
				<td>${enemigo.points}</td>
				<td><input type="checkbox" name="seleccion[]"
					value="${enemigo.id}" /></td>
			</tr>
		</c:forEach>
	</table>
</jsp:root>