package gallinator.modelo;

public class Personaje {
	private int id;
	private String usuario;
	private String alias;
	private String clase;
	private int sangre;
	private int maxSangre;
	private int mana;
	private int maxMana;
	private int dmgF;
	private int dmgH;
	private int exp;
	private int lv;
	private int posX;
	private int posY;

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public int getSangre() {
		return sangre;
	}

	public void setSangre(int sangre) {
		this.sangre = sangre;
	}

	public int getMaxSangre() {
		return maxSangre;
	}

	public void setMaxSangre(int maxSangre) {
		this.maxSangre = maxSangre;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
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
