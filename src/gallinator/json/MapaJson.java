package gallinator.json;

import gallinator.tileMap.Mapa;
import gallinator.util.JSON;

public class MapaJson {
	/**
	 * Array de String de los json de los mapas*/
	private static String[] mapas = { "Lv1.json" };
	/**
	 * Lee los datos del json tranformandolos en objetos
	 */
	public static Mapa mapa(int i) {
		return JSON.read(mapas[i], Mapa.class);
	}

}
