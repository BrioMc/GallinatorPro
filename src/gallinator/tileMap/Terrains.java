package gallinator.tileMap;
/**
 * Clase Terrains de los distintos terrenos del mapa (arena,piedra,ladrillo,etc)
 */
public class Terrains {
	private String name;
	private int tile;

	public int getTile() {
		return tile;
	}

	public void setTile(int tile) {
		this.tile = tile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
