package gallinator.listabean;

import gallinator.modelo.Enemigo;
import gallinator.modelo.ModelFackade;

import java.util.Collection;

public class ListaEnemigo {

	private String clausulaWhere = new String();

	public String getClausulaWhere() {
		return clausulaWhere;
	}

	public void setClausulaWhere(String clausulaWhere) {
		this.clausulaWhere = clausulaWhere;
	}

	public Collection<Enemigo> getEnemigo() {

		Collection<Enemigo> alumno = ModelFackade.getEnemigo(clausulaWhere);
		return alumno;
	}
}
