$(document).ready(function() {
	arrayCasillas = [];
	arrayTiled = [];
	tiles = Controlador.arrayMapa(function(tpt) {
		console.log(tpt[0]);
		c = -1;
		for (var y = 0; y < 18; y++) {
			arrayTiled[y] = [];
			for (var x = 0; x < 28; x++) {
				c++;
				arrayTiled[y][x] = tpt[c];
			}
		}
	});
	var tabla = $('#lvgame');
	for (var y = 0; y < 18; y++) {
		var tr = document.createElement("TR");
		arrayCasillas[y] = [];
		for (var x = 0; x < 28; x++) {
			var td = document.createElement("TD");
			td.id = y + "-" + x;
			td.x=x;
			td.y=y;	
			arrayCasillas[y][x] = td;
			tr.appendChild(td);
		}
		tabla.append(tr);
	}
	

});