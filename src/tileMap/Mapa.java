package tileMap;

public class Mapa {

	private int height; // Alto
	private Layers[] layers;
	private String orientation;
	private Object properties;
	private String tileheight;
	private Object[] tilesets;
	private int tilewidth;
	private int version;
	private int width;

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Layers[] getLayers() {
		return layers;
	}

	public void setLayers(Layers[] layers) {
		this.layers = layers;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public Object getProperties() {
		return properties;
	}

	public void setProperties(Object properties) {
		this.properties = properties;
	}

	public String getTileheight() {
		return tileheight;
	}

	public void setTileheight(String tileheight) {
		this.tileheight = tileheight;
	}

	public Object[] getTilesets() {
		return tilesets;
	}

	public void setTilesets(Object[] tilesets) {
		this.tilesets = tilesets;
	}

	public int getTilewidth() {
		return tilewidth;
	}

	public void setTilewidth(int tilewidth) {
		this.tilewidth = tilewidth;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
