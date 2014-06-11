package gallinator.listabean;

import gallinator.modelo.ModelFackade;
import gallinator.modelo.Quest;

import java.util.ArrayList;
/** Clase que devuelve una lista de objetos Quest */
public class ListaQuest {
	private String clausulaWhere = new String();

	public String getClausulaWhere() {
		return clausulaWhere;
	}

	public void setClausulaWhere(String clausulaWhere) {
		this.clausulaWhere = clausulaWhere;
	}

	public ArrayList<Quest> getQuest() {

		ArrayList<Quest> quest = ModelFackade.getQuest(clausulaWhere);
		return quest;
	}
}
