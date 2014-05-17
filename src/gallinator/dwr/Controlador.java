package gallinator.dwr;

import gallinator.bean.Estado;
import gallinator.bean.SesionPlayer;
import gallinator.json.MapaJson;
import gallinator.tileMap.Layers;

public class Controlador {
	public int[][] arrayMapa() {
		gallinator.tileMap.Mapa mapa = MapaJson.mapa();
		Layers[] layerse;
		layerse = mapa.getLayers();
		Layers layer = new Layers();
		layer = layerse[0];
		mapa.getLayers();
		int array[] = layer.getData();
		int c=-1;
		int arrayTiled[][]= new int[18][28];
		for (int y = 0; y < 18; y++) {
			for (int x = 0; x < 28; x++) {
				c++;
				arrayTiled[y][x] = array[c];
			}
		}
		
		return arrayTiled;
	}

	public static Estado status() {
		Estado estado = new Estado();
		return estado;
	}

	public static void guardaPartida() {

		// ObjectMapper mapper = new ObjectMapper();
		// String json= mapper.writeValueAsString(osesion);

	}

	private SesionPlayer load() {
		SesionPlayer load = new SesionPlayer();

		// objeto <- BBDD
		return load;
	}

	private void save(SesionPlayer e) {
		// objeto -> BBDD
	}

	private void mueve(int pos) {
		SesionPlayer e = load();
		switch (pos) {
		case 0:

		}
		save(e);
	}

	/**************************** Movimientos ****************************/
	private boolean[] calculaFlechas(int x, int y) {
		boolean[] result = new boolean[4];
		//Ladrillos -->2,11,18,9,20,21,19,17
		//Piedra 	-->25,26,27,35,43,42,41,33
		//Objetos	-->31,47,40,38,46
		int pos[][] = arrayMapa();
		int posX;
		int posY;
		int[] blockTileds = {31,47,40,38,46,25,26,27,35,43,42,41,33,2,11,18,9,20,21,19,17};
			for(int v=0;v<blockTileds.length;v++){
				// arriba
				posX = x;
				posY = y-1;
				if(blockTileds[v]==pos[posY][posX]){
					result[0] = false;
				}
				else{
					result[0] = true;	
				}
				// derecha
				posX = x+1;
				posY = y;
				if(blockTileds[v]==pos[posY][posX]){
					result[1] = false;
				}
				else{
					result[1] = true;	
				}
				// abajo
				posX = x;
				posY = y+1;
				if(blockTileds[v]==pos[posY][posX]){
					result[2] = false;
				}
				else{
					result[2] = true;	
				}
				// izquierda
				posX = x-1;
				posY = y;
				if(blockTileds[v]==pos[posY][posX]){
					result[3] = false;
				}
				else{
					result[3] = true;	
				}
			}
		
		return result;
	}
}
