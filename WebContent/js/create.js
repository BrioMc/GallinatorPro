$(document).ready(function() {
	var content = "";
	arrayCasillas = [];
	arrayTiled = [];
	tiles = Mapa.arrayMapa(function(tpt) {
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
	for (var y = 0; y < 18; y++) {
		content += "<tr>";
		for (var x = 0; x < 28; x++) {
			content += "<td id='cell_" + y + "-" + x + "'></td>";
		}
		content += "</tr>";
	}
	$('#lvgame').append(content);
	for (var y = 0; y < 18; y++) {
		arrayCasillas[y] = [];
		for (var x = 0; x < 28; x++) {
			arrayCasillas[y][x] = $("#cell_" + y + "-" + x);

		}
	}

});