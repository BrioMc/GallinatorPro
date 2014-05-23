package gallinator.modelo;

import java.io.Serializable;

public class Quest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String definicion;
	private int posX_init;
	private int posY_init;
	private String respuesta;
	private int posX_finish;
	private int posY_finish;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDefinicion() {
		return definicion;
	}

	public void setDefinicion(String definicion) {
		this.definicion = definicion;
	}

	public int getPosX_init() {
		return posX_init;
	}

	public void setPosX_init(int posX_init) {
		this.posX_init = posX_init;
	}

	public int getPosY_init() {
		return posY_init;
	}

	public void setPosY_init(int posY_init) {
		this.posY_init = posY_init;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public int getPosX_finish() {
		return posX_finish;
	}

	public void setPosX_finish(int posX_finish) {
		this.posX_finish = posX_finish;
	}

	public int getPosY_finish() {
		return posY_finish;
	}

	public void setPosY_finish(int posY_finish) {
		this.posY_finish = posY_finish;
	}

}