package gallinator.util;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Clase que controla los archivos json
 */
public class JSON {
	private static ObjectMapper mapper = new ObjectMapper();

	/**
	 * Lee el JSON y escribe mapeandolo en la clase pasada
	 */
	public static <T> T read(String fileName, Class<T> cls) {
		InputStream is = null;
		try {
			is = Resource.openFile(fileName);
			return mapper.readValue(is, cls);
		} catch (JsonParseException e) {
			e.printStackTrace();
			return null;
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
