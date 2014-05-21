function emptytd() {
	for (var y = 0; y < 18; y++) {
		for (var x = 0; x < 28; x++) {
			$('#' + arrayCasillas[y][x]).empty();
		}
	}
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
			
			if (flechas[0] = true) {
				console.log("flecha arriba");
				flecha = "<button class='key' id='keyup' onclick='movestep(0,-1)'></button>";
				$('#' + (sesion.posY - 1) + "-" + sesion.posX).append(flecha);
			}
			if (flechas[1] == true) {
				console.log("flecha derecha");
				flecha = "<button class='key'id='keyright' onclick='movestep(+1,0)'></button>";
				
				console.log($('#' + sesion.posY + "-" + (sesion.posX + 1)).append(flecha));
			}
			if (flechas[2] == true) {
				console.log("flecha abajo");
				flecha = "<button class='key'id='keydown' onclick='movestep(0,+1)'></button>";
				$('#' + (sesion.posY + 1) + "-" + sesion.posX).append(flecha);
			}
			if (flechas[3] == true) {
				console.log("flecha izquierda");
				flecha = "<button class='key'id='keyleft' onclick='movestep(-1,0)'></button>";
				$('#' + sesion.posY + "-" + (sesion.posX - 1)).append(flecha);
			}

		});
	});

}

function movestep(x,y) {
	Controlador.leerSesion(function(tpt) {
		sesion = tpt;
		console.log(sesion.posX, sesion.posY - 1, sesion.id);
		Controlador.mueve(sesion.posX +x, sesion.posY +y, sesion.id,
				sesion.usuario);
		nextstepgame();
	});
}