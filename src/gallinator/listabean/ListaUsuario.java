package gallinator.listabean;

import gallinator.modelo.ModelFackade;
import gallinator.modelo.Usuario;

import java.util.ArrayList;

/** Clase que devuelve una lista de objetos Usuario */
public class ListaUsuario {
	private String clausulaWhere = new String();

	public String getClausulaWhere() {
		return clausulaWhere;
	}

	public void setClausulaWhere(String clausulaWhere) {
		this.clausulaWhere = clausulaWhere;
	}

	public ArrayList<Usuario> getUsuario() {

		ArrayList<Usuario> usuario = ModelFackade.getUsuario(clausulaWhere);
		return usuario;
	}
}
