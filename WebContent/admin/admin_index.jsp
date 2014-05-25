<script type="text/javascript" src="../js/jquery-2.0.2.js"></script>
<link rel="stylesheet" type="text/css" href="../style/admin.css"
	media="screen" />
<section class="wrapper">
	<h1>Administración</h1>
	<ul class="tabs">
		<li><a href="#usuarios">Usuarios</a></li>
		<li><a href="#jugadores">Jugadores</a></li>
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