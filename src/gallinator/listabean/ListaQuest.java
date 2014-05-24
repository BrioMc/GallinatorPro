package gallinator.listabean;

import gallinator.modelo.ModelFackade;
import gallinator.modelo.Quest;

import java.util.Collection;

public class ListaQuest {
	private String clausulaWhere = new String();

	public String getClausulaWhere() {
		return clausulaWhere;
	}

	public void setClausulaWhere(String clausulaWhere) {
		this.clausulaWhere = clausulaWhere;
	}

public Collection<Quest> getQuest() {

		Collection<Quest> quest = ModelFackade.getQuest(clausulaWhere);
		return quest;
	}
}
