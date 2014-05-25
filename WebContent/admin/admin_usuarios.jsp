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
	<jsp:useBean id="usuarioBean" class="gallinator.bean.UsuarioBean"
		scope="session" />
	<jsp:useBean id="listaUsuario"
		class="gallinator.listabean.ListaUsuario" scope="session" />
	<jsp:setProperty name="listaUsuario" property="clausulaWhere" value="" />

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
</jsp:root>