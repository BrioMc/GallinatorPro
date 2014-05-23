package gallinator.modelo;

import java.io.Serializable;

public class Enemigo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String imagen;
	private int sangre;
	private int dmg;
	private int exp;
	private int points;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getSangre() {
		return sangre;
	}

	public void setSangre(int sangre) {
		this.sangre = sangre;
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
