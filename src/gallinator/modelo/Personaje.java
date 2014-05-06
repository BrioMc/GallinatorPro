package gallinator.modelo;

public class Personaje {
	private int idPersonaje;
	private String usuariofk;
	private String alias;
	private int sangre;
	private int mana;
	private int dmgF;
	private int dmgH;
	private int maxSangre;
	private int maxMana;
	private String clase;
	private int exp;
	private int lv;

	public int getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	public String getUsuariofk() {
		return usuariofk;
	}

	public void setUsuariofk(String usuariofk) {
		this.usuariofk = usuariofk;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public int getSangre() {
		return sangre;
	}

	public void setSangre(int sangre) {
		this.sangre = sangre;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getDmgF() {
		return dmgF;
	}

	public void setDmgF(int dmgF) {
		this.dmgF = dmgF;
	}

	public int getDmgH() {
		return dmgH;
	}

	public void setDmgH(int dmgH) {
		this.dmgH = dmgH;
	}

	public int getMaxSangre() {
		return maxSangre;
	}

	public void setMaxSangre(int maxSangre) {
		this.maxSangre = maxSangre;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}
}
