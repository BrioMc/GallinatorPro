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
	<jsp:useBean id="questBean" class="gallinator.bean.QuestBean"
		scope="session" />
	<jsp:useBean id="listaQuest"
		class="gallinator.listabean.ListaQuest" scope="session" />
	<jsp:setProperty name="listaQuest" property="clausulaWhere"
		value="" />

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
</jsp:root>