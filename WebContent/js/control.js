$(document).ready(function() {
	arrayCasillas = [];
	arrayTiled = [];
	flechas = [];
	sesion = "";
	flecha = "";

	/*-------Limpieza de cada bloque-------*/
	function emptytd(){
		for (var y = 0; y < 18; y++) {
			for (var x = 0; x < 28; x++) {
				$('#'+arrayCasillas[y][x]).empty();
			}
		}
	}
	/*-------Creación del array del mapa y lectura de la sesion*/
	

	var tabla = $('#lvgame');
	for (var y = 0; y < 18; y++) {
		var tr = document.createElement("TR");
		arrayCasillas[y] = [];
		for (var x = 0; x < 28; x++) {
			var td = document.createElement("TD");
			td.id = y + "-" + x;
			td.x = x;
			td.y = y;
			arrayCasillas[y][x] = td.id;
			tr.appendChild(td);
		}
		tabla.append(tr);
	}
	nextstepgame();
});


