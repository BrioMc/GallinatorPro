package gallinator.listabean;

import gallinator.modelo.ModelFackade;
import gallinator.modelo.Usuario;

import java.util.Collection;

public class ListaUsuario {
	private String clausulaWhere = new String();

	public String getClausulaWhere() {
		return clausulaWhere;
	}

	public void setClausulaWhere(String clausulaWhere) {
		this.clausulaWhere = clausulaWhere;
	}

	public Collection<Usuario> getUsuario() {

		Collection<Usuario> usuario= ModelFackade.getUsuario(clausulaWhere);
		return usuario;
	}
}
