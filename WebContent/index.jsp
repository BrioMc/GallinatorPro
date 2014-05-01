<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
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
<title>GallinatorPro</title>
<jsp:include page="/includes/js.jsp" />
</head>
<body>
	<div id="gamebox">
		<jsp:include page="/includes/loggin.jsp" />

		<div id="panelusuario"><jsp:include page="/includes/keyboard.jsp" /></div>
		<div class="clear"></div>
	</div>
</body>
	</html>
</jsp:root>