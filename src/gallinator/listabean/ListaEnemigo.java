package gallinator.listabean;

import gallinator.modelo.Enemigo;
import gallinator.modelo.ModelFackade;

import java.util.ArrayList;

/** Clase que devuelve una lista de objetos Enemigo */
public class ListaEnemigo {

	private String clausulaWhere = new String();

	public String getClausulaWhere() {
		return clausulaWhere;
	}

	public void setClausulaWhere(String clausulaWhere) {
		this.clausulaWhere = clausulaWhere;
	}

	public ArrayList<Enemigo> getEnemigo() {

		ArrayList<Enemigo> alumno = ModelFackade.getEnemigo(clausulaWhere);
		return alumno;
	}
}
