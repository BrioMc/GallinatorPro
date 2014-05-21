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
<link rel="stylesheet" type="text/css" href="style/default.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="style/keys.css"
	media="screen" />
	
<jsp:include page="/includes/js.jsp" />
<title>GallinatorPro</title>
<jsp:useBean id="SesionPlayer" class="gallinator.bean.SesionPlayer"
	scope="session" />
</head>
<body>
	<div id="gamebox">
		<c:if test="${SesionPlayer.id==0 }">
		<script type="text/javascript" src="js/logg.js"></script>
			<jsp:include page="/includes/sesion_off.jsp" />
		</c:if>
		<c:if test="${SesionPlayer.id!=0 }">
			<jsp:include page="/includes/sesion_on.jsp" />
		</c:if>
		<div class="clear"></div>
	</div>
</body>
	</html>
</jsp:root>