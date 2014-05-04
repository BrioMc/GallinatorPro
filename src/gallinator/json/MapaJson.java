package gallinator.json;

import gallinator.tileMap.Mapa;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapaJson {
	public static Mapa mapa() {
		Mapa mapa = new Mapa();
		try {
			String File = "d:\\Trabajos\\Eclipse\\Workspace\\GallinatorPro\\WebContent\\json\\Lv1.json";
			ObjectMapper mapper = new ObjectMapper();
			mapa = mapper.readValue(new File(File), Mapa.class);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mapa;
	}


}
