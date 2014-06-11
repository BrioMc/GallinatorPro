package gallinator.tileMap;
/**
 * Clase Tilesets de los distintos bloques que componen el mapa
 */
public class Tilesets {
	private int firstgid;
	private String image;
	private int imageheight;
	private int imagewidth;
	private int margin;
	private String name;
	private Object properties;
	private int spacing;
	private Terrains[] terrains;
	private int tileheight;
	private Object tiles;
	private int tilewidth;

	public int getFirstgid() {
		return firstgid;
	}

	public void setFirstgid(int firstgid) {
		this.firstgid = firstgid;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getImageheight() {
		return imageheight;
	}

	public void setImageheight(int imageheight) {
		this.imageheight = imageheight;
	}

	public int getImagewidth() {
		return imagewidth;
	}

	public void setImagewidth(int imagewidth) {
		this.imagewidth = imagewidth;
	}

	public int getMargin() {
		return margin;
	}

	public void setMargin(int margin) {
		this.margin = margin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getProperties() {
		return properties;
	}

	public void setProperties(Object properties) {
		this.properties = properties;
	}

	public Terrains[] getTerrains() {
		return terrains;
	}

	public void setTerrains(Terrains[] terrains) {
		this.terrains = terrains;
	}

	public int getTileheight() {
		return tileheight;
	}

	public void setTileheight(int tileheight) {
		this.tileheight = tileheight;
	}

	public Object getTiles() {
		return tiles;
	}

	public void setTiles(Object tiles) {
		this.tiles = tiles;
	}

	public int getTilewidth() {
		return tilewidth;
	}

	public void setTilewidth(int tilewidth) {
		this.tilewidth = tilewidth;
	}

	public int getSpacing() {
		return spacing;
	}

	public void setSpacing(int spacing) {
		this.spacing = spacing;
	}

}
