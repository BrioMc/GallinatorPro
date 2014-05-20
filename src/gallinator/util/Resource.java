package gallinator.util;

import java.io.InputStream;

public class Resource {
	private static ClassLoader cloader;
	static {
		cloader = Resource.class.getClassLoader();
	}

	/**
	 * Returns a InputStream for a file, or null if not found.
	 * 
	 * @param fileName
	 * @return
	 */
	public static InputStream openFile(String fileName) {
		return cloader.getResourceAsStream(fileName);
	}
}
