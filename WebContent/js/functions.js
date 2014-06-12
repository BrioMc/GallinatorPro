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

function nextstepgame() {
	emptytd();
	Controlador.comprobarQuests();
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
				$('#' + sesion.posY + "-" + (sesion.posX + 1)).append(flecha);
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
		Controlador.mueve(sesion.posX +x, sesion.posY +y, sesion.id,sesion.usuario,function (){nextstepgame();randomBattle();});
		
	});
}


function seeStatus(){
	Controlador.leerSesion(function reStatus(user){
		$('#playerstatus').empty();
		Tupla=[];
		tabla=$('#playerstatus');
			Tupla[0]="<tr><td colspan='2'>Nick:</td><td>"+user.alias+"</td></tr>";
			Tupla[1]="<tr><td>Clase: "+user.clase +"</td><td>Exp: "+user.exp +"</td><td>Level: "+user.lv +"</td>	</tr>";
			Tupla[2]="<tr><td colspan='3'>HP:<progress class='progress' id='progressangre' max='"+user.maxSangre+"' value='"+user.sangre +"'></progress></td></tr>";
			Tupla[3]="<tr><td colspan='3'>MP:<progress class='progress' id='progressmana' max='"+user.maxMana+"' value='"+user.mana +"'></progress></td></tr>";
			Tupla[4]="<tr><td colspan='2'>Fuerza:</td><td>"+user.dmgF +"</td></tr>";
			Tupla[5]="<tr><td colspan='2'>Sabiduria:</td><td>"+user.dmgH +"</td></tr>";
			$.each(Tupla, function( index, value ) {
				tabla.append(value);
			});
});
	}