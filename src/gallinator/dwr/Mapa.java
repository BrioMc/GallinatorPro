package gallinator.dwr;

import gallinator.json.MapaJson;
import gallinator.tileMap.Layers;

public class Mapa {
	public int[] arrayMapa() {
		gallinator.tileMap.Mapa mapa = MapaJson.mapa();
		Layers[] layerse;
		layerse = mapa.getLayers();
		Layers layer = new Layers();
		layer = layerse[0];
		mapa.getLayers();
		int i[] = layer.getData();
		return i;
	}
}
