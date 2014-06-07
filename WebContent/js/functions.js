function emptytd() {
	for (var y = 0; y < 18; y++) {
		for (var x = 0; x < 28; x++) {
			$('#' + arrayCasillas[y][x]).empty();
		}
	}
}
function closeSession(){
	Controlador.closeSession(function(){location.reload();});
}
function quest(){
	Controlador.initQuestPJ(function(tpt){
		if(tpt==1){
			alert("Inicio quest");
			Controlador.takeQuest(1,function(tpt){});
		}
		console.log(tpt);
	});
	Controlador.finishQuestPJ(function(tpt){
		if(tpt==2){
			Controlador.takeQuest(2,function(tpt){});
		}
	});
}
function nextstepgame() {
	emptytd();
	Controlador.arrayMapa(function(tpt) {
		arrayTiled = tpt;

	});
	Controlador.leerSesion(function(tpt) {
		sesion = tpt;
		Controlador.calculaFlechas(sesion.posX, sesion.posY, function(tp) {
			flechas = tp;
			
			if (flechas[0] == true) {
				flecha = "<button class='key' id='keyup' onclick='movestep(0,-1)'></button>";
				$('#' + (sesion.posY - 1) + "-" + sesion.posX).append(flecha);
			}
			if (flechas[1] == true) {
				flecha = "<button class='key'id='keyright' onclick='movestep(+1,0)'></button>";
			}
			if (flechas[2] == true) {
				flecha = "<button class='key'id='keydown' onclick='movestep(0,+1)'></button>";
				$('#' + (sesion.posY + 1) + "-" + sesion.posX).append(flecha);
			}
			if (flechas[3] == true) {
				flecha = "<button class='key'id='keyleft' onclick='movestep(-1,0)'></button>";
				$('#' + sesion.posY + "-" + (sesion.posX - 1)).append(flecha);
			}

			quest();});
	});

}

function movestep(x,y) {
	Controlador.leerSesion(function(tpt) {
		sesion = tpt;
		Controlador.mueve(sesion.posX +x, sesion.posY +y, sesion.id,sesion.usuario,function (){nextstepgame();});
		
	});
}