package gallinator.json;

import gallinator.tileMap.Mapa;
import gallinator.util.JSON;

public class MapaJson {
	private static String[] mapas = { "Lv1.json" };

	public static Mapa mapa(int i) {
		return JSON.read(mapas[i], Mapa.class);
	}

}
