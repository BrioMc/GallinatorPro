package gallinator.listabean;

import gallinator.modelo.ModelFackade;
import gallinator.modelo.Personaje;

import java.util.Collection;

public class ListaPersonaje {
	private String clausulaWhere = new String();

	public String getClausulaWhere() {
		return clausulaWhere;
	}

	public void setClausulaWhere(String clausulaWhere) {
		this.clausulaWhere = clausulaWhere;
	}

	public Collection<Personaje> getPersonaje() {

		Collection<Personaje> personaje= ModelFackade.getPersonaje(clausulaWhere);
		return personaje;
	}
}
