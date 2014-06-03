package gallinator.listabean;

import gallinator.modelo.ModelFackade;
import gallinator.modelo.Personaje;

import java.util.ArrayList;

public class ListaPersonaje {
	private String clausulaWhere = new String();

	public String getClausulaWhere() {
		return clausulaWhere;
	}

	public void setClausulaWhere(String clausulaWhere) {
		this.clausulaWhere = clausulaWhere;
	}

	public ArrayList<Personaje> getPersonaje() {

		ArrayList<Personaje> personaje= ModelFackade.getPersonaje(clausulaWhere);
		return personaje;
	}
}
