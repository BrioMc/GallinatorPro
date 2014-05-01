package json;

import java.io.File;
import java.io.IOException;

import tileMap.Layers;
import tileMap.Mapa;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapaJson {
	public static Mapa mapa() {
		Mapa mapa = new Mapa();
		try {
			String File = "c:\\Program Files\\wamp\\www\\GallinatorPro\\WebContent\\json\\Lv1.json";
			ObjectMapper mapper = new ObjectMapper();
			mapa = mapper.readValue(new File(File), Mapa.class);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mapa;
	}

	public int[] arrayMapa() {
		Mapa mapa = mapa();
		Layers[] layerse;
		layerse = mapa.getLayers();
		Layers layer = new Layers();
		layer = layerse[0];
		mapa.getLayers();
		int i[] = layer.getData();
		System.out.println(i[5]);
		return i;
	}
}
