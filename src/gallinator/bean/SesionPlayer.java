package gallinator.bean;

import java.io.Serializable;

public class SesionPlayer implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String Usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
}
