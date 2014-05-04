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
<head>
<title>Ikex</title>
<link href="${pageContext.request.contextPath}/estilos/estilos.css"
	rel="stylesheet" type="text/css" />
<jsp:include
	page="${pageContext.request.contextPath}/../includes/js.jsp" />
<link href="${pageContext.request.contextPath}/estilos/menu.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<!--Comienzo de la pagina -->
	<div id="pagina">
		<!--Comienza la cabecera -->
		<jsp:include
			page="${pageContext.request.contextPath}/../includes/cabecera.jsp" />
		<!--Termina la cabecera -->
		<!--Empieza el contenido -->
		<div id="contenido">
			<!-- Empieza el bloque medio-->
			<div id="medio" class="float">

				<jsp:include
					page="${pageContext.request.contextPath}/../includes/slider.jsp" />
			</div>
			<!-- Acaba el bloque medio-->
			<!--Comienza la barra lateral -->
			<jsp:include
				page="${pageContext.request.contextPath}/../includes/barLateral.jsp" />
			<!--Acaba la barra lateral-->
			<div class="clear"></div>
		</div>
		<!--Acaba el contenido -->
		<jsp:include
			page="${pageContext.request.contextPath}/../includes/piePagina.jsp" />
	</div>
	<!--Termina la pagina -->

</body>
	</html>
</jsp:root>