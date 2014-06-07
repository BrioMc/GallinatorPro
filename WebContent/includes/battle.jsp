
<div id="battle">
	<link rel="stylesheet" type="text/css" href="style/battle.css"
		media="screen" />
	<script type="text/javascript" src="js/jquery-2.0.2.js">
	<!--text-->
		
	</script>
	<script type="text/javascript" src="js/jquery.ghosttype-1.2.js">
	<!--text-->
		
	</script>


	<div id="battleenemy">
		<div id="battleenemyimg">
			<h1>Nombr</h1>
		</div>
		<div id="battleenemylife">
			<progress id="enemylife" max="100" value="50">
				<!-- text -->
			</progress>
		</div>
	</div>
	<!-- text -->
	<div id="battlepj">
		<div id="battlepjimg">
			<h1>Nombr</h1>
			<!-- text -->
		</div>
		<div id="battlepjlife">
			<progress id="pjlife" max="100" value="50">
				<!-- text -->
			</progress>
			<!-- text -->
		</div>
		<div id="battlepjoptions">
			<button>ATTACK</button>
			<button>RUN</button>
		</div>
	</div>
	<div id="battleinfo">
		<div id="ghostType">TENEMOS TODA TU BASE DE DATOS. ^^^^^^^^
			ESTAS MUERTO.</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$("#ghostType").ghostType();
	});
</script>
