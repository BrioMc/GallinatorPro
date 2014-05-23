<script type="text/javascript" src="../js/jquery-2.0.2.js"></script>
<link rel="stylesheet" type="text/css" href="../style/admin.css"
	media="screen" />
<section class="wrapper">
	<h1>Tabs with HTML5, CSS3 and jQuery</h1>
	<ul class="tabs">
		<li><a href="#tab1">Usuarios</a></li>
		<li><a href="#tab2">Jugadores</a></li>
		<li><a href="#tab3">Enemigos</a></li>
		<li><a href="#tab3">Quests</a></li>
	</ul>
	<div class="clr"></div>
	<section class="block">
		<article id="tab1">
			<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
				Phasellus hendrerit. Pellentesque aliquet nibh nec urna. In nisi
				neque, aliquet vel, dapibus id, mattis vel, nisi. Sed pretium,
				ligula sollicitudin laoreet viverra, tortor libero sodales leo, eget
				blandit nunc tortor eu nibh. Nullam mollis. Ut justo. Suspendisse
				potenti. Pellentesque fermentum dolor. Aliquam quam lectus,
				facilisis auctor, ultrices ut, elementum vulputate, nunc.</p>
		</article>
		<article id="tab2">
			<p>Sed egestas, ante et vulputate volutpat, eros pede semper est,
				vitae luctus metus libero eu augue. Morbi purus libero, faucibus
				adipiscing, commodo quis, gravida id, est. Sed lectus. Praesent
				elementum hendrerit tortor. Sed semper lorem at felis. Vestibulum
				volutpat, lacus a ultrices sagittis, mi neque euismod dui, eu
				pulvinar nunc sapien ornare nisl. Phasellus pede arcu, dapibus eu,
				fermentum et, dapibus sed, urna.</p>
		</article>
		<article id="tab3">
			<p>Morbi interdum mollis sapien. Sed ac risus. Phasellus lacinia,
				magna a ullamcorper laoreet, lectus arcu pulvinar risus, vitae
				facilisis libero dolor a purus. Sed vel lacus. Mauris nibh felis,
				adipiscing varius, adipiscing in, lacinia vel, tellus. Suspendisse
				ac urna. Etiam pellentesque mauris ut lectus. Nunc tellus ante,
				mattis eget, gravida vitae, ultricies ac, leo. Integer leo pede,
				ornare a, lacinia eu, vulputate vel, nisl.</p>
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