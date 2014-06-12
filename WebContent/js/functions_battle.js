function initBattleQuest() {
	batalla = $('#battle');
	imgenemy = $('#battleenemyimg');
	enemylife = document.querySelector('#enemylife');
	pjimg = $('#battlepjimg');
	pjlife = document.querySelector('#pjlife');
	options = $('#battlepjoptions');
	text = $('#ghostType');
	text.text("");
	batalla.addClass("animated rotateIn");
	batalla.show();
	Controlador.takeQuest(2, function(quest) {
		Controlador.seeEnemy(quest.enemy, function(enemy) {
			enemylife.setAttribute("max", enemy.sangre);
			img = "<img src='" + enemy.imagen + "'/>";
			imgenemy.append(img);
			progress("#enemylife", enemy.sangre);
			$('#battleenemyimg h1').text(enemy.nombre);
			Controlador.leerSesion(function(user) {
				pjlife.setAttribute("max", user.maxSangre);
				progress("#pjlife", user.sangre);
				$('#battlepjimg h1').text(user.alias);
				if (user.clase == "warrior") {
					img = "<img src='images/pj/warrior.png'/>";
				} else {
					img = "<img src='images/pj/mage.png'/>";
				}
				pjimg.append(img);
				attack = "<button onclick='attackpj(" + enemy.id
						+ ")'>ATTACK</button>";
				options.empty();
				options.append(attack);
			});

		});
	});
}
function randomBattle() {
	Controlador.existQuest(function(exist) {
		if (exist == false) {
			var batalla = 1 + Math.floor(Math.random() * 10);
			if (batalla > 6) {
				batalla = $('#battle');
				imgenemy = $('#battleenemyimg');
				enemylife = document.querySelector('#enemylife');
				pjimg = $('#battlepjimg');
				pjlife = document.querySelector('#pjlife');
				options = $('#battlepjoptions');
				text = $('#ghostType');
				text.text("");
				batalla.addClass("animated rotateIn");
				batalla.show();
				Controlador.idsEnemy(function(ids){
					var enemy = 1 + Math.floor(Math.random() * ids.length-1);
					console.log(enemy);
					Controlador.seeEnemy(ids[enemy], function(enemy) {
						text.text("Un " + enemy.nombre + " salvaje apareció.");
						enemylife.setAttribute("max", enemy.sangre);
						img = "<img src='" + enemy.imagen + "'/>";
						imgenemy.empty();
						imgenemy.append("<h1></h1>");
						imgenemy.append(img);
						progress("#enemylife", enemy.sangre);
						$('#battleenemyimg h1').text(enemy.nombre);
						Controlador.leerSesion(function(user) {
							pjlife.setAttribute("max", user.maxSangre);
							pjlife.setAttribute("value", user.sangre);
							if (user.clase == "warrior") {
								img = "<img src='images/pj/warrior.png'/>";
							} else {
								img = "<img src='images/pj/mage.png'/>";
							}
							pjimg.empty();
							pjimg.append("<h1></h1>");
							pjimg.append(img);
							$('#battlepjimg h1').text(user.alias);
							attack = "<button onclick='attackpj(" + enemy.id
									+ ")'>ATTACK</button>";
							options.empty();
							options.append(attack);
						});
					});
				});
			}
		}
	});

}
/**
 * function msg(msg) { // mensaje = $('#mensaje'); // mensaje.addClass("animated
 * rotateIn"); // $('#mensaje div').text(msg); // mensaje.show(); //
 * mensaje.removeClass("animated rotateIn"); }
 */
function attackpj(ene) {
	Controlador.leerSesion(function(user) {
		enemylife = document.querySelector('#enemylife');
		if (user.clase == "warrior") {
			dmg = user.dmgF;
		} else {
			dmg = user.dmgH;
		}
		text = $('#ghostType');
		for (var i = 1; i <= dmg; i++) {
			vidaEnemy = enemylife.getAttribute("value");
			enemylife.setAttribute("value", vidaEnemy - 1);
		}
		text.append("<p>Atacaste con una fuerza de "+dmg+"</p>");
		text.scrollTop(10000);
		Controlador.seeEnemy(ene, function(enemy) {
			if (vidaEnemy <= 0) {
				saveStatus(enemy, user);
				Controlador.saveSesion(user.usuario,function(){seeStatus();});
			}
			pjlife = document.querySelector('#pjlife');
			var acierta = 1 + Math.floor(Math.random() * 6);
			console.log(acierta);
			if (acierta > 3) {
				text.append("Has recibido " + enemy.dmg	+ " puntos de daño<p>");
				text.scrollTop(10000);
				for (var i = 1; i <= enemy.dmg; i++) {
					
					vidaPJ = pjlife.getAttribute("value");
					pjlife.setAttribute("value", vidaPJ - 1);
				if(vidaPJ<=0){
					text.append("De forma milagrosa has recuperado todas tus energias<p>");
					pjlife.setAttribute("value", pjlife.getAttribute("max"));	
				}
				}
				
			} else {
				text.append("<p>El ataque enemigo ha fallado</p>");
				text.scrollTop(10000);
			}
		});
	});
	
}
function saveStatus(enemy, user) {
	vidaPJ = pjlife.getAttribute("value");
	user.sangre = vidaPJ;
	console.log(user.sangre);
	Controlador.afterBattle(enemy, user, function() {
		batalla = $('#battle');
		batalla.hide();
		seeStatus();
	});

}
// Comprueba que existe quest en la casilla ya sea para empezarla o terminarla
function quest() {
	Controlador.initQuestPJ(function(tpt) {
		if (tpt == 1) {
			Controlador.takeQuest(1, function(quest) {
				alert(quest.definicion);
			});
			// batalla.removeClass("animated rotateIn");
		}
	});
	Controlador.finishQuestPJ(function(tpt) {
		if (tpt == 2) {
			Controlador.takeQuest(2, function(quest) {

				if (quest.battle == "Y") {
					initBattleQuest();
				}
			});
		}
	});
}