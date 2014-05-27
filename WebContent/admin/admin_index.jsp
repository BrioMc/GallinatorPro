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
			<li><a href="#enemigos">Enemigos</a></li>
			<li><a href="#quest">Quests</a></li>
		</ul>
		<div class="clr"></div>
		<section class="block">
			<article id="usuarios">
				<jsp:include page="admin_usuarios.jsp"></jsp:include>
			</article>
			<article id="jugadores">
				<jsp:include page="admin_jugadores.jsp"></jsp:include>
			</article>
			<article id="enemigos">
				<jsp:include page="admin_enemigos.jsp"></jsp:include>
			</article>
			<article id="quest">
				<jsp:include page="admin_quest.jsp"></jsp:include>
			</article>
		</section>
	</section>
</body>
<script type="text/javascript">
	$(function() {
		$('ul.tabs li:first').addClass('active');
		$('.block article').hide();
		$('.block article:first').show();
		$('ul.tabs li').on('click', function() {
			$('ul.tabs li').removeClass('active');
			$(this).addClass('active')
			$('.block article').hide();
			var activeTab = $(this).find('a').attr('href');
			$(activeTab).show();
		});
	})
</script>
	</html>
</jsp:root>